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

package com.liferay.micro.maintainance.candidate.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CandidateEntryService}.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateEntryService
 * @generated
 */
@ProviderType
public class CandidateEntryServiceWrapper implements CandidateEntryService,
	ServiceWrapper<CandidateEntryService> {
	public CandidateEntryServiceWrapper(
		CandidateEntryService candidateEntryService) {
		_candidateEntryService = candidateEntryService;
	}

	@Override
	public com.liferay.micro.maintainance.candidate.model.CandidateEntry addCandidateEntry(
		long userId, long groupId, long wikiPageId, long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateEntryService.addCandidateEntry(userId, groupId,
			wikiPageId, taskId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _candidateEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public CandidateEntryService getWrappedService() {
		return _candidateEntryService;
	}

	@Override
	public void setWrappedService(CandidateEntryService candidateEntryService) {
		_candidateEntryService = candidateEntryService;
	}

	private CandidateEntryService _candidateEntryService;
}