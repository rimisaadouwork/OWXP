package com.liferay.micro.maintainance.util;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.micro.maintainance.api.Task;
import com.liferay.micro.maintainance.api.TaskHandler;
import com.liferay.portal.kernel.exception.PortalException;

@Component
public class TaskHandlerUtil {

	public Map<Long, Task> getTaskEntries() {
		return _taskHandler.getTaskEntries();
	}

	public List<Task> getTaskEntryList() {
		return _taskHandler.getTaskEntryList();
	}

	public int getVote(long userId, long wikiPageId, long taskId)
		throws PortalException {

		return _taskHandler.getVote(userId, wikiPageId, taskId);
	}

	public void vote(long userId, long wikiPageId, long taskId, int vote) 
		throws PortalException {

		_taskHandler.vote(userId, wikiPageId, taskId, vote);
	}

	public static List<Task> getAvailableFlags(long wikiPageId) 
		throws PortalException {

		return _taskHandler.getAvailableFlags(wikiPageId);
	}

	@Reference(unbind = "-")
	protected void setTaskHandler(TaskHandler taskHandler) {
		_taskHandler = taskHandler;
	}

	private static TaskHandler _taskHandler;
}
