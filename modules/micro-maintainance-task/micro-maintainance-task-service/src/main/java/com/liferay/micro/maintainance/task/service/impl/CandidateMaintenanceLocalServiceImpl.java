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

import com.liferay.micro.maintainance.candidate.service.CandidateEntryLocalServiceUtil;
import com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.micro.maintainance.task.service.base.CandidateMaintenanceLocalServiceBaseImpl;
import com.liferay.micro.maintainance.task.service.persistence.CandidateMaintenanceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the candidate maintenance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.micro.maintainance.task.service.CandidateMaintenanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateMaintenanceLocalServiceBaseImpl
 * @see com.liferay.micro.maintainance.task.service.CandidateMaintenanceLocalServiceUtil
 */
@ProviderType
public class CandidateMaintenanceLocalServiceImpl
	extends CandidateMaintenanceLocalServiceBaseImpl {

	/**
	 * Adds a CandidateMaintenance entry to the database, this way assigning a
	 * wiki page to a maintenance task. The users can vote, while this entry is
	 * in the database.
	 *
	 * @param candidateEntryId: the id of the candidate entry belonging to the
	 *   flagged wiki page
	 * @param taskEntryId: the id of the maintenance task for which the page is
	 *   flagged
	 * @return the CandidateMaintenance entry that was added
	 * @throws PortalException
	 */
	@Override
	public CandidateMaintenance addCandidateMaintenance(
			long candidateEntryId, long taskEntryId)
		throws PortalException {

		long candidateMaintenanceId = counterLocalService.increment();
		Date now = new Date();

		CandidateMaintenance candidateMaintenance =
			candidateMaintenancePersistence.create(candidateEntryId);

		candidateMaintenance.setCandidateEntryId(candidateEntryId);
		candidateMaintenance.setTaskEntryId(taskEntryId);
		candidateMaintenance.setCreateDate(now);

		return candidateMaintenance;
	}

	/**
	 * Deletes the candidate maintenance with the primary key from the database.
	 * Also deletes the candidate entry if there are no more votes running for
	 * it.
	 *
	 * @param candidateMaintenanceId the primary key of the candidate maintenance
	 * @return the candidate maintenance that was removed
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CandidateMaintenance deleteCandidateMaintenance(
			long candidateMaintenanceId)
		throws PortalException {

		CandidateMaintenance currentCandidateMaintenance =
			candidateMaintenancePersistence.remove(candidateMaintenanceId);

		long candidateEntryId =
			currentCandidateMaintenance.getCandidateEntryId();

		if (getCandidateMaintenaceTasksCountByCandidate(candidateEntryId) ==
				0) {

			CandidateEntryLocalServiceUtil.deleteCandidateEntry(
				candidateEntryId);
		}

		return currentCandidateMaintenance;
	}

	@Override
	public CandidateMaintenance getCandidateMaintenaceTask(
			long candidateEntryId, long taskEntryId)
		throws PortalException {

		try {
			return CandidateMaintenanceUtil.findByC_T(
				candidateEntryId, taskEntryId);
		}
		catch (NoSuchCandidateMaintenanceException nscme) {
			return null;
		}
	}

	/**
	 * Returns the task assignments belonging to the given candidate.
	 *
	 * @param candidatId
	 * @return List of CandidateMaintenance entries with the given candidateEntryId
	 */
	@Override
	public List<CandidateMaintenance> getCandidateMaintenaceTasksByCandidate(
			long candidateEntryId)
		throws PortalException {

		return candidateMaintenancePersistence.findByCandidateEntryIds(
			candidateEntryId);
	}

	/**
	 * Returns the candidate assignments belonging to the given task.
	 *
	 * @param taskEntryId
	 * @return List of CandidateMaintenance entries with the given taskEntryId
	 */
	@Override
	public List<CandidateMaintenance> getCandidateMaintenaceTasksByTask(
			long taskEntryId)
		throws PortalException {

		return candidateMaintenancePersistence.findByTaskEntryIds(taskEntryId);
	}

	/**
	 * Returns number of the task assignments belonging to the given candidate.
	 *
	 * @param candidatId
	 * @return Number of CandidateMaintenance entries with the given candidateEntryId
	 */
	@Override
	public long getCandidateMaintenaceTasksCountByCandidate(
			long candidateEntryId)
		throws PortalException {

		return getCandidateMaintenaceTasksByCandidate(candidateEntryId).size();
	}

	/**
	 * Returns the number of the candidate assignments belonging to the given task.
	 *
	 * @param taskEntryId
	 * @return Number of CandidateMaintenance entries with the given taskEntryId
	 */
	@Override
	public long getCandidateMaintenaceTasksCountByTask(long taskEntryId)
		throws PortalException {

		return getCandidateMaintenaceTasksByTask(taskEntryId).size();
	}

}