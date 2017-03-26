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

import com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException;
import com.liferay.micro.maintainance.candidate.model.CandidateEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

/**
 * The persistence interface for the candidate entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.micro.maintainance.candidate.service.persistence.impl.CandidateEntryPersistenceImpl
 * @see CandidateEntryUtil
 * @generated
 */
@ProviderType
public interface CandidateEntryPersistence extends BasePersistence<CandidateEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CandidateEntryUtil} to access the candidate entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the candidate entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching candidate entries
	*/
	public java.util.List<CandidateEntry> findByUuid(java.lang.String uuid);

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
	public java.util.List<CandidateEntry> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<CandidateEntry> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public java.util.List<CandidateEntry> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first candidate entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

	/**
	* Returns the last candidate entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last candidate entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

	/**
	* Returns the candidate entries before and after the current candidate entry in the ordered set where uuid = &#63;.
	*
	* @param candidateEntryId the primary key of the current candidate entry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate entry
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public CandidateEntry[] findByUuid_PrevAndNext(long candidateEntryId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the candidate entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of candidate entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching candidate entries
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the candidate entry where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchEntryException;

	/**
	* Returns the candidate entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the candidate entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the candidate entry where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the candidate entry that was removed
	*/
	public CandidateEntry removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchEntryException;

	/**
	* Returns the number of candidate entries where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching candidate entries
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the candidate entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching candidate entries
	*/
	public java.util.List<CandidateEntry> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<CandidateEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<CandidateEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public java.util.List<CandidateEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first candidate entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

	/**
	* Returns the last candidate entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last candidate entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public CandidateEntry[] findByUuid_C_PrevAndNext(long candidateEntryId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the candidate entries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of candidate entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching candidate entries
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the candidate entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching candidate entries
	*/
	public java.util.List<CandidateEntry> findByGroupId(long groupId);

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
	public java.util.List<CandidateEntry> findByGroupId(long groupId,
		int start, int end);

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
	public java.util.List<CandidateEntry> findByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public java.util.List<CandidateEntry> findByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first candidate entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

	/**
	* Returns the last candidate entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last candidate entry in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

	/**
	* Returns the candidate entries before and after the current candidate entry in the ordered set where groupId = &#63;.
	*
	* @param candidateEntryId the primary key of the current candidate entry
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate entry
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public CandidateEntry[] findByGroupId_PrevAndNext(long candidateEntryId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the candidate entries where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of candidate entries where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching candidate entries
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the candidate entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching candidate entries
	*/
	public java.util.List<CandidateEntry> findByCompanyId(long companyId);

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
	public java.util.List<CandidateEntry> findByCompanyId(long companyId,
		int start, int end);

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
	public java.util.List<CandidateEntry> findByCompanyId(long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public java.util.List<CandidateEntry> findByCompanyId(long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first candidate entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

	/**
	* Returns the last candidate entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last candidate entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

	/**
	* Returns the candidate entries before and after the current candidate entry in the ordered set where companyId = &#63;.
	*
	* @param candidateEntryId the primary key of the current candidate entry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate entry
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public CandidateEntry[] findByCompanyId_PrevAndNext(long candidateEntryId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the candidate entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public void removeByCompanyId(long companyId);

	/**
	* Returns the number of candidate entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching candidate entries
	*/
	public int countByCompanyId(long companyId);

	/**
	* Returns all the candidate entries where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the matching candidate entries
	*/
	public java.util.List<CandidateEntry> findByC_ctD(long companyId,
		Date createDate);

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
	public java.util.List<CandidateEntry> findByC_ctD(long companyId,
		Date createDate, int start, int end);

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
	public java.util.List<CandidateEntry> findByC_ctD(long companyId,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public java.util.List<CandidateEntry> findByC_ctD(long companyId,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate entry in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByC_ctD_First(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first candidate entry in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByC_ctD_First(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

	/**
	* Returns the last candidate entry in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByC_ctD_Last(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last candidate entry in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByC_ctD_Last(long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public CandidateEntry[] findByC_ctD_PrevAndNext(long candidateEntryId,
		long companyId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the candidate entries where companyId = &#63; and createDate &lt; &#63; from the database.
	*
	* @param companyId the company ID
	* @param createDate the create date
	*/
	public void removeByC_ctD(long companyId, Date createDate);

	/**
	* Returns the number of candidate entries where companyId = &#63; and createDate &lt; &#63;.
	*
	* @param companyId the company ID
	* @param createDate the create date
	* @return the number of matching candidate entries
	*/
	public int countByC_ctD(long companyId, Date createDate);

	/**
	* Returns all the candidate entries where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching candidate entries
	*/
	public java.util.List<CandidateEntry> findByC_U(long companyId, long userId);

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
	public java.util.List<CandidateEntry> findByC_U(long companyId,
		long userId, int start, int end);

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
	public java.util.List<CandidateEntry> findByC_U(long companyId,
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public java.util.List<CandidateEntry> findByC_U(long companyId,
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByC_U_First(long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first candidate entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByC_U_First(long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

	/**
	* Returns the last candidate entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByC_U_Last(long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last candidate entry in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByC_U_Last(long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public CandidateEntry[] findByC_U_PrevAndNext(long candidateEntryId,
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the candidate entries where companyId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userId the user ID
	*/
	public void removeByC_U(long companyId, long userId);

	/**
	* Returns the number of candidate entries where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the number of matching candidate entries
	*/
	public int countByC_U(long companyId, long userId);

	/**
	* Returns the candidate entry where groupId = &#63; and wikiPageId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param groupId the group ID
	* @param wikiPageId the wiki page ID
	* @return the matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByG_P(long groupId, long wikiPageId)
		throws NoSuchEntryException;

	/**
	* Returns the candidate entry where groupId = &#63; and wikiPageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param wikiPageId the wiki page ID
	* @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByG_P(long groupId, long wikiPageId);

	/**
	* Returns the candidate entry where groupId = &#63; and wikiPageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param wikiPageId the wiki page ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByG_P(long groupId, long wikiPageId,
		boolean retrieveFromCache);

	/**
	* Removes the candidate entry where groupId = &#63; and wikiPageId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param wikiPageId the wiki page ID
	* @return the candidate entry that was removed
	*/
	public CandidateEntry removeByG_P(long groupId, long wikiPageId)
		throws NoSuchEntryException;

	/**
	* Returns the number of candidate entries where groupId = &#63; and wikiPageId = &#63;.
	*
	* @param groupId the group ID
	* @param wikiPageId the wiki page ID
	* @return the number of matching candidate entries
	*/
	public int countByG_P(long groupId, long wikiPageId);

	/**
	* Returns all the candidate entries where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @return the matching candidate entries
	*/
	public java.util.List<CandidateEntry> findByG_U_P(long groupId,
		long userId, long wikiPageId);

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
	public java.util.List<CandidateEntry> findByG_U_P(long groupId,
		long userId, long wikiPageId, int start, int end);

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
	public java.util.List<CandidateEntry> findByG_U_P(long groupId,
		long userId, long wikiPageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public java.util.List<CandidateEntry> findByG_U_P(long groupId,
		long userId, long wikiPageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache);

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
	public CandidateEntry findByG_U_P_First(long groupId, long userId,
		long wikiPageId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first candidate entry in the ordered set where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByG_U_P_First(long groupId, long userId,
		long wikiPageId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public CandidateEntry findByG_U_P_Last(long groupId, long userId,
		long wikiPageId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last candidate entry in the ordered set where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByG_U_P_Last(long groupId, long userId,
		long wikiPageId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public CandidateEntry[] findByG_U_P_PrevAndNext(long candidateEntryId,
		long groupId, long userId, long wikiPageId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the candidate entries where groupId = &#63; and userId = &#63; and wikiPageId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	*/
	public void removeByG_U_P(long groupId, long userId, long wikiPageId);

	/**
	* Returns the number of candidate entries where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @return the number of matching candidate entries
	*/
	public int countByG_U_P(long groupId, long userId, long wikiPageId);

	/**
	* Returns all the candidate entries where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @return the matching candidate entries
	*/
	public java.util.List<CandidateEntry> findByU_cD(long userId,
		Date createDate);

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
	public java.util.List<CandidateEntry> findByU_cD(long userId,
		Date createDate, int start, int end);

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
	public java.util.List<CandidateEntry> findByU_cD(long userId,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public java.util.List<CandidateEntry> findByU_cD(long userId,
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByU_cD_First(long userId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first candidate entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByU_cD_First(long userId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

	/**
	* Returns the last candidate entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByU_cD_Last(long userId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last candidate entry in the ordered set where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByU_cD_Last(long userId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public CandidateEntry[] findByU_cD_PrevAndNext(long candidateEntryId,
		long userId, Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the candidate entries where userId = &#63; and createDate = &#63; from the database.
	*
	* @param userId the user ID
	* @param createDate the create date
	*/
	public void removeByU_cD(long userId, Date createDate);

	/**
	* Returns the number of candidate entries where userId = &#63; and createDate = &#63;.
	*
	* @param userId the user ID
	* @param createDate the create date
	* @return the number of matching candidate entries
	*/
	public int countByU_cD(long userId, Date createDate);

	/**
	* Returns all the candidate entries where userId = &#63; and wikiPageId = &#63;.
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @return the matching candidate entries
	*/
	public java.util.List<CandidateEntry> findByU_P(long userId, long wikiPageId);

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
	public java.util.List<CandidateEntry> findByU_P(long userId,
		long wikiPageId, int start, int end);

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
	public java.util.List<CandidateEntry> findByU_P(long userId,
		long wikiPageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public java.util.List<CandidateEntry> findByU_P(long userId,
		long wikiPageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate entry in the ordered set where userId = &#63; and wikiPageId = &#63;.
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByU_P_First(long userId, long wikiPageId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first candidate entry in the ordered set where userId = &#63; and wikiPageId = &#63;.
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByU_P_First(long userId, long wikiPageId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

	/**
	* Returns the last candidate entry in the ordered set where userId = &#63; and wikiPageId = &#63;.
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByU_P_Last(long userId, long wikiPageId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last candidate entry in the ordered set where userId = &#63; and wikiPageId = &#63;.
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByU_P_Last(long userId, long wikiPageId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public CandidateEntry[] findByU_P_PrevAndNext(long candidateEntryId,
		long userId, long wikiPageId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the candidate entries where userId = &#63; and wikiPageId = &#63; from the database.
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	*/
	public void removeByU_P(long userId, long wikiPageId);

	/**
	* Returns the number of candidate entries where userId = &#63; and wikiPageId = &#63;.
	*
	* @param userId the user ID
	* @param wikiPageId the wiki page ID
	* @return the number of matching candidate entries
	*/
	public int countByU_P(long userId, long wikiPageId);

	/**
	* Returns the candidate entry where wikiPageId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param wikiPageId the wiki page ID
	* @return the matching candidate entry
	* @throws NoSuchEntryException if a matching candidate entry could not be found
	*/
	public CandidateEntry findByWikiPageId(long wikiPageId)
		throws NoSuchEntryException;

	/**
	* Returns the candidate entry where wikiPageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param wikiPageId the wiki page ID
	* @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByWikiPageId(long wikiPageId);

	/**
	* Returns the candidate entry where wikiPageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param wikiPageId the wiki page ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	*/
	public CandidateEntry fetchByWikiPageId(long wikiPageId,
		boolean retrieveFromCache);

	/**
	* Removes the candidate entry where wikiPageId = &#63; from the database.
	*
	* @param wikiPageId the wiki page ID
	* @return the candidate entry that was removed
	*/
	public CandidateEntry removeByWikiPageId(long wikiPageId)
		throws NoSuchEntryException;

	/**
	* Returns the number of candidate entries where wikiPageId = &#63;.
	*
	* @param wikiPageId the wiki page ID
	* @return the number of matching candidate entries
	*/
	public int countByWikiPageId(long wikiPageId);

	/**
	* Caches the candidate entry in the entity cache if it is enabled.
	*
	* @param candidateEntry the candidate entry
	*/
	public void cacheResult(CandidateEntry candidateEntry);

	/**
	* Caches the candidate entries in the entity cache if it is enabled.
	*
	* @param candidateEntries the candidate entries
	*/
	public void cacheResult(java.util.List<CandidateEntry> candidateEntries);

	/**
	* Creates a new candidate entry with the primary key. Does not add the candidate entry to the database.
	*
	* @param candidateEntryId the primary key for the new candidate entry
	* @return the new candidate entry
	*/
	public CandidateEntry create(long candidateEntryId);

	/**
	* Removes the candidate entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateEntryId the primary key of the candidate entry
	* @return the candidate entry that was removed
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public CandidateEntry remove(long candidateEntryId)
		throws NoSuchEntryException;

	public CandidateEntry updateImpl(CandidateEntry candidateEntry);

	/**
	* Returns the candidate entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param candidateEntryId the primary key of the candidate entry
	* @return the candidate entry
	* @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	*/
	public CandidateEntry findByPrimaryKey(long candidateEntryId)
		throws NoSuchEntryException;

	/**
	* Returns the candidate entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param candidateEntryId the primary key of the candidate entry
	* @return the candidate entry, or <code>null</code> if a candidate entry with the primary key could not be found
	*/
	public CandidateEntry fetchByPrimaryKey(long candidateEntryId);

	@Override
	public java.util.Map<java.io.Serializable, CandidateEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the candidate entries.
	*
	* @return the candidate entries
	*/
	public java.util.List<CandidateEntry> findAll();

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
	public java.util.List<CandidateEntry> findAll(int start, int end);

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
	public java.util.List<CandidateEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator);

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
	public java.util.List<CandidateEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the candidate entries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of candidate entries.
	*
	* @return the number of candidate entries
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}