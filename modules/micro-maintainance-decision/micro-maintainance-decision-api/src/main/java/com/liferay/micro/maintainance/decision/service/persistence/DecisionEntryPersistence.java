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

import com.liferay.micro.maintainance.decision.exception.NoSuchEntryException;
import com.liferay.micro.maintainance.decision.model.DecisionEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the decision entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.micro.maintainance.decision.service.persistence.impl.DecisionEntryPersistenceImpl
 * @see DecisionEntryUtil
 * @generated
 */
@ProviderType
public interface DecisionEntryPersistence extends BasePersistence<DecisionEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DecisionEntryUtil} to access the decision entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the decision entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByUuid(java.lang.String uuid);

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
	public java.util.List<DecisionEntry> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<DecisionEntry> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where uuid = &#63;.
	*
	* @param decisionEntryId the primary key of the current decision entry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public DecisionEntry[] findByUuid_PrevAndNext(long decisionEntryId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the decision entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of decision entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching decision entries
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the decision entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public DecisionEntry[] findByUuid_C_PrevAndNext(long decisionEntryId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the decision entries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of decision entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the decision entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByCompanyId(long companyId);

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
	public java.util.List<DecisionEntry> findByCompanyId(long companyId,
		int start, int end);

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
	public java.util.List<DecisionEntry> findByCompanyId(long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByCompanyId(long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where companyId = &#63;.
	*
	* @param decisionEntryId the primary key of the current decision entry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public DecisionEntry[] findByCompanyId_PrevAndNext(long decisionEntryId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the decision entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public void removeByCompanyId(long companyId);

	/**
	* Returns the number of decision entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public int countByCompanyId(long companyId);

	/**
	* Returns all the decision entries where decisionEntryId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByDecisionEntryId(
		long decisionEntryId);

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
	public java.util.List<DecisionEntry> findByDecisionEntryId(
		long decisionEntryId, int start, int end);

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
	public java.util.List<DecisionEntry> findByDecisionEntryId(
		long decisionEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByDecisionEntryId(
		long decisionEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByDecisionEntryId_First(long decisionEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByDecisionEntryId_First(long decisionEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByDecisionEntryId_Last(long decisionEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByDecisionEntryId_Last(long decisionEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Removes all the decision entries where decisionEntryId = &#63; from the database.
	*
	* @param decisionEntryId the decision entry ID
	*/
	public void removeByDecisionEntryId(long decisionEntryId);

	/**
	* Returns the number of decision entries where decisionEntryId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @return the number of matching decision entries
	*/
	public int countByDecisionEntryId(long decisionEntryId);

	/**
	* Returns all the decision entries where outcome = &#63;.
	*
	* @param outcome the outcome
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByOutcome(java.lang.String outcome);

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
	public java.util.List<DecisionEntry> findByOutcome(
		java.lang.String outcome, int start, int end);

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
	public java.util.List<DecisionEntry> findByOutcome(
		java.lang.String outcome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByOutcome(
		java.lang.String outcome, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where outcome = &#63;.
	*
	* @param outcome the outcome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByOutcome_First(java.lang.String outcome,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where outcome = &#63;.
	*
	* @param outcome the outcome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByOutcome_First(java.lang.String outcome,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where outcome = &#63;.
	*
	* @param outcome the outcome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByOutcome_Last(java.lang.String outcome,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where outcome = &#63;.
	*
	* @param outcome the outcome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByOutcome_Last(java.lang.String outcome,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where outcome = &#63;.
	*
	* @param decisionEntryId the primary key of the current decision entry
	* @param outcome the outcome
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public DecisionEntry[] findByOutcome_PrevAndNext(long decisionEntryId,
		java.lang.String outcome,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the decision entries where outcome = &#63; from the database.
	*
	* @param outcome the outcome
	*/
	public void removeByOutcome(java.lang.String outcome);

	/**
	* Returns the number of decision entries where outcome = &#63;.
	*
	* @param outcome the outcome
	* @return the number of matching decision entries
	*/
	public int countByOutcome(java.lang.String outcome);

	/**
	* Returns all the decision entries where wikiPageId = &#63;.
	*
	* @param wikiPageId the wiki page ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByWikiPageId(long wikiPageId);

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
	public java.util.List<DecisionEntry> findByWikiPageId(long wikiPageId,
		int start, int end);

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
	public java.util.List<DecisionEntry> findByWikiPageId(long wikiPageId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByWikiPageId(long wikiPageId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where wikiPageId = &#63;.
	*
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByWikiPageId_First(long wikiPageId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where wikiPageId = &#63;.
	*
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByWikiPageId_First(long wikiPageId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where wikiPageId = &#63;.
	*
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByWikiPageId_Last(long wikiPageId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where wikiPageId = &#63;.
	*
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByWikiPageId_Last(long wikiPageId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where wikiPageId = &#63;.
	*
	* @param decisionEntryId the primary key of the current decision entry
	* @param wikiPageId the wiki page ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public DecisionEntry[] findByWikiPageId_PrevAndNext(long decisionEntryId,
		long wikiPageId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the decision entries where wikiPageId = &#63; from the database.
	*
	* @param wikiPageId the wiki page ID
	*/
	public void removeByWikiPageId(long wikiPageId);

	/**
	* Returns the number of decision entries where wikiPageId = &#63;.
	*
	* @param wikiPageId the wiki page ID
	* @return the number of matching decision entries
	*/
	public int countByWikiPageId(long wikiPageId);

	/**
	* Returns all the decision entries where wikiPageName = &#63;.
	*
	* @param wikiPageName the wiki page name
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByWikiPageName(
		java.lang.String wikiPageName);

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
	public java.util.List<DecisionEntry> findByWikiPageName(
		java.lang.String wikiPageName, int start, int end);

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
	public java.util.List<DecisionEntry> findByWikiPageName(
		java.lang.String wikiPageName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByWikiPageName(
		java.lang.String wikiPageName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where wikiPageName = &#63;.
	*
	* @param wikiPageName the wiki page name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByWikiPageName_First(
		java.lang.String wikiPageName,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where wikiPageName = &#63;.
	*
	* @param wikiPageName the wiki page name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByWikiPageName_First(
		java.lang.String wikiPageName,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where wikiPageName = &#63;.
	*
	* @param wikiPageName the wiki page name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByWikiPageName_Last(
		java.lang.String wikiPageName,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where wikiPageName = &#63;.
	*
	* @param wikiPageName the wiki page name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByWikiPageName_Last(
		java.lang.String wikiPageName,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the decision entries before and after the current decision entry in the ordered set where wikiPageName = &#63;.
	*
	* @param decisionEntryId the primary key of the current decision entry
	* @param wikiPageName the wiki page name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public DecisionEntry[] findByWikiPageName_PrevAndNext(
		long decisionEntryId, java.lang.String wikiPageName,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the decision entries where wikiPageName = &#63; from the database.
	*
	* @param wikiPageName the wiki page name
	*/
	public void removeByWikiPageName(java.lang.String wikiPageName);

	/**
	* Returns the number of decision entries where wikiPageName = &#63;.
	*
	* @param wikiPageName the wiki page name
	* @return the number of matching decision entries
	*/
	public int countByWikiPageName(java.lang.String wikiPageName);

	/**
	* Returns all the decision entries where companyId = &#63; and handled = &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByC_H(long companyId,
		boolean handled);

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
	public java.util.List<DecisionEntry> findByC_H(long companyId,
		boolean handled, int start, int end);

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
	public java.util.List<DecisionEntry> findByC_H(long companyId,
		boolean handled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByC_H(long companyId,
		boolean handled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63; and handled = &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByC_H_First(long companyId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where companyId = &#63; and handled = &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByC_H_First(long companyId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63; and handled = &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByC_H_Last(long companyId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where companyId = &#63; and handled = &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByC_H_Last(long companyId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public DecisionEntry[] findByC_H_PrevAndNext(long decisionEntryId,
		long companyId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the decision entries where companyId = &#63; and handled = &#63; from the database.
	*
	* @param companyId the company ID
	* @param handled the handled
	*/
	public void removeByC_H(long companyId, boolean handled);

	/**
	* Returns the number of decision entries where companyId = &#63; and handled = &#63;.
	*
	* @param companyId the company ID
	* @param handled the handled
	* @return the number of matching decision entries
	*/
	public int countByC_H(long companyId, boolean handled);

	/**
	* Returns all the decision entries where decisionEntryId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByD_C(long decisionEntryId,
		long companyId);

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
	public java.util.List<DecisionEntry> findByD_C(long decisionEntryId,
		long companyId, int start, int end);

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
	public java.util.List<DecisionEntry> findByD_C(long decisionEntryId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByD_C(long decisionEntryId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByD_C_First(long decisionEntryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_C_First(long decisionEntryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByD_C_Last(long decisionEntryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_C_Last(long decisionEntryId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Removes all the decision entries where decisionEntryId = &#63; and companyId = &#63; from the database.
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	*/
	public void removeByD_C(long decisionEntryId, long companyId);

	/**
	* Returns the number of decision entries where decisionEntryId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public int countByD_C(long decisionEntryId, long companyId);

	/**
	* Returns all the decision entries where decisionEntryId = &#63; and handled = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByD_H(long decisionEntryId,
		boolean handled);

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
	public java.util.List<DecisionEntry> findByD_H(long decisionEntryId,
		boolean handled, int start, int end);

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
	public java.util.List<DecisionEntry> findByD_H(long decisionEntryId,
		boolean handled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByD_H(long decisionEntryId,
		boolean handled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63; and handled = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByD_H_First(long decisionEntryId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63; and handled = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_H_First(long decisionEntryId,
		boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63; and handled = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByD_H_Last(long decisionEntryId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63; and handled = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_H_Last(long decisionEntryId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Removes all the decision entries where decisionEntryId = &#63; and handled = &#63; from the database.
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	*/
	public void removeByD_H(long decisionEntryId, boolean handled);

	/**
	* Returns the number of decision entries where decisionEntryId = &#63; and handled = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param handled the handled
	* @return the number of matching decision entries
	*/
	public int countByD_H(long decisionEntryId, boolean handled);

	/**
	* Returns all the decision entries where decisionEntryId = &#63; and userId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByD_U(long decisionEntryId,
		long userId);

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
	public java.util.List<DecisionEntry> findByD_U(long decisionEntryId,
		long userId, int start, int end);

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
	public java.util.List<DecisionEntry> findByD_U(long decisionEntryId,
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByD_U(long decisionEntryId,
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByD_U_First(long decisionEntryId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_U_First(long decisionEntryId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByD_U_Last(long decisionEntryId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_U_Last(long decisionEntryId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Removes all the decision entries where decisionEntryId = &#63; and userId = &#63; from the database.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	*/
	public void removeByD_U(long decisionEntryId, long userId);

	/**
	* Returns the number of decision entries where decisionEntryId = &#63; and userId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @return the number of matching decision entries
	*/
	public int countByD_U(long decisionEntryId, long userId);

	/**
	* Returns all the decision entries where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param companyId the company ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByD_U_C(long decisionEntryId,
		long userId, long companyId);

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
	public java.util.List<DecisionEntry> findByD_U_C(long decisionEntryId,
		long userId, long companyId, int start, int end);

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
	public java.util.List<DecisionEntry> findByD_U_C(long decisionEntryId,
		long userId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByD_U_C(long decisionEntryId,
		long userId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

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
	public DecisionEntry findByD_U_C_First(long decisionEntryId, long userId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_U_C_First(long decisionEntryId, long userId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public DecisionEntry findByD_U_C_Last(long decisionEntryId, long userId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByD_U_C_Last(long decisionEntryId, long userId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Removes all the decision entries where decisionEntryId = &#63; and userId = &#63; and companyId = &#63; from the database.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param companyId the company ID
	*/
	public void removeByD_U_C(long decisionEntryId, long userId, long companyId);

	/**
	* Returns the number of decision entries where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param decisionEntryId the decision entry ID
	* @param userId the user ID
	* @param companyId the company ID
	* @return the number of matching decision entries
	*/
	public int countByD_U_C(long decisionEntryId, long userId, long companyId);

	/**
	* Returns all the decision entries where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByU_H(long userId, boolean handled);

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
	public java.util.List<DecisionEntry> findByU_H(long userId,
		boolean handled, int start, int end);

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
	public java.util.List<DecisionEntry> findByU_H(long userId,
		boolean handled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByU_H(long userId,
		boolean handled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByU_H_First(long userId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByU_H_First(long userId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry
	* @throws NoSuchEntryException if a matching decision entry could not be found
	*/
	public DecisionEntry findByU_H_Last(long userId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByU_H_Last(long userId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public DecisionEntry[] findByU_H_PrevAndNext(long decisionEntryId,
		long userId, boolean handled,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the decision entries where userId = &#63; and handled = &#63; from the database.
	*
	* @param userId the user ID
	* @param handled the handled
	*/
	public void removeByU_H(long userId, boolean handled);

	/**
	* Returns the number of decision entries where userId = &#63; and handled = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @return the number of matching decision entries
	*/
	public int countByU_H(long userId, boolean handled);

	/**
	* Returns all the decision entries where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionEntryId the decision entry ID
	* @return the matching decision entries
	*/
	public java.util.List<DecisionEntry> findByU_H_D(long userId,
		boolean handled, long decisionEntryId);

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
	public java.util.List<DecisionEntry> findByU_H_D(long userId,
		boolean handled, long decisionEntryId, int start, int end);

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
	public java.util.List<DecisionEntry> findByU_H_D(long userId,
		boolean handled, long decisionEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findByU_H_D(long userId,
		boolean handled, long decisionEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

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
	public DecisionEntry findByU_H_D_First(long userId, boolean handled,
		long decisionEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionEntryId the decision entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByU_H_D_First(long userId, boolean handled,
		long decisionEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public DecisionEntry findByU_H_D_Last(long userId, boolean handled,
		long decisionEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionEntryId the decision entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	*/
	public DecisionEntry fetchByU_H_D_Last(long userId, boolean handled,
		long decisionEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

	/**
	* Removes all the decision entries where userId = &#63; and handled = &#63; and decisionEntryId = &#63; from the database.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionEntryId the decision entry ID
	*/
	public void removeByU_H_D(long userId, boolean handled, long decisionEntryId);

	/**
	* Returns the number of decision entries where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	*
	* @param userId the user ID
	* @param handled the handled
	* @param decisionEntryId the decision entry ID
	* @return the number of matching decision entries
	*/
	public int countByU_H_D(long userId, boolean handled, long decisionEntryId);

	/**
	* Caches the decision entry in the entity cache if it is enabled.
	*
	* @param decisionEntry the decision entry
	*/
	public void cacheResult(DecisionEntry decisionEntry);

	/**
	* Caches the decision entries in the entity cache if it is enabled.
	*
	* @param decisionEntries the decision entries
	*/
	public void cacheResult(java.util.List<DecisionEntry> decisionEntries);

	/**
	* Creates a new decision entry with the primary key. Does not add the decision entry to the database.
	*
	* @param decisionEntryId the primary key for the new decision entry
	* @return the new decision entry
	*/
	public DecisionEntry create(long decisionEntryId);

	/**
	* Removes the decision entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param decisionEntryId the primary key of the decision entry
	* @return the decision entry that was removed
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public DecisionEntry remove(long decisionEntryId)
		throws NoSuchEntryException;

	public DecisionEntry updateImpl(DecisionEntry decisionEntry);

	/**
	* Returns the decision entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param decisionEntryId the primary key of the decision entry
	* @return the decision entry
	* @throws NoSuchEntryException if a decision entry with the primary key could not be found
	*/
	public DecisionEntry findByPrimaryKey(long decisionEntryId)
		throws NoSuchEntryException;

	/**
	* Returns the decision entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param decisionEntryId the primary key of the decision entry
	* @return the decision entry, or <code>null</code> if a decision entry with the primary key could not be found
	*/
	public DecisionEntry fetchByPrimaryKey(long decisionEntryId);

	@Override
	public java.util.Map<java.io.Serializable, DecisionEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the decision entries.
	*
	* @return the decision entries
	*/
	public java.util.List<DecisionEntry> findAll();

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
	public java.util.List<DecisionEntry> findAll(int start, int end);

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
	public java.util.List<DecisionEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator);

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
	public java.util.List<DecisionEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the decision entries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of decision entries.
	*
	* @return the number of decision entries
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}