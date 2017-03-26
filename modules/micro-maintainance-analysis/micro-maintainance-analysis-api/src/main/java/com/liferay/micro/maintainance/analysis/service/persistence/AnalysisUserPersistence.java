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

import com.liferay.micro.maintainance.analysis.exception.NoSuchUserException;
import com.liferay.micro.maintainance.analysis.model.AnalysisUser;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the analysis user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.micro.maintainance.analysis.service.persistence.impl.AnalysisUserPersistenceImpl
 * @see AnalysisUserUtil
 * @generated
 */
@ProviderType
public interface AnalysisUserPersistence extends BasePersistence<AnalysisUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnalysisUserUtil} to access the analysis user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the analysis users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching analysis users
	*/
	public java.util.List<AnalysisUser> findByUuid(java.lang.String uuid);

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
	public java.util.List<AnalysisUser> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<AnalysisUser> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

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
	public java.util.List<AnalysisUser> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analysis user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public AnalysisUser findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException;

	/**
	* Returns the first analysis user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public AnalysisUser fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

	/**
	* Returns the last analysis user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public AnalysisUser findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException;

	/**
	* Returns the last analysis user in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public AnalysisUser fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

	/**
	* Returns the analysis users before and after the current analysis user in the ordered set where uuid = &#63;.
	*
	* @param analysisUserId the primary key of the current analysis user
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis user
	* @throws NoSuchUserException if a analysis user with the primary key could not be found
	*/
	public AnalysisUser[] findByUuid_PrevAndNext(long analysisUserId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException;

	/**
	* Removes all the analysis users where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of analysis users where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching analysis users
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the analysis users where analysisEntryId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @return the matching analysis users
	*/
	public java.util.List<AnalysisUser> findByAnalysisEntryId(
		long analysisEntryId);

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
	public java.util.List<AnalysisUser> findByAnalysisEntryId(
		long analysisEntryId, int start, int end);

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
	public java.util.List<AnalysisUser> findByAnalysisEntryId(
		long analysisEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

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
	public java.util.List<AnalysisUser> findByAnalysisEntryId(
		long analysisEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analysis user in the ordered set where analysisEntryId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public AnalysisUser findByAnalysisEntryId_First(long analysisEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException;

	/**
	* Returns the first analysis user in the ordered set where analysisEntryId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public AnalysisUser fetchByAnalysisEntryId_First(long analysisEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

	/**
	* Returns the last analysis user in the ordered set where analysisEntryId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public AnalysisUser findByAnalysisEntryId_Last(long analysisEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException;

	/**
	* Returns the last analysis user in the ordered set where analysisEntryId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public AnalysisUser fetchByAnalysisEntryId_Last(long analysisEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

	/**
	* Returns the analysis users before and after the current analysis user in the ordered set where analysisEntryId = &#63;.
	*
	* @param analysisUserId the primary key of the current analysis user
	* @param analysisEntryId the analysis entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis user
	* @throws NoSuchUserException if a analysis user with the primary key could not be found
	*/
	public AnalysisUser[] findByAnalysisEntryId_PrevAndNext(
		long analysisUserId, long analysisEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException;

	/**
	* Removes all the analysis users where analysisEntryId = &#63; from the database.
	*
	* @param analysisEntryId the analysis entry ID
	*/
	public void removeByAnalysisEntryId(long analysisEntryId);

	/**
	* Returns the number of analysis users where analysisEntryId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @return the number of matching analysis users
	*/
	public int countByAnalysisEntryId(long analysisEntryId);

	/**
	* Returns all the analysis users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching analysis users
	*/
	public java.util.List<AnalysisUser> findByUserId(long userId);

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
	public java.util.List<AnalysisUser> findByUserId(long userId, int start,
		int end);

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
	public java.util.List<AnalysisUser> findByUserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

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
	public java.util.List<AnalysisUser> findByUserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analysis user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public AnalysisUser findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException;

	/**
	* Returns the first analysis user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public AnalysisUser fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

	/**
	* Returns the last analysis user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public AnalysisUser findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException;

	/**
	* Returns the last analysis user in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public AnalysisUser fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

	/**
	* Returns the analysis users before and after the current analysis user in the ordered set where userId = &#63;.
	*
	* @param analysisUserId the primary key of the current analysis user
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis user
	* @throws NoSuchUserException if a analysis user with the primary key could not be found
	*/
	public AnalysisUser[] findByUserId_PrevAndNext(long analysisUserId,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException;

	/**
	* Removes all the analysis users where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUserId(long userId);

	/**
	* Returns the number of analysis users where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching analysis users
	*/
	public int countByUserId(long userId);

	/**
	* Returns all the analysis users where userName = &#63;.
	*
	* @param userName the user name
	* @return the matching analysis users
	*/
	public java.util.List<AnalysisUser> findByUserName(
		java.lang.String userName);

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
	public java.util.List<AnalysisUser> findByUserName(
		java.lang.String userName, int start, int end);

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
	public java.util.List<AnalysisUser> findByUserName(
		java.lang.String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

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
	public java.util.List<AnalysisUser> findByUserName(
		java.lang.String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analysis user in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public AnalysisUser findByUserName_First(java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException;

	/**
	* Returns the first analysis user in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public AnalysisUser fetchByUserName_First(java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

	/**
	* Returns the last analysis user in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public AnalysisUser findByUserName_Last(java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException;

	/**
	* Returns the last analysis user in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public AnalysisUser fetchByUserName_Last(java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

	/**
	* Returns the analysis users before and after the current analysis user in the ordered set where userName = &#63;.
	*
	* @param analysisUserId the primary key of the current analysis user
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next analysis user
	* @throws NoSuchUserException if a analysis user with the primary key could not be found
	*/
	public AnalysisUser[] findByUserName_PrevAndNext(long analysisUserId,
		java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException;

	/**
	* Removes all the analysis users where userName = &#63; from the database.
	*
	* @param userName the user name
	*/
	public void removeByUserName(java.lang.String userName);

	/**
	* Returns the number of analysis users where userName = &#63;.
	*
	* @param userName the user name
	* @return the number of matching analysis users
	*/
	public int countByUserName(java.lang.String userName);

	/**
	* Returns the analysis user where analysisUserId = &#63; or throws a {@link NoSuchUserException} if it could not be found.
	*
	* @param analysisUserId the analysis user ID
	* @return the matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public AnalysisUser findByAU(long analysisUserId)
		throws NoSuchUserException;

	/**
	* Returns the analysis user where analysisUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param analysisUserId the analysis user ID
	* @return the matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public AnalysisUser fetchByAU(long analysisUserId);

	/**
	* Returns the analysis user where analysisUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param analysisUserId the analysis user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public AnalysisUser fetchByAU(long analysisUserId, boolean retrieveFromCache);

	/**
	* Removes the analysis user where analysisUserId = &#63; from the database.
	*
	* @param analysisUserId the analysis user ID
	* @return the analysis user that was removed
	*/
	public AnalysisUser removeByAU(long analysisUserId)
		throws NoSuchUserException;

	/**
	* Returns the number of analysis users where analysisUserId = &#63;.
	*
	* @param analysisUserId the analysis user ID
	* @return the number of matching analysis users
	*/
	public int countByAU(long analysisUserId);

	/**
	* Returns the analysis user where analysisEntryId = &#63; and userId = &#63; or throws a {@link NoSuchUserException} if it could not be found.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @return the matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public AnalysisUser findByA_U(long analysisEntryId, long userId)
		throws NoSuchUserException;

	/**
	* Returns the analysis user where analysisEntryId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @return the matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public AnalysisUser fetchByA_U(long analysisEntryId, long userId);

	/**
	* Returns the analysis user where analysisEntryId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public AnalysisUser fetchByA_U(long analysisEntryId, long userId,
		boolean retrieveFromCache);

	/**
	* Removes the analysis user where analysisEntryId = &#63; and userId = &#63; from the database.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @return the analysis user that was removed
	*/
	public AnalysisUser removeByA_U(long analysisEntryId, long userId)
		throws NoSuchUserException;

	/**
	* Returns the number of analysis users where analysisEntryId = &#63; and userId = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param userId the user ID
	* @return the number of matching analysis users
	*/
	public int countByA_U(long analysisEntryId, long userId);

	/**
	* Returns all the analysis users where analysisEntryId = &#63; and voted = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @return the matching analysis users
	*/
	public java.util.List<AnalysisUser> findByVoted(long analysisEntryId,
		int voted);

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
	public java.util.List<AnalysisUser> findByVoted(long analysisEntryId,
		int voted, int start, int end);

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
	public java.util.List<AnalysisUser> findByVoted(long analysisEntryId,
		int voted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

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
	public java.util.List<AnalysisUser> findByVoted(long analysisEntryId,
		int voted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first analysis user in the ordered set where analysisEntryId = &#63; and voted = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public AnalysisUser findByVoted_First(long analysisEntryId, int voted,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException;

	/**
	* Returns the first analysis user in the ordered set where analysisEntryId = &#63; and voted = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public AnalysisUser fetchByVoted_First(long analysisEntryId, int voted,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

	/**
	* Returns the last analysis user in the ordered set where analysisEntryId = &#63; and voted = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user
	* @throws NoSuchUserException if a matching analysis user could not be found
	*/
	public AnalysisUser findByVoted_Last(long analysisEntryId, int voted,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException;

	/**
	* Returns the last analysis user in the ordered set where analysisEntryId = &#63; and voted = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching analysis user, or <code>null</code> if a matching analysis user could not be found
	*/
	public AnalysisUser fetchByVoted_Last(long analysisEntryId, int voted,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

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
	public AnalysisUser[] findByVoted_PrevAndNext(long analysisUserId,
		long analysisEntryId, int voted,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException;

	/**
	* Removes all the analysis users where analysisEntryId = &#63; and voted = &#63; from the database.
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	*/
	public void removeByVoted(long analysisEntryId, int voted);

	/**
	* Returns the number of analysis users where analysisEntryId = &#63; and voted = &#63;.
	*
	* @param analysisEntryId the analysis entry ID
	* @param voted the voted
	* @return the number of matching analysis users
	*/
	public int countByVoted(long analysisEntryId, int voted);

	/**
	* Caches the analysis user in the entity cache if it is enabled.
	*
	* @param analysisUser the analysis user
	*/
	public void cacheResult(AnalysisUser analysisUser);

	/**
	* Caches the analysis users in the entity cache if it is enabled.
	*
	* @param analysisUsers the analysis users
	*/
	public void cacheResult(java.util.List<AnalysisUser> analysisUsers);

	/**
	* Creates a new analysis user with the primary key. Does not add the analysis user to the database.
	*
	* @param analysisUserId the primary key for the new analysis user
	* @return the new analysis user
	*/
	public AnalysisUser create(long analysisUserId);

	/**
	* Removes the analysis user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analysisUserId the primary key of the analysis user
	* @return the analysis user that was removed
	* @throws NoSuchUserException if a analysis user with the primary key could not be found
	*/
	public AnalysisUser remove(long analysisUserId) throws NoSuchUserException;

	public AnalysisUser updateImpl(AnalysisUser analysisUser);

	/**
	* Returns the analysis user with the primary key or throws a {@link NoSuchUserException} if it could not be found.
	*
	* @param analysisUserId the primary key of the analysis user
	* @return the analysis user
	* @throws NoSuchUserException if a analysis user with the primary key could not be found
	*/
	public AnalysisUser findByPrimaryKey(long analysisUserId)
		throws NoSuchUserException;

	/**
	* Returns the analysis user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param analysisUserId the primary key of the analysis user
	* @return the analysis user, or <code>null</code> if a analysis user with the primary key could not be found
	*/
	public AnalysisUser fetchByPrimaryKey(long analysisUserId);

	@Override
	public java.util.Map<java.io.Serializable, AnalysisUser> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the analysis users.
	*
	* @return the analysis users
	*/
	public java.util.List<AnalysisUser> findAll();

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
	public java.util.List<AnalysisUser> findAll(int start, int end);

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
	public java.util.List<AnalysisUser> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator);

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
	public java.util.List<AnalysisUser> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the analysis users from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of analysis users.
	*
	* @return the number of analysis users
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}