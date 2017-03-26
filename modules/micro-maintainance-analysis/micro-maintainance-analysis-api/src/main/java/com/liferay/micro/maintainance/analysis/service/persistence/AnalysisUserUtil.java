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

import com.liferay.micro.maintainance.analysis.model.AnalysisUser;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the analysis user service. This utility wraps {@link com.liferay.micro.maintainance.analysis.service.persistence.impl.AnalysisUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisUserPersistence
 * @see com.liferay.micro.maintainance.analysis.service.persistence.impl.AnalysisUserPersistenceImpl
 * @generated
 */
@ProviderType
public class AnalysisUserUtil {
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
	public static void clearCache(AnalysisUser analysisUser) {
		getPersistence().clearCache(analysisUser);
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
	public static List<AnalysisUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnalysisUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnalysisUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AnalysisUser update(AnalysisUser analysisUser) {
		return getPersistence().update(analysisUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AnalysisUser update(AnalysisUser analysisUser,
		ServiceContext serviceContext) {
		return getPersistence().update(analysisUser, serviceContext);
	}

	/**
	* Returns all the analysis users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching analysis users
	*/
	public static List<AnalysisUser> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the analysis users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @return the range of matching analysis users
	*/
	public static List<AnalysisUser> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the analysis users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis users
	*/
	public static List<AnalysisUser> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis users where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis users
	*/
	public static List<AnalysisUser> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first analysis user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public static AnalysisUser findByUuid_First(java.lang.String uuid,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first analysis user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public static AnalysisUser fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last analysis user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public static AnalysisUser findByUuid_Last(java.lang.String uuid,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last analysis user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public static AnalysisUser fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the analysis users before and after the current analysis user in the ordered set where uuid = &#63;.
	*
	* @param analysisUserId the primary key of the current analysis user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis user
	* @throws NoSuchUserException if a analysis user with the primary key could not be found
	*/
	public static AnalysisUser[] findByUuid_PrevAndNext(long analysisUserId,
		java.lang.String uuid, OrderByComparator<AnalysisUser> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence()
				   .findByUuid_PrevAndNext(analysisUserId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the analysis users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of analysis users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching analysis users
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the analysis users where analysisEntryId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @return the matching analysis users
	*/
	public static List<AnalysisUser> findByAnalysisEntryId(long analysisEntryId) {
		return getPersistence().findByAnalysisEntryId(analysisEntryId);
	}

	/**
	* Returns a range of all the analysis users where analysisEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisEntryId the analysis entry ID
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @return the range of matching analysis users
	*/
	public static List<AnalysisUser> findByAnalysisEntryId(
		long analysisEntryId, int start, int end) {
		return getPersistence()
				   .findByAnalysisEntryId(analysisEntryId, start, end);
	}

	/**
	* Returns an ordered range of all the analysis users where analysisEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisEntryId the analysis entry ID
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis users
	*/
	public static List<AnalysisUser> findByAnalysisEntryId(
		long analysisEntryId, int start, int end,
		OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence()
				   .findByAnalysisEntryId(analysisEntryId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis users where analysisEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisEntryId the analysis entry ID
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis users
	*/
	public static List<AnalysisUser> findByAnalysisEntryId(
		long analysisEntryId, int start, int end,
		OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByAnalysisEntryId(analysisEntryId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first analysis user in the ordered set where analysisEntryId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public static AnalysisUser findByAnalysisEntryId_First(
		long analysisEntryId, OrderByComparator<AnalysisUser> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence()
				   .findByAnalysisEntryId_First(analysisEntryId,
			orderByComparator);
	}

	/**
	* Returns the first analysis user in the ordered set where analysisEntryId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public static AnalysisUser fetchByAnalysisEntryId_First(
		long analysisEntryId, OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence()
				   .fetchByAnalysisEntryId_First(analysisEntryId,
			orderByComparator);
	}

	/**
	* Returns the last analysis user in the ordered set where analysisEntryId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public static AnalysisUser findByAnalysisEntryId_Last(
		long analysisEntryId, OrderByComparator<AnalysisUser> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence()
				   .findByAnalysisEntryId_Last(analysisEntryId,
			orderByComparator);
	}

	/**
	* Returns the last analysis user in the ordered set where analysisEntryId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public static AnalysisUser fetchByAnalysisEntryId_Last(
		long analysisEntryId, OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence()
				   .fetchByAnalysisEntryId_Last(analysisEntryId,
			orderByComparator);
	}

	/**
	* Returns the analysis users before and after the current analysis user in the ordered set where analysisEntryId = &#63;.
	*
	* @param analysisUserId the primary key of the current analysis user
	* @param analysisEntryId the analysis entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis user
	* @throws NoSuchUserException if a analysis user with the primary key could not be found
	*/
	public static AnalysisUser[] findByAnalysisEntryId_PrevAndNext(
		long analysisUserId, long analysisEntryId,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence()
				   .findByAnalysisEntryId_PrevAndNext(analysisUserId,
			analysisEntryId, orderByComparator);
	}

	/**
	* Removes all the analysis users where analysisEntryId = &#63; from the database.
	*
	* @param analysisEntryId the analysis entry ID
	*/
	public static void removeByAnalysisEntryId(long analysisEntryId) {
		getPersistence().removeByAnalysisEntryId(analysisEntryId);
	}

	/**
	* Returns the number of analysis users where analysisEntryId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @return the number of matching analysis users
	*/
	public static int countByAnalysisEntryId(long analysisEntryId) {
		return getPersistence().countByAnalysisEntryId(analysisEntryId);
	}

	/**
	* Returns all the analysis users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching analysis users
	*/
	public static List<AnalysisUser> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the analysis users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @return the range of matching analysis users
	*/
	public static List<AnalysisUser> findByUserId(long userId, int start,
		int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the analysis users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis users
	*/
	public static List<AnalysisUser> findByUserId(long userId, int start,
		int end, OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis users where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis users
	*/
	public static List<AnalysisUser> findByUserId(long userId, int start,
		int end, OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first analysis user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public static AnalysisUser findByUserId_First(long userId,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first analysis user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public static AnalysisUser fetchByUserId_First(long userId,
		OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last analysis user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public static AnalysisUser findByUserId_Last(long userId,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last analysis user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public static AnalysisUser fetchByUserId_Last(long userId,
		OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the analysis users before and after the current analysis user in the ordered set where userId = &#63;.
	*
	* @param analysisUserId the primary key of the current analysis user
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis user
	* @throws NoSuchUserException if a analysis user with the primary key could not be found
	*/
	public static AnalysisUser[] findByUserId_PrevAndNext(long analysisUserId,
		long userId, OrderByComparator<AnalysisUser> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence()
				   .findByUserId_PrevAndNext(analysisUserId, userId,
			orderByComparator);
	}

	/**
	* Removes all the analysis users where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of analysis users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching analysis users
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the analysis users where userName = &#63;.
	*
	* @param userName the user name
	* @return the matching analysis users
	*/
	public static List<AnalysisUser> findByUserName(java.lang.String userName) {
		return getPersistence().findByUserName(userName);
	}

	/**
	* Returns a range of all the analysis users where userName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userName the user name
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @return the range of matching analysis users
	*/
	public static List<AnalysisUser> findByUserName(java.lang.String userName,
		int start, int end) {
		return getPersistence().findByUserName(userName, start, end);
	}

	/**
	* Returns an ordered range of all the analysis users where userName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userName the user name
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis users
	*/
	public static List<AnalysisUser> findByUserName(java.lang.String userName,
		int start, int end, OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence()
				   .findByUserName(userName, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis users where userName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userName the user name
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis users
	*/
	public static List<AnalysisUser> findByUserName(java.lang.String userName,
		int start, int end, OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserName(userName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first analysis user in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public static AnalysisUser findByUserName_First(java.lang.String userName,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence().findByUserName_First(userName, orderByComparator);
	}

	/**
	* Returns the first analysis user in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public static AnalysisUser fetchByUserName_First(
		java.lang.String userName,
		OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence()
				   .fetchByUserName_First(userName, orderByComparator);
	}

	/**
	* Returns the last analysis user in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public static AnalysisUser findByUserName_Last(java.lang.String userName,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence().findByUserName_Last(userName, orderByComparator);
	}

	/**
	* Returns the last analysis user in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public static AnalysisUser fetchByUserName_Last(java.lang.String userName,
		OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence().fetchByUserName_Last(userName, orderByComparator);
	}

	/**
	* Returns the analysis users before and after the current analysis user in the ordered set where userName = &#63;.
	*
	* @param analysisUserId the primary key of the current analysis user
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis user
	* @throws NoSuchUserException if a analysis user with the primary key could not be found
	*/
	public static AnalysisUser[] findByUserName_PrevAndNext(
		long analysisUserId, java.lang.String userName,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence()
				   .findByUserName_PrevAndNext(analysisUserId, userName,
			orderByComparator);
	}

	/**
	* Removes all the analysis users where userName = &#63; from the database.
	*
	* @param userName the user name
	*/
	public static void removeByUserName(java.lang.String userName) {
		getPersistence().removeByUserName(userName);
	}

	/**
	* Returns the number of analysis users where userName = &#63;.
	*
	* @param userName the user name
	* @return the number of matching analysis users
	*/
	public static int countByUserName(java.lang.String userName) {
		return getPersistence().countByUserName(userName);
	}

	/**
	* Returns the analysis user where analysisUserId = &#63; or throws a {@link NoSuchUserException} if it could not be found.
	*
	* @param analysisUserId the analysis user ID
	* @return the matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public static AnalysisUser findByAU(long analysisUserId)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence().findByAU(analysisUserId);
	}

	/**
	* Returns the analysis user where analysisUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param analysisUserId the analysis user ID
	* @return the matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public static AnalysisUser fetchByAU(long analysisUserId) {
		return getPersistence().fetchByAU(analysisUserId);
	}

	/**
	* Returns the analysis user where analysisUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param analysisUserId the analysis user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public static AnalysisUser fetchByAU(long analysisUserId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByAU(analysisUserId, retrieveFromCache);
	}

	/**
	* Removes the analysis user where analysisUserId = &#63; from the database.
	*
	* @param analysisUserId the analysis user ID
	* @return the analysis user that was removed
	*/
	public static AnalysisUser removeByAU(long analysisUserId)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence().removeByAU(analysisUserId);
	}

	/**
	* Returns the number of analysis users where analysisUserId = &#63;.
	*
	* @param analysisUserId the analysis user ID
	* @return the number of matching analysis users
	*/
	public static int countByAU(long analysisUserId) {
		return getPersistence().countByAU(analysisUserId);
	}

	/**
	* Returns the analysis user where analysisEntryId = &#63; and userId = &#63; or throws a {@link NoSuchUserException} if it could not be found.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @return the matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public static AnalysisUser findByA_U(long analysisEntryId, long userId)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence().findByA_U(analysisEntryId, userId);
	}

	/**
	* Returns the analysis user where analysisEntryId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @return the matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public static AnalysisUser fetchByA_U(long analysisEntryId, long userId) {
		return getPersistence().fetchByA_U(analysisEntryId, userId);
	}

	/**
	* Returns the analysis user where analysisEntryId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public static AnalysisUser fetchByA_U(long analysisEntryId, long userId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByA_U(analysisEntryId, userId, retrieveFromCache);
	}

	/**
	* Removes the analysis user where analysisEntryId = &#63; and userId = &#63; from the database.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @return the analysis user that was removed
	*/
	public static AnalysisUser removeByA_U(long analysisEntryId, long userId)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence().removeByA_U(analysisEntryId, userId);
	}

	/**
	* Returns the number of analysis users where analysisEntryId = &#63; and userId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @return the number of matching analysis users
	*/
	public static int countByA_U(long analysisEntryId, long userId) {
		return getPersistence().countByA_U(analysisEntryId, userId);
	}

	/**
	* Returns all the analysis users where analysisEntryId = &#63; and voted = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @return the matching analysis users
	*/
	public static List<AnalysisUser> findByVoted(long analysisEntryId, int voted) {
		return getPersistence().findByVoted(analysisEntryId, voted);
	}

	/**
	* Returns a range of all the analysis users where analysisEntryId = &#63; and voted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @return the range of matching analysis users
	*/
	public static List<AnalysisUser> findByVoted(long analysisEntryId,
		int voted, int start, int end) {
		return getPersistence().findByVoted(analysisEntryId, voted, start, end);
	}

	/**
	* Returns an ordered range of all the analysis users where analysisEntryId = &#63; and voted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching analysis users
	*/
	public static List<AnalysisUser> findByVoted(long analysisEntryId,
		int voted, int start, int end,
		OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence()
				   .findByVoted(analysisEntryId, voted, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis users where analysisEntryId = &#63; and voted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching analysis users
	*/
	public static List<AnalysisUser> findByVoted(long analysisEntryId,
		int voted, int start, int end,
		OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByVoted(analysisEntryId, voted, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first analysis user in the ordered set where analysisEntryId = &#63; and voted = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public static AnalysisUser findByVoted_First(long analysisEntryId,
		int voted, OrderByComparator<AnalysisUser> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence()
				   .findByVoted_First(analysisEntryId, voted, orderByComparator);
	}

	/**
	* Returns the first analysis user in the ordered set where analysisEntryId = &#63; and voted = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public static AnalysisUser fetchByVoted_First(long analysisEntryId,
		int voted, OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence()
				   .fetchByVoted_First(analysisEntryId, voted, orderByComparator);
	}

	/**
	* Returns the last analysis user in the ordered set where analysisEntryId = &#63; and voted = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public static AnalysisUser findByVoted_Last(long analysisEntryId,
		int voted, OrderByComparator<AnalysisUser> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence()
				   .findByVoted_Last(analysisEntryId, voted, orderByComparator);
	}

	/**
	* Returns the last analysis user in the ordered set where analysisEntryId = &#63; and voted = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public static AnalysisUser fetchByVoted_Last(long analysisEntryId,
		int voted, OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence()
				   .fetchByVoted_Last(analysisEntryId, voted, orderByComparator);
	}

	/**
	* Returns the analysis users before and after the current analysis user in the ordered set where analysisEntryId = &#63; and voted = &#63;.
	*
	* @param analysisUserId the primary key of the current analysis user
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis user
	* @throws NoSuchUserException if a analysis user with the primary key could not be found
	*/
	public static AnalysisUser[] findByVoted_PrevAndNext(long analysisUserId,
		long analysisEntryId, int voted,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence()
				   .findByVoted_PrevAndNext(analysisUserId, analysisEntryId,
			voted, orderByComparator);
	}

	/**
	* Removes all the analysis users where analysisEntryId = &#63; and voted = &#63; from the database.
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	*/
	public static void removeByVoted(long analysisEntryId, int voted) {
		getPersistence().removeByVoted(analysisEntryId, voted);
	}

	/**
	* Returns the number of analysis users where analysisEntryId = &#63; and voted = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @return the number of matching analysis users
	*/
	public static int countByVoted(long analysisEntryId, int voted) {
		return getPersistence().countByVoted(analysisEntryId, voted);
	}

	/**
	* Caches the analysis user in the entity cache if it is enabled.
	*
	* @param analysisUser the analysis user
	*/
	public static void cacheResult(AnalysisUser analysisUser) {
		getPersistence().cacheResult(analysisUser);
	}

	/**
	* Caches the analysis users in the entity cache if it is enabled.
	*
	* @param analysisUsers the analysis users
	*/
	public static void cacheResult(List<AnalysisUser> analysisUsers) {
		getPersistence().cacheResult(analysisUsers);
	}

	/**
	* Creates a new analysis user with the primary key. Does not add the analysis user to the database.
	*
	* @param analysisUserId the primary key for the new analysis user
	* @return the new analysis user
	*/
	public static AnalysisUser create(long analysisUserId) {
		return getPersistence().create(analysisUserId);
	}

	/**
	* Removes the analysis user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analysisUserId the primary key of the analysis user
	* @return the analysis user that was removed
	* @throws NoSuchUserException if a analysis user with the primary key could not be found
	*/
	public static AnalysisUser remove(long analysisUserId)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence().remove(analysisUserId);
	}

	public static AnalysisUser updateImpl(AnalysisUser analysisUser) {
		return getPersistence().updateImpl(analysisUser);
	}

	/**
	* Returns the analysis user with the primary key or throws a {@link NoSuchUserException} if it could not be found.
	*
	* @param analysisUserId the primary key of the analysis user
	* @return the analysis user
	* @throws NoSuchUserException if a analysis user with the primary key could not be found
	*/
	public static AnalysisUser findByPrimaryKey(long analysisUserId)
		throws com.liferay.micro.maintainance.analysis.exception.NoSuchUserException {
		return getPersistence().findByPrimaryKey(analysisUserId);
	}

	/**
	* Returns the analysis user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param analysisUserId the primary key of the analysis user
	* @return the analysis user, or <code>null</code> if a analysis user with the primary key could not be found
	*/
	public static AnalysisUser fetchByPrimaryKey(long analysisUserId) {
		return getPersistence().fetchByPrimaryKey(analysisUserId);
	}

	public static java.util.Map<java.io.Serializable, AnalysisUser> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the analysis users.
	*
	* @return the analysis users
	*/
	public static List<AnalysisUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the analysis users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @return the range of analysis users
	*/
	public static List<AnalysisUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the analysis users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of analysis users
	*/
	public static List<AnalysisUser> findAll(int start, int end,
		OrderByComparator<AnalysisUser> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the analysis users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of analysis users
	*/
	public static List<AnalysisUser> findAll(int start, int end,
		OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the analysis users from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of analysis users.
	*
	* @return the number of analysis users
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AnalysisUserPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AnalysisUserPersistence, AnalysisUserPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AnalysisUserPersistence.class);
}