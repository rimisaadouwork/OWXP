package com.liferay.micro.maintainance.task;

import com.liferay.micro.maintainance.action.Action;
import com.liferay.micro.maintainance.action.NotifyCreatorAction;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.micro.maintainance.util.VoteCalculations;
import com.liferay.micro.maintainance.util.VoteConstants;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
public class OutdatedTask implements Task {

	public static OutdatedTask getOutdatedTaskInstance() {
		if (_outdatedTask == null) {
			_outdatedTask = new OutdatedTask();
		}

		return _outdatedTask;
	}

	@Override
	public List<Action> analyze(AnalysisEntry analysisEntry) {
		List<Action> actions = new ArrayList<>();

		double percentageYesVotes = VoteCalculations.getVotePercentage(
			analysisEntry.getAnalysisData(), VoteConstants.YES_DESCRIPTION);
		int totalUsers = UserLocalServiceUtil.getUsersCount();
		int totalVotedUsers = VoteCalculations.getTotalVotes(
			analysisEntry.getAnalysisData());
		double percentageVoted = 0.00;

		if (totalVotedUsers > 0) {
			percentageVoted = totalVotedUsers * 100 / totalUsers;
		}

		if ((percentageVoted > _requiredVotingPercentage) &&
			(percentageYesVotes > _requiredYesVotesPercentage)) {
			actions.add(new NotifyCreatorAction());
		}

		return actions;
	}

	@Override
	public String getOutcome() {
		return _outcome;
	}

	public int getRequiredVotingPercentage() {
		return _requiredVotingPercentage;
	}

	public int getRequiredYesVotesPercentage() {
		return _requiredYesVotesPercentage;
	}

	@Override
	public long getTaskId() {
		return _taskId;
	}

	@Override
	public String getTaskName() {
		return _TASK_NAME;
	}

	public int getVotingPeriodDays() {
		return _votingPeriodDays;
	}

	@Override
	public boolean isAnalyseReady(CandidateMaintenance candidateMaintenance) {
		Date now = new Date();

		if (DateUtil.getDaysBetween(now, candidateMaintenance.getCreateDate()) >
				_votingPeriodDays) {

			return true;
		}

		return false;
	}

	public void setRequiredVotingPercentage(int requiredVotingPercentage) {
		_requiredVotingPercentage = requiredVotingPercentage;
	}

	public void setRequiredYesVotesPercentage(int requiredYesVotesPercentage) {
		_requiredYesVotesPercentage = requiredYesVotesPercentage;
	}

	@Override
	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public void setVotingPeriodDays(int votingPeriodDays) {
		_votingPeriodDays = votingPeriodDays;
	}

	protected OutdatedTask() {
		_taskId = 0;
	}

	private static final String _TASK_NAME = "Outdated";

	private static OutdatedTask _outdatedTask;

	private String _outcome = "";
	private int _requiredVotingPercentage;
	private int _requiredYesVotesPercentage;
	private long _taskId = 0;
	private int _votingPeriodDays;

}