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

package com.liferay.micro.maintainance.decision.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DecisionEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DecisionEntryLocalService
 * @generated
 */
@ProviderType
public class DecisionEntryLocalServiceWrapper
	implements DecisionEntryLocalService,
		ServiceWrapper<DecisionEntryLocalService> {
	public DecisionEntryLocalServiceWrapper(
		DecisionEntryLocalService decisionEntryLocalService) {
		_decisionEntryLocalService = decisionEntryLocalService;
	}

	/**
	* Adds the decision entry to the database. Also notifies the appropriate model listeners.
	*
	* @param decisionEntry the decision entry
	* @return the decision entry that was added
	*/
	@Override
	public com.liferay.micro.maintainance.decision.model.DecisionEntry addDecisionEntry(
		com.liferay.micro.maintainance.decision.model.DecisionEntry decisionEntry) {
		return _decisionEntryLocalService.addDecisionEntry(decisionEntry);
	}

	/**
	* Adds the results of an analysis to the database
	*
	* @param userId: the id of the user who flagged the page
	* @param analysisData: the gathered votes
	* @param candidateEntryId: the id of the candidate entry belonging to the
	flagged wiki page
	* @param outcome: the actions to be taken
	* @param handled: indicates if the actions could be executed
	* @return the DecisionEntry that was added
	* @throws PortalException
	*/
	@Override
	public com.liferay.micro.maintainance.decision.model.DecisionEntry addDecisionEntry(
		long userId, java.lang.String analysisData, long candidateEntryId,
		java.lang.String outcome, boolean handled)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _decisionEntryLocalService.addDecisionEntry(userId,
			analysisData, candidateEntryId, outcome, handled);
	}

	/**
	* Creates a new decision entry with the primary key. Does not add the decision entry to the database.
	*
	* @param decisionEntryId the primary key for the new decision entry
	* @return the new decision entry
	*/
	@Override
	public com.liferay.micro.maintainance.decision.model.DecisionEntry createDecisionEntry(
		long decisionEntryId) {
		return _decisionEntryLocalService.createDecisionEntry(decisionEntryId);
	}

	/**
	* Deletes the decision entry from the database. Also notifies the appropriate model listeners.
	*
	* @param decisionEntry the decision entry
	* @return the decision entry that was removed
	*/
	@Override
	public com.liferay.micro.maintainance.decision.model.DecisionEntry deleteDecisionEntry(
		com.liferay.micro.maintainance.decision.model.DecisionEntry decisionEntry) {
		return _decisionEntryLocalService.deleteDecisionEntry(decisionEntry);
	}

	/**
	* Deletes the decision entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param decisionEntryId the primary key of the decision entry
	* @return the decision entry that was removed
	* @throws PortalException if a decision entry with the primary key could not be found
	*/
	@Override
	public com.liferay.micro.maintainance.decision.model.DecisionEntry deleteDecisionEntry(
		long decisionEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _decisionEntryLocalService.deleteDecisionEntry(decisionEntryId);
	}

	@Override
	public com.liferay.micro.maintainance.decision.model.DecisionEntry fetchDecisionEntry(
		long decisionEntryId) {
		return _decisionEntryLocalService.fetchDecisionEntry(decisionEntryId);
	}

	/**
	* Returns the decision entry with the matching UUID and company.
	*
	* @param uuid the decision entry's UUID
	* @param companyId the primary key of the company
	* @return the matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	@Override
	public com.liferay.micro.maintainance.decision.model.DecisionEntry fetchDecisionEntryByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _decisionEntryLocalService.fetchDecisionEntryByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the decision entry with the primary key.
	*
	* @param decisionEntryId the primary key of the decision entry
	* @return the decision entry
	* @throws PortalException if a decision entry with the primary key could not be found
	*/
	@Override
	public com.liferay.micro.maintainance.decision.model.DecisionEntry getDecisionEntry(
		long decisionEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _decisionEntryLocalService.getDecisionEntry(decisionEntryId);
	}

	/**
	* Returns the decision entry with the matching UUID and company.
	*
	* @param uuid the decision entry's UUID
	* @param companyId the primary key of the company
	* @return the matching decision entry
	* @throws PortalException if a matching decision entry could not be found
	*/
	@Override
	public com.liferay.micro.maintainance.decision.model.DecisionEntry getDecisionEntryByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _decisionEntryLocalService.getDecisionEntryByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Updates the decision entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param decisionEntry the decision entry
	* @return the decision entry that was updated
	*/
	@Override
	public com.liferay.micro.maintainance.decision.model.DecisionEntry updateDecisionEntry(
		com.liferay.micro.maintainance.decision.model.DecisionEntry decisionEntry) {
		return _decisionEntryLocalService.updateDecisionEntry(decisionEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _decisionEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _decisionEntryLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _decisionEntryLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _decisionEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _decisionEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _decisionEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of decision entries.
	*
	* @return the number of decision entries
	*/
	@Override
	public int getDecisionEntriesCount() {
		return _decisionEntryLocalService.getDecisionEntriesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _decisionEntryLocalService.getOSGiServiceIdentifier();
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
		return _decisionEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.decision.model.impl.DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _decisionEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.decision.model.impl.DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _decisionEntryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the decision entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.decision.model.impl.DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of decision entries
	*/
	@Override
	public java.util.List<com.liferay.micro.maintainance.decision.model.DecisionEntry> getDecisionEntries(
		int start, int end) {
		return _decisionEntryLocalService.getDecisionEntries(start, end);
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
		return _decisionEntryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _decisionEntryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public DecisionEntryLocalService getWrappedService() {
		return _decisionEntryLocalService;
	}

	@Override
	public void setWrappedService(
		DecisionEntryLocalService decisionEntryLocalService) {
		_decisionEntryLocalService = decisionEntryLocalService;
	}

	private DecisionEntryLocalService _decisionEntryLocalService;
}