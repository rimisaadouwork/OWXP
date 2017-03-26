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

package com.liferay.micro.maintainance.decision.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.decision.model.DecisionEntry;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the decision entry service. This utility wraps {@link com.liferay.micro.maintainance.decision.service.persistence.impl.DecisionEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DecisionEntryPersistence
 * @see com.liferay.micro.maintainance.decision.service.persistence.impl.DecisionEntryPersistenceImpl
 * @generated
 */
@ProviderType
public class DecisionEntryUtil {
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
	public static void clearCache(DecisionEntry decisionEntry) {
		getPersistence().clearCache(decisionEntry);
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
	public static List<DecisionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DecisionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DecisionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DecisionEntry update(DecisionEntry decisionEntry) {
		return getPersistence().update(decisionEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DecisionEntry update(DecisionEntry decisionEntry,
		ServiceContext serviceContext) {
		return getPersistence().update(decisionEntry, serviceContext);
	}

	/**
	* Returns all the decision entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the decision entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByUuid_First(java.lang.String uuid,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByUuid_Last(java.lang.String uuid,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where uuid = &#63;.
	*
	* @param decisionEntryId the primary key of the current decision entry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry[] findByUuid_PrevAndNext(long decisionEntryId,
		java.lang.String uuid,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(decisionEntryId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of decision entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching decision entries
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the decision entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the decision entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the primary key of the current decision entry
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry[] findByUuid_C_PrevAndNext(
		long decisionEntryId, java.lang.String uuid, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(decisionEntryId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of decision entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the decision entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the decision entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByCompanyId(long companyId,
		int start, int end) {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByCompanyId(long companyId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByCompanyId(long companyId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByCompanyId_First(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByCompanyId_First(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByCompanyId_Last(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByCompanyId_Last(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where companyId = &#63;.
	*
	* @param decisionEntryId the primary key of the current decision entry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry[] findByCompanyId_PrevAndNext(
		long decisionEntryId, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(decisionEntryId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of decision entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the decision entries where decisionEntryId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByDecisionEntryId(
		long decisionEntryId) {
		return getPersistence().findByDecisionEntryId(decisionEntryId);
	}

	/**
	* Returns a range of all the decision entries where decisionEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionEntryId the decision entry ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByDecisionEntryId(
		long decisionEntryId, int start, int end) {
		return getPersistence()
				   .findByDecisionEntryId(decisionEntryId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionEntryId the decision entry ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByDecisionEntryId(
		long decisionEntryId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByDecisionEntryId(decisionEntryId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionEntryId the decision entry ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByDecisionEntryId(
		long decisionEntryId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDecisionEntryId(decisionEntryId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByDecisionEntryId_First(
		long decisionEntryId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByDecisionEntryId_First(decisionEntryId,
			orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByDecisionEntryId_First(
		long decisionEntryId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByDecisionEntryId_First(decisionEntryId,
			orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByDecisionEntryId_Last(
		long decisionEntryId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByDecisionEntryId_Last(decisionEntryId,
			orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByDecisionEntryId_Last(
		long decisionEntryId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByDecisionEntryId_Last(decisionEntryId,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where decisionEntryId = &#63; from the database.
	*
	* @param decisionEntryId the decision entry ID
	*/
	public static void removeByDecisionEntryId(long decisionEntryId) {
		getPersistence().removeByDecisionEntryId(decisionEntryId);
	}

	/**
	* Returns the number of decision entries where decisionEntryId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @return the number of matching decision entries
	*/
	public static int countByDecisionEntryId(long decisionEntryId) {
		return getPersistence().countByDecisionEntryId(decisionEntryId);
	}

	/**
	* Returns all the decision entries where outcome = &#63;.
	*
	* @param outcome the outcome
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByOutcome(java.lang.String outcome) {
		return getPersistence().findByOutcome(outcome);
	}

	/**
	* Returns a range of all the decision entries where outcome = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param outcome the outcome
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByOutcome(java.lang.String outcome,
		int start, int end) {
		return getPersistence().findByOutcome(outcome, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where outcome = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param outcome the outcome
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByOutcome(java.lang.String outcome,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByOutcome(outcome, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where outcome = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param outcome the outcome
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByOutcome(java.lang.String outcome,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByOutcome(outcome, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where outcome = &#63;.
	*
	* @param outcome the outcome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByOutcome_First(java.lang.String outcome,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence().findByOutcome_First(outcome, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where outcome = &#63;.
	*
	* @param outcome the outcome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByOutcome_First(java.lang.String outcome,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence().fetchByOutcome_First(outcome, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where outcome = &#63;.
	*
	* @param outcome the outcome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByOutcome_Last(java.lang.String outcome,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence().findByOutcome_Last(outcome, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where outcome = &#63;.
	*
	* @param outcome the outcome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByOutcome_Last(java.lang.String outcome,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence().fetchByOutcome_Last(outcome, orderByComparator);
	}

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where outcome = &#63;.
	*
	* @param decisionEntryId the primary key of the current decision entry
	* @param outcome the outcome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry[] findByOutcome_PrevAndNext(
		long decisionEntryId, java.lang.String outcome,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByOutcome_PrevAndNext(decisionEntryId, outcome,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where outcome = &#63; from the database.
	*
	* @param outcome the outcome
	*/
	public static void removeByOutcome(java.lang.String outcome) {
		getPersistence().removeByOutcome(outcome);
	}

	/**
	* Returns the number of decision entries where outcome = &#63;.
	*
	* @param outcome the outcome
	* @return the number of matching decision entries
	*/
	public static int countByOutcome(java.lang.String outcome) {
		return getPersistence().countByOutcome(outcome);
	}

	/**
	* Returns all the decision entries where wikiPageId = &#63;.
	*
	* @param wikiPageId the wiki page ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByWikiPageId(long wikiPageId) {
		return getPersistence().findByWikiPageId(wikiPageId);
	}

	/**
	* Returns a range of all the decision entries where wikiPageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param wikiPageId the wiki page ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByWikiPageId(long wikiPageId,
		int start, int end) {
		return getPersistence().findByWikiPageId(wikiPageId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where wikiPageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param wikiPageId the wiki page ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByWikiPageId(long wikiPageId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByWikiPageId(wikiPageId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where wikiPageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param wikiPageId the wiki page ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByWikiPageId(long wikiPageId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByWikiPageId(wikiPageId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where wikiPageId = &#63;.
	*
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByWikiPageId_First(long wikiPageId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByWikiPageId_First(wikiPageId, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where wikiPageId = &#63;.
	*
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByWikiPageId_First(long wikiPageId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByWikiPageId_First(wikiPageId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where wikiPageId = &#63;.
	*
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByWikiPageId_Last(long wikiPageId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByWikiPageId_Last(wikiPageId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where wikiPageId = &#63;.
	*
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByWikiPageId_Last(long wikiPageId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByWikiPageId_Last(wikiPageId, orderByComparator);
	}

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where wikiPageId = &#63;.
	*
	* @param decisionEntryId the primary key of the current decision entry
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry[] findByWikiPageId_PrevAndNext(
		long decisionEntryId, long wikiPageId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByWikiPageId_PrevAndNext(decisionEntryId, wikiPageId,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where wikiPageId = &#63; from the database.
	*
	* @param wikiPageId the wiki page ID
	*/
	public static void removeByWikiPageId(long wikiPageId) {
		getPersistence().removeByWikiPageId(wikiPageId);
	}

	/**
	* Returns the number of decision entries where wikiPageId = &#63;.
	*
	* @param wikiPageId the wiki page ID
	* @return the number of matching decision entries
	*/
	public static int countByWikiPageId(long wikiPageId) {
		return getPersistence().countByWikiPageId(wikiPageId);
	}

	/**
	* Returns all the decision entries where wikiPageName = &#63;.
	*
	* @param wikiPageName the wiki page name
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByWikiPageName(
		java.lang.String wikiPageName) {
		return getPersistence().findByWikiPageName(wikiPageName);
	}

	/**
	* Returns a range of all the decision entries where wikiPageName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param wikiPageName the wiki page name
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByWikiPageName(
		java.lang.String wikiPageName, int start, int end) {
		return getPersistence().findByWikiPageName(wikiPageName, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where wikiPageName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param wikiPageName the wiki page name
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByWikiPageName(
		java.lang.String wikiPageName, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByWikiPageName(wikiPageName, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where wikiPageName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param wikiPageName the wiki page name
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByWikiPageName(
		java.lang.String wikiPageName, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByWikiPageName(wikiPageName, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where wikiPageName = &#63;.
	*
	* @param wikiPageName the wiki page name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByWikiPageName_First(
		java.lang.String wikiPageName,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByWikiPageName_First(wikiPageName, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where wikiPageName = &#63;.
	*
	* @param wikiPageName the wiki page name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByWikiPageName_First(
		java.lang.String wikiPageName,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByWikiPageName_First(wikiPageName, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where wikiPageName = &#63;.
	*
	* @param wikiPageName the wiki page name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByWikiPageName_Last(
		java.lang.String wikiPageName,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByWikiPageName_Last(wikiPageName, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where wikiPageName = &#63;.
	*
	* @param wikiPageName the wiki page name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByWikiPageName_Last(
		java.lang.String wikiPageName,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByWikiPageName_Last(wikiPageName, orderByComparator);
	}

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where wikiPageName = &#63;.
	*
	* @param decisionEntryId the primary key of the current decision entry
	* @param wikiPageName the wiki page name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry[] findByWikiPageName_PrevAndNext(
		long decisionEntryId, java.lang.String wikiPageName,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByWikiPageName_PrevAndNext(decisionEntryId,
			wikiPageName, orderByComparator);
	}

	/**
	* Removes all the decision entries where wikiPageName = &#63; from the database.
	*
	* @param wikiPageName the wiki page name
	*/
	public static void removeByWikiPageName(java.lang.String wikiPageName) {
		getPersistence().removeByWikiPageName(wikiPageName);
	}

	/**
	* Returns the number of decision entries where wikiPageName = &#63;.
	*
	* @param wikiPageName the wiki page name
	* @return the number of matching decision entries
	*/
	public static int countByWikiPageName(java.lang.String wikiPageName) {
		return getPersistence().countByWikiPageName(wikiPageName);
	}

	/**
	* Returns all the decision entries where companyId = &#63; and handled = &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByC_H(long companyId, boolean handled) {
		return getPersistence().findByC_H(companyId, handled);
	}

	/**
	* Returns a range of all the decision entries where companyId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByC_H(long companyId,
		boolean handled, int start, int end) {
		return getPersistence().findByC_H(companyId, handled, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where companyId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByC_H(long companyId,
		boolean handled, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByC_H(companyId, handled, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where companyId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByC_H(long companyId,
		boolean handled, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_H(companyId, handled, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63; and handled = &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByC_H_First(long companyId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_H_First(companyId, handled, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63; and handled = &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByC_H_First(long companyId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByC_H_First(companyId, handled, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63; and handled = &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByC_H_Last(long companyId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_H_Last(companyId, handled, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63; and handled = &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByC_H_Last(long companyId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByC_H_Last(companyId, handled, orderByComparator);
	}

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where companyId = &#63; and handled = &#63;.
	*
	* @param decisionEntryId the primary key of the current decision entry
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry[] findByC_H_PrevAndNext(long decisionEntryId,
		long companyId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_H_PrevAndNext(decisionEntryId, companyId, handled,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where companyId = &#63; and handled = &#63; from the database.
	*
	* @param companyId the company ID
	* @param handled the handled
	*/
	public static void removeByC_H(long companyId, boolean handled) {
		getPersistence().removeByC_H(companyId, handled);
	}

	/**
	* Returns the number of decision entries where companyId = &#63; and handled = &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @return the number of matching decision entries
	*/
	public static int countByC_H(long companyId, boolean handled) {
		return getPersistence().countByC_H(companyId, handled);
	}

	/**
	* Returns all the decision entries where decisionEntryId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByD_C(long decisionEntryId,
		long companyId) {
		return getPersistence().findByD_C(decisionEntryId, companyId);
	}

	/**
	* Returns a range of all the decision entries where decisionEntryId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_C(long decisionEntryId,
		long companyId, int start, int end) {
		return getPersistence().findByD_C(decisionEntryId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionEntryId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_C(long decisionEntryId,
		long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByD_C(decisionEntryId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionEntryId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_C(long decisionEntryId,
		long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByD_C(decisionEntryId, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_C_First(long decisionEntryId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_C_First(decisionEntryId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_C_First(long decisionEntryId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_C_First(decisionEntryId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_C_Last(long decisionEntryId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_C_Last(decisionEntryId, companyId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_C_Last(long decisionEntryId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_C_Last(decisionEntryId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where decisionEntryId = &#63; and companyId = &#63; from the database.
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	*/
	public static void removeByD_C(long decisionEntryId, long companyId) {
		getPersistence().removeByD_C(decisionEntryId, companyId);
	}

	/**
	* Returns the number of decision entries where decisionEntryId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public static int countByD_C(long decisionEntryId, long companyId) {
		return getPersistence().countByD_C(decisionEntryId, companyId);
	}

	/**
	* Returns all the decision entries where decisionEntryId = &#63; and handled = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByD_H(long decisionEntryId,
		boolean handled) {
		return getPersistence().findByD_H(decisionEntryId, handled);
	}

	/**
	* Returns a range of all the decision entries where decisionEntryId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_H(long decisionEntryId,
		boolean handled, int start, int end) {
		return getPersistence().findByD_H(decisionEntryId, handled, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionEntryId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_H(long decisionEntryId,
		boolean handled, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByD_H(decisionEntryId, handled, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionEntryId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_H(long decisionEntryId,
		boolean handled, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByD_H(decisionEntryId, handled, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63; and handled = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_H_First(long decisionEntryId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_H_First(decisionEntryId, handled, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63; and handled = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_H_First(long decisionEntryId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_H_First(decisionEntryId, handled, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63; and handled = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_H_Last(long decisionEntryId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_H_Last(decisionEntryId, handled, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63; and handled = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_H_Last(long decisionEntryId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_H_Last(decisionEntryId, handled, orderByComparator);
	}

	/**
	* Removes all the decision entries where decisionEntryId = &#63; and handled = &#63; from the database.
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	*/
	public static void removeByD_H(long decisionEntryId, boolean handled) {
		getPersistence().removeByD_H(decisionEntryId, handled);
	}

	/**
	* Returns the number of decision entries where decisionEntryId = &#63; and handled = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	* @return the number of matching decision entries
	*/
	public static int countByD_H(long decisionEntryId, boolean handled) {
		return getPersistence().countByD_H(decisionEntryId, handled);
	}

	/**
	* Returns all the decision entries where decisionEntryId = &#63; and userId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByD_U(long decisionEntryId,
		long userId) {
		return getPersistence().findByD_U(decisionEntryId, userId);
	}

	/**
	* Returns a range of all the decision entries where decisionEntryId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_U(long decisionEntryId,
		long userId, int start, int end) {
		return getPersistence().findByD_U(decisionEntryId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionEntryId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_U(long decisionEntryId,
		long userId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByD_U(decisionEntryId, userId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionEntryId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_U(long decisionEntryId,
		long userId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByD_U(decisionEntryId, userId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_U_First(long decisionEntryId,
		long userId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_U_First(decisionEntryId, userId, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_U_First(long decisionEntryId,
		long userId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_U_First(decisionEntryId, userId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_U_Last(long decisionEntryId,
		long userId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_U_Last(decisionEntryId, userId, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_U_Last(long decisionEntryId,
		long userId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_U_Last(decisionEntryId, userId, orderByComparator);
	}

	/**
	* Removes all the decision entries where decisionEntryId = &#63; and userId = &#63; from the database.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	*/
	public static void removeByD_U(long decisionEntryId, long userId) {
		getPersistence().removeByD_U(decisionEntryId, userId);
	}

	/**
	* Returns the number of decision entries where decisionEntryId = &#63; and userId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @return the number of matching decision entries
	*/
	public static int countByD_U(long decisionEntryId, long userId) {
		return getPersistence().countByD_U(decisionEntryId, userId);
	}

	/**
	* Returns all the decision entries where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByD_U_C(long decisionEntryId,
		long userId, long companyId) {
		return getPersistence().findByD_U_C(decisionEntryId, userId, companyId);
	}

	/**
	* Returns a range of all the decision entries where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_U_C(long decisionEntryId,
		long userId, long companyId, int start, int end) {
		return getPersistence()
				   .findByD_U_C(decisionEntryId, userId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_U_C(long decisionEntryId,
		long userId, long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByD_U_C(decisionEntryId, userId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByD_U_C(long decisionEntryId,
		long userId, long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByD_U_C(decisionEntryId, userId, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_U_C_First(long decisionEntryId,
		long userId, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_U_C_First(decisionEntryId, userId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_U_C_First(long decisionEntryId,
		long userId, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_U_C_First(decisionEntryId, userId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByD_U_C_Last(long decisionEntryId,
		long userId, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByD_U_C_Last(decisionEntryId, userId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByD_U_C_Last(long decisionEntryId,
		long userId, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByD_U_C_Last(decisionEntryId, userId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where decisionEntryId = &#63; and userId = &#63; and companyId = &#63; from the database.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param companyId the company ID
	*/
	public static void removeByD_U_C(long decisionEntryId, long userId,
		long companyId) {
		getPersistence().removeByD_U_C(decisionEntryId, userId, companyId);
	}

	/**
	* Returns the number of decision entries where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public static int countByD_U_C(long decisionEntryId, long userId,
		long companyId) {
		return getPersistence().countByD_U_C(decisionEntryId, userId, companyId);
	}

	/**
	* Returns all the decision entries where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByU_H(long userId, boolean handled) {
		return getPersistence().findByU_H(userId, handled);
	}

	/**
	* Returns a range of all the decision entries where userId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByU_H(long userId, boolean handled,
		int start, int end) {
		return getPersistence().findByU_H(userId, handled, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where userId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByU_H(long userId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByU_H(userId, handled, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where userId = &#63; and handled = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param handled the handled
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByU_H(long userId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_H(userId, handled, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByU_H_First(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_H_First(userId, handled, orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByU_H_First(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_H_First(userId, handled, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByU_H_Last(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_H_Last(userId, handled, orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByU_H_Last(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_H_Last(userId, handled, orderByComparator);
	}

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param decisionEntryId the primary key of the current decision entry
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry[] findByU_H_PrevAndNext(long decisionEntryId,
		long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_H_PrevAndNext(decisionEntryId, userId, handled,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where userId = &#63; and handled = &#63; from the database.
	*
	* @param userId the user ID
	* @param handled the handled
	*/
	public static void removeByU_H(long userId, boolean handled) {
		getPersistence().removeByU_H(userId, handled);
	}

	/**
	* Returns the number of decision entries where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @return the number of matching decision entries
	*/
	public static int countByU_H(long userId, boolean handled) {
		return getPersistence().countByU_H(userId, handled);
	}

	/**
	* Returns all the decision entries where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionEntryId the decision entry ID
	* @return the matching decision entries
	*/
	public static List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionEntryId) {
		return getPersistence().findByU_H_D(userId, handled, decisionEntryId);
	}

	/**
	* Returns a range of all the decision entries where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionEntryId the decision entry ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of matching decision entries
	*/
	public static List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionEntryId, int start, int end) {
		return getPersistence()
				   .findByU_H_D(userId, handled, decisionEntryId, start, end);
	}

	/**
	* Returns an ordered range of all the decision entries where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionEntryId the decision entry ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionEntryId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .findByU_H_D(userId, handled, decisionEntryId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionEntryId the decision entry ID
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching decision entries
	*/
	public static List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionEntryId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_H_D(userId, handled, decisionEntryId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionEntryId the decision entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByU_H_D_First(long userId, boolean handled,
		long decisionEntryId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_H_D_First(userId, handled, decisionEntryId,
			orderByComparator);
	}

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionEntryId the decision entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByU_H_D_First(long userId,
		boolean handled, long decisionEntryId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_H_D_First(userId, handled, decisionEntryId,
			orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionEntryId the decision entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public static DecisionEntry findByU_H_D_Last(long userId, boolean handled,
		long decisionEntryId, OrderByComparator<DecisionEntry> orderByComparator)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_H_D_Last(userId, handled, decisionEntryId,
			orderByComparator);
	}

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionEntryId the decision entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public static DecisionEntry fetchByU_H_D_Last(long userId, boolean handled,
		long decisionEntryId, OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_H_D_Last(userId, handled, decisionEntryId,
			orderByComparator);
	}

	/**
	* Removes all the decision entries where userId = &#63; and handled = &#63; and decisionEntryId = &#63; from the database.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionEntryId the decision entry ID
	*/
	public static void removeByU_H_D(long userId, boolean handled,
		long decisionEntryId) {
		getPersistence().removeByU_H_D(userId, handled, decisionEntryId);
	}

	/**
	* Returns the number of decision entries where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionEntryId the decision entry ID
	* @return the number of matching decision entries
	*/
	public static int countByU_H_D(long userId, boolean handled,
		long decisionEntryId) {
		return getPersistence().countByU_H_D(userId, handled, decisionEntryId);
	}

	/**
	* Caches the decision entry in the entity cache if it is enabled.
	*
	* @param decisionEntry the decision entry
	*/
	public static void cacheResult(DecisionEntry decisionEntry) {
		getPersistence().cacheResult(decisionEntry);
	}

	/**
	* Caches the decision entries in the entity cache if it is enabled.
	*
	* @param decisionEntries the decision entries
	*/
	public static void cacheResult(List<DecisionEntry> decisionEntries) {
		getPersistence().cacheResult(decisionEntries);
	}

	/**
	* Creates a new decision entry with the primary key. Does not add the decision entry to the database.
	*
	* @param decisionEntryId the primary key for the new decision entry
	* @return the new decision entry
	*/
	public static DecisionEntry create(long decisionEntryId) {
		return getPersistence().create(decisionEntryId);
	}

	/**
	* Removes the decision entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param decisionEntryId the primary key of the decision entry
	* @return the decision entry that was removed
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry remove(long decisionEntryId)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence().remove(decisionEntryId);
	}

	public static DecisionEntry updateImpl(DecisionEntry decisionEntry) {
		return getPersistence().updateImpl(decisionEntry);
	}

	/**
	* Returns the decision entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param decisionEntryId the primary key of the decision entry
	* @return the decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry findByPrimaryKey(long decisionEntryId)
		throws com.liferay.micro.maintainance.decision.exception.NoSuchEntryException {
		return getPersistence().findByPrimaryKey(decisionEntryId);
	}

	/**
	* Returns the decision entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param decisionEntryId the primary key of the decision entry
	* @return the decision entry, or <code>null</code> if a decision entry with the primary key could not be found
	*/
	public static DecisionEntry fetchByPrimaryKey(long decisionEntryId) {
		return getPersistence().fetchByPrimaryKey(decisionEntryId);
	}

	public static java.util.Map<java.io.Serializable, DecisionEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the decision entries.
	*
	* @return the decision entries
	*/
	public static List<DecisionEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the decision entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @return the range of decision entries
	*/
	public static List<DecisionEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the decision entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of decision entries
	*/
	public static List<DecisionEntry> findAll(int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the decision entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DecisionEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of decision entries
	* @param end the upper bound of the range of decision entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of decision entries
	*/
	public static List<DecisionEntry> findAll(int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the decision entries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of decision entries.
	*
	* @return the number of decision entries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DecisionEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DecisionEntryPersistence, DecisionEntryPersistence> _serviceTracker =
		ServiceTrackerFactory.open(DecisionEntryPersistence.class);
}