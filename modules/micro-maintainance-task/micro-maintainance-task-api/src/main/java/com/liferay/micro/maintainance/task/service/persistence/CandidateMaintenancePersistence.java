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

import com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the candidate maintenance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.micro.maintainance.task.service.persistence.impl.CandidateMaintenancePersistenceImpl
 * @see CandidateMaintenanceUtil
 * @generated
 */
@ProviderType
public interface CandidateMaintenancePersistence extends BasePersistence<CandidateMaintenance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CandidateMaintenanceUtil} to access the candidate maintenance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the candidate maintenances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching candidate maintenances
	*/
	public java.util.List<CandidateMaintenance> findByUuid(
		java.lang.String uuid);

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
	public java.util.List<CandidateMaintenance> findByUuid(
		java.lang.String uuid, int start, int end);

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
	public java.util.List<CandidateMaintenance> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator);

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
	public java.util.List<CandidateMaintenance> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate maintenance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a matching candidate maintenance could not be found
	*/
	public CandidateMaintenance findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator)
		throws NoSuchCandidateMaintenanceException;

	/**
	* Returns the first candidate maintenance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public CandidateMaintenance fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator);

	/**
	* Returns the last candidate maintenance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a matching candidate maintenance could not be found
	*/
	public CandidateMaintenance findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator)
		throws NoSuchCandidateMaintenanceException;

	/**
	* Returns the last candidate maintenance in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public CandidateMaintenance fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator);

	/**
	* Returns the candidate maintenances before and after the current candidate maintenance in the ordered set where uuid = &#63;.
	*
	* @param candidateMaintenanceId the primary key of the current candidate maintenance
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a candidate maintenance with the primary key could not be found
	*/
	public CandidateMaintenance[] findByUuid_PrevAndNext(
		long candidateMaintenanceId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator)
		throws NoSuchCandidateMaintenanceException;

	/**
	* Removes all the candidate maintenances where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of candidate maintenances where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching candidate maintenances
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the candidate maintenances where candidateEntryId = &#63;.
	*
	* @param candidateEntryId the candidate entry ID
	* @return the matching candidate maintenances
	*/
	public java.util.List<CandidateMaintenance> findByCandidateEntryIds(
		long candidateEntryId);

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
	public java.util.List<CandidateMaintenance> findByCandidateEntryIds(
		long candidateEntryId, int start, int end);

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
	public java.util.List<CandidateMaintenance> findByCandidateEntryIds(
		long candidateEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator);

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
	public java.util.List<CandidateMaintenance> findByCandidateEntryIds(
		long candidateEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate maintenance in the ordered set where candidateEntryId = &#63;.
	*
	* @param candidateEntryId the candidate entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a matching candidate maintenance could not be found
	*/
	public CandidateMaintenance findByCandidateEntryIds_First(
		long candidateEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator)
		throws NoSuchCandidateMaintenanceException;

	/**
	* Returns the first candidate maintenance in the ordered set where candidateEntryId = &#63;.
	*
	* @param candidateEntryId the candidate entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public CandidateMaintenance fetchByCandidateEntryIds_First(
		long candidateEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator);

	/**
	* Returns the last candidate maintenance in the ordered set where candidateEntryId = &#63;.
	*
	* @param candidateEntryId the candidate entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a matching candidate maintenance could not be found
	*/
	public CandidateMaintenance findByCandidateEntryIds_Last(
		long candidateEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator)
		throws NoSuchCandidateMaintenanceException;

	/**
	* Returns the last candidate maintenance in the ordered set where candidateEntryId = &#63;.
	*
	* @param candidateEntryId the candidate entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public CandidateMaintenance fetchByCandidateEntryIds_Last(
		long candidateEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator);

	/**
	* Returns the candidate maintenances before and after the current candidate maintenance in the ordered set where candidateEntryId = &#63;.
	*
	* @param candidateMaintenanceId the primary key of the current candidate maintenance
	* @param candidateEntryId the candidate entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a candidate maintenance with the primary key could not be found
	*/
	public CandidateMaintenance[] findByCandidateEntryIds_PrevAndNext(
		long candidateMaintenanceId, long candidateEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator)
		throws NoSuchCandidateMaintenanceException;

	/**
	* Removes all the candidate maintenances where candidateEntryId = &#63; from the database.
	*
	* @param candidateEntryId the candidate entry ID
	*/
	public void removeByCandidateEntryIds(long candidateEntryId);

	/**
	* Returns the number of candidate maintenances where candidateEntryId = &#63;.
	*
	* @param candidateEntryId the candidate entry ID
	* @return the number of matching candidate maintenances
	*/
	public int countByCandidateEntryIds(long candidateEntryId);

	/**
	* Returns all the candidate maintenances where taskEntryId = &#63;.
	*
	* @param taskEntryId the task entry ID
	* @return the matching candidate maintenances
	*/
	public java.util.List<CandidateMaintenance> findByTaskEntryIds(
		long taskEntryId);

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
	public java.util.List<CandidateMaintenance> findByTaskEntryIds(
		long taskEntryId, int start, int end);

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
	public java.util.List<CandidateMaintenance> findByTaskEntryIds(
		long taskEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator);

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
	public java.util.List<CandidateMaintenance> findByTaskEntryIds(
		long taskEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate maintenance in the ordered set where taskEntryId = &#63;.
	*
	* @param taskEntryId the task entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a matching candidate maintenance could not be found
	*/
	public CandidateMaintenance findByTaskEntryIds_First(long taskEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator)
		throws NoSuchCandidateMaintenanceException;

	/**
	* Returns the first candidate maintenance in the ordered set where taskEntryId = &#63;.
	*
	* @param taskEntryId the task entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public CandidateMaintenance fetchByTaskEntryIds_First(long taskEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator);

	/**
	* Returns the last candidate maintenance in the ordered set where taskEntryId = &#63;.
	*
	* @param taskEntryId the task entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a matching candidate maintenance could not be found
	*/
	public CandidateMaintenance findByTaskEntryIds_Last(long taskEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator)
		throws NoSuchCandidateMaintenanceException;

	/**
	* Returns the last candidate maintenance in the ordered set where taskEntryId = &#63;.
	*
	* @param taskEntryId the task entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public CandidateMaintenance fetchByTaskEntryIds_Last(long taskEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator);

	/**
	* Returns the candidate maintenances before and after the current candidate maintenance in the ordered set where taskEntryId = &#63;.
	*
	* @param candidateMaintenanceId the primary key of the current candidate maintenance
	* @param taskEntryId the task entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a candidate maintenance with the primary key could not be found
	*/
	public CandidateMaintenance[] findByTaskEntryIds_PrevAndNext(
		long candidateMaintenanceId, long taskEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator)
		throws NoSuchCandidateMaintenanceException;

	/**
	* Removes all the candidate maintenances where taskEntryId = &#63; from the database.
	*
	* @param taskEntryId the task entry ID
	*/
	public void removeByTaskEntryIds(long taskEntryId);

	/**
	* Returns the number of candidate maintenances where taskEntryId = &#63;.
	*
	* @param taskEntryId the task entry ID
	* @return the number of matching candidate maintenances
	*/
	public int countByTaskEntryIds(long taskEntryId);

	/**
	* Returns the candidate maintenance where candidateEntryId = &#63; and taskEntryId = &#63; or throws a {@link NoSuchCandidateMaintenanceException} if it could not be found.
	*
	* @param candidateEntryId the candidate entry ID
	* @param taskEntryId the task entry ID
	* @return the matching candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a matching candidate maintenance could not be found
	*/
	public CandidateMaintenance findByC_T(long candidateEntryId,
		long taskEntryId) throws NoSuchCandidateMaintenanceException;

	/**
	* Returns the candidate maintenance where candidateEntryId = &#63; and taskEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param candidateEntryId the candidate entry ID
	* @param taskEntryId the task entry ID
	* @return the matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public CandidateMaintenance fetchByC_T(long candidateEntryId,
		long taskEntryId);

	/**
	* Returns the candidate maintenance where candidateEntryId = &#63; and taskEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param candidateEntryId the candidate entry ID
	* @param taskEntryId the task entry ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching candidate maintenance, or <code>null</code> if a matching candidate maintenance could not be found
	*/
	public CandidateMaintenance fetchByC_T(long candidateEntryId,
		long taskEntryId, boolean retrieveFromCache);

	/**
	* Removes the candidate maintenance where candidateEntryId = &#63; and taskEntryId = &#63; from the database.
	*
	* @param candidateEntryId the candidate entry ID
	* @param taskEntryId the task entry ID
	* @return the candidate maintenance that was removed
	*/
	public CandidateMaintenance removeByC_T(long candidateEntryId,
		long taskEntryId) throws NoSuchCandidateMaintenanceException;

	/**
	* Returns the number of candidate maintenances where candidateEntryId = &#63; and taskEntryId = &#63;.
	*
	* @param candidateEntryId the candidate entry ID
	* @param taskEntryId the task entry ID
	* @return the number of matching candidate maintenances
	*/
	public int countByC_T(long candidateEntryId, long taskEntryId);

	/**
	* Caches the candidate maintenance in the entity cache if it is enabled.
	*
	* @param candidateMaintenance the candidate maintenance
	*/
	public void cacheResult(CandidateMaintenance candidateMaintenance);

	/**
	* Caches the candidate maintenances in the entity cache if it is enabled.
	*
	* @param candidateMaintenances the candidate maintenances
	*/
	public void cacheResult(
		java.util.List<CandidateMaintenance> candidateMaintenances);

	/**
	* Creates a new candidate maintenance with the primary key. Does not add the candidate maintenance to the database.
	*
	* @param candidateMaintenanceId the primary key for the new candidate maintenance
	* @return the new candidate maintenance
	*/
	public CandidateMaintenance create(long candidateMaintenanceId);

	/**
	* Removes the candidate maintenance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateMaintenanceId the primary key of the candidate maintenance
	* @return the candidate maintenance that was removed
	* @throws NoSuchCandidateMaintenanceException if a candidate maintenance with the primary key could not be found
	*/
	public CandidateMaintenance remove(long candidateMaintenanceId)
		throws NoSuchCandidateMaintenanceException;

	public CandidateMaintenance updateImpl(
		CandidateMaintenance candidateMaintenance);

	/**
	* Returns the candidate maintenance with the primary key or throws a {@link NoSuchCandidateMaintenanceException} if it could not be found.
	*
	* @param candidateMaintenanceId the primary key of the candidate maintenance
	* @return the candidate maintenance
	* @throws NoSuchCandidateMaintenanceException if a candidate maintenance with the primary key could not be found
	*/
	public CandidateMaintenance findByPrimaryKey(long candidateMaintenanceId)
		throws NoSuchCandidateMaintenanceException;

	/**
	* Returns the candidate maintenance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidateMaintenanceId the primary key of the candidate maintenance
	* @return the candidate maintenance, or <code>null</code> if a candidate maintenance with the primary key could not be found
	*/
	public CandidateMaintenance fetchByPrimaryKey(long candidateMaintenanceId);

	@Override
	public java.util.Map<java.io.Serializable, CandidateMaintenance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the candidate maintenances.
	*
	* @return the candidate maintenances
	*/
	public java.util.List<CandidateMaintenance> findAll();

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
	public java.util.List<CandidateMaintenance> findAll(int start, int end);

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
	public java.util.List<CandidateMaintenance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator);

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
	public java.util.List<CandidateMaintenance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateMaintenance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the candidate maintenances from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of candidate maintenances.
	*
	* @return the number of candidate maintenances
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}