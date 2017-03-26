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

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.micro.maintainance.decision.model.DecisionEntry;

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
 * Provides the local service interface for DecisionEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DecisionEntryLocalServiceUtil
 * @see com.liferay.micro.maintainance.decision.service.base.DecisionEntryLocalServiceBaseImpl
 * @see com.liferay.micro.maintainance.decision.service.impl.DecisionEntryLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface DecisionEntryLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DecisionEntryLocalServiceUtil} to access the decision entry local service. Add custom service methods to {@link com.liferay.micro.maintainance.decision.service.impl.DecisionEntryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the decision entry to the database. Also notifies the appropriate model listeners.
	*
	* @param decisionEntry the decision entry
	* @return the decision entry that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public DecisionEntry addDecisionEntry(DecisionEntry decisionEntry);

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
	public DecisionEntry addDecisionEntry(long userId,
		java.lang.String analysisData, long candidateEntryId,
		java.lang.String outcome, boolean handled) throws PortalException;

	/**
	* Creates a new decision entry with the primary key. Does not add the decision entry to the database.
	*
	* @param decisionEntryId the primary key for the new decision entry
	* @return the new decision entry
	*/
	public DecisionEntry createDecisionEntry(long decisionEntryId);

	/**
	* Deletes the decision entry from the database. Also notifies the appropriate model listeners.
	*
	* @param decisionEntry the decision entry
	* @return the decision entry that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public DecisionEntry deleteDecisionEntry(DecisionEntry decisionEntry);

	/**
	* Deletes the decision entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param decisionEntryId the primary key of the decision entry
	* @return the decision entry that was removed
	* @throws PortalException if a decision entry with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public DecisionEntry deleteDecisionEntry(long decisionEntryId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DecisionEntry fetchDecisionEntry(long decisionEntryId);

	/**
	* Returns the decision entry with the matching UUID and company.
	*
	* @param uuid the decision entry's UUID
	* @param companyId the primary key of the company
	* @return the matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DecisionEntry fetchDecisionEntryByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns the decision entry with the primary key.
	*
	* @param decisionEntryId the primary key of the decision entry
	* @return the decision entry
	* @throws PortalException if a decision entry with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DecisionEntry getDecisionEntry(long decisionEntryId)
		throws PortalException;

	/**
	* Returns the decision entry with the matching UUID and company.
	*
	* @param uuid the decision entry's UUID
	* @param companyId the primary key of the company
	* @return the matching decision entry
	* @throws PortalException if a matching decision entry could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DecisionEntry getDecisionEntryByUuidAndCompanyId(
		java.lang.String uuid, long companyId) throws PortalException;

	/**
	* Updates the decision entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param decisionEntry the decision entry
	* @return the decision entry that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public DecisionEntry updateDecisionEntry(DecisionEntry decisionEntry);

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
	* Returns the number of decision entries.
	*
	* @return the number of decision entries
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDecisionEntriesCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.decision.model.impl.DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.decision.model.impl.DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DecisionEntry> getDecisionEntries(int start, int end);

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