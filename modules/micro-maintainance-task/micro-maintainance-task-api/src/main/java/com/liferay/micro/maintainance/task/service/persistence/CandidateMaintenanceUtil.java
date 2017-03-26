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

package com.liferay.micro.maintainance.task.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.task.model.CandidateMaintenance;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the candidate maintenance service. This utility wraps {@link com.liferay.micro.maintainance.task.service.persistence.impl.CandidateMaintenancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateMaintenancePersistence
 * @see com.liferay.micro.maintainance.task.service.persistence.impl.CandidateMaintenancePersistenceImpl
 * @generated
 */
@ProviderType
public class CandidateMaintenanceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CandidateMaintenance candidateMaintenance) {
		getPersistence().clearCache(candidateMaintenance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CandidateMaintenance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CandidateMaintenance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CandidateMaintenance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CandidateMaintenance> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CandidateMaintenance update(
		CandidateMaintenance candidateMaintenance) {
		return getPersistence().update(candidateMaintenance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CandidateMaintenance update(
		CandidateMaintenance candidateMaintenance, ServiceContext serviceContext) {
		return getPersistence().update(candidateMaintenance, serviceContext);
	}

	/**
	* Returns all the candidate maintenances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching candidate maintenances
	*/
	public static List<CandidateMaintenance> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the candidate maintenances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateMaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of candidate maintenances
	* @param end the upper bound of the range of candidate maintenances (not inclusive)
	* @return the range of matching candidate maintenances
	*/
	public static List<CandidateMaintenance> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the candidate maintenances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateMaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of candidate maintenances
	* @param end the upper bound of the range of candidate maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate maintenances
	*/
	public static List<CandidateMaintenance> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<CandidateMaintenance> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate maintenances where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateMaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of candidate maintenances
	* @param end the upper bound of the range of candidate maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate maintenances
	*/
	public static List<CandidateMaintenance> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<CandidateMaintenance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first candidate maintenance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a matching candidate maintenance could not be found
	*/
	public static CandidateMaintenance findByUuid_First(java.lang.String uuid,
		OrderByComparator<CandidateMaintenance> orderByComparator)
		throws com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first candidate maintenance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public static CandidateMaintenance fetchByUuid_First(
		java.lang.String uuid,
		OrderByComparator<CandidateMaintenance> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last candidate maintenance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a matching candidate maintenance could not be found
	*/
	public static CandidateMaintenance findByUuid_Last(java.lang.String uuid,
		OrderByComparator<CandidateMaintenance> orderByComparator)
		throws com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last candidate maintenance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public static CandidateMaintenance fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<CandidateMaintenance> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the candidate maintenances before and after the current candidate maintenance in the ordered set where uuid = &#63;.
	*
	* @param candidateMaintenanceId the primary key of the current candidate maintenance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a candidate maintenance with the primary key could not be found
	*/
	public static CandidateMaintenance[] findByUuid_PrevAndNext(
		long candidateMaintenanceId, java.lang.String uuid,
		OrderByComparator<CandidateMaintenance> orderByComparator)
		throws com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException {
		return getPersistence()
				   .findByUuid_PrevAndNext(candidateMaintenanceId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the candidate maintenances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of candidate maintenances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching candidate maintenances
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the candidate maintenances where candidateEntryId = &#63;.
	*
	* @param candidateEntryId the candidate entry ID
	* @return the matching candidate maintenances
	*/
	public static List<CandidateMaintenance> findByCandidateEntryIds(
		long candidateEntryId) {
		return getPersistence().findByCandidateEntryIds(candidateEntryId);
	}

	/**
	* Returns a range of all the candidate maintenances where candidateEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateMaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateEntryId the candidate entry ID
	* @param start the lower bound of the range of candidate maintenances
	* @param end the upper bound of the range of candidate maintenances (not inclusive)
	* @return the range of matching candidate maintenances
	*/
	public static List<CandidateMaintenance> findByCandidateEntryIds(
		long candidateEntryId, int start, int end) {
		return getPersistence()
				   .findByCandidateEntryIds(candidateEntryId, start, end);
	}

	/**
	* Returns an ordered range of all the candidate maintenances where candidateEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateMaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateEntryId the candidate entry ID
	* @param start the lower bound of the range of candidate maintenances
	* @param end the upper bound of the range of candidate maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate maintenances
	*/
	public static List<CandidateMaintenance> findByCandidateEntryIds(
		long candidateEntryId, int start, int end,
		OrderByComparator<CandidateMaintenance> orderByComparator) {
		return getPersistence()
				   .findByCandidateEntryIds(candidateEntryId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate maintenances where candidateEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateMaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateEntryId the candidate entry ID
	* @param start the lower bound of the range of candidate maintenances
	* @param end the upper bound of the range of candidate maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate maintenances
	*/
	public static List<CandidateMaintenance> findByCandidateEntryIds(
		long candidateEntryId, int start, int end,
		OrderByComparator<CandidateMaintenance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCandidateEntryIds(candidateEntryId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first candidate maintenance in the ordered set where candidateEntryId = &#63;.
	*
	* @param candidateEntryId the candidate entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a matching candidate maintenance could not be found
	*/
	public static CandidateMaintenance findByCandidateEntryIds_First(
		long candidateEntryId,
		OrderByComparator<CandidateMaintenance> orderByComparator)
		throws com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException {
		return getPersistence()
				   .findByCandidateEntryIds_First(candidateEntryId,
			orderByComparator);
	}

	/**
	* Returns the first candidate maintenance in the ordered set where candidateEntryId = &#63;.
	*
	* @param candidateEntryId the candidate entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public static CandidateMaintenance fetchByCandidateEntryIds_First(
		long candidateEntryId,
		OrderByComparator<CandidateMaintenance> orderByComparator) {
		return getPersistence()
				   .fetchByCandidateEntryIds_First(candidateEntryId,
			orderByComparator);
	}

	/**
	* Returns the last candidate maintenance in the ordered set where candidateEntryId = &#63;.
	*
	* @param candidateEntryId the candidate entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a matching candidate maintenance could not be found
	*/
	public static CandidateMaintenance findByCandidateEntryIds_Last(
		long candidateEntryId,
		OrderByComparator<CandidateMaintenance> orderByComparator)
		throws com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException {
		return getPersistence()
				   .findByCandidateEntryIds_Last(candidateEntryId,
			orderByComparator);
	}

	/**
	* Returns the last candidate maintenance in the ordered set where candidateEntryId = &#63;.
	*
	* @param candidateEntryId the candidate entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public static CandidateMaintenance fetchByCandidateEntryIds_Last(
		long candidateEntryId,
		OrderByComparator<CandidateMaintenance> orderByComparator) {
		return getPersistence()
				   .fetchByCandidateEntryIds_Last(candidateEntryId,
			orderByComparator);
	}

	/**
	* Returns the candidate maintenances before and after the current candidate maintenance in the ordered set where candidateEntryId = &#63;.
	*
	* @param candidateMaintenanceId the primary key of the current candidate maintenance
	* @param candidateEntryId the candidate entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a candidate maintenance with the primary key could not be found
	*/
	public static CandidateMaintenance[] findByCandidateEntryIds_PrevAndNext(
		long candidateMaintenanceId, long candidateEntryId,
		OrderByComparator<CandidateMaintenance> orderByComparator)
		throws com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException {
		return getPersistence()
				   .findByCandidateEntryIds_PrevAndNext(candidateMaintenanceId,
			candidateEntryId, orderByComparator);
	}

	/**
	* Removes all the candidate maintenances where candidateEntryId = &#63; from the database.
	*
	* @param candidateEntryId the candidate entry ID
	*/
	public static void removeByCandidateEntryIds(long candidateEntryId) {
		getPersistence().removeByCandidateEntryIds(candidateEntryId);
	}

	/**
	* Returns the number of candidate maintenances where candidateEntryId = &#63;.
	*
	* @param candidateEntryId the candidate entry ID
	* @return the number of matching candidate maintenances
	*/
	public static int countByCandidateEntryIds(long candidateEntryId) {
		return getPersistence().countByCandidateEntryIds(candidateEntryId);
	}

	/**
	* Returns all the candidate maintenances where taskEntryId = &#63;.
	*
	* @param taskEntryId the task entry ID
	* @return the matching candidate maintenances
	*/
	public static List<CandidateMaintenance> findByTaskEntryIds(
		long taskEntryId) {
		return getPersistence().findByTaskEntryIds(taskEntryId);
	}

	/**
	* Returns a range of all the candidate maintenances where taskEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateMaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param taskEntryId the task entry ID
	* @param start the lower bound of the range of candidate maintenances
	* @param end the upper bound of the range of candidate maintenances (not inclusive)
	* @return the range of matching candidate maintenances
	*/
	public static List<CandidateMaintenance> findByTaskEntryIds(
		long taskEntryId, int start, int end) {
		return getPersistence().findByTaskEntryIds(taskEntryId, start, end);
	}

	/**
	* Returns an ordered range of all the candidate maintenances where taskEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateMaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param taskEntryId the task entry ID
	* @param start the lower bound of the range of candidate maintenances
	* @param end the upper bound of the range of candidate maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate maintenances
	*/
	public static List<CandidateMaintenance> findByTaskEntryIds(
		long taskEntryId, int start, int end,
		OrderByComparator<CandidateMaintenance> orderByComparator) {
		return getPersistence()
				   .findByTaskEntryIds(taskEntryId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate maintenances where taskEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateMaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param taskEntryId the task entry ID
	* @param start the lower bound of the range of candidate maintenances
	* @param end the upper bound of the range of candidate maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate maintenances
	*/
	public static List<CandidateMaintenance> findByTaskEntryIds(
		long taskEntryId, int start, int end,
		OrderByComparator<CandidateMaintenance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByTaskEntryIds(taskEntryId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first candidate maintenance in the ordered set where taskEntryId = &#63;.
	*
	* @param taskEntryId the task entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a matching candidate maintenance could not be found
	*/
	public static CandidateMaintenance findByTaskEntryIds_First(
		long taskEntryId,
		OrderByComparator<CandidateMaintenance> orderByComparator)
		throws com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException {
		return getPersistence()
				   .findByTaskEntryIds_First(taskEntryId, orderByComparator);
	}

	/**
	* Returns the first candidate maintenance in the ordered set where taskEntryId = &#63;.
	*
	* @param taskEntryId the task entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public static CandidateMaintenance fetchByTaskEntryIds_First(
		long taskEntryId,
		OrderByComparator<CandidateMaintenance> orderByComparator) {
		return getPersistence()
				   .fetchByTaskEntryIds_First(taskEntryId, orderByComparator);
	}

	/**
	* Returns the last candidate maintenance in the ordered set where taskEntryId = &#63;.
	*
	* @param taskEntryId the task entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a matching candidate maintenance could not be found
	*/
	public static CandidateMaintenance findByTaskEntryIds_Last(
		long taskEntryId,
		OrderByComparator<CandidateMaintenance> orderByComparator)
		throws com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException {
		return getPersistence()
				   .findByTaskEntryIds_Last(taskEntryId, orderByComparator);
	}

	/**
	* Returns the last candidate maintenance in the ordered set where taskEntryId = &#63;.
	*
	* @param taskEntryId the task entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public static CandidateMaintenance fetchByTaskEntryIds_Last(
		long taskEntryId,
		OrderByComparator<CandidateMaintenance> orderByComparator) {
		return getPersistence()
				   .fetchByTaskEntryIds_Last(taskEntryId, orderByComparator);
	}

	/**
	* Returns the candidate maintenances before and after the current candidate maintenance in the ordered set where taskEntryId = &#63;.
	*
	* @param candidateMaintenanceId the primary key of the current candidate maintenance
	* @param taskEntryId the task entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a candidate maintenance with the primary key could not be found
	*/
	public static CandidateMaintenance[] findByTaskEntryIds_PrevAndNext(
		long candidateMaintenanceId, long taskEntryId,
		OrderByComparator<CandidateMaintenance> orderByComparator)
		throws com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException {
		return getPersistence()
				   .findByTaskEntryIds_PrevAndNext(candidateMaintenanceId,
			taskEntryId, orderByComparator);
	}

	/**
	* Removes all the candidate maintenances where taskEntryId = &#63; from the database.
	*
	* @param taskEntryId the task entry ID
	*/
	public static void removeByTaskEntryIds(long taskEntryId) {
		getPersistence().removeByTaskEntryIds(taskEntryId);
	}

	/**
	* Returns the number of candidate maintenances where taskEntryId = &#63;.
	*
	* @param taskEntryId the task entry ID
	* @return the number of matching candidate maintenances
	*/
	public static int countByTaskEntryIds(long taskEntryId) {
		return getPersistence().countByTaskEntryIds(taskEntryId);
	}

	/**
	* Returns the candidate maintenance where candidateEntryId = &#63; and taskEntryId = &#63; or throws a {@link NoSuchCandidateMaintenanceException} if it could not be found.
	*
	* @param candidateEntryId the candidate entry ID
	* @param taskEntryId the task entry ID
	* @return the matching candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a matching candidate maintenance could not be found
	*/
	public static CandidateMaintenance findByC_T(long candidateEntryId,
		long taskEntryId)
		throws com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException {
		return getPersistence().findByC_T(candidateEntryId, taskEntryId);
	}

	/**
	* Returns the candidate maintenance where candidateEntryId = &#63; and taskEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param candidateEntryId the candidate entry ID
	* @param taskEntryId the task entry ID
	* @return the matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public static CandidateMaintenance fetchByC_T(long candidateEntryId,
		long taskEntryId) {
		return getPersistence().fetchByC_T(candidateEntryId, taskEntryId);
	}

	/**
	* Returns the candidate maintenance where candidateEntryId = &#63; and taskEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param candidateEntryId the candidate entry ID
	* @param taskEntryId the task entry ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public static CandidateMaintenance fetchByC_T(long candidateEntryId,
		long taskEntryId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByC_T(candidateEntryId, taskEntryId, retrieveFromCache);
	}

	/**
	* Removes the candidate maintenance where candidateEntryId = &#63; and taskEntryId = &#63; from the database.
	*
	* @param candidateEntryId the candidate entry ID
	* @param taskEntryId the task entry ID
	* @return the candidate maintenance that was removed
	*/
	public static CandidateMaintenance removeByC_T(long candidateEntryId,
		long taskEntryId)
		throws com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException {
		return getPersistence().removeByC_T(candidateEntryId, taskEntryId);
	}

	/**
	* Returns the number of candidate maintenances where candidateEntryId = &#63; and taskEntryId = &#63;.
	*
	* @param candidateEntryId the candidate entry ID
	* @param taskEntryId the task entry ID
	* @return the number of matching candidate maintenances
	*/
	public static int countByC_T(long candidateEntryId, long taskEntryId) {
		return getPersistence().countByC_T(candidateEntryId, taskEntryId);
	}

	/**
	* Caches the candidate maintenance in the entity cache if it is enabled.
	*
	* @param candidateMaintenance the candidate maintenance
	*/
	public static void cacheResult(CandidateMaintenance candidateMaintenance) {
		getPersistence().cacheResult(candidateMaintenance);
	}

	/**
	* Caches the candidate maintenances in the entity cache if it is enabled.
	*
	* @param candidateMaintenances the candidate maintenances
	*/
	public static void cacheResult(
		List<CandidateMaintenance> candidateMaintenances) {
		getPersistence().cacheResult(candidateMaintenances);
	}

	/**
	* Creates a new candidate maintenance with the primary key. Does not add the candidate maintenance to the database.
	*
	* @param candidateMaintenanceId the primary key for the new candidate maintenance
	* @return the new candidate maintenance
	*/
	public static CandidateMaintenance create(long candidateMaintenanceId) {
		return getPersistence().create(candidateMaintenanceId);
	}

	/**
	* Removes the candidate maintenance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateMaintenanceId the primary key of the candidate maintenance
	* @return the candidate maintenance that was removed
	* @throws NoSuchCandidateMaintenanceException if a candidate maintenance with the primary key could not be found
	*/
	public static CandidateMaintenance remove(long candidateMaintenanceId)
		throws com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException {
		return getPersistence().remove(candidateMaintenanceId);
	}

	public static CandidateMaintenance updateImpl(
		CandidateMaintenance candidateMaintenance) {
		return getPersistence().updateImpl(candidateMaintenance);
	}

	/**
	* Returns the candidate maintenance with the primary key or throws a {@link NoSuchCandidateMaintenanceException} if it could not be found.
	*
	* @param candidateMaintenanceId the primary key of the candidate maintenance
	* @return the candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a candidate maintenance with the primary key could not be found
	*/
	public static CandidateMaintenance findByPrimaryKey(
		long candidateMaintenanceId)
		throws com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException {
		return getPersistence().findByPrimaryKey(candidateMaintenanceId);
	}

	/**
	* Returns the candidate maintenance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidateMaintenanceId the primary key of the candidate maintenance
	* @return the candidate maintenance, or <code>null</code> if a candidate maintenance with the primary key could not be found
	*/
	public static CandidateMaintenance fetchByPrimaryKey(
		long candidateMaintenanceId) {
		return getPersistence().fetchByPrimaryKey(candidateMaintenanceId);
	}

	public static java.util.Map<java.io.Serializable, CandidateMaintenance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the candidate maintenances.
	*
	* @return the candidate maintenances
	*/
	public static List<CandidateMaintenance> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the candidate maintenances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateMaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate maintenances
	* @param end the upper bound of the range of candidate maintenances (not inclusive)
	* @return the range of candidate maintenances
	*/
	public static List<CandidateMaintenance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the candidate maintenances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateMaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate maintenances
	* @param end the upper bound of the range of candidate maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of candidate maintenances
	*/
	public static List<CandidateMaintenance> findAll(int start, int end,
		OrderByComparator<CandidateMaintenance> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate maintenances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateMaintenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate maintenances
	* @param end the upper bound of the range of candidate maintenances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of candidate maintenances
	*/
	public static List<CandidateMaintenance> findAll(int start, int end,
		OrderByComparator<CandidateMaintenance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the candidate maintenances from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of candidate maintenances.
	*
	* @return the number of candidate maintenances
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CandidateMaintenancePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CandidateMaintenancePersistence, CandidateMaintenancePersistence> _serviceTracker =
		ServiceTrackerFactory.open(CandidateMaintenancePersistence.class);
}