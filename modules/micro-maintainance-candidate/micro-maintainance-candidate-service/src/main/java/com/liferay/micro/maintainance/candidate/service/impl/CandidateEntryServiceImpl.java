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

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.candidate.service.base.CandidateEntryServiceBaseImpl;

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

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.micro.maintainance.candidate.service.CandidateEntryServiceUtil} to access the candidate entry remote service.
	 */
}