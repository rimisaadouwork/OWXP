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

package com.liferay.micro.maintainance.candidate.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException;
import com.liferay.micro.maintainance.candidate.model.CandidateEntry;
import com.liferay.micro.maintainance.candidate.model.impl.CandidateEntryImpl;
import com.liferay.micro.maintainance.candidate.model.impl.CandidateEntryModelImpl;
import com.liferay.micro.maintainance.candidate.service.persistence.CandidateEntryPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the candidate entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateEntryPersistence
 * @see com.liferay.micro.maintainance.candidate.service.persistence.CandidateEntryUtil
 * @generated
 */
@ProviderType
public class CandidateEntryPersistenceImpl extends BasePersistenceImpl<CandidateEntry>
	implements CandidateEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CandidateEntryUtil} to access the candidate entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CandidateEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			CandidateEntryModelImpl.UUID_COLUMN_BITMASK |
			CandidateEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the candidate entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching candidate entries
	 */
	@Override
	public List<CandidateEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CandidateEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CandidateEntry> findByUuid(String uuid, int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<CandidateEntry> findByUuid(String uuid, int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
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

		List<CandidateEntry> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateEntry candidateEntry : list) {
					if (!Objects.equals(uuid, candidateEntry.getUuid())) {
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

			query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

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
				query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
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
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first candidate entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry
	 * @throws NoSuchEntryException if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry findByUuid_First(String uuid,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByUuid_First(uuid,
				orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first candidate entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByUuid_First(String uuid,
		OrderByComparator<CandidateEntry> orderByComparator) {
		List<CandidateEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate entry
	 * @throws NoSuchEntryException if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry findByUuid_Last(String uuid,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last candidate entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByUuid_Last(String uuid,
		OrderByComparator<CandidateEntry> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CandidateEntry> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CandidateEntry[] findByUuid_PrevAndNext(long candidateEntryId,
		String uuid, OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = findByPrimaryKey(candidateEntryId);

		Session session = null;

		try {
			session = openSession();

			CandidateEntry[] array = new CandidateEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(session, candidateEntry, uuid,
					orderByComparator, true);

			array[1] = candidateEntry;

			array[2] = getByUuid_PrevAndNext(session, candidateEntry, uuid,
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

	protected CandidateEntry getByUuid_PrevAndNext(Session session,
		CandidateEntry candidateEntry, String uuid,
		OrderByComparator<CandidateEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

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
			query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(candidateEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CandidateEntry candidateEntry : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidateEntry);
		}
	}

	/**
	 * Returns the number of candidate entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching candidate entries
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANDIDATEENTRY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "candidateEntry.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "candidateEntry.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(candidateEntry.uuid IS NULL OR candidateEntry.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			CandidateEntryModelImpl.UUID_COLUMN_BITMASK |
			CandidateEntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the candidate entry where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching candidate entry
	 * @throws NoSuchEntryException if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByUUID_G(uuid, groupId);

		if (candidateEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEntryException(msg.toString());
		}

		return candidateEntry;
	}

	/**
	 * Returns the candidate entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the candidate entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof CandidateEntry) {
			CandidateEntry candidateEntry = (CandidateEntry)result;

			if (!Objects.equals(uuid, candidateEntry.getUuid()) ||
					(groupId != candidateEntry.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<CandidateEntry> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					CandidateEntry candidateEntry = list.get(0);

					result = candidateEntry;

					cacheResult(candidateEntry);

					if ((candidateEntry.getUuid() == null) ||
							!candidateEntry.getUuid().equals(uuid) ||
							(candidateEntry.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, candidateEntry);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

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
			return (CandidateEntry)result;
		}
	}

	/**
	 * Removes the candidate entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the candidate entry that was removed
	 */
	@Override
	public CandidateEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = findByUUID_G(uuid, groupId);

		return remove(candidateEntry);
	}

	/**
	 * Returns the number of candidate entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching candidate entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CANDIDATEENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "candidateEntry.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "candidateEntry.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(candidateEntry.uuid IS NULL OR candidateEntry.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "candidateEntry.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			CandidateEntryModelImpl.UUID_COLUMN_BITMASK |
			CandidateEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			CandidateEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the candidate entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching candidate entries
	 */
	@Override
	public List<CandidateEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CandidateEntry> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<CandidateEntry> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<CandidateEntry> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<CandidateEntry> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<CandidateEntry> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateEntry candidateEntry : list) {
					if (!Objects.equals(uuid, candidateEntry.getUuid()) ||
							(companyId != candidateEntry.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
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

				qPos.add(companyId);

				if (!pagination) {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first candidate entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry
	 * @throws NoSuchEntryException if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first candidate entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		List<CandidateEntry> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CandidateEntry findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last candidate entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CandidateEntry> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CandidateEntry[] findByUuid_C_PrevAndNext(long candidateEntryId,
		String uuid, long companyId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = findByPrimaryKey(candidateEntryId);

		Session session = null;

		try {
			session = openSession();

			CandidateEntry[] array = new CandidateEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, candidateEntry, uuid,
					companyId, orderByComparator, true);

			array[1] = candidateEntry;

			array[2] = getByUuid_C_PrevAndNext(session, candidateEntry, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateEntry getByUuid_C_PrevAndNext(Session session,
		CandidateEntry candidateEntry, String uuid, long companyId,
		OrderByComparator<CandidateEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidateEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CandidateEntry candidateEntry : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidateEntry);
		}
	}

	/**
	 * Returns the number of candidate entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching candidate entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CANDIDATEENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "candidateEntry.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "candidateEntry.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(candidateEntry.uuid IS NULL OR candidateEntry.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "candidateEntry.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			CandidateEntryModelImpl.GROUPID_COLUMN_BITMASK |
			CandidateEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the candidate entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching candidate entries
	 */
	@Override
	public List<CandidateEntry> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CandidateEntry> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<CandidateEntry> findByGroupId(long groupId, int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<CandidateEntry> findByGroupId(long groupId, int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<CandidateEntry> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateEntry candidateEntry : list) {
					if ((groupId != candidateEntry.getGroupId())) {
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

			query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first candidate entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry
	 * @throws NoSuchEntryException if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry findByGroupId_First(long groupId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByGroupId_First(groupId,
				orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first candidate entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByGroupId_First(long groupId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		List<CandidateEntry> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate entry
	 * @throws NoSuchEntryException if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry findByGroupId_Last(long groupId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last candidate entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByGroupId_Last(long groupId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<CandidateEntry> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CandidateEntry[] findByGroupId_PrevAndNext(long candidateEntryId,
		long groupId, OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = findByPrimaryKey(candidateEntryId);

		Session session = null;

		try {
			session = openSession();

			CandidateEntry[] array = new CandidateEntryImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, candidateEntry,
					groupId, orderByComparator, true);

			array[1] = candidateEntry;

			array[2] = getByGroupId_PrevAndNext(session, candidateEntry,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateEntry getByGroupId_PrevAndNext(Session session,
		CandidateEntry candidateEntry, long groupId,
		OrderByComparator<CandidateEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidateEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (CandidateEntry candidateEntry : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidateEntry);
		}
	}

	/**
	 * Returns the number of candidate entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching candidate entries
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "candidateEntry.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			CandidateEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			CandidateEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the candidate entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching candidate entries
	 */
	@Override
	public List<CandidateEntry> findByCompanyId(long companyId) {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<CandidateEntry> findByCompanyId(long companyId, int start,
		int end) {
		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<CandidateEntry> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<CandidateEntry> orderByComparator) {
		return findByCompanyId(companyId, start, end, orderByComparator, true);
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
	@Override
	public List<CandidateEntry> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<CandidateEntry> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateEntry candidateEntry : list) {
					if ((companyId != candidateEntry.getCompanyId())) {
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

			query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first candidate entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry
	 * @throws NoSuchEntryException if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry findByCompanyId_First(long companyId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first candidate entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByCompanyId_First(long companyId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		List<CandidateEntry> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate entry
	 * @throws NoSuchEntryException if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry findByCompanyId_Last(long companyId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last candidate entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByCompanyId_Last(long companyId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<CandidateEntry> list = findByCompanyId(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CandidateEntry[] findByCompanyId_PrevAndNext(long candidateEntryId,
		long companyId, OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = findByPrimaryKey(candidateEntryId);

		Session session = null;

		try {
			session = openSession();

			CandidateEntry[] array = new CandidateEntryImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, candidateEntry,
					companyId, orderByComparator, true);

			array[1] = candidateEntry;

			array[2] = getByCompanyId_PrevAndNext(session, candidateEntry,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateEntry getByCompanyId_PrevAndNext(Session session,
		CandidateEntry candidateEntry, long companyId,
		OrderByComparator<CandidateEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidateEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (CandidateEntry candidateEntry : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidateEntry);
		}
	}

	/**
	 * Returns the number of candidate entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching candidate entries
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "candidateEntry.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_CTD = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_ctD",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_CTD = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_ctD",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the candidate entries where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @return the matching candidate entries
	 */
	@Override
	public List<CandidateEntry> findByC_ctD(long companyId, Date createDate) {
		return findByC_ctD(companyId, createDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CandidateEntry> findByC_ctD(long companyId, Date createDate,
		int start, int end) {
		return findByC_ctD(companyId, createDate, start, end, null);
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
	@Override
	public List<CandidateEntry> findByC_ctD(long companyId, Date createDate,
		int start, int end, OrderByComparator<CandidateEntry> orderByComparator) {
		return findByC_ctD(companyId, createDate, start, end,
			orderByComparator, true);
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
	@Override
	public List<CandidateEntry> findByC_ctD(long companyId, Date createDate,
		int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_CTD;
		finderArgs = new Object[] {
				companyId, createDate,
				
				start, end, orderByComparator
			};

		List<CandidateEntry> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateEntry candidateEntry : list) {
					if ((companyId != candidateEntry.getCompanyId()) ||
							(createDate.getTime() <= candidateEntry.getCreateDate()
																	   .getTime())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_CTD_COMPANYID_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_C_CTD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_C_CTD_CREATEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
				}

				if (!pagination) {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first candidate entry in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry
	 * @throws NoSuchEntryException if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry findByC_ctD_First(long companyId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByC_ctD_First(companyId,
				createDate, orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first candidate entry in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByC_ctD_First(long companyId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator) {
		List<CandidateEntry> list = findByC_ctD(companyId, createDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CandidateEntry findByC_ctD_Last(long companyId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByC_ctD_Last(companyId,
				createDate, orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last candidate entry in the ordered set where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByC_ctD_Last(long companyId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator) {
		int count = countByC_ctD(companyId, createDate);

		if (count == 0) {
			return null;
		}

		List<CandidateEntry> list = findByC_ctD(companyId, createDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CandidateEntry[] findByC_ctD_PrevAndNext(long candidateEntryId,
		long companyId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = findByPrimaryKey(candidateEntryId);

		Session session = null;

		try {
			session = openSession();

			CandidateEntry[] array = new CandidateEntryImpl[3];

			array[0] = getByC_ctD_PrevAndNext(session, candidateEntry,
					companyId, createDate, orderByComparator, true);

			array[1] = candidateEntry;

			array[2] = getByC_ctD_PrevAndNext(session, candidateEntry,
					companyId, createDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateEntry getByC_ctD_PrevAndNext(Session session,
		CandidateEntry candidateEntry, long companyId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

		query.append(_FINDER_COLUMN_C_CTD_COMPANYID_2);

		boolean bindCreateDate = false;

		if (createDate == null) {
			query.append(_FINDER_COLUMN_C_CTD_CREATEDATE_1);
		}
		else {
			bindCreateDate = true;

			query.append(_FINDER_COLUMN_C_CTD_CREATEDATE_2);
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
			query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindCreateDate) {
			qPos.add(new Timestamp(createDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidateEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate entries where companyId = &#63; and createDate &lt; &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 */
	@Override
	public void removeByC_ctD(long companyId, Date createDate) {
		for (CandidateEntry candidateEntry : findByC_ctD(companyId, createDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidateEntry);
		}
	}

	/**
	 * Returns the number of candidate entries where companyId = &#63; and createDate &lt; &#63;.
	 *
	 * @param companyId the company ID
	 * @param createDate the create date
	 * @return the number of matching candidate entries
	 */
	@Override
	public int countByC_ctD(long companyId, Date createDate) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_CTD;

		Object[] finderArgs = new Object[] { companyId, createDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_CTD_COMPANYID_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_C_CTD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_C_CTD_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
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

	private static final String _FINDER_COLUMN_C_CTD_COMPANYID_2 = "candidateEntry.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_CTD_CREATEDATE_1 = "candidateEntry.createDate IS NULL";
	private static final String _FINDER_COLUMN_C_CTD_CREATEDATE_2 = "candidateEntry.createDate < ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_U = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_U = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			CandidateEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			CandidateEntryModelImpl.USERID_COLUMN_BITMASK |
			CandidateEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_U = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_U",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the candidate entries where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching candidate entries
	 */
	@Override
	public List<CandidateEntry> findByC_U(long companyId, long userId) {
		return findByC_U(companyId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CandidateEntry> findByC_U(long companyId, long userId,
		int start, int end) {
		return findByC_U(companyId, userId, start, end, null);
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
	@Override
	public List<CandidateEntry> findByC_U(long companyId, long userId,
		int start, int end, OrderByComparator<CandidateEntry> orderByComparator) {
		return findByC_U(companyId, userId, start, end, orderByComparator, true);
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
	@Override
	public List<CandidateEntry> findByC_U(long companyId, long userId,
		int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_U;
			finderArgs = new Object[] { companyId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_U;
			finderArgs = new Object[] {
					companyId, userId,
					
					start, end, orderByComparator
				};
		}

		List<CandidateEntry> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateEntry candidateEntry : list) {
					if ((companyId != candidateEntry.getCompanyId()) ||
							(userId != candidateEntry.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_U_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first candidate entry in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry
	 * @throws NoSuchEntryException if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry findByC_U_First(long companyId, long userId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByC_U_First(companyId, userId,
				orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first candidate entry in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByC_U_First(long companyId, long userId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		List<CandidateEntry> list = findByC_U(companyId, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CandidateEntry findByC_U_Last(long companyId, long userId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByC_U_Last(companyId, userId,
				orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last candidate entry in the ordered set where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByC_U_Last(long companyId, long userId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		int count = countByC_U(companyId, userId);

		if (count == 0) {
			return null;
		}

		List<CandidateEntry> list = findByC_U(companyId, userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CandidateEntry[] findByC_U_PrevAndNext(long candidateEntryId,
		long companyId, long userId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = findByPrimaryKey(candidateEntryId);

		Session session = null;

		try {
			session = openSession();

			CandidateEntry[] array = new CandidateEntryImpl[3];

			array[0] = getByC_U_PrevAndNext(session, candidateEntry, companyId,
					userId, orderByComparator, true);

			array[1] = candidateEntry;

			array[2] = getByC_U_PrevAndNext(session, candidateEntry, companyId,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateEntry getByC_U_PrevAndNext(Session session,
		CandidateEntry candidateEntry, long companyId, long userId,
		OrderByComparator<CandidateEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

		query.append(_FINDER_COLUMN_C_U_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_U_USERID_2);

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
			query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidateEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate entries where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByC_U(long companyId, long userId) {
		for (CandidateEntry candidateEntry : findByC_U(companyId, userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidateEntry);
		}
	}

	/**
	 * Returns the number of candidate entries where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching candidate entries
	 */
	@Override
	public int countByC_U(long companyId, long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_U;

		Object[] finderArgs = new Object[] { companyId, userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_U_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_C_U_COMPANYID_2 = "candidateEntry.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_U_USERID_2 = "candidateEntry.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_P = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByG_P",
			new String[] { Long.class.getName(), Long.class.getName() },
			CandidateEntryModelImpl.GROUPID_COLUMN_BITMASK |
			CandidateEntryModelImpl.WIKIPAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_P = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_P",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the candidate entry where groupId = &#63; and wikiPageId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param wikiPageId the wiki page ID
	 * @return the matching candidate entry
	 * @throws NoSuchEntryException if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry findByG_P(long groupId, long wikiPageId)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByG_P(groupId, wikiPageId);

		if (candidateEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", wikiPageId=");
			msg.append(wikiPageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEntryException(msg.toString());
		}

		return candidateEntry;
	}

	/**
	 * Returns the candidate entry where groupId = &#63; and wikiPageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param wikiPageId the wiki page ID
	 * @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByG_P(long groupId, long wikiPageId) {
		return fetchByG_P(groupId, wikiPageId, true);
	}

	/**
	 * Returns the candidate entry where groupId = &#63; and wikiPageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param wikiPageId the wiki page ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByG_P(long groupId, long wikiPageId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { groupId, wikiPageId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_G_P,
					finderArgs, this);
		}

		if (result instanceof CandidateEntry) {
			CandidateEntry candidateEntry = (CandidateEntry)result;

			if ((groupId != candidateEntry.getGroupId()) ||
					(wikiPageId != candidateEntry.getWikiPageId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_WIKIPAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(wikiPageId);

				List<CandidateEntry> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_G_P, finderArgs,
						list);
				}
				else {
					CandidateEntry candidateEntry = list.get(0);

					result = candidateEntry;

					cacheResult(candidateEntry);

					if ((candidateEntry.getGroupId() != groupId) ||
							(candidateEntry.getWikiPageId() != wikiPageId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_G_P,
							finderArgs, candidateEntry);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_G_P, finderArgs);

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
			return (CandidateEntry)result;
		}
	}

	/**
	 * Removes the candidate entry where groupId = &#63; and wikiPageId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param wikiPageId the wiki page ID
	 * @return the candidate entry that was removed
	 */
	@Override
	public CandidateEntry removeByG_P(long groupId, long wikiPageId)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = findByG_P(groupId, wikiPageId);

		return remove(candidateEntry);
	}

	/**
	 * Returns the number of candidate entries where groupId = &#63; and wikiPageId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param wikiPageId the wiki page ID
	 * @return the number of matching candidate entries
	 */
	@Override
	public int countByG_P(long groupId, long wikiPageId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_P;

		Object[] finderArgs = new Object[] { groupId, wikiPageId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_P_WIKIPAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(wikiPageId);

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

	private static final String _FINDER_COLUMN_G_P_GROUPID_2 = "candidateEntry.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_P_WIKIPAGEID_2 = "candidateEntry.wikiPageId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U_P = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_U_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_P = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			CandidateEntryModelImpl.GROUPID_COLUMN_BITMASK |
			CandidateEntryModelImpl.USERID_COLUMN_BITMASK |
			CandidateEntryModelImpl.WIKIPAGEID_COLUMN_BITMASK |
			CandidateEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_U_P = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the candidate entries where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param wikiPageId the wiki page ID
	 * @return the matching candidate entries
	 */
	@Override
	public List<CandidateEntry> findByG_U_P(long groupId, long userId,
		long wikiPageId) {
		return findByG_U_P(groupId, userId, wikiPageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CandidateEntry> findByG_U_P(long groupId, long userId,
		long wikiPageId, int start, int end) {
		return findByG_U_P(groupId, userId, wikiPageId, start, end, null);
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
	@Override
	public List<CandidateEntry> findByG_U_P(long groupId, long userId,
		long wikiPageId, int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return findByG_U_P(groupId, userId, wikiPageId, start, end,
			orderByComparator, true);
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
	@Override
	public List<CandidateEntry> findByG_U_P(long groupId, long userId,
		long wikiPageId, int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_P;
			finderArgs = new Object[] { groupId, userId, wikiPageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U_P;
			finderArgs = new Object[] {
					groupId, userId, wikiPageId,
					
					start, end, orderByComparator
				};
		}

		List<CandidateEntry> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateEntry candidateEntry : list) {
					if ((groupId != candidateEntry.getGroupId()) ||
							(userId != candidateEntry.getUserId()) ||
							(wikiPageId != candidateEntry.getWikiPageId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_G_U_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_P_USERID_2);

			query.append(_FINDER_COLUMN_G_U_P_WIKIPAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				qPos.add(wikiPageId);

				if (!pagination) {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first candidate entry in the ordered set where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param wikiPageId the wiki page ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry
	 * @throws NoSuchEntryException if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry findByG_U_P_First(long groupId, long userId,
		long wikiPageId, OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByG_U_P_First(groupId, userId,
				wikiPageId, orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", wikiPageId=");
		msg.append(wikiPageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
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
	@Override
	public CandidateEntry fetchByG_U_P_First(long groupId, long userId,
		long wikiPageId, OrderByComparator<CandidateEntry> orderByComparator) {
		List<CandidateEntry> list = findByG_U_P(groupId, userId, wikiPageId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CandidateEntry findByG_U_P_Last(long groupId, long userId,
		long wikiPageId, OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByG_U_P_Last(groupId, userId,
				wikiPageId, orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", wikiPageId=");
		msg.append(wikiPageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
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
	@Override
	public CandidateEntry fetchByG_U_P_Last(long groupId, long userId,
		long wikiPageId, OrderByComparator<CandidateEntry> orderByComparator) {
		int count = countByG_U_P(groupId, userId, wikiPageId);

		if (count == 0) {
			return null;
		}

		List<CandidateEntry> list = findByG_U_P(groupId, userId, wikiPageId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CandidateEntry[] findByG_U_P_PrevAndNext(long candidateEntryId,
		long groupId, long userId, long wikiPageId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = findByPrimaryKey(candidateEntryId);

		Session session = null;

		try {
			session = openSession();

			CandidateEntry[] array = new CandidateEntryImpl[3];

			array[0] = getByG_U_P_PrevAndNext(session, candidateEntry, groupId,
					userId, wikiPageId, orderByComparator, true);

			array[1] = candidateEntry;

			array[2] = getByG_U_P_PrevAndNext(session, candidateEntry, groupId,
					userId, wikiPageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateEntry getByG_U_P_PrevAndNext(Session session,
		CandidateEntry candidateEntry, long groupId, long userId,
		long wikiPageId, OrderByComparator<CandidateEntry> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

		query.append(_FINDER_COLUMN_G_U_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_U_P_USERID_2);

		query.append(_FINDER_COLUMN_G_U_P_WIKIPAGEID_2);

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
			query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		qPos.add(wikiPageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidateEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate entries where groupId = &#63; and userId = &#63; and wikiPageId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param wikiPageId the wiki page ID
	 */
	@Override
	public void removeByG_U_P(long groupId, long userId, long wikiPageId) {
		for (CandidateEntry candidateEntry : findByG_U_P(groupId, userId,
				wikiPageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidateEntry);
		}
	}

	/**
	 * Returns the number of candidate entries where groupId = &#63; and userId = &#63; and wikiPageId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param wikiPageId the wiki page ID
	 * @return the number of matching candidate entries
	 */
	@Override
	public int countByG_U_P(long groupId, long userId, long wikiPageId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_U_P;

		Object[] finderArgs = new Object[] { groupId, userId, wikiPageId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_G_U_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_U_P_USERID_2);

			query.append(_FINDER_COLUMN_G_U_P_WIKIPAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				qPos.add(wikiPageId);

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

	private static final String _FINDER_COLUMN_G_U_P_GROUPID_2 = "candidateEntry.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_U_P_USERID_2 = "candidateEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_G_U_P_WIKIPAGEID_2 = "candidateEntry.wikiPageId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_CD = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByU_cD",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_CD = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_cD",
			new String[] { Long.class.getName(), Date.class.getName() },
			CandidateEntryModelImpl.USERID_COLUMN_BITMASK |
			CandidateEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_CD = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_cD",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the candidate entries where userId = &#63; and createDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param createDate the create date
	 * @return the matching candidate entries
	 */
	@Override
	public List<CandidateEntry> findByU_cD(long userId, Date createDate) {
		return findByU_cD(userId, createDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CandidateEntry> findByU_cD(long userId, Date createDate,
		int start, int end) {
		return findByU_cD(userId, createDate, start, end, null);
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
	@Override
	public List<CandidateEntry> findByU_cD(long userId, Date createDate,
		int start, int end, OrderByComparator<CandidateEntry> orderByComparator) {
		return findByU_cD(userId, createDate, start, end, orderByComparator,
			true);
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
	@Override
	public List<CandidateEntry> findByU_cD(long userId, Date createDate,
		int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_CD;
			finderArgs = new Object[] { userId, createDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_CD;
			finderArgs = new Object[] {
					userId, createDate,
					
					start, end, orderByComparator
				};
		}

		List<CandidateEntry> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateEntry candidateEntry : list) {
					if ((userId != candidateEntry.getUserId()) ||
							!Objects.equals(createDate,
								candidateEntry.getCreateDate())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_CD_USERID_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_U_CD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_U_CD_CREATEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
				}

				if (!pagination) {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first candidate entry in the ordered set where userId = &#63; and createDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry
	 * @throws NoSuchEntryException if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry findByU_cD_First(long userId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByU_cD_First(userId, createDate,
				orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first candidate entry in the ordered set where userId = &#63; and createDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByU_cD_First(long userId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator) {
		List<CandidateEntry> list = findByU_cD(userId, createDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CandidateEntry findByU_cD_Last(long userId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByU_cD_Last(userId, createDate,
				orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last candidate entry in the ordered set where userId = &#63; and createDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByU_cD_Last(long userId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator) {
		int count = countByU_cD(userId, createDate);

		if (count == 0) {
			return null;
		}

		List<CandidateEntry> list = findByU_cD(userId, createDate, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CandidateEntry[] findByU_cD_PrevAndNext(long candidateEntryId,
		long userId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = findByPrimaryKey(candidateEntryId);

		Session session = null;

		try {
			session = openSession();

			CandidateEntry[] array = new CandidateEntryImpl[3];

			array[0] = getByU_cD_PrevAndNext(session, candidateEntry, userId,
					createDate, orderByComparator, true);

			array[1] = candidateEntry;

			array[2] = getByU_cD_PrevAndNext(session, candidateEntry, userId,
					createDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateEntry getByU_cD_PrevAndNext(Session session,
		CandidateEntry candidateEntry, long userId, Date createDate,
		OrderByComparator<CandidateEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

		query.append(_FINDER_COLUMN_U_CD_USERID_2);

		boolean bindCreateDate = false;

		if (createDate == null) {
			query.append(_FINDER_COLUMN_U_CD_CREATEDATE_1);
		}
		else {
			bindCreateDate = true;

			query.append(_FINDER_COLUMN_U_CD_CREATEDATE_2);
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
			query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (bindCreateDate) {
			qPos.add(new Timestamp(createDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidateEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate entries where userId = &#63; and createDate = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param createDate the create date
	 */
	@Override
	public void removeByU_cD(long userId, Date createDate) {
		for (CandidateEntry candidateEntry : findByU_cD(userId, createDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidateEntry);
		}
	}

	/**
	 * Returns the number of candidate entries where userId = &#63; and createDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param createDate the create date
	 * @return the number of matching candidate entries
	 */
	@Override
	public int countByU_cD(long userId, Date createDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_CD;

		Object[] finderArgs = new Object[] { userId, createDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_CD_USERID_2);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_U_CD_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_U_CD_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
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

	private static final String _FINDER_COLUMN_U_CD_USERID_2 = "candidateEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_CD_CREATEDATE_1 = "candidateEntry.createDate IS NULL";
	private static final String _FINDER_COLUMN_U_CD_CREATEDATE_2 = "candidateEntry.createDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_P = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByU_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_P = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_P",
			new String[] { Long.class.getName(), Long.class.getName() },
			CandidateEntryModelImpl.USERID_COLUMN_BITMASK |
			CandidateEntryModelImpl.WIKIPAGEID_COLUMN_BITMASK |
			CandidateEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_P = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_P",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the candidate entries where userId = &#63; and wikiPageId = &#63;.
	 *
	 * @param userId the user ID
	 * @param wikiPageId the wiki page ID
	 * @return the matching candidate entries
	 */
	@Override
	public List<CandidateEntry> findByU_P(long userId, long wikiPageId) {
		return findByU_P(userId, wikiPageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CandidateEntry> findByU_P(long userId, long wikiPageId,
		int start, int end) {
		return findByU_P(userId, wikiPageId, start, end, null);
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
	@Override
	public List<CandidateEntry> findByU_P(long userId, long wikiPageId,
		int start, int end, OrderByComparator<CandidateEntry> orderByComparator) {
		return findByU_P(userId, wikiPageId, start, end, orderByComparator, true);
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
	@Override
	public List<CandidateEntry> findByU_P(long userId, long wikiPageId,
		int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_P;
			finderArgs = new Object[] { userId, wikiPageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_P;
			finderArgs = new Object[] {
					userId, wikiPageId,
					
					start, end, orderByComparator
				};
		}

		List<CandidateEntry> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateEntry candidateEntry : list) {
					if ((userId != candidateEntry.getUserId()) ||
							(wikiPageId != candidateEntry.getWikiPageId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_P_USERID_2);

			query.append(_FINDER_COLUMN_U_P_WIKIPAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(wikiPageId);

				if (!pagination) {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first candidate entry in the ordered set where userId = &#63; and wikiPageId = &#63;.
	 *
	 * @param userId the user ID
	 * @param wikiPageId the wiki page ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry
	 * @throws NoSuchEntryException if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry findByU_P_First(long userId, long wikiPageId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByU_P_First(userId, wikiPageId,
				orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", wikiPageId=");
		msg.append(wikiPageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first candidate entry in the ordered set where userId = &#63; and wikiPageId = &#63;.
	 *
	 * @param userId the user ID
	 * @param wikiPageId the wiki page ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByU_P_First(long userId, long wikiPageId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		List<CandidateEntry> list = findByU_P(userId, wikiPageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CandidateEntry findByU_P_Last(long userId, long wikiPageId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByU_P_Last(userId, wikiPageId,
				orderByComparator);

		if (candidateEntry != null) {
			return candidateEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", wikiPageId=");
		msg.append(wikiPageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last candidate entry in the ordered set where userId = &#63; and wikiPageId = &#63;.
	 *
	 * @param userId the user ID
	 * @param wikiPageId the wiki page ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByU_P_Last(long userId, long wikiPageId,
		OrderByComparator<CandidateEntry> orderByComparator) {
		int count = countByU_P(userId, wikiPageId);

		if (count == 0) {
			return null;
		}

		List<CandidateEntry> list = findByU_P(userId, wikiPageId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CandidateEntry[] findByU_P_PrevAndNext(long candidateEntryId,
		long userId, long wikiPageId,
		OrderByComparator<CandidateEntry> orderByComparator)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = findByPrimaryKey(candidateEntryId);

		Session session = null;

		try {
			session = openSession();

			CandidateEntry[] array = new CandidateEntryImpl[3];

			array[0] = getByU_P_PrevAndNext(session, candidateEntry, userId,
					wikiPageId, orderByComparator, true);

			array[1] = candidateEntry;

			array[2] = getByU_P_PrevAndNext(session, candidateEntry, userId,
					wikiPageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateEntry getByU_P_PrevAndNext(Session session,
		CandidateEntry candidateEntry, long userId, long wikiPageId,
		OrderByComparator<CandidateEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

		query.append(_FINDER_COLUMN_U_P_USERID_2);

		query.append(_FINDER_COLUMN_U_P_WIKIPAGEID_2);

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
			query.append(CandidateEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(wikiPageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidateEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate entries where userId = &#63; and wikiPageId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param wikiPageId the wiki page ID
	 */
	@Override
	public void removeByU_P(long userId, long wikiPageId) {
		for (CandidateEntry candidateEntry : findByU_P(userId, wikiPageId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidateEntry);
		}
	}

	/**
	 * Returns the number of candidate entries where userId = &#63; and wikiPageId = &#63;.
	 *
	 * @param userId the user ID
	 * @param wikiPageId the wiki page ID
	 * @return the number of matching candidate entries
	 */
	@Override
	public int countByU_P(long userId, long wikiPageId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_P;

		Object[] finderArgs = new Object[] { userId, wikiPageId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_P_USERID_2);

			query.append(_FINDER_COLUMN_U_P_WIKIPAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(wikiPageId);

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

	private static final String _FINDER_COLUMN_U_P_USERID_2 = "candidateEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_P_WIKIPAGEID_2 = "candidateEntry.wikiPageId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_WIKIPAGEID = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED,
			CandidateEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByWikiPageId", new String[] { Long.class.getName() },
			CandidateEntryModelImpl.WIKIPAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WIKIPAGEID = new FinderPath(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWikiPageId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the candidate entry where wikiPageId = &#63; or throws a {@link NoSuchEntryException} if it could not be found.
	 *
	 * @param wikiPageId the wiki page ID
	 * @return the matching candidate entry
	 * @throws NoSuchEntryException if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry findByWikiPageId(long wikiPageId)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByWikiPageId(wikiPageId);

		if (candidateEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("wikiPageId=");
			msg.append(wikiPageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEntryException(msg.toString());
		}

		return candidateEntry;
	}

	/**
	 * Returns the candidate entry where wikiPageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param wikiPageId the wiki page ID
	 * @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByWikiPageId(long wikiPageId) {
		return fetchByWikiPageId(wikiPageId, true);
	}

	/**
	 * Returns the candidate entry where wikiPageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param wikiPageId the wiki page ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching candidate entry, or <code>null</code> if a matching candidate entry could not be found
	 */
	@Override
	public CandidateEntry fetchByWikiPageId(long wikiPageId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { wikiPageId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_WIKIPAGEID,
					finderArgs, this);
		}

		if (result instanceof CandidateEntry) {
			CandidateEntry candidateEntry = (CandidateEntry)result;

			if ((wikiPageId != candidateEntry.getWikiPageId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_WIKIPAGEID_WIKIPAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(wikiPageId);

				List<CandidateEntry> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_WIKIPAGEID,
						finderArgs, list);
				}
				else {
					CandidateEntry candidateEntry = list.get(0);

					result = candidateEntry;

					cacheResult(candidateEntry);

					if ((candidateEntry.getWikiPageId() != wikiPageId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_WIKIPAGEID,
							finderArgs, candidateEntry);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_WIKIPAGEID,
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
			return (CandidateEntry)result;
		}
	}

	/**
	 * Removes the candidate entry where wikiPageId = &#63; from the database.
	 *
	 * @param wikiPageId the wiki page ID
	 * @return the candidate entry that was removed
	 */
	@Override
	public CandidateEntry removeByWikiPageId(long wikiPageId)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = findByWikiPageId(wikiPageId);

		return remove(candidateEntry);
	}

	/**
	 * Returns the number of candidate entries where wikiPageId = &#63;.
	 *
	 * @param wikiPageId the wiki page ID
	 * @return the number of matching candidate entries
	 */
	@Override
	public int countByWikiPageId(long wikiPageId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WIKIPAGEID;

		Object[] finderArgs = new Object[] { wikiPageId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANDIDATEENTRY_WHERE);

			query.append(_FINDER_COLUMN_WIKIPAGEID_WIKIPAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(wikiPageId);

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

	private static final String _FINDER_COLUMN_WIKIPAGEID_WIKIPAGEID_2 = "candidateEntry.wikiPageId = ?";

	public CandidateEntryPersistenceImpl() {
		setModelClass(CandidateEntry.class);
	}

	/**
	 * Caches the candidate entry in the entity cache if it is enabled.
	 *
	 * @param candidateEntry the candidate entry
	 */
	@Override
	public void cacheResult(CandidateEntry candidateEntry) {
		entityCache.putResult(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryImpl.class, candidateEntry.getPrimaryKey(),
			candidateEntry);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { candidateEntry.getUuid(), candidateEntry.getGroupId() },
			candidateEntry);

		finderCache.putResult(FINDER_PATH_FETCH_BY_G_P,
			new Object[] {
				candidateEntry.getGroupId(), candidateEntry.getWikiPageId()
			}, candidateEntry);

		finderCache.putResult(FINDER_PATH_FETCH_BY_WIKIPAGEID,
			new Object[] { candidateEntry.getWikiPageId() }, candidateEntry);

		candidateEntry.resetOriginalValues();
	}

	/**
	 * Caches the candidate entries in the entity cache if it is enabled.
	 *
	 * @param candidateEntries the candidate entries
	 */
	@Override
	public void cacheResult(List<CandidateEntry> candidateEntries) {
		for (CandidateEntry candidateEntry : candidateEntries) {
			if (entityCache.getResult(
						CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
						CandidateEntryImpl.class, candidateEntry.getPrimaryKey()) == null) {
				cacheResult(candidateEntry);
			}
			else {
				candidateEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all candidate entries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CandidateEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the candidate entry.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CandidateEntry candidateEntry) {
		entityCache.removeResult(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryImpl.class, candidateEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CandidateEntryModelImpl)candidateEntry);
	}

	@Override
	public void clearCache(List<CandidateEntry> candidateEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CandidateEntry candidateEntry : candidateEntries) {
			entityCache.removeResult(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
				CandidateEntryImpl.class, candidateEntry.getPrimaryKey());

			clearUniqueFindersCache((CandidateEntryModelImpl)candidateEntry);
		}
	}

	protected void cacheUniqueFindersCache(
		CandidateEntryModelImpl candidateEntryModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					candidateEntryModelImpl.getUuid(),
					candidateEntryModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				candidateEntryModelImpl);

			args = new Object[] {
					candidateEntryModelImpl.getGroupId(),
					candidateEntryModelImpl.getWikiPageId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_G_P, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_G_P, args,
				candidateEntryModelImpl);

			args = new Object[] { candidateEntryModelImpl.getWikiPageId() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_WIKIPAGEID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_WIKIPAGEID, args,
				candidateEntryModelImpl);
		}
		else {
			if ((candidateEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateEntryModelImpl.getUuid(),
						candidateEntryModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					candidateEntryModelImpl);
			}

			if ((candidateEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateEntryModelImpl.getGroupId(),
						candidateEntryModelImpl.getWikiPageId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_G_P, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_G_P, args,
					candidateEntryModelImpl);
			}

			if ((candidateEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_WIKIPAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateEntryModelImpl.getWikiPageId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_WIKIPAGEID, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_WIKIPAGEID, args,
					candidateEntryModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		CandidateEntryModelImpl candidateEntryModelImpl) {
		Object[] args = new Object[] {
				candidateEntryModelImpl.getUuid(),
				candidateEntryModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((candidateEntryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					candidateEntryModelImpl.getOriginalUuid(),
					candidateEntryModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				candidateEntryModelImpl.getGroupId(),
				candidateEntryModelImpl.getWikiPageId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_G_P, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_G_P, args);

		if ((candidateEntryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_P.getColumnBitmask()) != 0) {
			args = new Object[] {
					candidateEntryModelImpl.getOriginalGroupId(),
					candidateEntryModelImpl.getOriginalWikiPageId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_G_P, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_G_P, args);
		}

		args = new Object[] { candidateEntryModelImpl.getWikiPageId() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_WIKIPAGEID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_WIKIPAGEID, args);

		if ((candidateEntryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_WIKIPAGEID.getColumnBitmask()) != 0) {
			args = new Object[] { candidateEntryModelImpl.getOriginalWikiPageId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_WIKIPAGEID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_WIKIPAGEID, args);
		}
	}

	/**
	 * Creates a new candidate entry with the primary key. Does not add the candidate entry to the database.
	 *
	 * @param candidateEntryId the primary key for the new candidate entry
	 * @return the new candidate entry
	 */
	@Override
	public CandidateEntry create(long candidateEntryId) {
		CandidateEntry candidateEntry = new CandidateEntryImpl();

		candidateEntry.setNew(true);
		candidateEntry.setPrimaryKey(candidateEntryId);

		String uuid = PortalUUIDUtil.generate();

		candidateEntry.setUuid(uuid);

		candidateEntry.setCompanyId(companyProvider.getCompanyId());

		return candidateEntry;
	}

	/**
	 * Removes the candidate entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateEntryId the primary key of the candidate entry
	 * @return the candidate entry that was removed
	 * @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	 */
	@Override
	public CandidateEntry remove(long candidateEntryId)
		throws NoSuchEntryException {
		return remove((Serializable)candidateEntryId);
	}

	/**
	 * Removes the candidate entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the candidate entry
	 * @return the candidate entry that was removed
	 * @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	 */
	@Override
	public CandidateEntry remove(Serializable primaryKey)
		throws NoSuchEntryException {
		Session session = null;

		try {
			session = openSession();

			CandidateEntry candidateEntry = (CandidateEntry)session.get(CandidateEntryImpl.class,
					primaryKey);

			if (candidateEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(candidateEntry);
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
	protected CandidateEntry removeImpl(CandidateEntry candidateEntry) {
		candidateEntry = toUnwrappedModel(candidateEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(candidateEntry)) {
				candidateEntry = (CandidateEntry)session.get(CandidateEntryImpl.class,
						candidateEntry.getPrimaryKeyObj());
			}

			if (candidateEntry != null) {
				session.delete(candidateEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (candidateEntry != null) {
			clearCache(candidateEntry);
		}

		return candidateEntry;
	}

	@Override
	public CandidateEntry updateImpl(CandidateEntry candidateEntry) {
		candidateEntry = toUnwrappedModel(candidateEntry);

		boolean isNew = candidateEntry.isNew();

		CandidateEntryModelImpl candidateEntryModelImpl = (CandidateEntryModelImpl)candidateEntry;

		if (Validator.isNull(candidateEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			candidateEntry.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (candidateEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				candidateEntry.setCreateDate(now);
			}
			else {
				candidateEntry.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!candidateEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				candidateEntry.setModifiedDate(now);
			}
			else {
				candidateEntry.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (candidateEntry.isNew()) {
				session.save(candidateEntry);

				candidateEntry.setNew(false);
			}
			else {
				candidateEntry = (CandidateEntry)session.merge(candidateEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CandidateEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((candidateEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateEntryModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { candidateEntryModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((candidateEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateEntryModelImpl.getOriginalUuid(),
						candidateEntryModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						candidateEntryModelImpl.getUuid(),
						candidateEntryModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((candidateEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateEntryModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { candidateEntryModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((candidateEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateEntryModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { candidateEntryModelImpl.getCompanyId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((candidateEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateEntryModelImpl.getOriginalCompanyId(),
						candidateEntryModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_U,
					args);

				args = new Object[] {
						candidateEntryModelImpl.getCompanyId(),
						candidateEntryModelImpl.getUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_U,
					args);
			}

			if ((candidateEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateEntryModelImpl.getOriginalGroupId(),
						candidateEntryModelImpl.getOriginalUserId(),
						candidateEntryModelImpl.getOriginalWikiPageId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_U_P, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_P,
					args);

				args = new Object[] {
						candidateEntryModelImpl.getGroupId(),
						candidateEntryModelImpl.getUserId(),
						candidateEntryModelImpl.getWikiPageId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_U_P, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U_P,
					args);
			}

			if ((candidateEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_CD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateEntryModelImpl.getOriginalUserId(),
						candidateEntryModelImpl.getOriginalCreateDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_CD, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_CD,
					args);

				args = new Object[] {
						candidateEntryModelImpl.getUserId(),
						candidateEntryModelImpl.getCreateDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_CD, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_CD,
					args);
			}

			if ((candidateEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateEntryModelImpl.getOriginalUserId(),
						candidateEntryModelImpl.getOriginalWikiPageId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_P, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_P,
					args);

				args = new Object[] {
						candidateEntryModelImpl.getUserId(),
						candidateEntryModelImpl.getWikiPageId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_P, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_P,
					args);
			}
		}

		entityCache.putResult(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEntryImpl.class, candidateEntry.getPrimaryKey(),
			candidateEntry, false);

		clearUniqueFindersCache(candidateEntryModelImpl);
		cacheUniqueFindersCache(candidateEntryModelImpl, isNew);

		candidateEntry.resetOriginalValues();

		return candidateEntry;
	}

	protected CandidateEntry toUnwrappedModel(CandidateEntry candidateEntry) {
		if (candidateEntry instanceof CandidateEntryImpl) {
			return candidateEntry;
		}

		CandidateEntryImpl candidateEntryImpl = new CandidateEntryImpl();

		candidateEntryImpl.setNew(candidateEntry.isNew());
		candidateEntryImpl.setPrimaryKey(candidateEntry.getPrimaryKey());

		candidateEntryImpl.setUuid(candidateEntry.getUuid());
		candidateEntryImpl.setCandidateEntryId(candidateEntry.getCandidateEntryId());
		candidateEntryImpl.setGroupId(candidateEntry.getGroupId());
		candidateEntryImpl.setCompanyId(candidateEntry.getCompanyId());
		candidateEntryImpl.setUserId(candidateEntry.getUserId());
		candidateEntryImpl.setUserName(candidateEntry.getUserName());
		candidateEntryImpl.setCreateDate(candidateEntry.getCreateDate());
		candidateEntryImpl.setModifiedDate(candidateEntry.getModifiedDate());
		candidateEntryImpl.setWikiPageId(candidateEntry.getWikiPageId());

		return candidateEntryImpl;
	}

	/**
	 * Returns the candidate entry with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate entry
	 * @return the candidate entry
	 * @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	 */
	@Override
	public CandidateEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEntryException {
		CandidateEntry candidateEntry = fetchByPrimaryKey(primaryKey);

		if (candidateEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return candidateEntry;
	}

	/**
	 * Returns the candidate entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	 *
	 * @param candidateEntryId the primary key of the candidate entry
	 * @return the candidate entry
	 * @throws NoSuchEntryException if a candidate entry with the primary key could not be found
	 */
	@Override
	public CandidateEntry findByPrimaryKey(long candidateEntryId)
		throws NoSuchEntryException {
		return findByPrimaryKey((Serializable)candidateEntryId);
	}

	/**
	 * Returns the candidate entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate entry
	 * @return the candidate entry, or <code>null</code> if a candidate entry with the primary key could not be found
	 */
	@Override
	public CandidateEntry fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
				CandidateEntryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CandidateEntry candidateEntry = (CandidateEntry)serializable;

		if (candidateEntry == null) {
			Session session = null;

			try {
				session = openSession();

				candidateEntry = (CandidateEntry)session.get(CandidateEntryImpl.class,
						primaryKey);

				if (candidateEntry != null) {
					cacheResult(candidateEntry);
				}
				else {
					entityCache.putResult(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
						CandidateEntryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
					CandidateEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return candidateEntry;
	}

	/**
	 * Returns the candidate entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidateEntryId the primary key of the candidate entry
	 * @return the candidate entry, or <code>null</code> if a candidate entry with the primary key could not be found
	 */
	@Override
	public CandidateEntry fetchByPrimaryKey(long candidateEntryId) {
		return fetchByPrimaryKey((Serializable)candidateEntryId);
	}

	@Override
	public Map<Serializable, CandidateEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CandidateEntry> map = new HashMap<Serializable, CandidateEntry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CandidateEntry candidateEntry = fetchByPrimaryKey(primaryKey);

			if (candidateEntry != null) {
				map.put(primaryKey, candidateEntry);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
					CandidateEntryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CandidateEntry)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CANDIDATEENTRY_WHERE_PKS_IN);

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

			for (CandidateEntry candidateEntry : (List<CandidateEntry>)q.list()) {
				map.put(candidateEntry.getPrimaryKeyObj(), candidateEntry);

				cacheResult(candidateEntry);

				uncachedPrimaryKeys.remove(candidateEntry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CandidateEntryModelImpl.ENTITY_CACHE_ENABLED,
					CandidateEntryImpl.class, primaryKey, nullModel);
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
	 * Returns all the candidate entries.
	 *
	 * @return the candidate entries
	 */
	@Override
	public List<CandidateEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CandidateEntry> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CandidateEntry> findAll(int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CandidateEntry> findAll(int start, int end,
		OrderByComparator<CandidateEntry> orderByComparator,
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

		List<CandidateEntry> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateEntry>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CANDIDATEENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CANDIDATEENTRY;

				if (pagination) {
					sql = sql.concat(CandidateEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateEntry>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the candidate entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CandidateEntry candidateEntry : findAll()) {
			remove(candidateEntry);
		}
	}

	/**
	 * Returns the number of candidate entries.
	 *
	 * @return the number of candidate entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CANDIDATEENTRY);

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
		return CandidateEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the candidate entry persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CandidateEntryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CANDIDATEENTRY = "SELECT candidateEntry FROM CandidateEntry candidateEntry";
	private static final String _SQL_SELECT_CANDIDATEENTRY_WHERE_PKS_IN = "SELECT candidateEntry FROM CandidateEntry candidateEntry WHERE candidateEntryId IN (";
	private static final String _SQL_SELECT_CANDIDATEENTRY_WHERE = "SELECT candidateEntry FROM CandidateEntry candidateEntry WHERE ";
	private static final String _SQL_COUNT_CANDIDATEENTRY = "SELECT COUNT(candidateEntry) FROM CandidateEntry candidateEntry";
	private static final String _SQL_COUNT_CANDIDATEENTRY_WHERE = "SELECT COUNT(candidateEntry) FROM CandidateEntry candidateEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "candidateEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CandidateEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CandidateEntry exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CandidateEntryPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}