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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for CandidateEntry. This utility wraps
 * {@link com.liferay.micro.maintainance.candidate.service.impl.CandidateEntryServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateEntryService
 * @see com.liferay.micro.maintainance.candidate.service.base.CandidateEntryServiceBaseImpl
 * @see com.liferay.micro.maintainance.candidate.service.impl.CandidateEntryServiceImpl
 * @generated
 */
@ProviderType
public class CandidateEntryServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.micro.maintainance.candidate.service.impl.CandidateEntryServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.micro.maintainance.candidate.model.CandidateEntry addCandidateEntry(
		long userId, long groupId, long wikiPageId, long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addCandidateEntry(userId, groupId, wikiPageId, taskId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CandidateEntryService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CandidateEntryService, CandidateEntryService> _serviceTracker =
		ServiceTrackerFactory.open(CandidateEntryService.class);
}