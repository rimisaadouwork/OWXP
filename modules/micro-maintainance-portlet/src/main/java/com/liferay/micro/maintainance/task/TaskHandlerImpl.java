package com.liferay.micro.maintainance.task;

import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.analysis.model.AnalysisUser;
import com.liferay.micro.maintainance.analysis.service.AnalysisEntryLocalServiceUtil;
import com.liferay.micro.maintainance.analysis.service.AnalysisUserLocalServiceUtil;
import com.liferay.micro.maintainance.api.Task;
import com.liferay.micro.maintainance.api.TaskHandler;
import com.liferay.micro.maintainance.candidate.model.CandidateEntry;
import com.liferay.micro.maintainance.candidate.service.CandidateEntryLocalServiceUtil;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.micro.maintainance.task.model.TaskEntry;
import com.liferay.micro.maintainance.task.service.CandidateMaintenanceLocalServiceUtil;
import com.liferay.micro.maintainance.task.service.TaskEntryLocalServiceUtil;
import com.liferay.micro.maintainance.util.VoteConstants;
import com.liferay.micro.maintainance.util.VotesJSONSerializer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
@Component(immediate = true, service = TaskHandler.class)
public class TaskHandlerImpl implements TaskHandler {

	/**
	 * Returns the list of the maintenance tasks for which the wiki page with
	 * the given id is not yet nominated for voting. If a task is not in the
	 * list the voting should be displayed.
	 *
	 * @param wikiPageId
	 * @throws PortalException
	 */
	@Override
	public List<Task> getAvailableFlags(long wikiPageId)
		throws PortalException {

		List<Task> availableFlags = new ArrayList<>();

		CandidateEntry candidateEntry =
			CandidateEntryLocalServiceUtil.getCandidateByWikiPageId(wikiPageId);

		if (candidateEntry == null) {
			availableFlags.addAll(_registeredTasks.values());
		}
		else {
			for (Task task : _registeredTasks.values()) {
				if (CandidateMaintenanceLocalServiceUtil
						.getCandidateMaintenaceTask(
							candidateEntry.getCandidateEntryId(),
							task.getTaskId()) == null) {

					availableFlags.add(task);
				}
			}
		}

		return availableFlags;
	}

	@Override
	public Map<Long, Task> getTaskEntries() {
		return _registeredTasks;
	}

	@Override
	public List<Task> getTaskEntryList() {
		return ListUtil.fromCollection(_registeredTasks.values());
	}

	/**
	 * Returns the vote of the user on the given maintenance task for the
	 * current wiki page, upon visiting the page
	 *
	 * @param userId: the visiting user's id
	 * @param wikiPageId: the visited wiki page's id
	 * @param taskId: the current task's id
	 * @return the vote
	 * @throws PortalException
	 */
	@Override
	public int getVote(long userId, long wikiPageId, long taskId)
		throws PortalException {

		CandidateEntry candidateEntry =
			CandidateEntryLocalServiceUtil.getCandidateByWikiPageId(wikiPageId);

		CandidateMaintenance candidateMaintenance =
			CandidateMaintenanceLocalServiceUtil.getCandidateMaintenaceTask(
				candidateEntry.getCandidateEntryId(), taskId);

		AnalysisEntry analysisEntry;

		analysisEntry =
			AnalysisEntryLocalServiceUtil.getAnalysisByCandidateMaintenance(
				candidateMaintenance.getCandidateMaintenanceId());

		long analysisEntryId = analysisEntry.getAnalysisEntryId();

		AnalysisUser analysisUser =
			AnalysisUserLocalServiceUtil.getAnalysisUser(
				analysisEntryId, userId);

		if (analysisUser != null) {
			return analysisUser.getVoted();
		}

		AnalysisUserLocalServiceUtil.addAnalysisUser(
			analysisEntryId, userId, VoteConstants.NOT_VOTED);

		return VoteConstants.NOT_VOTED;
	}

	/**
	 * Registers maintenance task modules
	 *  called upon deploying a task module
	 *  adds the task to the database
	 *  adds the task to the tasklist
	 *
	 * @param task: the deployed task
	 */
	@Override
	public void registerTask(Task task) throws PortalException {
		TaskEntry taskEntry = TaskEntryLocalServiceUtil.getTaskEntryByName(
			task.getTaskName());

		if (Validator.isNull(taskEntry)) {
			taskEntry = TaskEntryLocalServiceUtil.addTaskEntry(
				task.getTaskName());
		}

		task.setTaskId(taskEntry.getTaskEntryId());

		_registeredTasks.put(task.getTaskId(), task);
	}

	public void setTaskEntries(Map<Long, Task> taskEntries) {
		_registeredTasks = taskEntries;
	}

	/**
	 * Unregister task modules
	 * 	Called upon undeploying a task module
	 * 	Removes the task from the task list
	 * 	Remove it from the database
	 *
	 * @param task: the undeployed task
	 */
	@Override
	public void unregisterTask(Task task) throws PortalException {
		TaskEntryLocalServiceUtil.deleteTaskEntry(task.getTaskId());
		_registeredTasks.remove(task.getTaskId());
	}

	/**
	 * Stores a user's vote and updates the analysis belonging to the task in
	 * question.
	 *
	 * @param userId: the visiting user's id
	 * @param wikiPageId: the visited wiki page's id
	 * @param taskId: the current task's id
	 * @param vote: the user's decision
	 * @throws PortalException
	 */
	@Override
	public void vote(long userId, long wikiPageId, long taskId, int vote)
		throws PortalException {

		CandidateEntry candidateEntry =
			CandidateEntryLocalServiceUtil.getCandidateByWikiPageId(wikiPageId);

		CandidateMaintenance candidateMaintenance =
			CandidateMaintenanceLocalServiceUtil.getCandidateMaintenaceTask(
				candidateEntry.getCandidateEntryId(), taskId);

		AnalysisEntry analysisEntry;

		analysisEntry =
			AnalysisEntryLocalServiceUtil.getAnalysisByCandidateMaintenance(
				candidateMaintenance.getCandidateMaintenanceId());

		long analysisEntryId = analysisEntry.getAnalysisEntryId();

		AnalysisUser analysisUser =
			AnalysisUserLocalServiceUtil
				.getAnalysisUser(analysisEntryId, userId);

		int previousVote = analysisUser.getVoted();

		analysisUser.setVoted(vote);

		analysisUser.persist();

		String analysisData = analysisEntry.getAnalysisData();

		analysisData = VotesJSONSerializer.updateVotes(
			analysisData, previousVote, vote);

		analysisEntry.setAnalysisData(analysisData);

		analysisEntry.persist();
	}

	@Activate
	protected void activate() throws PortalException {
		_registeredTasks = new HashMap<>();
	}

	private Map<Long, Task> _registeredTasks;

}