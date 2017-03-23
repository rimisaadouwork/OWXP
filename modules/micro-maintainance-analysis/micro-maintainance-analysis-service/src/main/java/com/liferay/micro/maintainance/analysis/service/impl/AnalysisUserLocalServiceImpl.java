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

import com.liferay.micro.maintainance.analysis.exception.NoSuchUserException;
import com.liferay.micro.maintainance.analysis.model.AnalysisUser;
import com.liferay.micro.maintainance.analysis.service.base.AnalysisUserLocalServiceBaseImpl;
import com.liferay.micro.maintainance.analysis.service.persistence.AnalysisUserUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

/**
 * The implementation of the analysis user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.micro.maintainance.analysis.service.AnalysisUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisUserLocalServiceBaseImpl
 * @see com.liferay.micro.maintainance.analysis.service.AnalysisUserLocalServiceUtil
 */
@ProviderType
public class AnalysisUserLocalServiceImpl
	extends AnalysisUserLocalServiceBaseImpl {

	/**
	 * Adds a user's vote to an analysis
	 */
	@Override
	public AnalysisUser addAnalysisUser(
			long analysisEntryId, long userId, int vote)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);

		long analysisUserId = counterLocalService.increment();

		AnalysisUser analysisUser = analysisUserPersistence.create(
			analysisUserId);

		analysisUser.setAnalysisEntryId(analysisEntryId);
		analysisUser.setUserId(userId);
		analysisUser.setUserName(user.getFullName());
		analysisUser.setVoted(vote);

		analysisUserPersistence.update(analysisUser);

		return analysisUser;
	}

	@Override
	public AnalysisUser getAnalysisUser(long analysisEntryId, long userId) {
		try {
			return AnalysisUserUtil.findByA_U(analysisEntryId, userId);
		}
		catch (NoSuchUserException nsue) {
			return null;
		}
	}

}