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

package com.liferay.micro.maintainance.analysis.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.analysis.service.base.AnalysisEntryLocalServiceBaseImpl;
import com.liferay.micro.maintainance.analysis.service.persistence.AnalysisEntryUtil;
import com.liferay.micro.maintainance.util.VotesJSONSerializer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import java.util.Date;

/**
 * The implementation of the analysis entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.micro.maintainance.analysis.service.AnalysisEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisEntryLocalServiceBaseImpl
 * @see com.liferay.micro.maintainance.analysis.service.AnalysisEntryLocalServiceUtil
 */
@ProviderType
public class AnalysisEntryLocalServiceImpl
	extends AnalysisEntryLocalServiceBaseImpl {

	/**
	 * Adds an analysis entry, which will store the votes
	 *
	 * @param userId: the id of the user who flagged the page
	 * @param candidateMaintenanceId: the id of the CandidateMaintenance entry, in which the
	 *   assignment between a task and a candidate is stored.
	 * @return the AnalysisEntry that was added
	 * @throws PortalException
	 */
	@Override
	public AnalysisEntry addAnalysisEntry(
			long userId, long candidateMaintenanceId)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		long analysisEntryId = counterLocalService.increment();

		AnalysisEntry analysisEntry = analysisEntryPersistence.create(
			analysisEntryId);

		analysisEntry.setCompanyId(user.getCompanyId());
		analysisEntry.setUserId(userId);
		analysisEntry.setUserName(user.getFullName());
		analysisEntry.setCreateDate(now);
		analysisEntry.setModifiedDate(now);

		analysisEntry.setAnalysisData(VotesJSONSerializer.createVotes());
		analysisEntry.setCandidateMaintenanceId(candidateMaintenanceId);

		analysisEntryPersistence.update(analysisEntry);

		return analysisEntry;
	}

	@Override
	public AnalysisEntry getAnalysisByCandidateMaintenance(
		long candidateMaintenanceId) {

		try {
			return AnalysisEntryUtil.findByCandidateMaintenanceId(
				candidateMaintenanceId);
		}
		catch (NoSuchEntryException nsee) {
			return null;
		}
	}

}