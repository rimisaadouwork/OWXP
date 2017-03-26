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

package com.liferay.micro.maintainance.task.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.task.model.CandidateMaintenance;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
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
 * Provides the local service interface for CandidateMaintenance. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateMaintenanceLocalServiceUtil
 * @see com.liferay.micro.maintainance.task.service.base.CandidateMaintenanceLocalServiceBaseImpl
 * @see com.liferay.micro.maintainance.task.service.impl.CandidateMaintenanceLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CandidateMaintenanceLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CandidateMaintenanceLocalServiceUtil} to access the candidate maintenance local service. Add custom service methods to {@link com.liferay.micro.maintainance.task.service.impl.CandidateMaintenanceLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the candidate maintenance to the database. Also notifies the appropriate model listeners.
	*
	* @param candidateMaintenance the candidate maintenance
	* @return the candidate maintenance that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public CandidateMaintenance addCandidateMaintenance(
		CandidateMaintenance candidateMaintenance);

	/**
	* Adds a CandidateMaintenance entry to the database, this way assigning a
	* wiki page to a maintenance task. The users can vote, while this entry is
	* in the database.
	*
	* @param candidateEntryId: the id of the candidate entry belonging to the
	flagged wiki page
	* @param taskEntryId: the id of the maintenance task for which the page is
	flagged
	* @return the CandidateMaintenance entry that was added
	* @throws PortalException
	*/
	public CandidateMaintenance addCandidateMaintenance(long candidateEntryId,
		long taskEntryId) throws PortalException;

	/**
	* Creates a new candidate maintenance with the primary key. Does not add the candidate maintenance to the database.
	*
	* @param candidateMaintenanceId the primary key for the new candidate maintenance
	* @return the new candidate maintenance
	*/
	public CandidateMaintenance createCandidateMaintenance(
		long candidateMaintenanceId);

	/**
	* Deletes the candidate maintenance from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateMaintenance the candidate maintenance
	* @return the candidate maintenance that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public CandidateMaintenance deleteCandidateMaintenance(
		CandidateMaintenance candidateMaintenance);

	/**
	* Deletes the candidate maintenance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateMaintenanceId the primary key of the candidate maintenance
	* @return the candidate maintenance that was removed
	* @throws PortalException if a candidate maintenance with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public CandidateMaintenance deleteCandidateMaintenance(
		long candidateMaintenanceId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CandidateMaintenance fetchCandidateMaintenance(
		long candidateMaintenanceId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CandidateMaintenance getCandidateMaintenaceTask(
		long candidateEntryId, long taskEntryId) throws PortalException;

	/**
	* Returns the candidate maintenance with the primary key.
	*
	* @param candidateMaintenanceId the primary key of the candidate maintenance
	* @return the candidate maintenance
	* @throws PortalException if a candidate maintenance with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CandidateMaintenance getCandidateMaintenance(
		long candidateMaintenanceId) throws PortalException;

	/**
	* Updates the candidate maintenance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param candidateMaintenance the candidate maintenance
	* @return the candidate maintenance that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public CandidateMaintenance updateCandidateMaintenance(
		CandidateMaintenance candidateMaintenance);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

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
	* Returns the number of candidate maintenances.
	*
	* @return the number of candidate maintenances
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCandidateMaintenancesCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.task.model.impl.CandidateMaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.task.model.impl.CandidateMaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns the task assignments belonging to the given candidate.
	*
	* @param candidatId
	* @return List of CandidateMaintenance entries with the given candidateEntryId
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CandidateMaintenance> getCandidateMaintenaceTasksByCandidate(
		long candidateEntryId) throws PortalException;

	/**
	* Returns the candidate assignments belonging to the given task.
	*
	* @param taskEntryId
	* @return List of CandidateMaintenance entries with the given taskEntryId
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CandidateMaintenance> getCandidateMaintenaceTasksByTask(
		long taskEntryId) throws PortalException;

	/**
	* Returns a range of all the candidate maintenances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.task.model.impl.CandidateMaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate maintenances
	* @param end the upper bound of the range of candidate maintenances (not inclusive)
	* @return the range of candidate maintenances
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CandidateMaintenance> getCandidateMaintenances(int start,
		int end);

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

	/**
	* Returns number of the task assignments belonging to the given candidate.
	*
	* @param candidatId
	* @return Number of CandidateMaintenance entries with the given candidateEntryId
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getCandidateMaintenaceTasksCountByCandidate(
		long candidateEntryId) throws PortalException;

	/**
	* Returns the number of the candidate assignments belonging to the given task.
	*
	* @param taskEntryId
	* @return Number of CandidateMaintenance entries with the given taskEntryId
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getCandidateMaintenaceTasksCountByTask(long taskEntryId)
		throws PortalException;
}