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

import com.liferay.micro.maintainance.task.exception.NoSuchEntryException;
import com.liferay.micro.maintainance.task.model.TaskEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the task entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.micro.maintainance.task.service.persistence.impl.TaskEntryPersistenceImpl
 * @see TaskEntryUtil
 * @generated
 */
@ProviderType
public interface TaskEntryPersistence extends BasePersistence<TaskEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskEntryUtil} to access the task entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the task entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching task entries
	*/
	public java.util.List<TaskEntry> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the task entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of task entries
	* @param end the upper bound of the range of task entries (not inclusive)
	* @return the range of matching task entries
	*/
	public java.util.List<TaskEntry> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the task entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of task entries
	* @param end the upper bound of the range of task entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching task entries
	*/
	public java.util.List<TaskEntry> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskEntry> orderByComparator);

	/**
	* Returns an ordered range of all the task entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of task entries
	* @param end the upper bound of the range of task entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching task entries
	*/
	public java.util.List<TaskEntry> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first task entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching task entry
	* @throws NoSuchEntryException if a matching task entry could not be found
	*/
	public TaskEntry findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TaskEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the first task entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public TaskEntry fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TaskEntry> orderByComparator);

	/**
	* Returns the last task entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching task entry
	* @throws NoSuchEntryException if a matching task entry could not be found
	*/
	public TaskEntry findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TaskEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Returns the last task entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public TaskEntry fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TaskEntry> orderByComparator);

	/**
	* Returns the task entries before and after the current task entry in the ordered set where uuid = &#63;.
	*
	* @param taskEntryId the primary key of the current task entry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next task entry
	* @throws NoSuchEntryException if a task entry with the primary key could not be found
	*/
	public TaskEntry[] findByUuid_PrevAndNext(long taskEntryId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TaskEntry> orderByComparator)
		throws NoSuchEntryException;

	/**
	* Removes all the task entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of task entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching task entries
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the task entry where taskEntryId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param taskEntryId the task entry ID
	* @return the matching task entry
	* @throws NoSuchEntryException if a matching task entry could not be found
	*/
	public TaskEntry findByTasksById(long taskEntryId)
		throws NoSuchEntryException;

	/**
	* Returns the task entry where taskEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param taskEntryId the task entry ID
	* @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public TaskEntry fetchByTasksById(long taskEntryId);

	/**
	* Returns the task entry where taskEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param taskEntryId the task entry ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public TaskEntry fetchByTasksById(long taskEntryId,
		boolean retrieveFromCache);

	/**
	* Removes the task entry where taskEntryId = &#63; from the database.
	*
	* @param taskEntryId the task entry ID
	* @return the task entry that was removed
	*/
	public TaskEntry removeByTasksById(long taskEntryId)
		throws NoSuchEntryException;

	/**
	* Returns the number of task entries where taskEntryId = &#63;.
	*
	* @param taskEntryId the task entry ID
	* @return the number of matching task entries
	*/
	public int countByTasksById(long taskEntryId);

	/**
	* Returns the task entry where taskEntryName = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param taskEntryName the task entry name
	* @return the matching task entry
	* @throws NoSuchEntryException if a matching task entry could not be found
	*/
	public TaskEntry findByTasksByName(java.lang.String taskEntryName)
		throws NoSuchEntryException;

	/**
	* Returns the task entry where taskEntryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param taskEntryName the task entry name
	* @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public TaskEntry fetchByTasksByName(java.lang.String taskEntryName);

	/**
	* Returns the task entry where taskEntryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param taskEntryName the task entry name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	*/
	public TaskEntry fetchByTasksByName(java.lang.String taskEntryName,
		boolean retrieveFromCache);

	/**
	* Removes the task entry where taskEntryName = &#63; from the database.
	*
	* @param taskEntryName the task entry name
	* @return the task entry that was removed
	*/
	public TaskEntry removeByTasksByName(java.lang.String taskEntryName)
		throws NoSuchEntryException;

	/**
	* Returns the number of task entries where taskEntryName = &#63;.
	*
	* @param taskEntryName the task entry name
	* @return the number of matching task entries
	*/
	public int countByTasksByName(java.lang.String taskEntryName);

	/**
	* Caches the task entry in the entity cache if it is enabled.
	*
	* @param taskEntry the task entry
	*/
	public void cacheResult(TaskEntry taskEntry);

	/**
	* Caches the task entries in the entity cache if it is enabled.
	*
	* @param taskEntries the task entries
	*/
	public void cacheResult(java.util.List<TaskEntry> taskEntries);

	/**
	* Creates a new task entry with the primary key. Does not add the task entry to the database.
	*
	* @param taskEntryId the primary key for the new task entry
	* @return the new task entry
	*/
	public TaskEntry create(long taskEntryId);

	/**
	* Removes the task entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskEntryId the primary key of the task entry
	* @return the task entry that was removed
	* @throws NoSuchEntryException if a task entry with the primary key could not be found
	*/
	public TaskEntry remove(long taskEntryId) throws NoSuchEntryException;

	public TaskEntry updateImpl(TaskEntry taskEntry);

	/**
	* Returns the task entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	*
	* @param taskEntryId the primary key of the task entry
	* @return the task entry
	* @throws NoSuchEntryException if a task entry with the primary key could not be found
	*/
	public TaskEntry findByPrimaryKey(long taskEntryId)
		throws NoSuchEntryException;

	/**
	* Returns the task entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskEntryId the primary key of the task entry
	* @return the task entry, or <code>null</code> if a task entry with the primary key could not be found
	*/
	public TaskEntry fetchByPrimaryKey(long taskEntryId);

	@Override
	public java.util.Map<java.io.Serializable, TaskEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the task entries.
	*
	* @return the task entries
	*/
	public java.util.List<TaskEntry> findAll();

	/**
	* Returns a range of all the task entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task entries
	* @param end the upper bound of the range of task entries (not inclusive)
	* @return the range of task entries
	*/
	public java.util.List<TaskEntry> findAll(int start, int end);

	/**
	* Returns an ordered range of all the task entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task entries
	* @param end the upper bound of the range of task entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of task entries
	*/
	public java.util.List<TaskEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskEntry> orderByComparator);

	/**
	* Returns an ordered range of all the task entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TaskEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task entries
	* @param end the upper bound of the range of task entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of task entries
	*/
	public java.util.List<TaskEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the task entries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of task entries.
	*
	* @return the number of task entries
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}