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

package com.liferay.micro.maintainance.task.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.task.exception.NoSuchEntryException;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.micro.maintainance.task.model.TaskEntry;
import com.liferay.micro.maintainance.task.service.CandidateMaintenanceLocalServiceUtil;
import com.liferay.micro.maintainance.task.service.base.TaskEntryLocalServiceBaseImpl;
import com.liferay.micro.maintainance.task.service.persistence.TaskEntryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the task entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.micro.maintainance.task.service.TaskEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskEntryLocalServiceBaseImpl
 * @see com.liferay.micro.maintainance.task.service.TaskEntryLocalServiceUtil
 */
@ProviderType
public class TaskEntryLocalServiceImpl extends TaskEntryLocalServiceBaseImpl {

	/**
	 * Upon deploying a task module, this method adds entry for it to the
	 * database as registration.
	 *
	 * @param taskEntryName
	 * @return the TaskEntry that was added
	 * @throws PortalException
	 */
	@Override
	public TaskEntry addTaskEntry(String taskEntryName) throws PortalException {
		long taskEntryId = counterLocalService.increment();
		Date now = new Date();

		TaskEntry taskEntry = taskEntryPersistence.create(taskEntryId);

		taskEntry.setTaskEntryName(taskEntryName);
		taskEntry.setCreateDate(now);

		taskEntryPersistence.update(taskEntry);

		return taskEntry;
	}

	/**
	 * Deletes the task entry with the primary key from the database. Also
	 * invokes the deletion of all the running votes for this maintenance task.
	 *
	 * @param taskEntryId the primary key of the task entry
	 * @return the task entry that was removed
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TaskEntry deleteTaskEntry(long taskEntryId) throws PortalException {
		List<CandidateMaintenance> candidateMaintenanceTasks =
			CandidateMaintenanceLocalServiceUtil
				.getCandidateMaintenaceTasksByTask(taskEntryId);

		for (CandidateMaintenance candidateMaintenanceTask :
				candidateMaintenanceTasks) {

			CandidateMaintenanceLocalServiceUtil.deleteCandidateMaintenance(
				candidateMaintenanceTask.getCandidateMaintenanceId());
		}

		return taskEntryPersistence.remove(taskEntryId);
	}

	@Override
	public TaskEntry getTaskEntryByName(String taskEntryName) {
		try {
			return TaskEntryUtil.findByTasksByName(taskEntryName);
		}
		catch (NoSuchEntryException nsee) {
			return null;
		}
	}

}