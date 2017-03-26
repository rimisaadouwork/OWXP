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

package com.liferay.micro.maintainance.analysis.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;

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
 * Provides the local service interface for AnalysisEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisEntryLocalServiceUtil
 * @see com.liferay.micro.maintainance.analysis.service.base.AnalysisEntryLocalServiceBaseImpl
 * @see com.liferay.micro.maintainance.analysis.service.impl.AnalysisEntryLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AnalysisEntryLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnalysisEntryLocalServiceUtil} to access the analysis entry local service. Add custom service methods to {@link com.liferay.micro.maintainance.analysis.service.impl.AnalysisEntryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the analysis entry to the database. Also notifies the appropriate model listeners.
	*
	* @param analysisEntry the analysis entry
	* @return the analysis entry that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public AnalysisEntry addAnalysisEntry(AnalysisEntry analysisEntry);

	/**
	* Adds an analysis entry, which will store the votes
	*
	* @param userId: the id of the user who flagged the page
	* @param candidateMaintenanceId: the id of the CandidateMaintenance entry, in which the
	assignment between a task and a candidate is stored.
	* @return the AnalysisEntry that was added
	* @throws PortalException
	*/
	public AnalysisEntry addAnalysisEntry(long userId,
		long candidateMaintenanceId) throws PortalException;

	/**
	* Creates a new analysis entry with the primary key. Does not add the analysis entry to the database.
	*
	* @param analysisEntryId the primary key for the new analysis entry
	* @return the new analysis entry
	*/
	public AnalysisEntry createAnalysisEntry(long analysisEntryId);

	/**
	* Deletes the analysis entry from the database. Also notifies the appropriate model listeners.
	*
	* @param analysisEntry the analysis entry
	* @return the analysis entry that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public AnalysisEntry deleteAnalysisEntry(AnalysisEntry analysisEntry);

	/**
	* Deletes the analysis entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analysisEntryId the primary key of the analysis entry
	* @return the analysis entry that was removed
	* @throws PortalException if a analysis entry with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public AnalysisEntry deleteAnalysisEntry(long analysisEntryId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnalysisEntry fetchAnalysisEntry(long analysisEntryId);

	/**
	* Returns the analysis entry with the matching UUID and company.
	*
	* @param uuid the analysis entry's UUID
	* @param companyId the primary key of the company
	* @return the matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnalysisEntry fetchAnalysisEntryByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnalysisEntry getAnalysisByCandidateMaintenance(
		long candidateMaintenanceId);

	/**
	* Returns the analysis entry with the primary key.
	*
	* @param analysisEntryId the primary key of the analysis entry
	* @return the analysis entry
	* @throws PortalException if a analysis entry with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnalysisEntry getAnalysisEntry(long analysisEntryId)
		throws PortalException;

	/**
	* Returns the analysis entry with the matching UUID and company.
	*
	* @param uuid the analysis entry's UUID
	* @param companyId the primary key of the company
	* @return the matching analysis entry
	* @throws PortalException if a matching analysis entry could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnalysisEntry getAnalysisEntryByUuidAndCompanyId(
		java.lang.String uuid, long companyId) throws PortalException;

	/**
	* Updates the analysis entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param analysisEntry the analysis entry
	* @return the analysis entry that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public AnalysisEntry updateAnalysisEntry(AnalysisEntry analysisEntry);

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
	* Returns the number of analysis entries.
	*
	* @return the number of analysis entries
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnalysisEntriesCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.analysis.model.impl.AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.analysis.model.impl.AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the analysis entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.analysis.model.impl.AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of analysis entries
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnalysisEntry> getAnalysisEntries(int start, int end);

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