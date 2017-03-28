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

package com.liferay.micro.maintainance.candidate.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.candidate.model.CandidateEntry;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the candidate entry service. This utility wraps {@link com.liferay.micro.maintainance.candidate.service.persistence.impl.CandidateEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateEntryPersistence
 * @see com.liferay.micro.maintainance.candidate.service.persistence.impl.CandidateEntryPersistenceImpl
 * @generated
 */
@ProviderType
public class CandidateEntryUtil {
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
	public static void clearCache(CandidateEntry candidateEntry) {
		getPersistence().clearCache(candidateEntry);
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
	public static List<CandidateEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CandidateEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CandidateEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CandidateEntry update(CandidateEntry candidateEntry) {
		return getPersistence().update(candidateEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CandidateEntry update(CandidateEntry candidateEntry,
		ServiceContext serviceContext) {
		return getPersistence().update(candidateEntry, serviceContext);
	}

	/**
	* Returns all the candidate entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching candidate entries
	*/
	public static List<CandidateEntry> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the candidate entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @return the range of matching candidate entries
	*/
	public static List<CandidateEntry> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the candidate entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first candidate entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByUuid_First(java.lang.String uuid,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first candidate entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByUuid_Last(java.lang.String uuid,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the candidate entries before and after the current candidate entry in the ordered set where uuid = &#63;.
	*
	* @param candidateEntryId the primary key of the current candidate entry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate entry
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public static CandidateEntry[] findByUuid_PrevAndNext(
		long candidateEntryId, java.lang.String uuid,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(candidateEntryId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the candidate entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of candidate entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching candidate entries
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the candidate entry where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the candidate entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the candidate entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the candidate entry where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the candidate entry that was removed
	*/
	public static CandidateEntry removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of candidate entries where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching candidate entries
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the candidate entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching candidate entries
	*/
	public static List<CandidateEntry> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the candidate entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @return the range of matching candidate entries
	*/
	public static List<CandidateEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the candidate entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first candidate entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first candidate entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the candidate entries before and after the current candidate entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param candidateEntryId the primary key of the current candidate entry
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate entry
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public static CandidateEntry[] findByUuid_C_PrevAndNext(
		long candidateEntryId, java.lang.String uuid, long companyId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(candidateEntryId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the candidate entries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of candidate entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching candidate entries
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the candidate entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching candidate entries
	*/
	public static List<CandidateEntry> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the candidate entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @return the range of matching candidate entries
	*/
	public static List<CandidateEntry> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the candidate entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByGroupId(long groupId, int start,
		int end, OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate entries where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByGroupId(long groupId, int start,
		int end, OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first candidate entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByGroupId_First(long groupId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first candidate entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByGroupId_First(long groupId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByGroupId_Last(long groupId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByGroupId_Last(long groupId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the candidate entries before and after the current candidate entry in the ordered set where groupId = &#63;.
	*
	* @param candidateEntryId the primary key of the current candidate entry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate entry
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public static CandidateEntry[] findByGroupId_PrevAndNext(
		long candidateEntryId, long groupId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(candidateEntryId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the candidate entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of candidate entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching candidate entries
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the candidate entry where wikiPageId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param wikiPageId the wiki page ID
	* @return the matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByWikiPageId(long wikiPageId)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence().findByWikiPageId(wikiPageId);
	}

	/**
	* Returns the candidate entry where wikiPageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param wikiPageId the wiki page ID
	* @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByWikiPageId(long wikiPageId) {
		return getPersistence().fetchByWikiPageId(wikiPageId);
	}

	/**
	* Returns the candidate entry where wikiPageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param wikiPageId the wiki page ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByWikiPageId(long wikiPageId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByWikiPageId(wikiPageId, retrieveFromCache);
	}

	/**
	* Removes the candidate entry where wikiPageId = &#63; from the database.
	*
	* @param wikiPageId the wiki page ID
	* @return the candidate entry that was removed
	*/
	public static CandidateEntry removeByWikiPageId(long wikiPageId)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence().removeByWikiPageId(wikiPageId);
	}

	/**
	* Returns the number of candidate entries where wikiPageId = &#63;.
	*
	* @param wikiPageId the wiki page ID
	* @return the number of matching candidate entries
	*/
	public static int countByWikiPageId(long wikiPageId) {
		return getPersistence().countByWikiPageId(wikiPageId);
	}

	/**
	* Returns all the candidate entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching candidate entries
	*/
	public static List<CandidateEntry> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the candidate entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @return the range of matching candidate entries
	*/
	public static List<CandidateEntry> findByCompanyId(long companyId,
		int start, int end) {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the candidate entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByCompanyId(long companyId,
		int start, int end, OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByCompanyId(long companyId,
		int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first candidate entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByCompanyId_First(long companyId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first candidate entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByCompanyId_First(long companyId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByCompanyId_Last(long companyId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByCompanyId_Last(long companyId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the candidate entries before and after the current candidate entry in the ordered set where companyId = &#63;.
	*
	* @param candidateEntryId the primary key of the current candidate entry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate entry
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public static CandidateEntry[] findByCompanyId_PrevAndNext(
		long candidateEntryId, long companyId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(candidateEntryId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the candidate entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of candidate entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching candidate entries
	*/
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the candidate entries where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @return the matching candidate entries
	*/
	public static List<CandidateEntry> findByU_cD(long userId, Date createDate) {
		return getPersistence().findByU_cD(userId, createDate);
	}

	/**
	* Returns a range of all the candidate entries where userId = &#63; and createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @return the range of matching candidate entries
	*/
	public static List<CandidateEntry> findByU_cD(long userId, Date createDate,
		int start, int end) {
		return getPersistence().findByU_cD(userId, createDate, start, end);
	}

	/**
	* Returns an ordered range of all the candidate entries where userId = &#63; and createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByU_cD(long userId, Date createDate,
		int start, int end, OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .findByU_cD(userId, createDate, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate entries where userId = &#63; and createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByU_cD(long userId, Date createDate,
		int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_cD(userId, createDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first candidate entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByU_cD_First(long userId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_cD_First(userId, createDate, orderByComparator);
	}

	/**
	* Returns the first candidate entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByU_cD_First(long userId,
		Date createDate, OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_cD_First(userId, createDate, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByU_cD_Last(long userId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_cD_Last(userId, createDate, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByU_cD_Last(long userId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_cD_Last(userId, createDate, orderByComparator);
	}

	/**
	* Returns the candidate entries before and after the current candidate entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param candidateEntryId the primary key of the current candidate entry
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate entry
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public static CandidateEntry[] findByU_cD_PrevAndNext(
		long candidateEntryId, long userId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_cD_PrevAndNext(candidateEntryId, userId,
			createDate, orderByComparator);
	}

	/**
	* Removes all the candidate entries where userId = &#63; and createDate = &#63; from the database.
	*
	* @param userId the user ID
	* @param createDate the create date
	*/
	public static void removeByU_cD(long userId, Date createDate) {
		getPersistence().removeByU_cD(userId, createDate);
	}

	/**
	* Returns the number of candidate entries where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @return the number of matching candidate entries
	*/
	public static int countByU_cD(long userId, Date createDate) {
		return getPersistence().countByU_cD(userId, createDate);
	}

	/**
	* Returns all the candidate entries where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the matching candidate entries
	*/
	public static List<CandidateEntry> findByC_ctD(long companyId,
		Date createDate) {
		return getPersistence().findByC_ctD(companyId, createDate);
	}

	/**
	* Returns a range of all the candidate entries where companyId = &#63; and createDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @return the range of matching candidate entries
	*/
	public static List<CandidateEntry> findByC_ctD(long companyId,
		Date createDate, int start, int end) {
		return getPersistence().findByC_ctD(companyId, createDate, start, end);
	}

	/**
	* Returns an ordered range of all the candidate entries where companyId = &#63; and createDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByC_ctD(long companyId,
		Date createDate, int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .findByC_ctD(companyId, createDate, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate entries where companyId = &#63; and createDate &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByC_ctD(long companyId,
		Date createDate, int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_ctD(companyId, createDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first candidate entry in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByC_ctD_First(long companyId,
		Date createDate, OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_ctD_First(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the first candidate entry in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByC_ctD_First(long companyId,
		Date createDate, OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .fetchByC_ctD_First(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByC_ctD_Last(long companyId,
		Date createDate, OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_ctD_Last(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByC_ctD_Last(long companyId,
		Date createDate, OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .fetchByC_ctD_Last(companyId, createDate, orderByComparator);
	}

	/**
	* Returns the candidate entries before and after the current candidate entry in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param candidateEntryId the primary key of the current candidate entry
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate entry
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public static CandidateEntry[] findByC_ctD_PrevAndNext(
		long candidateEntryId, long companyId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_ctD_PrevAndNext(candidateEntryId, companyId,
			createDate, orderByComparator);
	}

	/**
	* Removes all the candidate entries where companyId = &#63; and createDate &lt; &#63; from the database.
	*
	* @param companyId the company ID
	* @param createDate the create date
	*/
	public static void removeByC_ctD(long companyId, Date createDate) {
		getPersistence().removeByC_ctD(companyId, createDate);
	}

	/**
	* Returns the number of candidate entries where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the number of matching candidate entries
	*/
	public static int countByC_ctD(long companyId, Date createDate) {
		return getPersistence().countByC_ctD(companyId, createDate);
	}

	/**
	* Returns all the candidate entries where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching candidate entries
	*/
	public static List<CandidateEntry> findByC_U(long companyId, long userId) {
		return getPersistence().findByC_U(companyId, userId);
	}

	/**
	* Returns a range of all the candidate entries where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @return the range of matching candidate entries
	*/
	public static List<CandidateEntry> findByC_U(long companyId, long userId,
		int start, int end) {
		return getPersistence().findByC_U(companyId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the candidate entries where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByC_U(long companyId, long userId,
		int start, int end, OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .findByC_U(companyId, userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate entries where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByC_U(long companyId, long userId,
		int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_U(companyId, userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first candidate entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByC_U_First(long companyId, long userId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_U_First(companyId, userId, orderByComparator);
	}

	/**
	* Returns the first candidate entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByC_U_First(long companyId, long userId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .fetchByC_U_First(companyId, userId, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByC_U_Last(long companyId, long userId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_U_Last(companyId, userId, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByC_U_Last(long companyId, long userId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .fetchByC_U_Last(companyId, userId, orderByComparator);
	}

	/**
	* Returns the candidate entries before and after the current candidate entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param candidateEntryId the primary key of the current candidate entry
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate entry
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public static CandidateEntry[] findByC_U_PrevAndNext(
		long candidateEntryId, long companyId, long userId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_U_PrevAndNext(candidateEntryId, companyId, userId,
			orderByComparator);
	}

	/**
	* Removes all the candidate entries where companyId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userId the user ID
	*/
	public static void removeByC_U(long companyId, long userId) {
		getPersistence().removeByC_U(companyId, userId);
	}

	/**
	* Returns the number of candidate entries where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the number of matching candidate entries
	*/
	public static int countByC_U(long companyId, long userId) {
		return getPersistence().countByC_U(companyId, userId);
	}

	/**
	* Returns the candidate entry where groupId = &#63; and wikiPageId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param groupId the group ID
	* @param wikiPageId the wiki page ID
	* @return the matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByG_P(long groupId, long wikiPageId)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence().findByG_P(groupId, wikiPageId);
	}

	/**
	* Returns the candidate entry where groupId = &#63; and wikiPageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param wikiPageId the wiki page ID
	* @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByG_P(long groupId, long wikiPageId) {
		return getPersistence().fetchByG_P(groupId, wikiPageId);
	}

	/**
	* Returns the candidate entry where groupId = &#63; and wikiPageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param wikiPageId the wiki page ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByG_P(long groupId, long wikiPageId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByG_P(groupId, wikiPageId, retrieveFromCache);
	}

	/**
	* Removes the candidate entry where groupId = &#63; and wikiPageId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param wikiPageId the wiki page ID
	* @return the candidate entry that was removed
	*/
	public static CandidateEntry removeByG_P(long groupId, long wikiPageId)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence().removeByG_P(groupId, wikiPageId);
	}

	/**
	* Returns the number of candidate entries where groupId = &#63; and wikiPageId = &#63;.
	*
	* @param groupId the group ID
	* @param wikiPageId the wiki page ID
	* @return the number of matching candidate entries
	*/
	public static int countByG_P(long groupId, long wikiPageId) {
		return getPersistence().countByG_P(groupId, wikiPageId);
	}

	/**
	* Returns all the candidate entries where userId = &#63; and wikiPageId = &#63;.
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @return the matching candidate entries
	*/
	public static List<CandidateEntry> findByU_P(long userId, long wikiPageId) {
		return getPersistence().findByU_P(userId, wikiPageId);
	}

	/**
	* Returns a range of all the candidate entries where userId = &#63; and wikiPageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @return the range of matching candidate entries
	*/
	public static List<CandidateEntry> findByU_P(long userId, long wikiPageId,
		int start, int end) {
		return getPersistence().findByU_P(userId, wikiPageId, start, end);
	}

	/**
	* Returns an ordered range of all the candidate entries where userId = &#63; and wikiPageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByU_P(long userId, long wikiPageId,
		int start, int end, OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .findByU_P(userId, wikiPageId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate entries where userId = &#63; and wikiPageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByU_P(long userId, long wikiPageId,
		int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_P(userId, wikiPageId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first candidate entry in the ordered set where userId = &#63; and wikiPageId = &#63;.
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByU_P_First(long userId, long wikiPageId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_P_First(userId, wikiPageId, orderByComparator);
	}

	/**
	* Returns the first candidate entry in the ordered set where userId = &#63; and wikiPageId = &#63;.
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByU_P_First(long userId, long wikiPageId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_P_First(userId, wikiPageId, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where userId = &#63; and wikiPageId = &#63;.
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByU_P_Last(long userId, long wikiPageId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_P_Last(userId, wikiPageId, orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where userId = &#63; and wikiPageId = &#63;.
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByU_P_Last(long userId, long wikiPageId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_P_Last(userId, wikiPageId, orderByComparator);
	}

	/**
	* Returns the candidate entries before and after the current candidate entry in the ordered set where userId = &#63; and wikiPageId = &#63;.
	*
	* @param candidateEntryId the primary key of the current candidate entry
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate entry
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public static CandidateEntry[] findByU_P_PrevAndNext(
		long candidateEntryId, long userId, long wikiPageId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_P_PrevAndNext(candidateEntryId, userId, wikiPageId,
			orderByComparator);
	}

	/**
	* Removes all the candidate entries where userId = &#63; and wikiPageId = &#63; from the database.
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	*/
	public static void removeByU_P(long userId, long wikiPageId) {
		getPersistence().removeByU_P(userId, wikiPageId);
	}

	/**
	* Returns the number of candidate entries where userId = &#63; and wikiPageId = &#63;.
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @return the number of matching candidate entries
	*/
	public static int countByU_P(long userId, long wikiPageId) {
		return getPersistence().countByU_P(userId, wikiPageId);
	}

	/**
	* Returns all the candidate entries where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @return the matching candidate entries
	*/
	public static List<CandidateEntry> findByG_U_P(long groupId, long userId,
		long wikiPageId) {
		return getPersistence().findByG_U_P(groupId, userId, wikiPageId);
	}

	/**
	* Returns a range of all the candidate entries where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @return the range of matching candidate entries
	*/
	public static List<CandidateEntry> findByG_U_P(long groupId, long userId,
		long wikiPageId, int start, int end) {
		return getPersistence()
				   .findByG_U_P(groupId, userId, wikiPageId, start, end);
	}

	/**
	* Returns an ordered range of all the candidate entries where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByG_U_P(long groupId, long userId,
		long wikiPageId, int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .findByG_U_P(groupId, userId, wikiPageId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate entries where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate entries
	*/
	public static List<CandidateEntry> findByG_U_P(long groupId, long userId,
		long wikiPageId, int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_U_P(groupId, userId, wikiPageId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first candidate entry in the ordered set where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByG_U_P_First(long groupId, long userId,
		long wikiPageId, OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByG_U_P_First(groupId, userId, wikiPageId,
			orderByComparator);
	}

	/**
	* Returns the first candidate entry in the ordered set where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByG_U_P_First(long groupId, long userId,
		long wikiPageId, OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .fetchByG_U_P_First(groupId, userId, wikiPageId,
			orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public static CandidateEntry findByG_U_P_Last(long groupId, long userId,
		long wikiPageId, OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByG_U_P_Last(groupId, userId, wikiPageId,
			orderByComparator);
	}

	/**
	* Returns the last candidate entry in the ordered set where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public static CandidateEntry fetchByG_U_P_Last(long groupId, long userId,
		long wikiPageId, OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence()
				   .fetchByG_U_P_Last(groupId, userId, wikiPageId,
			orderByComparator);
	}

	/**
	* Returns the candidate entries before and after the current candidate entry in the ordered set where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	*
	* @param candidateEntryId the primary key of the current candidate entry
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate entry
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public static CandidateEntry[] findByG_U_P_PrevAndNext(
		long candidateEntryId, long groupId, long userId, long wikiPageId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence()
				   .findByG_U_P_PrevAndNext(candidateEntryId, groupId, userId,
			wikiPageId, orderByComparator);
	}

	/**
	* Removes all the candidate entries where groupId = &#63; and userId = &#63; and wikiPageId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	*/
	public static void removeByG_U_P(long groupId, long userId, long wikiPageId) {
		getPersistence().removeByG_U_P(groupId, userId, wikiPageId);
	}

	/**
	* Returns the number of candidate entries where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @return the number of matching candidate entries
	*/
	public static int countByG_U_P(long groupId, long userId, long wikiPageId) {
		return getPersistence().countByG_U_P(groupId, userId, wikiPageId);
	}

	/**
	* Caches the candidate entry in the entity cache if it is enabled.
	*
	* @param candidateEntry the candidate entry
	*/
	public static void cacheResult(CandidateEntry candidateEntry) {
		getPersistence().cacheResult(candidateEntry);
	}

	/**
	* Caches the candidate entries in the entity cache if it is enabled.
	*
	* @param candidateEntries the candidate entries
	*/
	public static void cacheResult(List<CandidateEntry> candidateEntries) {
		getPersistence().cacheResult(candidateEntries);
	}

	/**
	* Creates a new candidate entry with the primary key. Does not add the candidate entry to the database.
	*
	* @param candidateEntryId the primary key for the new candidate entry
	* @return the new candidate entry
	*/
	public static CandidateEntry create(long candidateEntryId) {
		return getPersistence().create(candidateEntryId);
	}

	/**
	* Removes the candidate entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateEntryId the primary key of the candidate entry
	* @return the candidate entry that was removed
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public static CandidateEntry remove(long candidateEntryId)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence().remove(candidateEntryId);
	}

	public static CandidateEntry updateImpl(CandidateEntry candidateEntry) {
		return getPersistence().updateImpl(candidateEntry);
	}

	/**
	* Returns the candidate entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param candidateEntryId the primary key of the candidate entry
	* @return the candidate entry
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public static CandidateEntry findByPrimaryKey(long candidateEntryId)
		throws com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException {
		return getPersistence().findByPrimaryKey(candidateEntryId);
	}

	/**
	* Returns the candidate entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidateEntryId the primary key of the candidate entry
	* @return the candidate entry, or <code>null</code> if a candidate entry with the primary key could not be found
	*/
	public static CandidateEntry fetchByPrimaryKey(long candidateEntryId) {
		return getPersistence().fetchByPrimaryKey(candidateEntryId);
	}

	public static java.util.Map<java.io.Serializable, CandidateEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the candidate entries.
	*
	* @return the candidate entries
	*/
	public static List<CandidateEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the candidate entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @return the range of candidate entries
	*/
	public static List<CandidateEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the candidate entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of candidate entries
	*/
	public static List<CandidateEntry> findAll(int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate entries
	* @param end the upper bound of the range of candidate entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of candidate entries
	*/
	public static List<CandidateEntry> findAll(int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the candidate entries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of candidate entries.
	*
	* @return the number of candidate entries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CandidateEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CandidateEntryPersistence, CandidateEntryPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CandidateEntryPersistence.class);
}