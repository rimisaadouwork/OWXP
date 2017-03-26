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

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.micro.maintainance.candidate.model.CandidateEntry;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for CandidateEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateEntryLocalServiceUtil
 * @see com.liferay.micro.maintainance.candidate.service.base.CandidateEntryLocalServiceBaseImpl
 * @see com.liferay.micro.maintainance.candidate.service.impl.CandidateEntryLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CandidateEntryLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CandidateEntryLocalServiceUtil} to access the candidate entry local service. Add custom service methods to {@link com.liferay.micro.maintainance.candidate.service.impl.CandidateEntryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the candidate entry to the database. Also notifies the appropriate model listeners.
	*
	* @param candidateEntry the candidate entry
	* @return the candidate entry that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public CandidateEntry addCandidateEntry(CandidateEntry candidateEntry);

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
	public CandidateEntry addCandidateEntry(long userId, long groupId,
		long wikiPageId, long taskId) throws PortalException;

	/**
	* Creates a new candidate entry with the primary key. Does not add the candidate entry to the database.
	*
	* @param candidateEntryId the primary key for the new candidate entry
	* @return the new candidate entry
	*/
	public CandidateEntry createCandidateEntry(long candidateEntryId);

	/**
	* Deletes the candidate entry from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateEntry the candidate entry
	* @return the candidate entry that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public CandidateEntry deleteCandidateEntry(CandidateEntry candidateEntry);

	/**
	* Deletes the candidate entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateEntryId the primary key of the candidate entry
	* @return the candidate entry that was removed
	* @throws PortalException if a candidate entry with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public CandidateEntry deleteCandidateEntry(long candidateEntryId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CandidateEntry fetchCandidateEntry(long candidateEntryId);

	/**
	* Returns the candidate entry matching the UUID and group.
	*
	* @param uuid the candidate entry's UUID
	* @param groupId the primary key of the group
	* @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CandidateEntry fetchCandidateEntryByUuidAndGroupId(
		java.lang.String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CandidateEntry getCandidateByWikiPageId(long wikiPageId);

	/**
	* Returns the candidate entry with the primary key.
	*
	* @param candidateEntryId the primary key of the candidate entry
	* @return the candidate entry
	* @throws PortalException if a candidate entry with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CandidateEntry getCandidateEntry(long candidateEntryId)
		throws PortalException;

	/**
	* Returns the candidate entry matching the UUID and group.
	*
	* @param uuid the candidate entry's UUID
	* @param groupId the primary key of the group
	* @return the matching candidate entry
	* @throws PortalException if a matching candidate entry could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CandidateEntry getCandidateEntryByUuidAndGroupId(
		java.lang.String uuid, long groupId) throws PortalException;

	/**
	* Updates the candidate entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param candidateEntry the candidate entry
	* @return the candidate entry that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public CandidateEntry updateCandidateEntry(CandidateEntry candidateEntry);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the number of candidate entries.
	*
	* @return the number of candidate entries
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCandidateEntriesCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CandidateEntry> getCandidateEntries(int start, int end);

	/**
	* Returns all the candidate entries matching the UUID and company.
	*
	* @param uuid the UUID of the candidate entries
	* @param companyId the primary key of the company
	* @return the matching candidate entries, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CandidateEntry> getCandidateEntriesByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CandidateEntry> getCandidateEntriesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}