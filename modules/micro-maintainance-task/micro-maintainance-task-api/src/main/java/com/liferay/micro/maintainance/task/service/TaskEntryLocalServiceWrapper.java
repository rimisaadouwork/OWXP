/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.micro.maintainance.task.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TaskEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskEntryLocalService
 * @generated
 */
@ProviderType
public class TaskEntryLocalServiceWrapper implements TaskEntryLocalService,
	ServiceWrapper<TaskEntryLocalService> {
	public TaskEntryLocalServiceWrapper(
		TaskEntryLocalService taskEntryLocalService) {
		_taskEntryLocalService = taskEntryLocalService;
	}

	/**
	* Adds the task entry to the database. Also notifies the appropriate model listeners.
	*
	* @param taskEntry the task entry
	* @return the task entry that was added
	*/
	@Override
	public com.liferay.micro.maintainance.task.model.TaskEntry addTaskEntry(
		com.liferay.micro.maintainance.task.model.TaskEntry taskEntry) {
		return _taskEntryLocalService.addTaskEntry(taskEntry);
	}

	/**
	* Upon deploying a task module, this method adds entry for it to the
	* database as registration.
	*
	* @param taskEntryName
	* @return the TaskEntry that was added
	* @throws PortalException
	*/
	@Override
	public com.liferay.micro.maintainance.task.model.TaskEntry addTaskEntry(
		java.lang.String taskEntryName)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taskEntryLocalService.addTaskEntry(taskEntryName);
	}

	/**
	* Creates a new task entry with the primary key. Does not add the task entry to the database.
	*
	* @param taskEntryId the primary key for the new task entry
	* @return the new task entry
	*/
	@Override
	public com.liferay.micro.maintainance.task.model.TaskEntry createTaskEntry(
		long taskEntryId) {
		return _taskEntryLocalService.createTaskEntry(taskEntryId);
	}

	/**
	* Deletes the task entry from the database. Also notifies the appropriate model listeners.
	*
	* @param taskEntry the task entry
	* @return the task entry that was removed
	*/
	@Override
	public com.liferay.micro.maintainance.task.model.TaskEntry deleteTaskEntry(
		com.liferay.micro.maintainance.task.model.TaskEntry taskEntry) {
		return _taskEntryLocalService.deleteTaskEntry(taskEntry);
	}

	/**
	* Deletes the task entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskEntryId the primary key of the task entry
	* @return the task entry that was removed
	* @throws PortalException if a task entry with the primary key could not be found
	*/
	@Override
	public com.liferay.micro.maintainance.task.model.TaskEntry deleteTaskEntry(
		long taskEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taskEntryLocalService.deleteTaskEntry(taskEntryId);
	}

	@Override
	public com.liferay.micro.maintainance.task.model.TaskEntry fetchTaskEntry(
		long taskEntryId) {
		return _taskEntryLocalService.fetchTaskEntry(taskEntryId);
	}

	/**
	* Returns the task entry with the primary key.
	*
	* @param taskEntryId the primary key of the task entry
	* @return the task entry
	* @throws PortalException if a task entry with the primary key could not be found
	*/
	@Override
	public com.liferay.micro.maintainance.task.model.TaskEntry getTaskEntry(
		long taskEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taskEntryLocalService.getTaskEntry(taskEntryId);
	}

	@Override
	public com.liferay.micro.maintainance.task.model.TaskEntry getTaskEntryByName(
		java.lang.String taskEntryName) {
		return _taskEntryLocalService.getTaskEntryByName(taskEntryName);
	}

	/**
	* Updates the task entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taskEntry the task entry
	* @return the task entry that was updated
	*/
	@Override
	public com.liferay.micro.maintainance.task.model.TaskEntry updateTaskEntry(
		com.liferay.micro.maintainance.task.model.TaskEntry taskEntry) {
		return _taskEntryLocalService.updateTaskEntry(taskEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _taskEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taskEntryLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _taskEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taskEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taskEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of task entries.
	*
	* @return the number of task entries
	*/
	@Override
	public int getTaskEntriesCount() {
		return _taskEntryLocalService.getTaskEntriesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _taskEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _taskEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.task.model.impl.TaskEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _taskEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.task.model.impl.TaskEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _taskEntryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the task entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.task.model.impl.TaskEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task entries
	* @param end the upper bound of the range of task entries (not inclusive)
	* @return the range of task entries
	*/
	@Override
	public java.util.List<com.liferay.micro.maintainance.task.model.TaskEntry> getTaskEntries(
		int start, int end) {
		return _taskEntryLocalService.getTaskEntries(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _taskEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _taskEntryLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public TaskEntryLocalService getWrappedService() {
		return _taskEntryLocalService;
	}

	@Override
	public void setWrappedService(TaskEntryLocalService taskEntryLocalService) {
		_taskEntryLocalService = taskEntryLocalService;
	}

	private TaskEntryLocalService _taskEntryLocalService;
}