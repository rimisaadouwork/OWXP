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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CandidateMaintenanceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateMaintenanceLocalService
 * @generated
 */
@ProviderType
public class CandidateMaintenanceLocalServiceWrapper
	implements CandidateMaintenanceLocalService,
		ServiceWrapper<CandidateMaintenanceLocalService> {
	public CandidateMaintenanceLocalServiceWrapper(
		CandidateMaintenanceLocalService candidateMaintenanceLocalService) {
		_candidateMaintenanceLocalService = candidateMaintenanceLocalService;
	}

	/**
	* Adds the candidate maintenance to the database. Also notifies the appropriate model listeners.
	*
	* @param candidateMaintenance the candidate maintenance
	* @return the candidate maintenance that was added
	*/
	@Override
	public com.liferay.micro.maintainance.task.model.CandidateMaintenance addCandidateMaintenance(
		com.liferay.micro.maintainance.task.model.CandidateMaintenance candidateMaintenance) {
		return _candidateMaintenanceLocalService.addCandidateMaintenance(candidateMaintenance);
	}

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
	@Override
	public com.liferay.micro.maintainance.task.model.CandidateMaintenance addCandidateMaintenance(
		long candidateEntryId, long taskEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateMaintenanceLocalService.addCandidateMaintenance(candidateEntryId,
			taskEntryId);
	}

	/**
	* Creates a new candidate maintenance with the primary key. Does not add the candidate maintenance to the database.
	*
	* @param candidateMaintenanceId the primary key for the new candidate maintenance
	* @return the new candidate maintenance
	*/
	@Override
	public com.liferay.micro.maintainance.task.model.CandidateMaintenance createCandidateMaintenance(
		long candidateMaintenanceId) {
		return _candidateMaintenanceLocalService.createCandidateMaintenance(candidateMaintenanceId);
	}

	/**
	* Deletes the candidate maintenance from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateMaintenance the candidate maintenance
	* @return the candidate maintenance that was removed
	*/
	@Override
	public com.liferay.micro.maintainance.task.model.CandidateMaintenance deleteCandidateMaintenance(
		com.liferay.micro.maintainance.task.model.CandidateMaintenance candidateMaintenance) {
		return _candidateMaintenanceLocalService.deleteCandidateMaintenance(candidateMaintenance);
	}

	/**
	* Deletes the candidate maintenance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateMaintenanceId the primary key of the candidate maintenance
	* @return the candidate maintenance that was removed
	* @throws PortalException if a candidate maintenance with the primary key could not be found
	*/
	@Override
	public com.liferay.micro.maintainance.task.model.CandidateMaintenance deleteCandidateMaintenance(
		long candidateMaintenanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateMaintenanceLocalService.deleteCandidateMaintenance(candidateMaintenanceId);
	}

	@Override
	public com.liferay.micro.maintainance.task.model.CandidateMaintenance fetchCandidateMaintenance(
		long candidateMaintenanceId) {
		return _candidateMaintenanceLocalService.fetchCandidateMaintenance(candidateMaintenanceId);
	}

	@Override
	public com.liferay.micro.maintainance.task.model.CandidateMaintenance getCandidateMaintenaceTask(
		long candidateEntryId, long taskEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateMaintenanceLocalService.getCandidateMaintenaceTask(candidateEntryId,
			taskEntryId);
	}

	/**
	* Returns the candidate maintenance with the primary key.
	*
	* @param candidateMaintenanceId the primary key of the candidate maintenance
	* @return the candidate maintenance
	* @throws PortalException if a candidate maintenance with the primary key could not be found
	*/
	@Override
	public com.liferay.micro.maintainance.task.model.CandidateMaintenance getCandidateMaintenance(
		long candidateMaintenanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateMaintenanceLocalService.getCandidateMaintenance(candidateMaintenanceId);
	}

	/**
	* Updates the candidate maintenance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param candidateMaintenance the candidate maintenance
	* @return the candidate maintenance that was updated
	*/
	@Override
	public com.liferay.micro.maintainance.task.model.CandidateMaintenance updateCandidateMaintenance(
		com.liferay.micro.maintainance.task.model.CandidateMaintenance candidateMaintenance) {
		return _candidateMaintenanceLocalService.updateCandidateMaintenance(candidateMaintenance);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _candidateMaintenanceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _candidateMaintenanceLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _candidateMaintenanceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateMaintenanceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateMaintenanceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of candidate maintenances.
	*
	* @return the number of candidate maintenances
	*/
	@Override
	public int getCandidateMaintenancesCount() {
		return _candidateMaintenanceLocalService.getCandidateMaintenancesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _candidateMaintenanceLocalService.getOSGiServiceIdentifier();
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
		return _candidateMaintenanceLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _candidateMaintenanceLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _candidateMaintenanceLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the task assignments belonging to the given candidate.
	*
	* @param candidatId
	* @return List of CandidateMaintenance entries with the given candidateEntryId
	*/
	@Override
	public java.util.List<com.liferay.micro.maintainance.task.model.CandidateMaintenance> getCandidateMaintenaceTasksByCandidate(
		long candidateEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateMaintenanceLocalService.getCandidateMaintenaceTasksByCandidate(candidateEntryId);
	}

	/**
	* Returns the candidate assignments belonging to the given task.
	*
	* @param taskEntryId
	* @return List of CandidateMaintenance entries with the given taskEntryId
	*/
	@Override
	public java.util.List<com.liferay.micro.maintainance.task.model.CandidateMaintenance> getCandidateMaintenaceTasksByTask(
		long taskEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateMaintenanceLocalService.getCandidateMaintenaceTasksByTask(taskEntryId);
	}

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
	@Override
	public java.util.List<com.liferay.micro.maintainance.task.model.CandidateMaintenance> getCandidateMaintenances(
		int start, int end) {
		return _candidateMaintenanceLocalService.getCandidateMaintenances(start,
			end);
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
		return _candidateMaintenanceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _candidateMaintenanceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Returns number of the task assignments belonging to the given candidate.
	*
	* @param candidatId
	* @return Number of CandidateMaintenance entries with the given candidateEntryId
	*/
	@Override
	public long getCandidateMaintenaceTasksCountByCandidate(
		long candidateEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateMaintenanceLocalService.getCandidateMaintenaceTasksCountByCandidate(candidateEntryId);
	}

	/**
	* Returns the number of the candidate assignments belonging to the given task.
	*
	* @param taskEntryId
	* @return Number of CandidateMaintenance entries with the given taskEntryId
	*/
	@Override
	public long getCandidateMaintenaceTasksCountByTask(long taskEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateMaintenanceLocalService.getCandidateMaintenaceTasksCountByTask(taskEntryId);
	}

	@Override
	public CandidateMaintenanceLocalService getWrappedService() {
		return _candidateMaintenanceLocalService;
	}

	@Override
	public void setWrappedService(
		CandidateMaintenanceLocalService candidateMaintenanceLocalService) {
		_candidateMaintenanceLocalService = candidateMaintenanceLocalService;
	}

	private CandidateMaintenanceLocalService _candidateMaintenanceLocalService;
}