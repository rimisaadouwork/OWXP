package com.liferay.micro.maintainance.api;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;
import java.util.Map;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
public interface TaskHandler {

	public List<Task> getAvailableFlags(long wikiPageId) throws PortalException;

	public Map<Long, Task> getTaskEntries();

	public List<Task> getTaskEntryList();

	public int getVote(long userId, long wikiPageId, long taskId)
		throws PortalException;

	public void registerTask(Task task) throws PortalException;

	public void unregisterTask(Task task) throws PortalException;

	public void vote(long userId, long wikiPageId, long taskId, int vote)
		throws PortalException;

}