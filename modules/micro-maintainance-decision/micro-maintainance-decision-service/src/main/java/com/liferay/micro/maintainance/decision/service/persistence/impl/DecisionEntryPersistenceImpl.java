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

package com.liferay.micro.maintainance.decision.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.decision.exception.NoSuchEntryException;
import com.liferay.micro.maintainance.decision.model.DecisionEntry;
import com.liferay.micro.maintainance.decision.model.impl.DecisionEntryImpl;
import com.liferay.micro.maintainance.decision.model.impl.DecisionEntryModelImpl;
import com.liferay.micro.maintainance.decision.service.persistence.DecisionEntryPersistence;

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
 * The persistence implementation for the decision entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DecisionEntryPersistence
 * @see com.liferay.micro.maintainance.decision.service.persistence.DecisionEntryUtil
 * @generated
 */
@ProviderType
public class DecisionEntryPersistenceImpl extends BasePersistenceImpl<DecisionEntry>
	implements DecisionEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DecisionEntryUtil} to access the decision entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DecisionEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			DecisionEntryModelImpl.UUID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the decision entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DecisionEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<DecisionEntry> findByUuid(String uuid, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<DecisionEntry> findByUuid(String uuid, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
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

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if (!Objects.equals(uuid, decisionEntry.getUuid())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

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
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
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
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByUuid_First(String uuid,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByUuid_First(uuid, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByUuid_First(String uuid,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByUuid_Last(String uuid,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByUuid_Last(String uuid,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry[] findByUuid_PrevAndNext(long decisionEntryId,
		String uuid, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = findByPrimaryKey(decisionEntryId);

		Session session = null;

		try {
			session = openSession();

			DecisionEntry[] array = new DecisionEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(session, decisionEntry, uuid,
					orderByComparator, true);

			array[1] = decisionEntry;

			array[2] = getByUuid_PrevAndNext(session, decisionEntry, uuid,
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

	protected DecisionEntry getByUuid_PrevAndNext(Session session,
		DecisionEntry decisionEntry, String uuid,
		OrderByComparator<DecisionEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

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
			query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(decisionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DecisionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the decision entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DecisionEntry decisionEntry : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "decisionEntry.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "decisionEntry.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(decisionEntry.uuid IS NULL OR decisionEntry.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			DecisionEntryModelImpl.UUID_COLUMN_BITMASK |
			DecisionEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the decision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<DecisionEntry> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<DecisionEntry> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<DecisionEntry> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
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

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if (!Objects.equals(uuid, decisionEntry.getUuid()) ||
							(companyId != decisionEntry.getCompanyId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

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
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
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
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
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
	 * Returns the first decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
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
	 * Returns the last decision entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry[] findByUuid_C_PrevAndNext(long decisionEntryId,
		String uuid, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = findByPrimaryKey(decisionEntryId);

		Session session = null;

		try {
			session = openSession();

			DecisionEntry[] array = new DecisionEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, decisionEntry, uuid,
					companyId, orderByComparator, true);

			array[1] = decisionEntry;

			array[2] = getByUuid_C_PrevAndNext(session, decisionEntry, uuid,
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

	protected DecisionEntry getByUuid_C_PrevAndNext(Session session,
		DecisionEntry decisionEntry, String uuid, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

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
			query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(decisionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DecisionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the decision entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DecisionEntry decisionEntry : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "decisionEntry.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "decisionEntry.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(decisionEntry.uuid IS NULL OR decisionEntry.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "decisionEntry.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyId", new String[] { Long.class.getName() },
			DecisionEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the decision entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByCompanyId(long companyId) {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<DecisionEntry> findByCompanyId(long companyId, int start,
		int end) {
		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<DecisionEntry> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByCompanyId(companyId, start, end, orderByComparator, true);
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
	@Override
	public List<DecisionEntry> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<DecisionEntry> orderByComparator,
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

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((companyId != decisionEntry.getCompanyId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByCompanyId_First(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByCompanyId_First(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByCompanyId_Last(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByCompanyId_Last(long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry[] findByCompanyId_PrevAndNext(long decisionEntryId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = findByPrimaryKey(decisionEntryId);

		Session session = null;

		try {
			session = openSession();

			DecisionEntry[] array = new DecisionEntryImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, decisionEntry,
					companyId, orderByComparator, true);

			array[1] = decisionEntry;

			array[2] = getByCompanyId_PrevAndNext(session, decisionEntry,
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

	protected DecisionEntry getByCompanyId_PrevAndNext(Session session,
		DecisionEntry decisionEntry, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

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
			query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(decisionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DecisionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the decision entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (DecisionEntry decisionEntry : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "decisionEntry.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DECISIONENTRYID =
		new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDecisionEntryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECISIONENTRYID =
		new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDecisionEntryId", new String[] { Long.class.getName() },
			DecisionEntryModelImpl.DECISIONENTRYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DECISIONENTRYID = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDecisionEntryId", new String[] { Long.class.getName() });

	/**
	 * Returns all the decision entries where decisionEntryId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByDecisionEntryId(long decisionEntryId) {
		return findByDecisionEntryId(decisionEntryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<DecisionEntry> findByDecisionEntryId(long decisionEntryId,
		int start, int end) {
		return findByDecisionEntryId(decisionEntryId, start, end, null);
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
	@Override
	public List<DecisionEntry> findByDecisionEntryId(long decisionEntryId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByDecisionEntryId(decisionEntryId, start, end,
			orderByComparator, true);
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
	@Override
	public List<DecisionEntry> findByDecisionEntryId(long decisionEntryId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECISIONENTRYID;
			finderArgs = new Object[] { decisionEntryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DECISIONENTRYID;
			finderArgs = new Object[] {
					decisionEntryId,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((decisionEntryId != decisionEntry.getDecisionEntryId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_DECISIONENTRYID_DECISIONENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionEntryId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where decisionEntryId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByDecisionEntryId_First(long decisionEntryId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByDecisionEntryId_First(decisionEntryId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionEntryId=");
		msg.append(decisionEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where decisionEntryId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByDecisionEntryId_First(long decisionEntryId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByDecisionEntryId(decisionEntryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionEntryId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByDecisionEntryId_Last(long decisionEntryId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByDecisionEntryId_Last(decisionEntryId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionEntryId=");
		msg.append(decisionEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionEntryId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByDecisionEntryId_Last(long decisionEntryId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByDecisionEntryId(decisionEntryId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByDecisionEntryId(decisionEntryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the decision entries where decisionEntryId = &#63; from the database.
	 *
	 * @param decisionEntryId the decision entry ID
	 */
	@Override
	public void removeByDecisionEntryId(long decisionEntryId) {
		for (DecisionEntry decisionEntry : findByDecisionEntryId(
				decisionEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where decisionEntryId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByDecisionEntryId(long decisionEntryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DECISIONENTRYID;

		Object[] finderArgs = new Object[] { decisionEntryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_DECISIONENTRYID_DECISIONENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionEntryId);

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

	private static final String _FINDER_COLUMN_DECISIONENTRYID_DECISIONENTRYID_2 =
		"decisionEntry.decisionEntryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OUTCOME = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOutcome",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OUTCOME =
		new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOutcome", new String[] { String.class.getName() },
			DecisionEntryModelImpl.OUTCOME_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OUTCOME = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOutcome",
			new String[] { String.class.getName() });

	/**
	 * Returns all the decision entries where outcome = &#63;.
	 *
	 * @param outcome the outcome
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByOutcome(String outcome) {
		return findByOutcome(outcome, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DecisionEntry> findByOutcome(String outcome, int start, int end) {
		return findByOutcome(outcome, start, end, null);
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
	@Override
	public List<DecisionEntry> findByOutcome(String outcome, int start,
		int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByOutcome(outcome, start, end, orderByComparator, true);
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
	@Override
	public List<DecisionEntry> findByOutcome(String outcome, int start,
		int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OUTCOME;
			finderArgs = new Object[] { outcome };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OUTCOME;
			finderArgs = new Object[] { outcome, start, end, orderByComparator };
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if (!Objects.equals(outcome, decisionEntry.getOutcome())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			boolean bindOutcome = false;

			if (outcome == null) {
				query.append(_FINDER_COLUMN_OUTCOME_OUTCOME_1);
			}
			else if (outcome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OUTCOME_OUTCOME_3);
			}
			else {
				bindOutcome = true;

				query.append(_FINDER_COLUMN_OUTCOME_OUTCOME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOutcome) {
					qPos.add(outcome);
				}

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where outcome = &#63;.
	 *
	 * @param outcome the outcome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByOutcome_First(String outcome,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByOutcome_First(outcome,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("outcome=");
		msg.append(outcome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where outcome = &#63;.
	 *
	 * @param outcome the outcome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByOutcome_First(String outcome,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByOutcome(outcome, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where outcome = &#63;.
	 *
	 * @param outcome the outcome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByOutcome_Last(String outcome,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByOutcome_Last(outcome,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("outcome=");
		msg.append(outcome);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where outcome = &#63;.
	 *
	 * @param outcome the outcome
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByOutcome_Last(String outcome,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByOutcome(outcome);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByOutcome(outcome, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry[] findByOutcome_PrevAndNext(long decisionEntryId,
		String outcome, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = findByPrimaryKey(decisionEntryId);

		Session session = null;

		try {
			session = openSession();

			DecisionEntry[] array = new DecisionEntryImpl[3];

			array[0] = getByOutcome_PrevAndNext(session, decisionEntry,
					outcome, orderByComparator, true);

			array[1] = decisionEntry;

			array[2] = getByOutcome_PrevAndNext(session, decisionEntry,
					outcome, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DecisionEntry getByOutcome_PrevAndNext(Session session,
		DecisionEntry decisionEntry, String outcome,
		OrderByComparator<DecisionEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

		boolean bindOutcome = false;

		if (outcome == null) {
			query.append(_FINDER_COLUMN_OUTCOME_OUTCOME_1);
		}
		else if (outcome.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OUTCOME_OUTCOME_3);
		}
		else {
			bindOutcome = true;

			query.append(_FINDER_COLUMN_OUTCOME_OUTCOME_2);
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
			query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindOutcome) {
			qPos.add(outcome);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(decisionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DecisionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the decision entries where outcome = &#63; from the database.
	 *
	 * @param outcome the outcome
	 */
	@Override
	public void removeByOutcome(String outcome) {
		for (DecisionEntry decisionEntry : findByOutcome(outcome,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where outcome = &#63;.
	 *
	 * @param outcome the outcome
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByOutcome(String outcome) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OUTCOME;

		Object[] finderArgs = new Object[] { outcome };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			boolean bindOutcome = false;

			if (outcome == null) {
				query.append(_FINDER_COLUMN_OUTCOME_OUTCOME_1);
			}
			else if (outcome.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OUTCOME_OUTCOME_3);
			}
			else {
				bindOutcome = true;

				query.append(_FINDER_COLUMN_OUTCOME_OUTCOME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOutcome) {
					qPos.add(outcome);
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

	private static final String _FINDER_COLUMN_OUTCOME_OUTCOME_1 = "decisionEntry.outcome IS NULL";
	private static final String _FINDER_COLUMN_OUTCOME_OUTCOME_2 = "decisionEntry.outcome = ?";
	private static final String _FINDER_COLUMN_OUTCOME_OUTCOME_3 = "(decisionEntry.outcome IS NULL OR decisionEntry.outcome = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WIKIPAGEID =
		new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByWikiPageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WIKIPAGEID =
		new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByWikiPageId", new String[] { Long.class.getName() },
			DecisionEntryModelImpl.WIKIPAGEID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WIKIPAGEID = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWikiPageId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the decision entries where wikiPageId = &#63;.
	 *
	 * @param wikiPageId the wiki page ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByWikiPageId(long wikiPageId) {
		return findByWikiPageId(wikiPageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<DecisionEntry> findByWikiPageId(long wikiPageId, int start,
		int end) {
		return findByWikiPageId(wikiPageId, start, end, null);
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
	@Override
	public List<DecisionEntry> findByWikiPageId(long wikiPageId, int start,
		int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByWikiPageId(wikiPageId, start, end, orderByComparator, true);
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
	@Override
	public List<DecisionEntry> findByWikiPageId(long wikiPageId, int start,
		int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WIKIPAGEID;
			finderArgs = new Object[] { wikiPageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WIKIPAGEID;
			finderArgs = new Object[] { wikiPageId, start, end, orderByComparator };
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((wikiPageId != decisionEntry.getWikiPageId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_WIKIPAGEID_WIKIPAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(wikiPageId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where wikiPageId = &#63;.
	 *
	 * @param wikiPageId the wiki page ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByWikiPageId_First(long wikiPageId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByWikiPageId_First(wikiPageId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("wikiPageId=");
		msg.append(wikiPageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where wikiPageId = &#63;.
	 *
	 * @param wikiPageId the wiki page ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByWikiPageId_First(long wikiPageId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByWikiPageId(wikiPageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where wikiPageId = &#63;.
	 *
	 * @param wikiPageId the wiki page ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByWikiPageId_Last(long wikiPageId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByWikiPageId_Last(wikiPageId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("wikiPageId=");
		msg.append(wikiPageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where wikiPageId = &#63;.
	 *
	 * @param wikiPageId the wiki page ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByWikiPageId_Last(long wikiPageId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByWikiPageId(wikiPageId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByWikiPageId(wikiPageId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry[] findByWikiPageId_PrevAndNext(long decisionEntryId,
		long wikiPageId, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = findByPrimaryKey(decisionEntryId);

		Session session = null;

		try {
			session = openSession();

			DecisionEntry[] array = new DecisionEntryImpl[3];

			array[0] = getByWikiPageId_PrevAndNext(session, decisionEntry,
					wikiPageId, orderByComparator, true);

			array[1] = decisionEntry;

			array[2] = getByWikiPageId_PrevAndNext(session, decisionEntry,
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

	protected DecisionEntry getByWikiPageId_PrevAndNext(Session session,
		DecisionEntry decisionEntry, long wikiPageId,
		OrderByComparator<DecisionEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_WIKIPAGEID_WIKIPAGEID_2);

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
			query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(wikiPageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(decisionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DecisionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the decision entries where wikiPageId = &#63; from the database.
	 *
	 * @param wikiPageId the wiki page ID
	 */
	@Override
	public void removeByWikiPageId(long wikiPageId) {
		for (DecisionEntry decisionEntry : findByWikiPageId(wikiPageId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where wikiPageId = &#63;.
	 *
	 * @param wikiPageId the wiki page ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByWikiPageId(long wikiPageId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WIKIPAGEID;

		Object[] finderArgs = new Object[] { wikiPageId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

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

	private static final String _FINDER_COLUMN_WIKIPAGEID_WIKIPAGEID_2 = "decisionEntry.wikiPageId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WIKIPAGENAME =
		new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByWikiPageName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WIKIPAGENAME =
		new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByWikiPageName", new String[] { String.class.getName() },
			DecisionEntryModelImpl.WIKIPAGENAME_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WIKIPAGENAME = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWikiPageName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the decision entries where wikiPageName = &#63;.
	 *
	 * @param wikiPageName the wiki page name
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByWikiPageName(String wikiPageName) {
		return findByWikiPageName(wikiPageName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<DecisionEntry> findByWikiPageName(String wikiPageName,
		int start, int end) {
		return findByWikiPageName(wikiPageName, start, end, null);
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
	@Override
	public List<DecisionEntry> findByWikiPageName(String wikiPageName,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByWikiPageName(wikiPageName, start, end, orderByComparator,
			true);
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
	@Override
	public List<DecisionEntry> findByWikiPageName(String wikiPageName,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WIKIPAGENAME;
			finderArgs = new Object[] { wikiPageName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WIKIPAGENAME;
			finderArgs = new Object[] {
					wikiPageName,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if (!Objects.equals(wikiPageName,
								decisionEntry.getWikiPageName())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			boolean bindWikiPageName = false;

			if (wikiPageName == null) {
				query.append(_FINDER_COLUMN_WIKIPAGENAME_WIKIPAGENAME_1);
			}
			else if (wikiPageName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_WIKIPAGENAME_WIKIPAGENAME_3);
			}
			else {
				bindWikiPageName = true;

				query.append(_FINDER_COLUMN_WIKIPAGENAME_WIKIPAGENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWikiPageName) {
					qPos.add(wikiPageName);
				}

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where wikiPageName = &#63;.
	 *
	 * @param wikiPageName the wiki page name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByWikiPageName_First(String wikiPageName,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByWikiPageName_First(wikiPageName,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("wikiPageName=");
		msg.append(wikiPageName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where wikiPageName = &#63;.
	 *
	 * @param wikiPageName the wiki page name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByWikiPageName_First(String wikiPageName,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByWikiPageName(wikiPageName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last decision entry in the ordered set where wikiPageName = &#63;.
	 *
	 * @param wikiPageName the wiki page name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByWikiPageName_Last(String wikiPageName,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByWikiPageName_Last(wikiPageName,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("wikiPageName=");
		msg.append(wikiPageName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where wikiPageName = &#63;.
	 *
	 * @param wikiPageName the wiki page name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByWikiPageName_Last(String wikiPageName,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByWikiPageName(wikiPageName);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByWikiPageName(wikiPageName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry[] findByWikiPageName_PrevAndNext(
		long decisionEntryId, String wikiPageName,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = findByPrimaryKey(decisionEntryId);

		Session session = null;

		try {
			session = openSession();

			DecisionEntry[] array = new DecisionEntryImpl[3];

			array[0] = getByWikiPageName_PrevAndNext(session, decisionEntry,
					wikiPageName, orderByComparator, true);

			array[1] = decisionEntry;

			array[2] = getByWikiPageName_PrevAndNext(session, decisionEntry,
					wikiPageName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DecisionEntry getByWikiPageName_PrevAndNext(Session session,
		DecisionEntry decisionEntry, String wikiPageName,
		OrderByComparator<DecisionEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

		boolean bindWikiPageName = false;

		if (wikiPageName == null) {
			query.append(_FINDER_COLUMN_WIKIPAGENAME_WIKIPAGENAME_1);
		}
		else if (wikiPageName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_WIKIPAGENAME_WIKIPAGENAME_3);
		}
		else {
			bindWikiPageName = true;

			query.append(_FINDER_COLUMN_WIKIPAGENAME_WIKIPAGENAME_2);
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
			query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindWikiPageName) {
			qPos.add(wikiPageName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(decisionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DecisionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the decision entries where wikiPageName = &#63; from the database.
	 *
	 * @param wikiPageName the wiki page name
	 */
	@Override
	public void removeByWikiPageName(String wikiPageName) {
		for (DecisionEntry decisionEntry : findByWikiPageName(wikiPageName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where wikiPageName = &#63;.
	 *
	 * @param wikiPageName the wiki page name
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByWikiPageName(String wikiPageName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WIKIPAGENAME;

		Object[] finderArgs = new Object[] { wikiPageName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			boolean bindWikiPageName = false;

			if (wikiPageName == null) {
				query.append(_FINDER_COLUMN_WIKIPAGENAME_WIKIPAGENAME_1);
			}
			else if (wikiPageName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_WIKIPAGENAME_WIKIPAGENAME_3);
			}
			else {
				bindWikiPageName = true;

				query.append(_FINDER_COLUMN_WIKIPAGENAME_WIKIPAGENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWikiPageName) {
					qPos.add(wikiPageName);
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

	private static final String _FINDER_COLUMN_WIKIPAGENAME_WIKIPAGENAME_1 = "decisionEntry.wikiPageName IS NULL";
	private static final String _FINDER_COLUMN_WIKIPAGENAME_WIKIPAGENAME_2 = "decisionEntry.wikiPageName = ?";
	private static final String _FINDER_COLUMN_WIKIPAGENAME_WIKIPAGENAME_3 = "(decisionEntry.wikiPageName IS NULL OR decisionEntry.wikiPageName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_H",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByC_H",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			DecisionEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.HANDLED_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_H",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the decision entries where companyId = &#63; and handled = &#63;.
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByC_H(long companyId, boolean handled) {
		return findByC_H(companyId, handled, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<DecisionEntry> findByC_H(long companyId, boolean handled,
		int start, int end) {
		return findByC_H(companyId, handled, start, end, null);
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
	@Override
	public List<DecisionEntry> findByC_H(long companyId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByC_H(companyId, handled, start, end, orderByComparator, true);
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
	@Override
	public List<DecisionEntry> findByC_H(long companyId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_H;
			finderArgs = new Object[] { companyId, handled };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_H;
			finderArgs = new Object[] {
					companyId, handled,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((companyId != decisionEntry.getCompanyId()) ||
							(handled != decisionEntry.getHandled())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_H_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_H_HANDLED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(handled);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where companyId = &#63; and handled = &#63;.
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByC_H_First(long companyId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByC_H_First(companyId, handled,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where companyId = &#63; and handled = &#63;.
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByC_H_First(long companyId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByC_H(companyId, handled, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry findByC_H_Last(long companyId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByC_H_Last(companyId, handled,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where companyId = &#63; and handled = &#63;.
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByC_H_Last(long companyId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByC_H(companyId, handled);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByC_H(companyId, handled, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry[] findByC_H_PrevAndNext(long decisionEntryId,
		long companyId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = findByPrimaryKey(decisionEntryId);

		Session session = null;

		try {
			session = openSession();

			DecisionEntry[] array = new DecisionEntryImpl[3];

			array[0] = getByC_H_PrevAndNext(session, decisionEntry, companyId,
					handled, orderByComparator, true);

			array[1] = decisionEntry;

			array[2] = getByC_H_PrevAndNext(session, decisionEntry, companyId,
					handled, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DecisionEntry getByC_H_PrevAndNext(Session session,
		DecisionEntry decisionEntry, long companyId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_C_H_COMPANYID_2);

		query.append(_FINDER_COLUMN_C_H_HANDLED_2);

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
			query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(handled);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(decisionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DecisionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the decision entries where companyId = &#63; and handled = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 */
	@Override
	public void removeByC_H(long companyId, boolean handled) {
		for (DecisionEntry decisionEntry : findByC_H(companyId, handled,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where companyId = &#63; and handled = &#63;.
	 *
	 * @param companyId the company ID
	 * @param handled the handled
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByC_H(long companyId, boolean handled) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_H;

		Object[] finderArgs = new Object[] { companyId, handled };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_H_COMPANYID_2);

			query.append(_FINDER_COLUMN_C_H_HANDLED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(handled);

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

	private static final String _FINDER_COLUMN_C_H_COMPANYID_2 = "decisionEntry.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_H_HANDLED_2 = "decisionEntry.handled = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByD_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByD_C",
			new String[] { Long.class.getName(), Long.class.getName() },
			DecisionEntryModelImpl.DECISIONENTRYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_C",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the decision entries where decisionEntryId = &#63; and companyId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param companyId the company ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_C(long decisionEntryId, long companyId) {
		return findByD_C(decisionEntryId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<DecisionEntry> findByD_C(long decisionEntryId, long companyId,
		int start, int end) {
		return findByD_C(decisionEntryId, companyId, start, end, null);
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
	@Override
	public List<DecisionEntry> findByD_C(long decisionEntryId, long companyId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByD_C(decisionEntryId, companyId, start, end,
			orderByComparator, true);
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
	@Override
	public List<DecisionEntry> findByD_C(long decisionEntryId, long companyId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_C;
			finderArgs = new Object[] { decisionEntryId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_C;
			finderArgs = new Object[] {
					decisionEntryId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((decisionEntryId != decisionEntry.getDecisionEntryId()) ||
							(companyId != decisionEntry.getCompanyId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_C_DECISIONENTRYID_2);

			query.append(_FINDER_COLUMN_D_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionEntryId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where decisionEntryId = &#63; and companyId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_C_First(long decisionEntryId, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_C_First(decisionEntryId,
				companyId, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionEntryId=");
		msg.append(decisionEntryId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where decisionEntryId = &#63; and companyId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_C_First(long decisionEntryId, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByD_C(decisionEntryId, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry findByD_C_Last(long decisionEntryId, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_C_Last(decisionEntryId,
				companyId, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionEntryId=");
		msg.append(decisionEntryId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionEntryId = &#63; and companyId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_C_Last(long decisionEntryId, long companyId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByD_C(decisionEntryId, companyId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByD_C(decisionEntryId, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the decision entries where decisionEntryId = &#63; and companyId = &#63; from the database.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByD_C(long decisionEntryId, long companyId) {
		for (DecisionEntry decisionEntry : findByD_C(decisionEntryId,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where decisionEntryId = &#63; and companyId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param companyId the company ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByD_C(long decisionEntryId, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_C;

		Object[] finderArgs = new Object[] { decisionEntryId, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_C_DECISIONENTRYID_2);

			query.append(_FINDER_COLUMN_D_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionEntryId);

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

	private static final String _FINDER_COLUMN_D_C_DECISIONENTRYID_2 = "decisionEntry.decisionEntryId = ? AND ";
	private static final String _FINDER_COLUMN_D_C_COMPANYID_2 = "decisionEntry.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByD_H",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByD_H",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			DecisionEntryModelImpl.DECISIONENTRYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.HANDLED_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_H",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the decision entries where decisionEntryId = &#63; and handled = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param handled the handled
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_H(long decisionEntryId, boolean handled) {
		return findByD_H(decisionEntryId, handled, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<DecisionEntry> findByD_H(long decisionEntryId, boolean handled,
		int start, int end) {
		return findByD_H(decisionEntryId, handled, start, end, null);
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
	@Override
	public List<DecisionEntry> findByD_H(long decisionEntryId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByD_H(decisionEntryId, handled, start, end,
			orderByComparator, true);
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
	@Override
	public List<DecisionEntry> findByD_H(long decisionEntryId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_H;
			finderArgs = new Object[] { decisionEntryId, handled };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_H;
			finderArgs = new Object[] {
					decisionEntryId, handled,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((decisionEntryId != decisionEntry.getDecisionEntryId()) ||
							(handled != decisionEntry.getHandled())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_H_DECISIONENTRYID_2);

			query.append(_FINDER_COLUMN_D_H_HANDLED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionEntryId);

				qPos.add(handled);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where decisionEntryId = &#63; and handled = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_H_First(long decisionEntryId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_H_First(decisionEntryId,
				handled, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionEntryId=");
		msg.append(decisionEntryId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where decisionEntryId = &#63; and handled = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_H_First(long decisionEntryId,
		boolean handled, OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByD_H(decisionEntryId, handled, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry findByD_H_Last(long decisionEntryId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_H_Last(decisionEntryId, handled,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionEntryId=");
		msg.append(decisionEntryId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionEntryId = &#63; and handled = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_H_Last(long decisionEntryId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByD_H(decisionEntryId, handled);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByD_H(decisionEntryId, handled,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the decision entries where decisionEntryId = &#63; and handled = &#63; from the database.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param handled the handled
	 */
	@Override
	public void removeByD_H(long decisionEntryId, boolean handled) {
		for (DecisionEntry decisionEntry : findByD_H(decisionEntryId, handled,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where decisionEntryId = &#63; and handled = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param handled the handled
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByD_H(long decisionEntryId, boolean handled) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_H;

		Object[] finderArgs = new Object[] { decisionEntryId, handled };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_H_DECISIONENTRYID_2);

			query.append(_FINDER_COLUMN_D_H_HANDLED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionEntryId);

				qPos.add(handled);

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

	private static final String _FINDER_COLUMN_D_H_DECISIONENTRYID_2 = "decisionEntry.decisionEntryId = ? AND ";
	private static final String _FINDER_COLUMN_D_H_HANDLED_2 = "decisionEntry.handled = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_U = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByD_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByD_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			DecisionEntryModelImpl.DECISIONENTRYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.USERID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_U = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_U",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the decision entries where decisionEntryId = &#63; and userId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param userId the user ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_U(long decisionEntryId, long userId) {
		return findByD_U(decisionEntryId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<DecisionEntry> findByD_U(long decisionEntryId, long userId,
		int start, int end) {
		return findByD_U(decisionEntryId, userId, start, end, null);
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
	@Override
	public List<DecisionEntry> findByD_U(long decisionEntryId, long userId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByD_U(decisionEntryId, userId, start, end,
			orderByComparator, true);
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
	@Override
	public List<DecisionEntry> findByD_U(long decisionEntryId, long userId,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U;
			finderArgs = new Object[] { decisionEntryId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_U;
			finderArgs = new Object[] {
					decisionEntryId, userId,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((decisionEntryId != decisionEntry.getDecisionEntryId()) ||
							(userId != decisionEntry.getUserId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_U_DECISIONENTRYID_2);

			query.append(_FINDER_COLUMN_D_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionEntryId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_U_First(long decisionEntryId, long userId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_U_First(decisionEntryId, userId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionEntryId=");
		msg.append(decisionEntryId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_U_First(long decisionEntryId, long userId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByD_U(decisionEntryId, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry findByD_U_Last(long decisionEntryId, long userId,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_U_Last(decisionEntryId, userId,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionEntryId=");
		msg.append(decisionEntryId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByD_U_Last(long decisionEntryId, long userId,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByD_U(decisionEntryId, userId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByD_U(decisionEntryId, userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the decision entries where decisionEntryId = &#63; and userId = &#63; from the database.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByD_U(long decisionEntryId, long userId) {
		for (DecisionEntry decisionEntry : findByD_U(decisionEntryId, userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where decisionEntryId = &#63; and userId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param userId the user ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByD_U(long decisionEntryId, long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_U;

		Object[] finderArgs = new Object[] { decisionEntryId, userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_U_DECISIONENTRYID_2);

			query.append(_FINDER_COLUMN_D_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionEntryId);

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

	private static final String _FINDER_COLUMN_D_U_DECISIONENTRYID_2 = "decisionEntry.decisionEntryId = ? AND ";
	private static final String _FINDER_COLUMN_D_U_USERID_2 = "decisionEntry.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_U_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByD_U_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByD_U_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			DecisionEntryModelImpl.DECISIONENTRYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.USERID_COLUMN_BITMASK |
			DecisionEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_U_C = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_U_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the decision entries where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByD_U_C(long decisionEntryId, long userId,
		long companyId) {
		return findByD_U_C(decisionEntryId, userId, companyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DecisionEntry> findByD_U_C(long decisionEntryId, long userId,
		long companyId, int start, int end) {
		return findByD_U_C(decisionEntryId, userId, companyId, start, end, null);
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
	@Override
	public List<DecisionEntry> findByD_U_C(long decisionEntryId, long userId,
		long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return findByD_U_C(decisionEntryId, userId, companyId, start, end,
			orderByComparator, true);
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
	@Override
	public List<DecisionEntry> findByD_U_C(long decisionEntryId, long userId,
		long companyId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U_C;
			finderArgs = new Object[] { decisionEntryId, userId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_U_C;
			finderArgs = new Object[] {
					decisionEntryId, userId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((decisionEntryId != decisionEntry.getDecisionEntryId()) ||
							(userId != decisionEntry.getUserId()) ||
							(companyId != decisionEntry.getCompanyId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_U_C_DECISIONENTRYID_2);

			query.append(_FINDER_COLUMN_D_U_C_USERID_2);

			query.append(_FINDER_COLUMN_D_U_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionEntryId);

				qPos.add(userId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByD_U_C_First(long decisionEntryId, long userId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_U_C_First(decisionEntryId,
				userId, companyId, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionEntryId=");
		msg.append(decisionEntryId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
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
	@Override
	public DecisionEntry fetchByD_U_C_First(long decisionEntryId, long userId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByD_U_C(decisionEntryId, userId,
				companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry findByD_U_C_Last(long decisionEntryId, long userId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByD_U_C_Last(decisionEntryId,
				userId, companyId, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("decisionEntryId=");
		msg.append(decisionEntryId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
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
	@Override
	public DecisionEntry fetchByD_U_C_Last(long decisionEntryId, long userId,
		long companyId, OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByD_U_C(decisionEntryId, userId, companyId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByD_U_C(decisionEntryId, userId,
				companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the decision entries where decisionEntryId = &#63; and userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByD_U_C(long decisionEntryId, long userId, long companyId) {
		for (DecisionEntry decisionEntry : findByD_U_C(decisionEntryId, userId,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where decisionEntryId = &#63; and userId = &#63; and companyId = &#63;.
	 *
	 * @param decisionEntryId the decision entry ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByD_U_C(long decisionEntryId, long userId, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_U_C;

		Object[] finderArgs = new Object[] { decisionEntryId, userId, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_D_U_C_DECISIONENTRYID_2);

			query.append(_FINDER_COLUMN_D_U_C_USERID_2);

			query.append(_FINDER_COLUMN_D_U_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(decisionEntryId);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_D_U_C_DECISIONENTRYID_2 = "decisionEntry.decisionEntryId = ? AND ";
	private static final String _FINDER_COLUMN_D_U_C_USERID_2 = "decisionEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_D_U_C_COMPANYID_2 = "decisionEntry.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByU_H",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByU_H",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			DecisionEntryModelImpl.USERID_COLUMN_BITMASK |
			DecisionEntryModelImpl.HANDLED_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_H = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_H",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the decision entries where userId = &#63; and handled = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByU_H(long userId, boolean handled) {
		return findByU_H(userId, handled, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<DecisionEntry> findByU_H(long userId, boolean handled,
		int start, int end) {
		return findByU_H(userId, handled, start, end, null);
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
	@Override
	public List<DecisionEntry> findByU_H(long userId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator) {
		return findByU_H(userId, handled, start, end, orderByComparator, true);
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
	@Override
	public List<DecisionEntry> findByU_H(long userId, boolean handled,
		int start, int end, OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H;
			finderArgs = new Object[] { userId, handled };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_H;
			finderArgs = new Object[] {
					userId, handled,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((userId != decisionEntry.getUserId()) ||
							(handled != decisionEntry.getHandled())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_H_USERID_2);

			query.append(_FINDER_COLUMN_U_H_HANDLED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(handled);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByU_H_First(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByU_H_First(userId, handled,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByU_H_First(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByU_H(userId, handled, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry findByU_H_Last(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByU_H_Last(userId, handled,
				orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last decision entry in the ordered set where userId = &#63; and handled = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching decision entry, or <code>null</code> if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry fetchByU_H_Last(long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByU_H(userId, handled);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByU_H(userId, handled, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry[] findByU_H_PrevAndNext(long decisionEntryId,
		long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = findByPrimaryKey(decisionEntryId);

		Session session = null;

		try {
			session = openSession();

			DecisionEntry[] array = new DecisionEntryImpl[3];

			array[0] = getByU_H_PrevAndNext(session, decisionEntry, userId,
					handled, orderByComparator, true);

			array[1] = decisionEntry;

			array[2] = getByU_H_PrevAndNext(session, decisionEntry, userId,
					handled, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DecisionEntry getByU_H_PrevAndNext(Session session,
		DecisionEntry decisionEntry, long userId, boolean handled,
		OrderByComparator<DecisionEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_U_H_USERID_2);

		query.append(_FINDER_COLUMN_U_H_HANDLED_2);

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
			query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(handled);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(decisionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DecisionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the decision entries where userId = &#63; and handled = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 */
	@Override
	public void removeByU_H(long userId, boolean handled) {
		for (DecisionEntry decisionEntry : findByU_H(userId, handled,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where userId = &#63; and handled = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByU_H(long userId, boolean handled) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_H;

		Object[] finderArgs = new Object[] { userId, handled };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_H_USERID_2);

			query.append(_FINDER_COLUMN_U_H_HANDLED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(handled);

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

	private static final String _FINDER_COLUMN_U_H_USERID_2 = "decisionEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_H_HANDLED_2 = "decisionEntry.handled = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_H_D = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByU_H_D",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H_D = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED,
			DecisionEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByU_H_D",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			},
			DecisionEntryModelImpl.USERID_COLUMN_BITMASK |
			DecisionEntryModelImpl.HANDLED_COLUMN_BITMASK |
			DecisionEntryModelImpl.DECISIONENTRYID_COLUMN_BITMASK |
			DecisionEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_H_D = new FinderPath(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_H_D",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the decision entries where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param decisionEntryId the decision entry ID
	 * @return the matching decision entries
	 */
	@Override
	public List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionEntryId) {
		return findByU_H_D(userId, handled, decisionEntryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionEntryId, int start, int end) {
		return findByU_H_D(userId, handled, decisionEntryId, start, end, null);
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
	@Override
	public List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionEntryId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return findByU_H_D(userId, handled, decisionEntryId, start, end,
			orderByComparator, true);
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
	@Override
	public List<DecisionEntry> findByU_H_D(long userId, boolean handled,
		long decisionEntryId, int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H_D;
			finderArgs = new Object[] { userId, handled, decisionEntryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_H_D;
			finderArgs = new Object[] {
					userId, handled, decisionEntryId,
					
					start, end, orderByComparator
				};
		}

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DecisionEntry decisionEntry : list) {
					if ((userId != decisionEntry.getUserId()) ||
							(handled != decisionEntry.getHandled()) ||
							(decisionEntryId != decisionEntry.getDecisionEntryId())) {
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

			query.append(_SQL_SELECT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_H_D_USERID_2);

			query.append(_FINDER_COLUMN_U_H_D_HANDLED_2);

			query.append(_FINDER_COLUMN_U_H_D_DECISIONENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DecisionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(handled);

				qPos.add(decisionEntryId);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first decision entry in the ordered set where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param decisionEntryId the decision entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching decision entry
	 * @throws NoSuchEntryException if a matching decision entry could not be found
	 */
	@Override
	public DecisionEntry findByU_H_D_First(long userId, boolean handled,
		long decisionEntryId, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByU_H_D_First(userId, handled,
				decisionEntryId, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(", decisionEntryId=");
		msg.append(decisionEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
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
	@Override
	public DecisionEntry fetchByU_H_D_First(long userId, boolean handled,
		long decisionEntryId, OrderByComparator<DecisionEntry> orderByComparator) {
		List<DecisionEntry> list = findByU_H_D(userId, handled,
				decisionEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DecisionEntry findByU_H_D_Last(long userId, boolean handled,
		long decisionEntryId, OrderByComparator<DecisionEntry> orderByComparator)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByU_H_D_Last(userId, handled,
				decisionEntryId, orderByComparator);

		if (decisionEntry != null) {
			return decisionEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", handled=");
		msg.append(handled);

		msg.append(", decisionEntryId=");
		msg.append(decisionEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
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
	@Override
	public DecisionEntry fetchByU_H_D_Last(long userId, boolean handled,
		long decisionEntryId, OrderByComparator<DecisionEntry> orderByComparator) {
		int count = countByU_H_D(userId, handled, decisionEntryId);

		if (count == 0) {
			return null;
		}

		List<DecisionEntry> list = findByU_H_D(userId, handled,
				decisionEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the decision entries where userId = &#63; and handled = &#63; and decisionEntryId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param decisionEntryId the decision entry ID
	 */
	@Override
	public void removeByU_H_D(long userId, boolean handled, long decisionEntryId) {
		for (DecisionEntry decisionEntry : findByU_H_D(userId, handled,
				decisionEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries where userId = &#63; and handled = &#63; and decisionEntryId = &#63;.
	 *
	 * @param userId the user ID
	 * @param handled the handled
	 * @param decisionEntryId the decision entry ID
	 * @return the number of matching decision entries
	 */
	@Override
	public int countByU_H_D(long userId, boolean handled, long decisionEntryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_H_D;

		Object[] finderArgs = new Object[] { userId, handled, decisionEntryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_DECISIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_H_D_USERID_2);

			query.append(_FINDER_COLUMN_U_H_D_HANDLED_2);

			query.append(_FINDER_COLUMN_U_H_D_DECISIONENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(handled);

				qPos.add(decisionEntryId);

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

	private static final String _FINDER_COLUMN_U_H_D_USERID_2 = "decisionEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_H_D_HANDLED_2 = "decisionEntry.handled = ? AND ";
	private static final String _FINDER_COLUMN_U_H_D_DECISIONENTRYID_2 = "decisionEntry.decisionEntryId = ?";

	public DecisionEntryPersistenceImpl() {
		setModelClass(DecisionEntry.class);
	}

	/**
	 * Caches the decision entry in the entity cache if it is enabled.
	 *
	 * @param decisionEntry the decision entry
	 */
	@Override
	public void cacheResult(DecisionEntry decisionEntry) {
		entityCache.putResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryImpl.class, decisionEntry.getPrimaryKey(),
			decisionEntry);

		decisionEntry.resetOriginalValues();
	}

	/**
	 * Caches the decision entries in the entity cache if it is enabled.
	 *
	 * @param decisionEntries the decision entries
	 */
	@Override
	public void cacheResult(List<DecisionEntry> decisionEntries) {
		for (DecisionEntry decisionEntry : decisionEntries) {
			if (entityCache.getResult(
						DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
						DecisionEntryImpl.class, decisionEntry.getPrimaryKey()) == null) {
				cacheResult(decisionEntry);
			}
			else {
				decisionEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all decision entries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DecisionEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the decision entry.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DecisionEntry decisionEntry) {
		entityCache.removeResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryImpl.class, decisionEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DecisionEntry> decisionEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DecisionEntry decisionEntry : decisionEntries) {
			entityCache.removeResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
				DecisionEntryImpl.class, decisionEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new decision entry with the primary key. Does not add the decision entry to the database.
	 *
	 * @param decisionEntryId the primary key for the new decision entry
	 * @return the new decision entry
	 */
	@Override
	public DecisionEntry create(long decisionEntryId) {
		DecisionEntry decisionEntry = new DecisionEntryImpl();

		decisionEntry.setNew(true);
		decisionEntry.setPrimaryKey(decisionEntryId);

		String uuid = PortalUUIDUtil.generate();

		decisionEntry.setUuid(uuid);

		decisionEntry.setCompanyId(companyProvider.getCompanyId());

		return decisionEntry;
	}

	/**
	 * Removes the decision entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param decisionEntryId the primary key of the decision entry
	 * @return the decision entry that was removed
	 * @throws NoSuchEntryException if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry remove(long decisionEntryId)
		throws NoSuchEntryException {
		return remove((Serializable)decisionEntryId);
	}

	/**
	 * Removes the decision entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the decision entry
	 * @return the decision entry that was removed
	 * @throws NoSuchEntryException if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry remove(Serializable primaryKey)
		throws NoSuchEntryException {
		Session session = null;

		try {
			session = openSession();

			DecisionEntry decisionEntry = (DecisionEntry)session.get(DecisionEntryImpl.class,
					primaryKey);

			if (decisionEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(decisionEntry);
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
	protected DecisionEntry removeImpl(DecisionEntry decisionEntry) {
		decisionEntry = toUnwrappedModel(decisionEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(decisionEntry)) {
				decisionEntry = (DecisionEntry)session.get(DecisionEntryImpl.class,
						decisionEntry.getPrimaryKeyObj());
			}

			if (decisionEntry != null) {
				session.delete(decisionEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (decisionEntry != null) {
			clearCache(decisionEntry);
		}

		return decisionEntry;
	}

	@Override
	public DecisionEntry updateImpl(DecisionEntry decisionEntry) {
		decisionEntry = toUnwrappedModel(decisionEntry);

		boolean isNew = decisionEntry.isNew();

		DecisionEntryModelImpl decisionEntryModelImpl = (DecisionEntryModelImpl)decisionEntry;

		if (Validator.isNull(decisionEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			decisionEntry.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (decisionEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				decisionEntry.setCreateDate(now);
			}
			else {
				decisionEntry.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!decisionEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				decisionEntry.setModifiedDate(now);
			}
			else {
				decisionEntry.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (decisionEntry.isNew()) {
				session.save(decisionEntry);

				decisionEntry.setNew(false);
			}
			else {
				decisionEntry = (DecisionEntry)session.merge(decisionEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DecisionEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { decisionEntryModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalUuid(),
						decisionEntryModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getUuid(),
						decisionEntryModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { decisionEntryModelImpl.getCompanyId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECISIONENTRYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalDecisionEntryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DECISIONENTRYID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECISIONENTRYID,
					args);

				args = new Object[] { decisionEntryModelImpl.getDecisionEntryId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DECISIONENTRYID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECISIONENTRYID,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OUTCOME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalOutcome()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_OUTCOME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OUTCOME,
					args);

				args = new Object[] { decisionEntryModelImpl.getOutcome() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_OUTCOME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OUTCOME,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WIKIPAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalWikiPageId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_WIKIPAGEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WIKIPAGEID,
					args);

				args = new Object[] { decisionEntryModelImpl.getWikiPageId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_WIKIPAGEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WIKIPAGEID,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WIKIPAGENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalWikiPageName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_WIKIPAGENAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WIKIPAGENAME,
					args);

				args = new Object[] { decisionEntryModelImpl.getWikiPageName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_WIKIPAGENAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WIKIPAGENAME,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_H.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalCompanyId(),
						decisionEntryModelImpl.getOriginalHandled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_H, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_H,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getCompanyId(),
						decisionEntryModelImpl.getHandled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_H, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_H,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalDecisionEntryId(),
						decisionEntryModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_C,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getDecisionEntryId(),
						decisionEntryModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_C,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_H.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalDecisionEntryId(),
						decisionEntryModelImpl.getOriginalHandled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_H, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_H,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getDecisionEntryId(),
						decisionEntryModelImpl.getHandled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_H, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_H,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalDecisionEntryId(),
						decisionEntryModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getDecisionEntryId(),
						decisionEntryModelImpl.getUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalDecisionEntryId(),
						decisionEntryModelImpl.getOriginalUserId(),
						decisionEntryModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_U_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U_C,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getDecisionEntryId(),
						decisionEntryModelImpl.getUserId(),
						decisionEntryModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_D_U_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_U_C,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalUserId(),
						decisionEntryModelImpl.getOriginalHandled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_H, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getUserId(),
						decisionEntryModelImpl.getHandled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_H, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H,
					args);
			}

			if ((decisionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H_D.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						decisionEntryModelImpl.getOriginalUserId(),
						decisionEntryModelImpl.getOriginalHandled(),
						decisionEntryModelImpl.getOriginalDecisionEntryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_H_D, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H_D,
					args);

				args = new Object[] {
						decisionEntryModelImpl.getUserId(),
						decisionEntryModelImpl.getHandled(),
						decisionEntryModelImpl.getDecisionEntryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_H_D, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_H_D,
					args);
			}
		}

		entityCache.putResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
			DecisionEntryImpl.class, decisionEntry.getPrimaryKey(),
			decisionEntry, false);

		decisionEntry.resetOriginalValues();

		return decisionEntry;
	}

	protected DecisionEntry toUnwrappedModel(DecisionEntry decisionEntry) {
		if (decisionEntry instanceof DecisionEntryImpl) {
			return decisionEntry;
		}

		DecisionEntryImpl decisionEntryImpl = new DecisionEntryImpl();

		decisionEntryImpl.setNew(decisionEntry.isNew());
		decisionEntryImpl.setPrimaryKey(decisionEntry.getPrimaryKey());

		decisionEntryImpl.setUuid(decisionEntry.getUuid());
		decisionEntryImpl.setDecisionEntryId(decisionEntry.getDecisionEntryId());
		decisionEntryImpl.setCompanyId(decisionEntry.getCompanyId());
		decisionEntryImpl.setUserId(decisionEntry.getUserId());
		decisionEntryImpl.setUserName(decisionEntry.getUserName());
		decisionEntryImpl.setCreateDate(decisionEntry.getCreateDate());
		decisionEntryImpl.setModifiedDate(decisionEntry.getModifiedDate());
		decisionEntryImpl.setAnalysisData(decisionEntry.getAnalysisData());
		decisionEntryImpl.setWikiPageId(decisionEntry.getWikiPageId());
		decisionEntryImpl.setWikiPageName(decisionEntry.getWikiPageName());
		decisionEntryImpl.setOutcome(decisionEntry.getOutcome());
		decisionEntryImpl.setHandled(decisionEntry.isHandled());

		return decisionEntryImpl;
	}

	/**
	 * Returns the decision entry with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the decision entry
	 * @return the decision entry
	 * @throws NoSuchEntryException if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEntryException {
		DecisionEntry decisionEntry = fetchByPrimaryKey(primaryKey);

		if (decisionEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return decisionEntry;
	}

	/**
	 * Returns the decision entry with the primary key or throws a {@link NoSuchEntryException} if it could not be found.
	 *
	 * @param decisionEntryId the primary key of the decision entry
	 * @return the decision entry
	 * @throws NoSuchEntryException if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry findByPrimaryKey(long decisionEntryId)
		throws NoSuchEntryException {
		return findByPrimaryKey((Serializable)decisionEntryId);
	}

	/**
	 * Returns the decision entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the decision entry
	 * @return the decision entry, or <code>null</code> if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
				DecisionEntryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DecisionEntry decisionEntry = (DecisionEntry)serializable;

		if (decisionEntry == null) {
			Session session = null;

			try {
				session = openSession();

				decisionEntry = (DecisionEntry)session.get(DecisionEntryImpl.class,
						primaryKey);

				if (decisionEntry != null) {
					cacheResult(decisionEntry);
				}
				else {
					entityCache.putResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
						DecisionEntryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
					DecisionEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return decisionEntry;
	}

	/**
	 * Returns the decision entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param decisionEntryId the primary key of the decision entry
	 * @return the decision entry, or <code>null</code> if a decision entry with the primary key could not be found
	 */
	@Override
	public DecisionEntry fetchByPrimaryKey(long decisionEntryId) {
		return fetchByPrimaryKey((Serializable)decisionEntryId);
	}

	@Override
	public Map<Serializable, DecisionEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DecisionEntry> map = new HashMap<Serializable, DecisionEntry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DecisionEntry decisionEntry = fetchByPrimaryKey(primaryKey);

			if (decisionEntry != null) {
				map.put(primaryKey, decisionEntry);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
					DecisionEntryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DecisionEntry)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DECISIONENTRY_WHERE_PKS_IN);

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

			for (DecisionEntry decisionEntry : (List<DecisionEntry>)q.list()) {
				map.put(decisionEntry.getPrimaryKeyObj(), decisionEntry);

				cacheResult(decisionEntry);

				uncachedPrimaryKeys.remove(decisionEntry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DecisionEntryModelImpl.ENTITY_CACHE_ENABLED,
					DecisionEntryImpl.class, primaryKey, nullModel);
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
	 * Returns all the decision entries.
	 *
	 * @return the decision entries
	 */
	@Override
	public List<DecisionEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DecisionEntry> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<DecisionEntry> findAll(int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<DecisionEntry> findAll(int start, int end,
		OrderByComparator<DecisionEntry> orderByComparator,
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

		List<DecisionEntry> list = null;

		if (retrieveFromCache) {
			list = (List<DecisionEntry>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DECISIONENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DECISIONENTRY;

				if (pagination) {
					sql = sql.concat(DecisionEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DecisionEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the decision entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DecisionEntry decisionEntry : findAll()) {
			remove(decisionEntry);
		}
	}

	/**
	 * Returns the number of decision entries.
	 *
	 * @return the number of decision entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DECISIONENTRY);

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
		return DecisionEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the decision entry persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DecisionEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_DECISIONENTRY = "SELECT decisionEntry FROM DecisionEntry decisionEntry";
	private static final String _SQL_SELECT_DECISIONENTRY_WHERE_PKS_IN = "SELECT decisionEntry FROM DecisionEntry decisionEntry WHERE decisionEntryId IN (";
	private static final String _SQL_SELECT_DECISIONENTRY_WHERE = "SELECT decisionEntry FROM DecisionEntry decisionEntry WHERE ";
	private static final String _SQL_COUNT_DECISIONENTRY = "SELECT COUNT(decisionEntry) FROM DecisionEntry decisionEntry";
	private static final String _SQL_COUNT_DECISIONENTRY_WHERE = "SELECT COUNT(decisionEntry) FROM DecisionEntry decisionEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "decisionEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DecisionEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DecisionEntry exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DecisionEntryPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}