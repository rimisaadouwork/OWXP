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

package com.liferay.micro.maintainance.analysis.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the analysis entry service. This utility wraps {@link com.liferay.micro.maintainance.analysis.service.persistence.impl.AnalysisEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisEntryPersistence
 * @see com.liferay.micro.maintainance.analysis.service.persistence.impl.AnalysisEntryPersistenceImpl
 * @generated
 */
@ProviderType
public class AnalysisEntryUtil {
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
	public static void clearCache(AnalysisEntry analysisEntry) {
		getPersistence().clearCache(analysisEntry);
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
	public static List<AnalysisEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnalysisEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnalysisEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AnalysisEntry update(AnalysisEntry analysisEntry) {
		return getPersistence().update(analysisEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AnalysisEntry update(AnalysisEntry analysisEntry,
		ServiceContext serviceContext) {
		return getPersistence().update(analysisEntry, serviceContext);
	}

	/**
	* Returns all the analysis entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching analysis entries
	*/
	public static List<AnalysisEntry> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the analysis entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the analysis entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first analysis entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByUuid_First(java.lang.String uuid,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first analysis entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByUuid_Last(java.lang.String uuid,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the analysis entries before and after the current analysis entry in the ordered set where uuid = &#63;.
	*
	* @param analysisEntryId the primary key of the current analysis entry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis entry
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public static AnalysisEntry[] findByUuid_PrevAndNext(long analysisEntryId,
		java.lang.String uuid,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(analysisEntryId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the analysis entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of analysis entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching analysis entries
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the analysis entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching analysis entries
	*/
	public static List<AnalysisEntry> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the analysis entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the analysis entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first analysis entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first analysis entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the analysis entries before and after the current analysis entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param analysisEntryId the primary key of the current analysis entry
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis entry
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public static AnalysisEntry[] findByUuid_C_PrevAndNext(
		long analysisEntryId, java.lang.String uuid, long companyId,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(analysisEntryId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the analysis entries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of analysis entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching analysis entries
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the analysis entry where analysisEntryId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param analysisEntryId the analysis entry ID
	* @return the matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByAnalysisEntryId(long analysisEntryId)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence().findByAnalysisEntryId(analysisEntryId);
	}

	/**
	* Returns the analysis entry where analysisEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param analysisEntryId the analysis entry ID
	* @return the matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByAnalysisEntryId(long analysisEntryId) {
		return getPersistence().fetchByAnalysisEntryId(analysisEntryId);
	}

	/**
	* Returns the analysis entry where analysisEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param analysisEntryId the analysis entry ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByAnalysisEntryId(long analysisEntryId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByAnalysisEntryId(analysisEntryId, retrieveFromCache);
	}

	/**
	* Removes the analysis entry where analysisEntryId = &#63; from the database.
	*
	* @param analysisEntryId the analysis entry ID
	* @return the analysis entry that was removed
	*/
	public static AnalysisEntry removeByAnalysisEntryId(long analysisEntryId)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence().removeByAnalysisEntryId(analysisEntryId);
	}

	/**
	* Returns the number of analysis entries where analysisEntryId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @return the number of matching analysis entries
	*/
	public static int countByAnalysisEntryId(long analysisEntryId) {
		return getPersistence().countByAnalysisEntryId(analysisEntryId);
	}

	/**
	* Returns all the analysis entries where analysisEntryId = &#63; and companyId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param companyId the company ID
	* @return the matching analysis entries
	*/
	public static List<AnalysisEntry> findByA_C(long analysisEntryId,
		long companyId) {
		return getPersistence().findByA_C(analysisEntryId, companyId);
	}

	/**
	* Returns a range of all the analysis entries where analysisEntryId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisEntryId the analysis entry ID
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByA_C(long analysisEntryId,
		long companyId, int start, int end) {
		return getPersistence().findByA_C(analysisEntryId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the analysis entries where analysisEntryId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisEntryId the analysis entry ID
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByA_C(long analysisEntryId,
		long companyId, int start, int end,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .findByA_C(analysisEntryId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis entries where analysisEntryId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisEntryId the analysis entry ID
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByA_C(long analysisEntryId,
		long companyId, int start, int end,
		OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByA_C(analysisEntryId, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first analysis entry in the ordered set where analysisEntryId = &#63; and companyId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByA_C_First(long analysisEntryId,
		long companyId, OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByA_C_First(analysisEntryId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first analysis entry in the ordered set where analysisEntryId = &#63; and companyId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByA_C_First(long analysisEntryId,
		long companyId, OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByA_C_First(analysisEntryId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where analysisEntryId = &#63; and companyId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByA_C_Last(long analysisEntryId,
		long companyId, OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByA_C_Last(analysisEntryId, companyId, orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where analysisEntryId = &#63; and companyId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByA_C_Last(long analysisEntryId,
		long companyId, OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByA_C_Last(analysisEntryId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the analysis entries where analysisEntryId = &#63; and companyId = &#63; from the database.
	*
	* @param analysisEntryId the analysis entry ID
	* @param companyId the company ID
	*/
	public static void removeByA_C(long analysisEntryId, long companyId) {
		getPersistence().removeByA_C(analysisEntryId, companyId);
	}

	/**
	* Returns the number of analysis entries where analysisEntryId = &#63; and companyId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param companyId the company ID
	* @return the number of matching analysis entries
	*/
	public static int countByA_C(long analysisEntryId, long companyId) {
		return getPersistence().countByA_C(analysisEntryId, companyId);
	}

	/**
	* Returns all the analysis entries where analysisEntryId = &#63; and candidateMaintenanceId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @return the matching analysis entries
	*/
	public static List<AnalysisEntry> findByA_CM(long analysisEntryId,
		long candidateMaintenanceId) {
		return getPersistence()
				   .findByA_CM(analysisEntryId, candidateMaintenanceId);
	}

	/**
	* Returns a range of all the analysis entries where analysisEntryId = &#63; and candidateMaintenanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisEntryId the analysis entry ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByA_CM(long analysisEntryId,
		long candidateMaintenanceId, int start, int end) {
		return getPersistence()
				   .findByA_CM(analysisEntryId, candidateMaintenanceId, start,
			end);
	}

	/**
	* Returns an ordered range of all the analysis entries where analysisEntryId = &#63; and candidateMaintenanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisEntryId the analysis entry ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByA_CM(long analysisEntryId,
		long candidateMaintenanceId, int start, int end,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .findByA_CM(analysisEntryId, candidateMaintenanceId, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis entries where analysisEntryId = &#63; and candidateMaintenanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisEntryId the analysis entry ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByA_CM(long analysisEntryId,
		long candidateMaintenanceId, int start, int end,
		OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByA_CM(analysisEntryId, candidateMaintenanceId, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first analysis entry in the ordered set where analysisEntryId = &#63; and candidateMaintenanceId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByA_CM_First(long analysisEntryId,
		long candidateMaintenanceId,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByA_CM_First(analysisEntryId, candidateMaintenanceId,
			orderByComparator);
	}

	/**
	* Returns the first analysis entry in the ordered set where analysisEntryId = &#63; and candidateMaintenanceId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByA_CM_First(long analysisEntryId,
		long candidateMaintenanceId,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByA_CM_First(analysisEntryId, candidateMaintenanceId,
			orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where analysisEntryId = &#63; and candidateMaintenanceId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByA_CM_Last(long analysisEntryId,
		long candidateMaintenanceId,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByA_CM_Last(analysisEntryId, candidateMaintenanceId,
			orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where analysisEntryId = &#63; and candidateMaintenanceId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByA_CM_Last(long analysisEntryId,
		long candidateMaintenanceId,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByA_CM_Last(analysisEntryId, candidateMaintenanceId,
			orderByComparator);
	}

	/**
	* Removes all the analysis entries where analysisEntryId = &#63; and candidateMaintenanceId = &#63; from the database.
	*
	* @param analysisEntryId the analysis entry ID
	* @param candidateMaintenanceId the candidate maintenance ID
	*/
	public static void removeByA_CM(long analysisEntryId,
		long candidateMaintenanceId) {
		getPersistence().removeByA_CM(analysisEntryId, candidateMaintenanceId);
	}

	/**
	* Returns the number of analysis entries where analysisEntryId = &#63; and candidateMaintenanceId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @return the number of matching analysis entries
	*/
	public static int countByA_CM(long analysisEntryId,
		long candidateMaintenanceId) {
		return getPersistence()
				   .countByA_CM(analysisEntryId, candidateMaintenanceId);
	}

	/**
	* Returns all the analysis entries where analysisEntryId = &#63; and userId = &#63; and candidateMaintenanceId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @return the matching analysis entries
	*/
	public static List<AnalysisEntry> findByA_U_CM(long analysisEntryId,
		long userId, long candidateMaintenanceId) {
		return getPersistence()
				   .findByA_U_CM(analysisEntryId, userId, candidateMaintenanceId);
	}

	/**
	* Returns a range of all the analysis entries where analysisEntryId = &#63; and userId = &#63; and candidateMaintenanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByA_U_CM(long analysisEntryId,
		long userId, long candidateMaintenanceId, int start, int end) {
		return getPersistence()
				   .findByA_U_CM(analysisEntryId, userId,
			candidateMaintenanceId, start, end);
	}

	/**
	* Returns an ordered range of all the analysis entries where analysisEntryId = &#63; and userId = &#63; and candidateMaintenanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByA_U_CM(long analysisEntryId,
		long userId, long candidateMaintenanceId, int start, int end,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .findByA_U_CM(analysisEntryId, userId,
			candidateMaintenanceId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis entries where analysisEntryId = &#63; and userId = &#63; and candidateMaintenanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByA_U_CM(long analysisEntryId,
		long userId, long candidateMaintenanceId, int start, int end,
		OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByA_U_CM(analysisEntryId, userId,
			candidateMaintenanceId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first analysis entry in the ordered set where analysisEntryId = &#63; and userId = &#63; and candidateMaintenanceId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByA_U_CM_First(long analysisEntryId,
		long userId, long candidateMaintenanceId,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByA_U_CM_First(analysisEntryId, userId,
			candidateMaintenanceId, orderByComparator);
	}

	/**
	* Returns the first analysis entry in the ordered set where analysisEntryId = &#63; and userId = &#63; and candidateMaintenanceId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByA_U_CM_First(long analysisEntryId,
		long userId, long candidateMaintenanceId,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByA_U_CM_First(analysisEntryId, userId,
			candidateMaintenanceId, orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where analysisEntryId = &#63; and userId = &#63; and candidateMaintenanceId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByA_U_CM_Last(long analysisEntryId,
		long userId, long candidateMaintenanceId,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByA_U_CM_Last(analysisEntryId, userId,
			candidateMaintenanceId, orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where analysisEntryId = &#63; and userId = &#63; and candidateMaintenanceId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByA_U_CM_Last(long analysisEntryId,
		long userId, long candidateMaintenanceId,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByA_U_CM_Last(analysisEntryId, userId,
			candidateMaintenanceId, orderByComparator);
	}

	/**
	* Removes all the analysis entries where analysisEntryId = &#63; and userId = &#63; and candidateMaintenanceId = &#63; from the database.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @param candidateMaintenanceId the candidate maintenance ID
	*/
	public static void removeByA_U_CM(long analysisEntryId, long userId,
		long candidateMaintenanceId) {
		getPersistence()
			.removeByA_U_CM(analysisEntryId, userId, candidateMaintenanceId);
	}

	/**
	* Returns the number of analysis entries where analysisEntryId = &#63; and userId = &#63; and candidateMaintenanceId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @param candidateMaintenanceId the candidate maintenance ID
	* @return the number of matching analysis entries
	*/
	public static int countByA_U_CM(long analysisEntryId, long userId,
		long candidateMaintenanceId) {
		return getPersistence()
				   .countByA_U_CM(analysisEntryId, userId,
			candidateMaintenanceId);
	}

	/**
	* Returns the analysis entry where candidateMaintenanceId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param candidateMaintenanceId the candidate maintenance ID
	* @return the matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByCandidateMaintenanceId(
		long candidateMaintenanceId)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCandidateMaintenanceId(candidateMaintenanceId);
	}

	/**
	* Returns the analysis entry where candidateMaintenanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param candidateMaintenanceId the candidate maintenance ID
	* @return the matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByCandidateMaintenanceId(
		long candidateMaintenanceId) {
		return getPersistence()
				   .fetchByCandidateMaintenanceId(candidateMaintenanceId);
	}

	/**
	* Returns the analysis entry where candidateMaintenanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByCandidateMaintenanceId(
		long candidateMaintenanceId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByCandidateMaintenanceId(candidateMaintenanceId,
			retrieveFromCache);
	}

	/**
	* Removes the analysis entry where candidateMaintenanceId = &#63; from the database.
	*
	* @param candidateMaintenanceId the candidate maintenance ID
	* @return the analysis entry that was removed
	*/
	public static AnalysisEntry removeByCandidateMaintenanceId(
		long candidateMaintenanceId)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .removeByCandidateMaintenanceId(candidateMaintenanceId);
	}

	/**
	* Returns the number of analysis entries where candidateMaintenanceId = &#63;.
	*
	* @param candidateMaintenanceId the candidate maintenance ID
	* @return the number of matching analysis entries
	*/
	public static int countByCandidateMaintenanceId(long candidateMaintenanceId) {
		return getPersistence()
				   .countByCandidateMaintenanceId(candidateMaintenanceId);
	}

	/**
	* Returns all the analysis entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching analysis entries
	*/
	public static List<AnalysisEntry> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the analysis entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByCompanyId(long companyId,
		int start, int end) {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the analysis entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByCompanyId(long companyId,
		int start, int end, OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByCompanyId(long companyId,
		int start, int end, OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first analysis entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByCompanyId_First(long companyId,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first analysis entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByCompanyId_First(long companyId,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByCompanyId_Last(long companyId,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByCompanyId_Last(long companyId,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the analysis entries before and after the current analysis entry in the ordered set where companyId = &#63;.
	*
	* @param analysisEntryId the primary key of the current analysis entry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis entry
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public static AnalysisEntry[] findByCompanyId_PrevAndNext(
		long analysisEntryId, long companyId,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(analysisEntryId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the analysis entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of analysis entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching analysis entries
	*/
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the analysis entries where candidateMaintenanceId = &#63; and userId = &#63;.
	*
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param userId the user ID
	* @return the matching analysis entries
	*/
	public static List<AnalysisEntry> findByCM_U(long candidateMaintenanceId,
		long userId) {
		return getPersistence().findByCM_U(candidateMaintenanceId, userId);
	}

	/**
	* Returns a range of all the analysis entries where candidateMaintenanceId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param userId the user ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByCM_U(long candidateMaintenanceId,
		long userId, int start, int end) {
		return getPersistence()
				   .findByCM_U(candidateMaintenanceId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the analysis entries where candidateMaintenanceId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param userId the user ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByCM_U(long candidateMaintenanceId,
		long userId, int start, int end,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .findByCM_U(candidateMaintenanceId, userId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis entries where candidateMaintenanceId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param userId the user ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByCM_U(long candidateMaintenanceId,
		long userId, int start, int end,
		OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCM_U(candidateMaintenanceId, userId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first analysis entry in the ordered set where candidateMaintenanceId = &#63; and userId = &#63;.
	*
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByCM_U_First(long candidateMaintenanceId,
		long userId, OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCM_U_First(candidateMaintenanceId, userId,
			orderByComparator);
	}

	/**
	* Returns the first analysis entry in the ordered set where candidateMaintenanceId = &#63; and userId = &#63;.
	*
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByCM_U_First(long candidateMaintenanceId,
		long userId, OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByCM_U_First(candidateMaintenanceId, userId,
			orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where candidateMaintenanceId = &#63; and userId = &#63;.
	*
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByCM_U_Last(long candidateMaintenanceId,
		long userId, OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCM_U_Last(candidateMaintenanceId, userId,
			orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where candidateMaintenanceId = &#63; and userId = &#63;.
	*
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByCM_U_Last(long candidateMaintenanceId,
		long userId, OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByCM_U_Last(candidateMaintenanceId, userId,
			orderByComparator);
	}

	/**
	* Returns the analysis entries before and after the current analysis entry in the ordered set where candidateMaintenanceId = &#63; and userId = &#63;.
	*
	* @param analysisEntryId the primary key of the current analysis entry
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis entry
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public static AnalysisEntry[] findByCM_U_PrevAndNext(long analysisEntryId,
		long candidateMaintenanceId, long userId,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByCM_U_PrevAndNext(analysisEntryId,
			candidateMaintenanceId, userId, orderByComparator);
	}

	/**
	* Removes all the analysis entries where candidateMaintenanceId = &#63; and userId = &#63; from the database.
	*
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param userId the user ID
	*/
	public static void removeByCM_U(long candidateMaintenanceId, long userId) {
		getPersistence().removeByCM_U(candidateMaintenanceId, userId);
	}

	/**
	* Returns the number of analysis entries where candidateMaintenanceId = &#63; and userId = &#63;.
	*
	* @param candidateMaintenanceId the candidate maintenance ID
	* @param userId the user ID
	* @return the number of matching analysis entries
	*/
	public static int countByCM_U(long candidateMaintenanceId, long userId) {
		return getPersistence().countByCM_U(candidateMaintenanceId, userId);
	}

	/**
	* Returns all the analysis entries where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching analysis entries
	*/
	public static List<AnalysisEntry> findByC_U(long companyId, long userId) {
		return getPersistence().findByC_U(companyId, userId);
	}

	/**
	* Returns a range of all the analysis entries where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByC_U(long companyId, long userId,
		int start, int end) {
		return getPersistence().findByC_U(companyId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the analysis entries where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByC_U(long companyId, long userId,
		int start, int end, OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .findByC_U(companyId, userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis entries where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByC_U(long companyId, long userId,
		int start, int end, OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_U(companyId, userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first analysis entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByC_U_First(long companyId, long userId,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_U_First(companyId, userId, orderByComparator);
	}

	/**
	* Returns the first analysis entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByC_U_First(long companyId, long userId,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByC_U_First(companyId, userId, orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByC_U_Last(long companyId, long userId,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_U_Last(companyId, userId, orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByC_U_Last(long companyId, long userId,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByC_U_Last(companyId, userId, orderByComparator);
	}

	/**
	* Returns the analysis entries before and after the current analysis entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param analysisEntryId the primary key of the current analysis entry
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis entry
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public static AnalysisEntry[] findByC_U_PrevAndNext(long analysisEntryId,
		long companyId, long userId,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByC_U_PrevAndNext(analysisEntryId, companyId, userId,
			orderByComparator);
	}

	/**
	* Removes all the analysis entries where companyId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userId the user ID
	*/
	public static void removeByC_U(long companyId, long userId) {
		getPersistence().removeByC_U(companyId, userId);
	}

	/**
	* Returns the number of analysis entries where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the number of matching analysis entries
	*/
	public static int countByC_U(long companyId, long userId) {
		return getPersistence().countByC_U(companyId, userId);
	}

	/**
	* Returns all the analysis entries where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @return the matching analysis entries
	*/
	public static List<AnalysisEntry> findByU_cD(long userId, Date createDate) {
		return getPersistence().findByU_cD(userId, createDate);
	}

	/**
	* Returns a range of all the analysis entries where userId = &#63; and createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByU_cD(long userId, Date createDate,
		int start, int end) {
		return getPersistence().findByU_cD(userId, createDate, start, end);
	}

	/**
	* Returns an ordered range of all the analysis entries where userId = &#63; and createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByU_cD(long userId, Date createDate,
		int start, int end, OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .findByU_cD(userId, createDate, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis entries where userId = &#63; and createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis entries
	*/
	public static List<AnalysisEntry> findByU_cD(long userId, Date createDate,
		int start, int end, OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_cD(userId, createDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first analysis entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByU_cD_First(long userId, Date createDate,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_cD_First(userId, createDate, orderByComparator);
	}

	/**
	* Returns the first analysis entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByU_cD_First(long userId, Date createDate,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_cD_First(userId, createDate, orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry
	* @throws NoSuchEntryException if a matching analysis entry could not be found
	*/
	public static AnalysisEntry findByU_cD_Last(long userId, Date createDate,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_cD_Last(userId, createDate, orderByComparator);
	}

	/**
	* Returns the last analysis entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static AnalysisEntry fetchByU_cD_Last(long userId, Date createDate,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence()
				   .fetchByU_cD_Last(userId, createDate, orderByComparator);
	}

	/**
	* Returns the analysis entries before and after the current analysis entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param analysisEntryId the primary key of the current analysis entry
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis entry
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public static AnalysisEntry[] findByU_cD_PrevAndNext(long analysisEntryId,
		long userId, Date createDate,
		OrderByComparator<AnalysisEntry> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence()
				   .findByU_cD_PrevAndNext(analysisEntryId, userId, createDate,
			orderByComparator);
	}

	/**
	* Removes all the analysis entries where userId = &#63; and createDate = &#63; from the database.
	*
	* @param userId the user ID
	* @param createDate the create date
	*/
	public static void removeByU_cD(long userId, Date createDate) {
		getPersistence().removeByU_cD(userId, createDate);
	}

	/**
	* Returns the number of analysis entries where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @return the number of matching analysis entries
	*/
	public static int countByU_cD(long userId, Date createDate) {
		return getPersistence().countByU_cD(userId, createDate);
	}

	/**
	* Caches the analysis entry in the entity cache if it is enabled.
	*
	* @param analysisEntry the analysis entry
	*/
	public static void cacheResult(AnalysisEntry analysisEntry) {
		getPersistence().cacheResult(analysisEntry);
	}

	/**
	* Caches the analysis entries in the entity cache if it is enabled.
	*
	* @param analysisEntries the analysis entries
	*/
	public static void cacheResult(List<AnalysisEntry> analysisEntries) {
		getPersistence().cacheResult(analysisEntries);
	}

	/**
	* Creates a new analysis entry with the primary key. Does not add the analysis entry to the database.
	*
	* @param analysisEntryId the primary key for the new analysis entry
	* @return the new analysis entry
	*/
	public static AnalysisEntry create(long analysisEntryId) {
		return getPersistence().create(analysisEntryId);
	}

	/**
	* Removes the analysis entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analysisEntryId the primary key of the analysis entry
	* @return the analysis entry that was removed
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public static AnalysisEntry remove(long analysisEntryId)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence().remove(analysisEntryId);
	}

	public static AnalysisEntry updateImpl(AnalysisEntry analysisEntry) {
		return getPersistence().updateImpl(analysisEntry);
	}

	/**
	* Returns the analysis entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param analysisEntryId the primary key of the analysis entry
	* @return the analysis entry
	* @throws NoSuchEntryException if a analysis entry with the primary key could not be found
	*/
	public static AnalysisEntry findByPrimaryKey(long analysisEntryId)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException {
		return getPersistence().findByPrimaryKey(analysisEntryId);
	}

	/**
	* Returns the analysis entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param analysisEntryId the primary key of the analysis entry
	* @return the analysis entry, or <code>null</code> if a analysis entry with the primary key could not be found
	*/
	public static AnalysisEntry fetchByPrimaryKey(long analysisEntryId) {
		return getPersistence().fetchByPrimaryKey(analysisEntryId);
	}

	public static java.util.Map<java.io.Serializable, AnalysisEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the analysis entries.
	*
	* @return the analysis entries
	*/
	public static List<AnalysisEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the analysis entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of analysis entries
	*/
	public static List<AnalysisEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the analysis entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of analysis entries
	*/
	public static List<AnalysisEntry> findAll(int start, int end,
		OrderByComparator<AnalysisEntry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of analysis entries
	*/
	public static List<AnalysisEntry> findAll(int start, int end,
		OrderByComparator<AnalysisEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the analysis entries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of analysis entries.
	*
	* @return the number of analysis entries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AnalysisEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AnalysisEntryPersistence, AnalysisEntryPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AnalysisEntryPersistence.class);
}