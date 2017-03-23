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

package com.liferay.micro.maintainance.decision.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.candidate.model.CandidateEntry;
import com.liferay.micro.maintainance.candidate.service.CandidateEntryLocalServiceUtil;
import com.liferay.micro.maintainance.decision.model.DecisionEntry;
import com.liferay.micro.maintainance.decision.service.base.DecisionEntryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiPageLocalServiceUtil;

import java.util.Date;

/**
 * The implementation of the decision entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.micro.maintainance.decision.service.DecisionEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DecisionEntryLocalServiceBaseImpl
 * @see com.liferay.micro.maintainance.decision.service.DecisionEntryLocalServiceUtil
 */
@ProviderType
public class DecisionEntryLocalServiceImpl
	extends DecisionEntryLocalServiceBaseImpl {

	/**
	 * Adds the results of an analysis to the database
	 *
	 * @param userId: the id of the user who flagged the page
	 * @param analysisData: the gathered votes
	 * @param candidateEntryId: the id of the candidate entry belonging to the
	 *   flagged wiki page
	 * @param outcome: the actions to be taken
	 * @param handled: indicates if the actions could be executed
	 * @return the DecisionEntry that was added
	 * @throws PortalException
	 */
	@Override
	public DecisionEntry addDecisionEntry(
			long userId, String analysisData, long candidateEntryId,
			String outcome, boolean handled)
		throws PortalException {

		User user = userPersistence.findByPrimaryKey(userId);
		long decisionEntryId = counterLocalService.increment();
		Date now = new Date();

		DecisionEntry decision = decisionEntryPersistence.create(
			decisionEntryId);

		CandidateEntry candidate =
			CandidateEntryLocalServiceUtil.getCandidateEntry(candidateEntryId);

		WikiPage wikiPage = WikiPageLocalServiceUtil.getPageByPageId(
			candidate.getWikiPageId());

		decision.setCompanyId(user.getCompanyId());
		decision.setUserId(userId);
		decision.setUserName(user.getFullName());
		decision.setCreateDate(now);
		decision.setModifiedDate(now);

		decision.setAnalysisData(analysisData);
		decision.setWikiPageId(wikiPage.getPageId());
		decision.setWikiPageName(wikiPage.getTitle());
		decision.setOutcome(outcome);
		decision.setHandled(handled);

		return decision;
	}

}