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

package com.liferay.micro.maintainance.candidate.service.impl;

import com.liferay.micro.maintainance.candidate.model.CandidateEntry;
import com.liferay.micro.maintainance.candidate.service.base.CandidateEntryServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the candidate entry remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.micro.maintainance.candidate.service.CandidateEntryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateEntryServiceBaseImpl
 * @see com.liferay.micro.maintainance.candidate.service.CandidateEntryServiceUtil
 */
@ProviderType
public class CandidateEntryServiceImpl extends CandidateEntryServiceBaseImpl {

	@Override
	public CandidateEntry addCandidateEntry(
			long userId, long groupId, long wikiPageId, long taskId)
		throws PortalException {

		return candidateEntryLocalService.addCandidateEntry(
			userId, groupId, wikiPageId, taskId);
	}
}