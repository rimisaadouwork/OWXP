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

package com.liferay.micro.maintainance.task.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.task.exception.NoSuchEntryException;
import com.liferay.micro.maintainance.task.model.TaskEntry;
import com.liferay.micro.maintainance.task.model.impl.TaskEntryImpl;
import com.liferay.micro.maintainance.task.model.impl.TaskEntryModelImpl;
import com.liferay.micro.maintainance.task.service.persistence.TaskEntryPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the task entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskEntryPersistence
 * @see com.liferay.micro.maintainance.task.service.persistence.TaskEntryUtil
 * @generated
 */
@ProviderType
public class TaskEntryPersistenceImpl extends BasePersistenceImpl<TaskEntry>
	implements TaskEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaskEntryUtil} to access the task entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaskEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
			TaskEntryModelImpl.FINDER_CACHE_ENABLED, TaskEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
			TaskEntryModelImpl.FINDER_CACHE_ENABLED, TaskEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
			TaskEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
			TaskEntryModelImpl.FINDER_CACHE_ENABLED, TaskEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
			TaskEntryModelImpl.FINDER_CACHE_ENABLED, TaskEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			TaskEntryModelImpl.UUID_COLUMN_BITMASK |
			TaskEntryModelImpl.TASKENTRYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
			TaskEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the task entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching task entries
	 */
	@Override
	public List<TaskEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<TaskEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<TaskEntry> findByUuid(String uuid, int start, int end,
		OrderByComparator<TaskEntry> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<TaskEntry> findByUuid(String uuid, int start, int end,
		OrderByComparator<TaskEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<TaskEntry> list = null;

		if (retrieveFromCache) {
			list = (List<TaskEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaskEntry taskEntry : list) {
					if (!Objects.equals(uuid, taskEntry.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TASKENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TaskEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<TaskEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaskEntry>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first task entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task entry
	 * @throws NoSuchEntryException if a matching task entry could not be found
	 */
	@Override
	public TaskEntry findByUuid_First(String uuid,
		OrderByComparator<TaskEntry> orderByComparator)
		throws NoSuchEntryException {
		TaskEntry taskEntry = fetchByUuid_First(uuid, orderByComparator);

		if (taskEntry != null) {
			return taskEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first task entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task entry, or <code>null</code> if a matching task entry could not be found
	 */
	@Override
	public TaskEntry fetchByUuid_First(String uuid,
		OrderByComparator<TaskEntry> orderByComparator) {
		List<TaskEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task entry
	 * @throws NoSuchEntryException if a matching task entry could not be found
	 */
	@Override
	public TaskEntry findByUuid_Last(String uuid,
		OrderByComparator<TaskEntry> orderByComparator)
		throws NoSuchEntryException {
		TaskEntry taskEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (taskEntry != null) {
			return taskEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last task entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task entry, or <code>null</code> if a matching task entry could not be found
	 */
	@Override
	public TaskEntry fetchByUuid_Last(String uuid,
		OrderByComparator<TaskEntry> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TaskEntry> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the task entries before and after the current task entry in the ordered set where uuid = &#63;.
	 *
	 * @param taskEntryId the primary key of the current task entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task entry
	 * @throws NoSuchEntryException if a task entry with the primary key could not be found
	 */
	@Override
	public TaskEntry[] findByUuid_PrevAndNext(long taskEntryId, String uuid,
		OrderByComparator<TaskEntry> orderByComparator)
		throws NoSuchEntryException {
		TaskEntry taskEntry = findByPrimaryKey(taskEntryId);

		Session session = null;

		try {
			session = openSession();

			TaskEntry[] array = new TaskEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(session, taskEntry, uuid,
					orderByComparator, true);

			array[1] = taskEntry;

			array[2] = getByUuid_PrevAndNext(session, taskEntry, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaskEntry getByUuid_PrevAndNext(Session session,
		TaskEntry taskEntry, String uuid,
		OrderByComparator<TaskEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TASKENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TaskEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(taskEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TaskEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the task entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TaskEntry taskEntry : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(taskEntry);
		}
	}

	/**
	 * Returns the number of task entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching task entries
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TASKENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "taskEntry.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "taskEntry.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(taskEntry.uuid IS NULL OR taskEntry.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_TASKSBYID = new FinderPath(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
			TaskEntryModelImpl.FINDER_CACHE_ENABLED, TaskEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTasksById",
			new String[] { Long.class.getName() },
			TaskEntryModelImpl.TASKENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TASKSBYID = new FinderPath(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
			TaskEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTasksById",
			new String[] { Long.class.getName() });

	/**
	 * Returns the task entry where taskEntryId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	 *
	 * @param taskEntryId the task entry ID
	 * @return the matching task entry
	 * @throws NoSuchEntryException if a matching task entry could not be found
	 */
	@Override
	public TaskEntry findByTasksById(long taskEntryId)
		throws NoSuchEntryException {
		TaskEntry taskEntry = fetchByTasksById(taskEntryId);

		if (taskEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taskEntryId=");
			msg.append(taskEntryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEntryException(msg.toString());
		}

		return taskEntry;
	}

	/**
	 * Returns the task entry where taskEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param taskEntryId the task entry ID
	 * @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	 */
	@Override
	public TaskEntry fetchByTasksById(long taskEntryId) {
		return fetchByTasksById(taskEntryId, true);
	}

	/**
	 * Returns the task entry where taskEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param taskEntryId the task entry ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	 */
	@Override
	public TaskEntry fetchByTasksById(long taskEntryId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { taskEntryId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TASKSBYID,
					finderArgs, this);
		}

		if (result instanceof TaskEntry) {
			TaskEntry taskEntry = (TaskEntry)result;

			if ((taskEntryId != taskEntry.getTaskEntryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TASKENTRY_WHERE);

			query.append(_FINDER_COLUMN_TASKSBYID_TASKENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taskEntryId);

				List<TaskEntry> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TASKSBYID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TaskEntryPersistenceImpl.fetchByTasksById(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TaskEntry taskEntry = list.get(0);

					result = taskEntry;

					cacheResult(taskEntry);

					if ((taskEntry.getTaskEntryId() != taskEntryId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_TASKSBYID,
							finderArgs, taskEntry);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TASKSBYID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TaskEntry)result;
		}
	}

	/**
	 * Removes the task entry where taskEntryId = &#63; from the database.
	 *
	 * @param taskEntryId the task entry ID
	 * @return the task entry that was removed
	 */
	@Override
	public TaskEntry removeByTasksById(long taskEntryId)
		throws NoSuchEntryException {
		TaskEntry taskEntry = findByTasksById(taskEntryId);

		return remove(taskEntry);
	}

	/**
	 * Returns the number of task entries where taskEntryId = &#63;.
	 *
	 * @param taskEntryId the task entry ID
	 * @return the number of matching task entries
	 */
	@Override
	public int countByTasksById(long taskEntryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TASKSBYID;

		Object[] finderArgs = new Object[] { taskEntryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TASKENTRY_WHERE);

			query.append(_FINDER_COLUMN_TASKSBYID_TASKENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taskEntryId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TASKSBYID_TASKENTRYID_2 = "taskEntry.taskEntryId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TASKSBYNAME = new FinderPath(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
			TaskEntryModelImpl.FINDER_CACHE_ENABLED, TaskEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTasksByName",
			new String[] { String.class.getName() },
			TaskEntryModelImpl.TASKENTRYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TASKSBYNAME = new FinderPath(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
			TaskEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTasksByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the task entry where taskEntryName = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	 *
	 * @param taskEntryName the task entry name
	 * @return the matching task entry
	 * @throws NoSuchEntryException if a matching task entry could not be found
	 */
	@Override
	public TaskEntry findByTasksByName(String taskEntryName)
		throws NoSuchEntryException {
		TaskEntry taskEntry = fetchByTasksByName(taskEntryName);

		if (taskEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taskEntryName=");
			msg.append(taskEntryName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEntryException(msg.toString());
		}

		return taskEntry;
	}

	/**
	 * Returns the task entry where taskEntryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param taskEntryName the task entry name
	 * @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	 */
	@Override
	public TaskEntry fetchByTasksByName(String taskEntryName) {
		return fetchByTasksByName(taskEntryName, true);
	}

	/**
	 * Returns the task entry where taskEntryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param taskEntryName the task entry name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching task entry, or <code>null</code> if a matching task entry could not be found
	 */
	@Override
	public TaskEntry fetchByTasksByName(String taskEntryName,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { taskEntryName };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TASKSBYNAME,
					finderArgs, this);
		}

		if (result instanceof TaskEntry) {
			TaskEntry taskEntry = (TaskEntry)result;

			if (!Objects.equals(taskEntryName, taskEntry.getTaskEntryName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TASKENTRY_WHERE);

			boolean bindTaskEntryName = false;

			if (taskEntryName == null) {
				query.append(_FINDER_COLUMN_TASKSBYNAME_TASKENTRYNAME_1);
			}
			else if (taskEntryName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TASKSBYNAME_TASKENTRYNAME_3);
			}
			else {
				bindTaskEntryName = true;

				query.append(_FINDER_COLUMN_TASKSBYNAME_TASKENTRYNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTaskEntryName) {
					qPos.add(taskEntryName);
				}

				List<TaskEntry> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TASKSBYNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TaskEntryPersistenceImpl.fetchByTasksByName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TaskEntry taskEntry = list.get(0);

					result = taskEntry;

					cacheResult(taskEntry);

					if ((taskEntry.getTaskEntryName() == null) ||
							!taskEntry.getTaskEntryName().equals(taskEntryName)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_TASKSBYNAME,
							finderArgs, taskEntry);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TASKSBYNAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TaskEntry)result;
		}
	}

	/**
	 * Removes the task entry where taskEntryName = &#63; from the database.
	 *
	 * @param taskEntryName the task entry name
	 * @return the task entry that was removed
	 */
	@Override
	public TaskEntry removeByTasksByName(String taskEntryName)
		throws NoSuchEntryException {
		TaskEntry taskEntry = findByTasksByName(taskEntryName);

		return remove(taskEntry);
	}

	/**
	 * Returns the number of task entries where taskEntryName = &#63;.
	 *
	 * @param taskEntryName the task entry name
	 * @return the number of matching task entries
	 */
	@Override
	public int countByTasksByName(String taskEntryName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TASKSBYNAME;

		Object[] finderArgs = new Object[] { taskEntryName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TASKENTRY_WHERE);

			boolean bindTaskEntryName = false;

			if (taskEntryName == null) {
				query.append(_FINDER_COLUMN_TASKSBYNAME_TASKENTRYNAME_1);
			}
			else if (taskEntryName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TASKSBYNAME_TASKENTRYNAME_3);
			}
			else {
				bindTaskEntryName = true;

				query.append(_FINDER_COLUMN_TASKSBYNAME_TASKENTRYNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTaskEntryName) {
					qPos.add(taskEntryName);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TASKSBYNAME_TASKENTRYNAME_1 = "taskEntry.taskEntryName IS NULL";
	private static final String _FINDER_COLUMN_TASKSBYNAME_TASKENTRYNAME_2 = "taskEntry.taskEntryName = ?";
	private static final String _FINDER_COLUMN_TASKSBYNAME_TASKENTRYNAME_3 = "(taskEntry.taskEntryName IS NULL OR taskEntry.taskEntryName = '')";

	public TaskEntryPersistenceImpl() {
		setModelClass(TaskEntry.class);
	}

	/**
	 * Caches the task entry in the entity cache if it is enabled.
	 *
	 * @param taskEntry the task entry
	 */
	@Override
	public void cacheResult(TaskEntry taskEntry) {
		entityCache.putResult(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
			TaskEntryImpl.class, taskEntry.getPrimaryKey(), taskEntry);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TASKSBYID,
			new Object[] { taskEntry.getTaskEntryId() }, taskEntry);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TASKSBYNAME,
			new Object[] { taskEntry.getTaskEntryName() }, taskEntry);

		taskEntry.resetOriginalValues();
	}

	/**
	 * Caches the task entries in the entity cache if it is enabled.
	 *
	 * @param taskEntries the task entries
	 */
	@Override
	public void cacheResult(List<TaskEntry> taskEntries) {
		for (TaskEntry taskEntry : taskEntries) {
			if (entityCache.getResult(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
						TaskEntryImpl.class, taskEntry.getPrimaryKey()) == null) {
				cacheResult(taskEntry);
			}
			else {
				taskEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all task entries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TaskEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the task entry.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaskEntry taskEntry) {
		entityCache.removeResult(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
			TaskEntryImpl.class, taskEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TaskEntryModelImpl)taskEntry);
	}

	@Override
	public void clearCache(List<TaskEntry> taskEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaskEntry taskEntry : taskEntries) {
			entityCache.removeResult(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
				TaskEntryImpl.class, taskEntry.getPrimaryKey());

			clearUniqueFindersCache((TaskEntryModelImpl)taskEntry);
		}
	}

	protected void cacheUniqueFindersCache(
		TaskEntryModelImpl taskEntryModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { taskEntryModelImpl.getTaskEntryId() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_TASKSBYID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_TASKSBYID, args,
				taskEntryModelImpl);

			args = new Object[] { taskEntryModelImpl.getTaskEntryName() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_TASKSBYNAME, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_TASKSBYNAME, args,
				taskEntryModelImpl);
		}
		else {
			if ((taskEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TASKSBYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { taskEntryModelImpl.getTaskEntryId() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_TASKSBYID, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_TASKSBYID, args,
					taskEntryModelImpl);
			}

			if ((taskEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TASKSBYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						taskEntryModelImpl.getTaskEntryName()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_TASKSBYNAME, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_TASKSBYNAME, args,
					taskEntryModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		TaskEntryModelImpl taskEntryModelImpl) {
		Object[] args = new Object[] { taskEntryModelImpl.getTaskEntryId() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_TASKSBYID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_TASKSBYID, args);

		if ((taskEntryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TASKSBYID.getColumnBitmask()) != 0) {
			args = new Object[] { taskEntryModelImpl.getOriginalTaskEntryId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TASKSBYID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TASKSBYID, args);
		}

		args = new Object[] { taskEntryModelImpl.getTaskEntryName() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_TASKSBYNAME, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_TASKSBYNAME, args);

		if ((taskEntryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TASKSBYNAME.getColumnBitmask()) != 0) {
			args = new Object[] { taskEntryModelImpl.getOriginalTaskEntryName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TASKSBYNAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TASKSBYNAME, args);
		}
	}

	/**
	 * Creates a new task entry with the primary key. Does not add the task entry to the database.
	 *
	 * @param taskEntryId the primary key for the new task entry
	 * @return the new task entry
	 */
	@Override
	public TaskEntry create(long taskEntryId) {
		TaskEntry taskEntry = new TaskEntryImpl();

		taskEntry.setNew(true);
		taskEntry.setPrimaryKey(taskEntryId);

		String uuid = PortalUUIDUtil.generate();

		taskEntry.setUuid(uuid);

		return taskEntry;
	}

	/**
	 * Removes the task entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskEntryId the primary key of the task entry
	 * @return the task entry that was removed
	 * @throws NoSuchEntryException if a task entry with the primary key could not be found
	 */
	@Override
	public TaskEntry remove(long taskEntryId) throws NoSuchEntryException {
		return remove((Serializable)taskEntryId);
	}

	/**
	 * Removes the task entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the task entry
	 * @return the task entry that was removed
	 * @throws NoSuchEntryException if a task entry with the primary key could not be found
	 */
	@Override
	public TaskEntry remove(Serializable primaryKey)
		throws NoSuchEntryException {
		Session session = null;

		try {
			session = openSession();

			TaskEntry taskEntry = (TaskEntry)session.get(TaskEntryImpl.class,
					primaryKey);

			if (taskEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taskEntry);
		}
		catch (NoSuchEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TaskEntry removeImpl(TaskEntry taskEntry) {
		taskEntry = toUnwrappedModel(taskEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taskEntry)) {
				taskEntry = (TaskEntry)session.get(TaskEntryImpl.class,
						taskEntry.getPrimaryKeyObj());
			}

			if (taskEntry != null) {
				session.delete(taskEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taskEntry != null) {
			clearCache(taskEntry);
		}

		return taskEntry;
	}

	@Override
	public TaskEntry updateImpl(TaskEntry taskEntry) {
		taskEntry = toUnwrappedModel(taskEntry);

		boolean isNew = taskEntry.isNew();

		TaskEntryModelImpl taskEntryModelImpl = (TaskEntryModelImpl)taskEntry;

		if (Validator.isNull(taskEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			taskEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (taskEntry.isNew()) {
				session.save(taskEntry);

				taskEntry.setNew(false);
			}
			else {
				taskEntry = (TaskEntry)session.merge(taskEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TaskEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((taskEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						taskEntryModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { taskEntryModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
			TaskEntryImpl.class, taskEntry.getPrimaryKey(), taskEntry, false);

		clearUniqueFindersCache(taskEntryModelImpl);
		cacheUniqueFindersCache(taskEntryModelImpl, isNew);

		taskEntry.resetOriginalValues();

		return taskEntry;
	}

	protected TaskEntry toUnwrappedModel(TaskEntry taskEntry) {
		if (taskEntry instanceof TaskEntryImpl) {
			return taskEntry;
		}

		TaskEntryImpl taskEntryImpl = new TaskEntryImpl();

		taskEntryImpl.setNew(taskEntry.isNew());
		taskEntryImpl.setPrimaryKey(taskEntry.getPrimaryKey());

		taskEntryImpl.setUuid(taskEntry.getUuid());
		taskEntryImpl.setTaskEntryId(taskEntry.getTaskEntryId());
		taskEntryImpl.setCreateDate(taskEntry.getCreateDate());
		taskEntryImpl.setTaskEntryName(taskEntry.getTaskEntryName());

		return taskEntryImpl;
	}

	/**
	 * Returns the task entry with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the task entry
	 * @return the task entry
	 * @throws NoSuchEntryException if a task entry with the primary key could not be found
	 */
	@Override
	public TaskEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEntryException {
		TaskEntry taskEntry = fetchByPrimaryKey(primaryKey);

		if (taskEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return taskEntry;
	}

	/**
	 * Returns the task entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	 *
	 * @param taskEntryId the primary key of the task entry
	 * @return the task entry
	 * @throws NoSuchEntryException if a task entry with the primary key could not be found
	 */
	@Override
	public TaskEntry findByPrimaryKey(long taskEntryId)
		throws NoSuchEntryException {
		return findByPrimaryKey((Serializable)taskEntryId);
	}

	/**
	 * Returns the task entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the task entry
	 * @return the task entry, or <code>null</code> if a task entry with the primary key could not be found
	 */
	@Override
	public TaskEntry fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
				TaskEntryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TaskEntry taskEntry = (TaskEntry)serializable;

		if (taskEntry == null) {
			Session session = null;

			try {
				session = openSession();

				taskEntry = (TaskEntry)session.get(TaskEntryImpl.class,
						primaryKey);

				if (taskEntry != null) {
					cacheResult(taskEntry);
				}
				else {
					entityCache.putResult(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
						TaskEntryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
					TaskEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taskEntry;
	}

	/**
	 * Returns the task entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskEntryId the primary key of the task entry
	 * @return the task entry, or <code>null</code> if a task entry with the primary key could not be found
	 */
	@Override
	public TaskEntry fetchByPrimaryKey(long taskEntryId) {
		return fetchByPrimaryKey((Serializable)taskEntryId);
	}

	@Override
	public Map<Serializable, TaskEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TaskEntry> map = new HashMap<Serializable, TaskEntry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TaskEntry taskEntry = fetchByPrimaryKey(primaryKey);

			if (taskEntry != null) {
				map.put(primaryKey, taskEntry);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
					TaskEntryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TaskEntry)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TASKENTRY_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (TaskEntry taskEntry : (List<TaskEntry>)q.list()) {
				map.put(taskEntry.getPrimaryKeyObj(), taskEntry);

				cacheResult(taskEntry);

				uncachedPrimaryKeys.remove(taskEntry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TaskEntryModelImpl.ENTITY_CACHE_ENABLED,
					TaskEntryImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the task entries.
	 *
	 * @return the task entries
	 */
	@Override
	public List<TaskEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<TaskEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<TaskEntry> findAll(int start, int end,
		OrderByComparator<TaskEntry> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<TaskEntry> findAll(int start, int end,
		OrderByComparator<TaskEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TaskEntry> list = null;

		if (retrieveFromCache) {
			list = (List<TaskEntry>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TASKENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TASKENTRY;

				if (pagination) {
					sql = sql.concat(TaskEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaskEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaskEntry>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the task entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TaskEntry taskEntry : findAll()) {
			remove(taskEntry);
		}
	}

	/**
	 * Returns the number of task entries.
	 *
	 * @return the number of task entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TASKENTRY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TaskEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the task entry persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TaskEntryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TASKENTRY = "SELECT taskEntry FROM TaskEntry taskEntry";
	private static final String _SQL_SELECT_TASKENTRY_WHERE_PKS_IN = "SELECT taskEntry FROM TaskEntry taskEntry WHERE taskEntryId IN (";
	private static final String _SQL_SELECT_TASKENTRY_WHERE = "SELECT taskEntry FROM TaskEntry taskEntry WHERE ";
	private static final String _SQL_COUNT_TASKENTRY = "SELECT COUNT(taskEntry) FROM TaskEntry taskEntry";
	private static final String _SQL_COUNT_TASKENTRY_WHERE = "SELECT COUNT(taskEntry) FROM TaskEntry taskEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taskEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaskEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TaskEntry exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TaskEntryPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}