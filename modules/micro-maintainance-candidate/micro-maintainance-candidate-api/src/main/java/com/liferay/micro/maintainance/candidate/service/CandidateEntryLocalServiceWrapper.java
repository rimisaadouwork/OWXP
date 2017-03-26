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
 * Provides a wrapper for {@link CandidateEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateEntryLocalService
 * @generated
 */
@ProviderType
public class CandidateEntryLocalServiceWrapper
	implements CandidateEntryLocalService,
		ServiceWrapper<CandidateEntryLocalService> {
	public CandidateEntryLocalServiceWrapper(
		CandidateEntryLocalService candidateEntryLocalService) {
		_candidateEntryLocalService = candidateEntryLocalService;
	}

	/**
	* Adds the candidate entry to the database. Also notifies the appropriate model listeners.
	*
	* @param candidateEntry the candidate entry
	* @return the candidate entry that was added
	*/
	@Override
	public com.liferay.micro.maintainance.candidate.model.CandidateEntry addCandidateEntry(
		com.liferay.micro.maintainance.candidate.model.CandidateEntry candidateEntry) {
		return _candidateEntryLocalService.addCandidateEntry(candidateEntry);
	}

	/**
	* Upon flagging a wiki page for a certain maintenance task this method
	* creates a candidate entry, belonging to the page, in the database.
	* It also creates an AnalysisEntry element, in which the current status of
	* the voting is stored, and a CandidateMaintenance element, which binds the
	* task and the candidate together.
	*
	* @param userId: the id of the user who flagged the page
	* @param groupId: the id of the group to which the wiki page belongs
	* @param wikiPageId: the id of the flagged wiki page
	* @param taskId: the id of the maintenance task for which the page is
	flagged
	* @return the CandidateEntry that was added
	* @throws PortalException
	*/
	@Override
	public com.liferay.micro.maintainance.candidate.model.CandidateEntry addCandidateEntry(
		long userId, long groupId, long wikiPageId, long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateEntryLocalService.addCandidateEntry(userId, groupId,
			wikiPageId, taskId);
	}

	/**
	* Creates a new candidate entry with the primary key. Does not add the candidate entry to the database.
	*
	* @param candidateEntryId the primary key for the new candidate entry
	* @return the new candidate entry
	*/
	@Override
	public com.liferay.micro.maintainance.candidate.model.CandidateEntry createCandidateEntry(
		long candidateEntryId) {
		return _candidateEntryLocalService.createCandidateEntry(candidateEntryId);
	}

	/**
	* Deletes the candidate entry from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateEntry the candidate entry
	* @return the candidate entry that was removed
	*/
	@Override
	public com.liferay.micro.maintainance.candidate.model.CandidateEntry deleteCandidateEntry(
		com.liferay.micro.maintainance.candidate.model.CandidateEntry candidateEntry) {
		return _candidateEntryLocalService.deleteCandidateEntry(candidateEntry);
	}

	/**
	* Deletes the candidate entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateEntryId the primary key of the candidate entry
	* @return the candidate entry that was removed
	* @throws PortalException if a candidate entry with the primary key could not be found
	*/
	@Override
	public com.liferay.micro.maintainance.candidate.model.CandidateEntry deleteCandidateEntry(
		long candidateEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateEntryLocalService.deleteCandidateEntry(candidateEntryId);
	}

	@Override
	public com.liferay.micro.maintainance.candidate.model.CandidateEntry fetchCandidateEntry(
		long candidateEntryId) {
		return _candidateEntryLocalService.fetchCandidateEntry(candidateEntryId);
	}

	/**
	* Returns the candidate entry matching the UUID and group.
	*
	* @param uuid the candidate entry's UUID
	* @param groupId the primary key of the group
	* @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	@Override
	public com.liferay.micro.maintainance.candidate.model.CandidateEntry fetchCandidateEntryByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _candidateEntryLocalService.fetchCandidateEntryByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.liferay.micro.maintainance.candidate.model.CandidateEntry getCandidateByWikiPageId(
		long wikiPageId) {
		return _candidateEntryLocalService.getCandidateByWikiPageId(wikiPageId);
	}

	/**
	* Returns the candidate entry with the primary key.
	*
	* @param candidateEntryId the primary key of the candidate entry
	* @return the candidate entry
	* @throws PortalException if a candidate entry with the primary key could not be found
	*/
	@Override
	public com.liferay.micro.maintainance.candidate.model.CandidateEntry getCandidateEntry(
		long candidateEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateEntryLocalService.getCandidateEntry(candidateEntryId);
	}

	/**
	* Returns the candidate entry matching the UUID and group.
	*
	* @param uuid the candidate entry's UUID
	* @param groupId the primary key of the group
	* @return the matching candidate entry
	* @throws PortalException if a matching candidate entry could not be found
	*/
	@Override
	public com.liferay.micro.maintainance.candidate.model.CandidateEntry getCandidateEntryByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateEntryLocalService.getCandidateEntryByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the candidate entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param candidateEntry the candidate entry
	* @return the candidate entry that was updated
	*/
	@Override
	public com.liferay.micro.maintainance.candidate.model.CandidateEntry updateCandidateEntry(
		com.liferay.micro.maintainance.candidate.model.CandidateEntry candidateEntry) {
		return _candidateEntryLocalService.updateCandidateEntry(candidateEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _candidateEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _candidateEntryLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _candidateEntryLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _candidateEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of candidate entries.
	*
	* @return the number of candidate entries
	*/
	@Override
	public int getCandidateEntriesCount() {
		return _candidateEntryLocalService.getCandidateEntriesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _candidateEntryLocalService.getOSGiServiceIdentifier();
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
		return _candidateEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.candidate.model.impl.CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _candidateEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.candidate.model.impl.CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _candidateEntryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the candidate entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.candidate.model.impl.CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @return the range of candidate entries
	*/
	@Override
	public java.util.List<com.liferay.micro.maintainance.candidate.model.CandidateEntry> getCandidateEntries(
		int start, int end) {
		return _candidateEntryLocalService.getCandidateEntries(start, end);
	}

	/**
	* Returns all the candidate entries matching the UUID and company.
	*
	* @param uuid the UUID of the candidate entries
	* @param companyId the primary key of the company
	* @return the matching candidate entries, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.micro.maintainance.candidate.model.CandidateEntry> getCandidateEntriesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _candidateEntryLocalService.getCandidateEntriesByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of candidate entries matching the UUID and company.
	*
	* @param uuid the UUID of the candidate entries
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching candidate entries, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.micro.maintainance.candidate.model.CandidateEntry> getCandidateEntriesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.micro.maintainance.candidate.model.CandidateEntry> orderByComparator) {
		return _candidateEntryLocalService.getCandidateEntriesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
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
		return _candidateEntryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _candidateEntryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public CandidateEntryLocalService getWrappedService() {
		return _candidateEntryLocalService;
	}

	@Override
	public void setWrappedService(
		CandidateEntryLocalService candidateEntryLocalService) {
		_candidateEntryLocalService = candidateEntryLocalService;
	}

	private CandidateEntryLocalService _candidateEntryLocalService;
}