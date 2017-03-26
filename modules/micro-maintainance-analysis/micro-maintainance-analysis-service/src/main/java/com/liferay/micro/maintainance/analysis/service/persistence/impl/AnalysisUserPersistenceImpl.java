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

package com.liferay.micro.maintainance.analysis.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.analysis.exception.NoSuchUserException;
import com.liferay.micro.maintainance.analysis.model.AnalysisUser;
import com.liferay.micro.maintainance.analysis.model.impl.AnalysisUserImpl;
import com.liferay.micro.maintainance.analysis.model.impl.AnalysisUserModelImpl;
import com.liferay.micro.maintainance.analysis.service.persistence.AnalysisUserPersistence;

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
 * The persistence implementation for the analysis user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisUserPersistence
 * @see com.liferay.micro.maintainance.analysis.service.persistence.AnalysisUserUtil
 * @generated
 */
@ProviderType
public class AnalysisUserPersistenceImpl extends BasePersistenceImpl<AnalysisUser>
	implements AnalysisUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnalysisUserUtil} to access the analysis user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnalysisUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, AnalysisUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, AnalysisUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, AnalysisUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, AnalysisUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			AnalysisUserModelImpl.UUID_COLUMN_BITMASK |
			AnalysisUserModelImpl.USERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the analysis users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching analysis users
	 */
	@Override
	public List<AnalysisUser> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AnalysisUser> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<AnalysisUser> findByUuid(String uuid, int start, int end,
		OrderByComparator<AnalysisUser> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<AnalysisUser> findByUuid(String uuid, int start, int end,
		OrderByComparator<AnalysisUser> orderByComparator,
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

		List<AnalysisUser> list = null;

		if (retrieveFromCache) {
			list = (List<AnalysisUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalysisUser analysisUser : list) {
					if (!Objects.equals(uuid, analysisUser.getUuid())) {
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

			query.append(_SQL_SELECT_ANALYSISUSER_WHERE);

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
				query.append(AnalysisUserModelImpl.ORDER_BY_JPQL);
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
					list = (List<AnalysisUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalysisUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first analysis user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analysis user
	 * @throws NoSuchUserException if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser findByUuid_First(String uuid,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException {
		AnalysisUser analysisUser = fetchByUuid_First(uuid, orderByComparator);

		if (analysisUser != null) {
			return analysisUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the first analysis user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analysis user, or <code>null</code> if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser fetchByUuid_First(String uuid,
		OrderByComparator<AnalysisUser> orderByComparator) {
		List<AnalysisUser> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analysis user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analysis user
	 * @throws NoSuchUserException if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser findByUuid_Last(String uuid,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException {
		AnalysisUser analysisUser = fetchByUuid_Last(uuid, orderByComparator);

		if (analysisUser != null) {
			return analysisUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the last analysis user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analysis user, or <code>null</code> if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser fetchByUuid_Last(String uuid,
		OrderByComparator<AnalysisUser> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AnalysisUser> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AnalysisUser[] findByUuid_PrevAndNext(long analysisUserId,
		String uuid, OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException {
		AnalysisUser analysisUser = findByPrimaryKey(analysisUserId);

		Session session = null;

		try {
			session = openSession();

			AnalysisUser[] array = new AnalysisUserImpl[3];

			array[0] = getByUuid_PrevAndNext(session, analysisUser, uuid,
					orderByComparator, true);

			array[1] = analysisUser;

			array[2] = getByUuid_PrevAndNext(session, analysisUser, uuid,
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

	protected AnalysisUser getByUuid_PrevAndNext(Session session,
		AnalysisUser analysisUser, String uuid,
		OrderByComparator<AnalysisUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANALYSISUSER_WHERE);

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
			query.append(AnalysisUserModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(analysisUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalysisUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analysis users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AnalysisUser analysisUser : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(analysisUser);
		}
	}

	/**
	 * Returns the number of analysis users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching analysis users
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANALYSISUSER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "analysisUser.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "analysisUser.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(analysisUser.uuid IS NULL OR analysisUser.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ANALYSISENTRYID =
		new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, AnalysisUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAnalysisEntryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANALYSISENTRYID =
		new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, AnalysisUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAnalysisEntryId",
			new String[] { Long.class.getName() },
			AnalysisUserModelImpl.ANALYSISENTRYID_COLUMN_BITMASK |
			AnalysisUserModelImpl.USERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ANALYSISENTRYID = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAnalysisEntryId", new String[] { Long.class.getName() });

	/**
	 * Returns all the analysis users where analysisEntryId = &#63;.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @return the matching analysis users
	 */
	@Override
	public List<AnalysisUser> findByAnalysisEntryId(long analysisEntryId) {
		return findByAnalysisEntryId(analysisEntryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<AnalysisUser> findByAnalysisEntryId(long analysisEntryId,
		int start, int end) {
		return findByAnalysisEntryId(analysisEntryId, start, end, null);
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
	@Override
	public List<AnalysisUser> findByAnalysisEntryId(long analysisEntryId,
		int start, int end, OrderByComparator<AnalysisUser> orderByComparator) {
		return findByAnalysisEntryId(analysisEntryId, start, end,
			orderByComparator, true);
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
	@Override
	public List<AnalysisUser> findByAnalysisEntryId(long analysisEntryId,
		int start, int end, OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANALYSISENTRYID;
			finderArgs = new Object[] { analysisEntryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ANALYSISENTRYID;
			finderArgs = new Object[] {
					analysisEntryId,
					
					start, end, orderByComparator
				};
		}

		List<AnalysisUser> list = null;

		if (retrieveFromCache) {
			list = (List<AnalysisUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalysisUser analysisUser : list) {
					if ((analysisEntryId != analysisUser.getAnalysisEntryId())) {
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

			query.append(_SQL_SELECT_ANALYSISUSER_WHERE);

			query.append(_FINDER_COLUMN_ANALYSISENTRYID_ANALYSISENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalysisUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(analysisEntryId);

				if (!pagination) {
					list = (List<AnalysisUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalysisUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first analysis user in the ordered set where analysisEntryId = &#63;.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analysis user
	 * @throws NoSuchUserException if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser findByAnalysisEntryId_First(long analysisEntryId,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException {
		AnalysisUser analysisUser = fetchByAnalysisEntryId_First(analysisEntryId,
				orderByComparator);

		if (analysisUser != null) {
			return analysisUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("analysisEntryId=");
		msg.append(analysisEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the first analysis user in the ordered set where analysisEntryId = &#63;.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analysis user, or <code>null</code> if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser fetchByAnalysisEntryId_First(long analysisEntryId,
		OrderByComparator<AnalysisUser> orderByComparator) {
		List<AnalysisUser> list = findByAnalysisEntryId(analysisEntryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analysis user in the ordered set where analysisEntryId = &#63;.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analysis user
	 * @throws NoSuchUserException if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser findByAnalysisEntryId_Last(long analysisEntryId,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException {
		AnalysisUser analysisUser = fetchByAnalysisEntryId_Last(analysisEntryId,
				orderByComparator);

		if (analysisUser != null) {
			return analysisUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("analysisEntryId=");
		msg.append(analysisEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the last analysis user in the ordered set where analysisEntryId = &#63;.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analysis user, or <code>null</code> if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser fetchByAnalysisEntryId_Last(long analysisEntryId,
		OrderByComparator<AnalysisUser> orderByComparator) {
		int count = countByAnalysisEntryId(analysisEntryId);

		if (count == 0) {
			return null;
		}

		List<AnalysisUser> list = findByAnalysisEntryId(analysisEntryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AnalysisUser[] findByAnalysisEntryId_PrevAndNext(
		long analysisUserId, long analysisEntryId,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException {
		AnalysisUser analysisUser = findByPrimaryKey(analysisUserId);

		Session session = null;

		try {
			session = openSession();

			AnalysisUser[] array = new AnalysisUserImpl[3];

			array[0] = getByAnalysisEntryId_PrevAndNext(session, analysisUser,
					analysisEntryId, orderByComparator, true);

			array[1] = analysisUser;

			array[2] = getByAnalysisEntryId_PrevAndNext(session, analysisUser,
					analysisEntryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnalysisUser getByAnalysisEntryId_PrevAndNext(Session session,
		AnalysisUser analysisUser, long analysisEntryId,
		OrderByComparator<AnalysisUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANALYSISUSER_WHERE);

		query.append(_FINDER_COLUMN_ANALYSISENTRYID_ANALYSISENTRYID_2);

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
			query.append(AnalysisUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(analysisEntryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(analysisUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalysisUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analysis users where analysisEntryId = &#63; from the database.
	 *
	 * @param analysisEntryId the analysis entry ID
	 */
	@Override
	public void removeByAnalysisEntryId(long analysisEntryId) {
		for (AnalysisUser analysisUser : findByAnalysisEntryId(
				analysisEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(analysisUser);
		}
	}

	/**
	 * Returns the number of analysis users where analysisEntryId = &#63;.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @return the number of matching analysis users
	 */
	@Override
	public int countByAnalysisEntryId(long analysisEntryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ANALYSISENTRYID;

		Object[] finderArgs = new Object[] { analysisEntryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANALYSISUSER_WHERE);

			query.append(_FINDER_COLUMN_ANALYSISENTRYID_ANALYSISENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(analysisEntryId);

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

	private static final String _FINDER_COLUMN_ANALYSISENTRYID_ANALYSISENTRYID_2 =
		"analysisUser.analysisEntryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, AnalysisUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, AnalysisUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			AnalysisUserModelImpl.USERID_COLUMN_BITMASK |
			AnalysisUserModelImpl.USERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the analysis users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching analysis users
	 */
	@Override
	public List<AnalysisUser> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AnalysisUser> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<AnalysisUser> findByUserId(long userId, int start, int end,
		OrderByComparator<AnalysisUser> orderByComparator) {
		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<AnalysisUser> findByUserId(long userId, int start, int end,
		OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<AnalysisUser> list = null;

		if (retrieveFromCache) {
			list = (List<AnalysisUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalysisUser analysisUser : list) {
					if ((userId != analysisUser.getUserId())) {
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

			query.append(_SQL_SELECT_ANALYSISUSER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalysisUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<AnalysisUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalysisUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first analysis user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analysis user
	 * @throws NoSuchUserException if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser findByUserId_First(long userId,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException {
		AnalysisUser analysisUser = fetchByUserId_First(userId,
				orderByComparator);

		if (analysisUser != null) {
			return analysisUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the first analysis user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analysis user, or <code>null</code> if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser fetchByUserId_First(long userId,
		OrderByComparator<AnalysisUser> orderByComparator) {
		List<AnalysisUser> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analysis user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analysis user
	 * @throws NoSuchUserException if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser findByUserId_Last(long userId,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException {
		AnalysisUser analysisUser = fetchByUserId_Last(userId, orderByComparator);

		if (analysisUser != null) {
			return analysisUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the last analysis user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analysis user, or <code>null</code> if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser fetchByUserId_Last(long userId,
		OrderByComparator<AnalysisUser> orderByComparator) {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<AnalysisUser> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AnalysisUser[] findByUserId_PrevAndNext(long analysisUserId,
		long userId, OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException {
		AnalysisUser analysisUser = findByPrimaryKey(analysisUserId);

		Session session = null;

		try {
			session = openSession();

			AnalysisUser[] array = new AnalysisUserImpl[3];

			array[0] = getByUserId_PrevAndNext(session, analysisUser, userId,
					orderByComparator, true);

			array[1] = analysisUser;

			array[2] = getByUserId_PrevAndNext(session, analysisUser, userId,
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

	protected AnalysisUser getByUserId_PrevAndNext(Session session,
		AnalysisUser analysisUser, long userId,
		OrderByComparator<AnalysisUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANALYSISUSER_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(AnalysisUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(analysisUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalysisUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analysis users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (AnalysisUser analysisUser : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(analysisUser);
		}
	}

	/**
	 * Returns the number of analysis users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching analysis users
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANALYSISUSER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "analysisUser.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERNAME = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, AnalysisUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME =
		new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, AnalysisUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserName",
			new String[] { String.class.getName() },
			AnalysisUserModelImpl.USERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERNAME = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the analysis users where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching analysis users
	 */
	@Override
	public List<AnalysisUser> findByUserName(String userName) {
		return findByUserName(userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<AnalysisUser> findByUserName(String userName, int start, int end) {
		return findByUserName(userName, start, end, null);
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
	@Override
	public List<AnalysisUser> findByUserName(String userName, int start,
		int end, OrderByComparator<AnalysisUser> orderByComparator) {
		return findByUserName(userName, start, end, orderByComparator, true);
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
	@Override
	public List<AnalysisUser> findByUserName(String userName, int start,
		int end, OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME;
			finderArgs = new Object[] { userName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERNAME;
			finderArgs = new Object[] { userName, start, end, orderByComparator };
		}

		List<AnalysisUser> list = null;

		if (retrieveFromCache) {
			list = (List<AnalysisUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalysisUser analysisUser : list) {
					if (!Objects.equals(userName, analysisUser.getUserName())) {
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

			query.append(_SQL_SELECT_ANALYSISUSER_WHERE);

			boolean bindUserName = false;

			if (userName == null) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_1);
			}
			else if (userName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUserName = true;

				query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalysisUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserName) {
					qPos.add(userName);
				}

				if (!pagination) {
					list = (List<AnalysisUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalysisUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first analysis user in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analysis user
	 * @throws NoSuchUserException if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser findByUserName_First(String userName,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException {
		AnalysisUser analysisUser = fetchByUserName_First(userName,
				orderByComparator);

		if (analysisUser != null) {
			return analysisUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userName=");
		msg.append(userName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the first analysis user in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analysis user, or <code>null</code> if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser fetchByUserName_First(String userName,
		OrderByComparator<AnalysisUser> orderByComparator) {
		List<AnalysisUser> list = findByUserName(userName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last analysis user in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analysis user
	 * @throws NoSuchUserException if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser findByUserName_Last(String userName,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException {
		AnalysisUser analysisUser = fetchByUserName_Last(userName,
				orderByComparator);

		if (analysisUser != null) {
			return analysisUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userName=");
		msg.append(userName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the last analysis user in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analysis user, or <code>null</code> if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser fetchByUserName_Last(String userName,
		OrderByComparator<AnalysisUser> orderByComparator) {
		int count = countByUserName(userName);

		if (count == 0) {
			return null;
		}

		List<AnalysisUser> list = findByUserName(userName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AnalysisUser[] findByUserName_PrevAndNext(long analysisUserId,
		String userName, OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException {
		AnalysisUser analysisUser = findByPrimaryKey(analysisUserId);

		Session session = null;

		try {
			session = openSession();

			AnalysisUser[] array = new AnalysisUserImpl[3];

			array[0] = getByUserName_PrevAndNext(session, analysisUser,
					userName, orderByComparator, true);

			array[1] = analysisUser;

			array[2] = getByUserName_PrevAndNext(session, analysisUser,
					userName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnalysisUser getByUserName_PrevAndNext(Session session,
		AnalysisUser analysisUser, String userName,
		OrderByComparator<AnalysisUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANALYSISUSER_WHERE);

		boolean bindUserName = false;

		if (userName == null) {
			query.append(_FINDER_COLUMN_USERNAME_USERNAME_1);
		}
		else if (userName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
		}
		else {
			bindUserName = true;

			query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
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
			query.append(AnalysisUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUserName) {
			qPos.add(userName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(analysisUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalysisUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analysis users where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	@Override
	public void removeByUserName(String userName) {
		for (AnalysisUser analysisUser : findByUserName(userName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(analysisUser);
		}
	}

	/**
	 * Returns the number of analysis users where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching analysis users
	 */
	@Override
	public int countByUserName(String userName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERNAME;

		Object[] finderArgs = new Object[] { userName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANALYSISUSER_WHERE);

			boolean bindUserName = false;

			if (userName == null) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_1);
			}
			else if (userName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUserName = true;

				query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserName) {
					qPos.add(userName);
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

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_1 = "analysisUser.userName IS NULL";
	private static final String _FINDER_COLUMN_USERNAME_USERNAME_2 = "analysisUser.userName = ?";
	private static final String _FINDER_COLUMN_USERNAME_USERNAME_3 = "(analysisUser.userName IS NULL OR analysisUser.userName = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_AU = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, AnalysisUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByAU",
			new String[] { Long.class.getName() },
			AnalysisUserModelImpl.ANALYSISUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AU = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAU",
			new String[] { Long.class.getName() });

	/**
	 * Returns the analysis user where analysisUserId = &#63; or throws a {@link NoSuchUserException} if it could not be found.
	 *
	 * @param analysisUserId the analysis user ID
	 * @return the matching analysis user
	 * @throws NoSuchUserException if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser findByAU(long analysisUserId)
		throws NoSuchUserException {
		AnalysisUser analysisUser = fetchByAU(analysisUserId);

		if (analysisUser == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("analysisUserId=");
			msg.append(analysisUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserException(msg.toString());
		}

		return analysisUser;
	}

	/**
	 * Returns the analysis user where analysisUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param analysisUserId the analysis user ID
	 * @return the matching analysis user, or <code>null</code> if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser fetchByAU(long analysisUserId) {
		return fetchByAU(analysisUserId, true);
	}

	/**
	 * Returns the analysis user where analysisUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param analysisUserId the analysis user ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching analysis user, or <code>null</code> if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser fetchByAU(long analysisUserId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { analysisUserId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_AU, finderArgs,
					this);
		}

		if (result instanceof AnalysisUser) {
			AnalysisUser analysisUser = (AnalysisUser)result;

			if ((analysisUserId != analysisUser.getAnalysisUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ANALYSISUSER_WHERE);

			query.append(_FINDER_COLUMN_AU_ANALYSISUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(analysisUserId);

				List<AnalysisUser> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_AU, finderArgs,
						list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AnalysisUserPersistenceImpl.fetchByAU(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					AnalysisUser analysisUser = list.get(0);

					result = analysisUser;

					cacheResult(analysisUser);

					if ((analysisUser.getAnalysisUserId() != analysisUserId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_AU,
							finderArgs, analysisUser);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_AU, finderArgs);

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
			return (AnalysisUser)result;
		}
	}

	/**
	 * Removes the analysis user where analysisUserId = &#63; from the database.
	 *
	 * @param analysisUserId the analysis user ID
	 * @return the analysis user that was removed
	 */
	@Override
	public AnalysisUser removeByAU(long analysisUserId)
		throws NoSuchUserException {
		AnalysisUser analysisUser = findByAU(analysisUserId);

		return remove(analysisUser);
	}

	/**
	 * Returns the number of analysis users where analysisUserId = &#63;.
	 *
	 * @param analysisUserId the analysis user ID
	 * @return the number of matching analysis users
	 */
	@Override
	public int countByAU(long analysisUserId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AU;

		Object[] finderArgs = new Object[] { analysisUserId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANALYSISUSER_WHERE);

			query.append(_FINDER_COLUMN_AU_ANALYSISUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(analysisUserId);

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

	private static final String _FINDER_COLUMN_AU_ANALYSISUSERID_2 = "analysisUser.analysisUserId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_A_U = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, AnalysisUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByA_U",
			new String[] { Long.class.getName(), Long.class.getName() },
			AnalysisUserModelImpl.ANALYSISENTRYID_COLUMN_BITMASK |
			AnalysisUserModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A_U = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_U",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the analysis user where analysisEntryId = &#63; and userId = &#63; or throws a {@link NoSuchUserException} if it could not be found.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @param userId the user ID
	 * @return the matching analysis user
	 * @throws NoSuchUserException if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser findByA_U(long analysisEntryId, long userId)
		throws NoSuchUserException {
		AnalysisUser analysisUser = fetchByA_U(analysisEntryId, userId);

		if (analysisUser == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("analysisEntryId=");
			msg.append(analysisEntryId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserException(msg.toString());
		}

		return analysisUser;
	}

	/**
	 * Returns the analysis user where analysisEntryId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @param userId the user ID
	 * @return the matching analysis user, or <code>null</code> if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser fetchByA_U(long analysisEntryId, long userId) {
		return fetchByA_U(analysisEntryId, userId, true);
	}

	/**
	 * Returns the analysis user where analysisEntryId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @param userId the user ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching analysis user, or <code>null</code> if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser fetchByA_U(long analysisEntryId, long userId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { analysisEntryId, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_A_U,
					finderArgs, this);
		}

		if (result instanceof AnalysisUser) {
			AnalysisUser analysisUser = (AnalysisUser)result;

			if ((analysisEntryId != analysisUser.getAnalysisEntryId()) ||
					(userId != analysisUser.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ANALYSISUSER_WHERE);

			query.append(_FINDER_COLUMN_A_U_ANALYSISENTRYID_2);

			query.append(_FINDER_COLUMN_A_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(analysisEntryId);

				qPos.add(userId);

				List<AnalysisUser> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_A_U, finderArgs,
						list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AnalysisUserPersistenceImpl.fetchByA_U(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					AnalysisUser analysisUser = list.get(0);

					result = analysisUser;

					cacheResult(analysisUser);

					if ((analysisUser.getAnalysisEntryId() != analysisEntryId) ||
							(analysisUser.getUserId() != userId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_A_U,
							finderArgs, analysisUser);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_A_U, finderArgs);

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
			return (AnalysisUser)result;
		}
	}

	/**
	 * Removes the analysis user where analysisEntryId = &#63; and userId = &#63; from the database.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @param userId the user ID
	 * @return the analysis user that was removed
	 */
	@Override
	public AnalysisUser removeByA_U(long analysisEntryId, long userId)
		throws NoSuchUserException {
		AnalysisUser analysisUser = findByA_U(analysisEntryId, userId);

		return remove(analysisUser);
	}

	/**
	 * Returns the number of analysis users where analysisEntryId = &#63; and userId = &#63;.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @param userId the user ID
	 * @return the number of matching analysis users
	 */
	@Override
	public int countByA_U(long analysisEntryId, long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_A_U;

		Object[] finderArgs = new Object[] { analysisEntryId, userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ANALYSISUSER_WHERE);

			query.append(_FINDER_COLUMN_A_U_ANALYSISENTRYID_2);

			query.append(_FINDER_COLUMN_A_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(analysisEntryId);

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

	private static final String _FINDER_COLUMN_A_U_ANALYSISENTRYID_2 = "analysisUser.analysisEntryId = ? AND ";
	private static final String _FINDER_COLUMN_A_U_USERID_2 = "analysisUser.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VOTED = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, AnalysisUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVoted",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VOTED = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, AnalysisUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVoted",
			new String[] { Long.class.getName(), Integer.class.getName() },
			AnalysisUserModelImpl.ANALYSISENTRYID_COLUMN_BITMASK |
			AnalysisUserModelImpl.VOTED_COLUMN_BITMASK |
			AnalysisUserModelImpl.USERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VOTED = new FinderPath(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVoted",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the analysis users where analysisEntryId = &#63; and voted = &#63;.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @param voted the voted
	 * @return the matching analysis users
	 */
	@Override
	public List<AnalysisUser> findByVoted(long analysisEntryId, int voted) {
		return findByVoted(analysisEntryId, voted, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<AnalysisUser> findByVoted(long analysisEntryId, int voted,
		int start, int end) {
		return findByVoted(analysisEntryId, voted, start, end, null);
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
	@Override
	public List<AnalysisUser> findByVoted(long analysisEntryId, int voted,
		int start, int end, OrderByComparator<AnalysisUser> orderByComparator) {
		return findByVoted(analysisEntryId, voted, start, end,
			orderByComparator, true);
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
	@Override
	public List<AnalysisUser> findByVoted(long analysisEntryId, int voted,
		int start, int end, OrderByComparator<AnalysisUser> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VOTED;
			finderArgs = new Object[] { analysisEntryId, voted };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VOTED;
			finderArgs = new Object[] {
					analysisEntryId, voted,
					
					start, end, orderByComparator
				};
		}

		List<AnalysisUser> list = null;

		if (retrieveFromCache) {
			list = (List<AnalysisUser>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnalysisUser analysisUser : list) {
					if ((analysisEntryId != analysisUser.getAnalysisEntryId()) ||
							(voted != analysisUser.getVoted())) {
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

			query.append(_SQL_SELECT_ANALYSISUSER_WHERE);

			query.append(_FINDER_COLUMN_VOTED_ANALYSISENTRYID_2);

			query.append(_FINDER_COLUMN_VOTED_VOTED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnalysisUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(analysisEntryId);

				qPos.add(voted);

				if (!pagination) {
					list = (List<AnalysisUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalysisUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first analysis user in the ordered set where analysisEntryId = &#63; and voted = &#63;.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @param voted the voted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analysis user
	 * @throws NoSuchUserException if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser findByVoted_First(long analysisEntryId, int voted,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException {
		AnalysisUser analysisUser = fetchByVoted_First(analysisEntryId, voted,
				orderByComparator);

		if (analysisUser != null) {
			return analysisUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("analysisEntryId=");
		msg.append(analysisEntryId);

		msg.append(", voted=");
		msg.append(voted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the first analysis user in the ordered set where analysisEntryId = &#63; and voted = &#63;.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @param voted the voted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching analysis user, or <code>null</code> if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser fetchByVoted_First(long analysisEntryId, int voted,
		OrderByComparator<AnalysisUser> orderByComparator) {
		List<AnalysisUser> list = findByVoted(analysisEntryId, voted, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AnalysisUser findByVoted_Last(long analysisEntryId, int voted,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException {
		AnalysisUser analysisUser = fetchByVoted_Last(analysisEntryId, voted,
				orderByComparator);

		if (analysisUser != null) {
			return analysisUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("analysisEntryId=");
		msg.append(analysisEntryId);

		msg.append(", voted=");
		msg.append(voted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the last analysis user in the ordered set where analysisEntryId = &#63; and voted = &#63;.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @param voted the voted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching analysis user, or <code>null</code> if a matching analysis user could not be found
	 */
	@Override
	public AnalysisUser fetchByVoted_Last(long analysisEntryId, int voted,
		OrderByComparator<AnalysisUser> orderByComparator) {
		int count = countByVoted(analysisEntryId, voted);

		if (count == 0) {
			return null;
		}

		List<AnalysisUser> list = findByVoted(analysisEntryId, voted,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AnalysisUser[] findByVoted_PrevAndNext(long analysisUserId,
		long analysisEntryId, int voted,
		OrderByComparator<AnalysisUser> orderByComparator)
		throws NoSuchUserException {
		AnalysisUser analysisUser = findByPrimaryKey(analysisUserId);

		Session session = null;

		try {
			session = openSession();

			AnalysisUser[] array = new AnalysisUserImpl[3];

			array[0] = getByVoted_PrevAndNext(session, analysisUser,
					analysisEntryId, voted, orderByComparator, true);

			array[1] = analysisUser;

			array[2] = getByVoted_PrevAndNext(session, analysisUser,
					analysisEntryId, voted, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnalysisUser getByVoted_PrevAndNext(Session session,
		AnalysisUser analysisUser, long analysisEntryId, int voted,
		OrderByComparator<AnalysisUser> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ANALYSISUSER_WHERE);

		query.append(_FINDER_COLUMN_VOTED_ANALYSISENTRYID_2);

		query.append(_FINDER_COLUMN_VOTED_VOTED_2);

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
			query.append(AnalysisUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(analysisEntryId);

		qPos.add(voted);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(analysisUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnalysisUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the analysis users where analysisEntryId = &#63; and voted = &#63; from the database.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @param voted the voted
	 */
	@Override
	public void removeByVoted(long analysisEntryId, int voted) {
		for (AnalysisUser analysisUser : findByVoted(analysisEntryId, voted,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(analysisUser);
		}
	}

	/**
	 * Returns the number of analysis users where analysisEntryId = &#63; and voted = &#63;.
	 *
	 * @param analysisEntryId the analysis entry ID
	 * @param voted the voted
	 * @return the number of matching analysis users
	 */
	@Override
	public int countByVoted(long analysisEntryId, int voted) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VOTED;

		Object[] finderArgs = new Object[] { analysisEntryId, voted };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ANALYSISUSER_WHERE);

			query.append(_FINDER_COLUMN_VOTED_ANALYSISENTRYID_2);

			query.append(_FINDER_COLUMN_VOTED_VOTED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(analysisEntryId);

				qPos.add(voted);

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

	private static final String _FINDER_COLUMN_VOTED_ANALYSISENTRYID_2 = "analysisUser.analysisEntryId = ? AND ";
	private static final String _FINDER_COLUMN_VOTED_VOTED_2 = "analysisUser.voted = ?";

	public AnalysisUserPersistenceImpl() {
		setModelClass(AnalysisUser.class);
	}

	/**
	 * Caches the analysis user in the entity cache if it is enabled.
	 *
	 * @param analysisUser the analysis user
	 */
	@Override
	public void cacheResult(AnalysisUser analysisUser) {
		entityCache.putResult(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserImpl.class, analysisUser.getPrimaryKey(), analysisUser);

		finderCache.putResult(FINDER_PATH_FETCH_BY_AU,
			new Object[] { analysisUser.getAnalysisUserId() }, analysisUser);

		finderCache.putResult(FINDER_PATH_FETCH_BY_A_U,
			new Object[] {
				analysisUser.getAnalysisEntryId(), analysisUser.getUserId()
			}, analysisUser);

		analysisUser.resetOriginalValues();
	}

	/**
	 * Caches the analysis users in the entity cache if it is enabled.
	 *
	 * @param analysisUsers the analysis users
	 */
	@Override
	public void cacheResult(List<AnalysisUser> analysisUsers) {
		for (AnalysisUser analysisUser : analysisUsers) {
			if (entityCache.getResult(
						AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
						AnalysisUserImpl.class, analysisUser.getPrimaryKey()) == null) {
				cacheResult(analysisUser);
			}
			else {
				analysisUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all analysis users.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnalysisUserImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the analysis user.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnalysisUser analysisUser) {
		entityCache.removeResult(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserImpl.class, analysisUser.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AnalysisUserModelImpl)analysisUser);
	}

	@Override
	public void clearCache(List<AnalysisUser> analysisUsers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AnalysisUser analysisUser : analysisUsers) {
			entityCache.removeResult(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
				AnalysisUserImpl.class, analysisUser.getPrimaryKey());

			clearUniqueFindersCache((AnalysisUserModelImpl)analysisUser);
		}
	}

	protected void cacheUniqueFindersCache(
		AnalysisUserModelImpl analysisUserModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					analysisUserModelImpl.getAnalysisUserId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_AU, args, Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_AU, args,
				analysisUserModelImpl);

			args = new Object[] {
					analysisUserModelImpl.getAnalysisEntryId(),
					analysisUserModelImpl.getUserId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_A_U, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_A_U, args,
				analysisUserModelImpl);
		}
		else {
			if ((analysisUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_AU.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						analysisUserModelImpl.getAnalysisUserId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_AU, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_AU, args,
					analysisUserModelImpl);
			}

			if ((analysisUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_A_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						analysisUserModelImpl.getAnalysisEntryId(),
						analysisUserModelImpl.getUserId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_A_U, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_A_U, args,
					analysisUserModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		AnalysisUserModelImpl analysisUserModelImpl) {
		Object[] args = new Object[] { analysisUserModelImpl.getAnalysisUserId() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_AU, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_AU, args);

		if ((analysisUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_AU.getColumnBitmask()) != 0) {
			args = new Object[] {
					analysisUserModelImpl.getOriginalAnalysisUserId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_AU, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_AU, args);
		}

		args = new Object[] {
				analysisUserModelImpl.getAnalysisEntryId(),
				analysisUserModelImpl.getUserId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_A_U, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_A_U, args);

		if ((analysisUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_A_U.getColumnBitmask()) != 0) {
			args = new Object[] {
					analysisUserModelImpl.getOriginalAnalysisEntryId(),
					analysisUserModelImpl.getOriginalUserId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_A_U, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_A_U, args);
		}
	}

	/**
	 * Creates a new analysis user with the primary key. Does not add the analysis user to the database.
	 *
	 * @param analysisUserId the primary key for the new analysis user
	 * @return the new analysis user
	 */
	@Override
	public AnalysisUser create(long analysisUserId) {
		AnalysisUser analysisUser = new AnalysisUserImpl();

		analysisUser.setNew(true);
		analysisUser.setPrimaryKey(analysisUserId);

		String uuid = PortalUUIDUtil.generate();

		analysisUser.setUuid(uuid);

		return analysisUser;
	}

	/**
	 * Removes the analysis user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param analysisUserId the primary key of the analysis user
	 * @return the analysis user that was removed
	 * @throws NoSuchUserException if a analysis user with the primary key could not be found
	 */
	@Override
	public AnalysisUser remove(long analysisUserId) throws NoSuchUserException {
		return remove((Serializable)analysisUserId);
	}

	/**
	 * Removes the analysis user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the analysis user
	 * @return the analysis user that was removed
	 * @throws NoSuchUserException if a analysis user with the primary key could not be found
	 */
	@Override
	public AnalysisUser remove(Serializable primaryKey)
		throws NoSuchUserException {
		Session session = null;

		try {
			session = openSession();

			AnalysisUser analysisUser = (AnalysisUser)session.get(AnalysisUserImpl.class,
					primaryKey);

			if (analysisUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(analysisUser);
		}
		catch (NoSuchUserException nsee) {
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
	protected AnalysisUser removeImpl(AnalysisUser analysisUser) {
		analysisUser = toUnwrappedModel(analysisUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(analysisUser)) {
				analysisUser = (AnalysisUser)session.get(AnalysisUserImpl.class,
						analysisUser.getPrimaryKeyObj());
			}

			if (analysisUser != null) {
				session.delete(analysisUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (analysisUser != null) {
			clearCache(analysisUser);
		}

		return analysisUser;
	}

	@Override
	public AnalysisUser updateImpl(AnalysisUser analysisUser) {
		analysisUser = toUnwrappedModel(analysisUser);

		boolean isNew = analysisUser.isNew();

		AnalysisUserModelImpl analysisUserModelImpl = (AnalysisUserModelImpl)analysisUser;

		if (Validator.isNull(analysisUser.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			analysisUser.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (analysisUser.isNew()) {
				session.save(analysisUser);

				analysisUser.setNew(false);
			}
			else {
				analysisUser = (AnalysisUser)session.merge(analysisUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AnalysisUserModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((analysisUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						analysisUserModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { analysisUserModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((analysisUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANALYSISENTRYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						analysisUserModelImpl.getOriginalAnalysisEntryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ANALYSISENTRYID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANALYSISENTRYID,
					args);

				args = new Object[] { analysisUserModelImpl.getAnalysisEntryId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ANALYSISENTRYID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANALYSISENTRYID,
					args);
			}

			if ((analysisUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						analysisUserModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { analysisUserModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((analysisUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						analysisUserModelImpl.getOriginalUserName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME,
					args);

				args = new Object[] { analysisUserModelImpl.getUserName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERNAME,
					args);
			}

			if ((analysisUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VOTED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						analysisUserModelImpl.getOriginalAnalysisEntryId(),
						analysisUserModelImpl.getOriginalVoted()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VOTED, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VOTED,
					args);

				args = new Object[] {
						analysisUserModelImpl.getAnalysisEntryId(),
						analysisUserModelImpl.getVoted()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VOTED, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VOTED,
					args);
			}
		}

		entityCache.putResult(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
			AnalysisUserImpl.class, analysisUser.getPrimaryKey(), analysisUser,
			false);

		clearUniqueFindersCache(analysisUserModelImpl);
		cacheUniqueFindersCache(analysisUserModelImpl, isNew);

		analysisUser.resetOriginalValues();

		return analysisUser;
	}

	protected AnalysisUser toUnwrappedModel(AnalysisUser analysisUser) {
		if (analysisUser instanceof AnalysisUserImpl) {
			return analysisUser;
		}

		AnalysisUserImpl analysisUserImpl = new AnalysisUserImpl();

		analysisUserImpl.setNew(analysisUser.isNew());
		analysisUserImpl.setPrimaryKey(analysisUser.getPrimaryKey());

		analysisUserImpl.setUuid(analysisUser.getUuid());
		analysisUserImpl.setAnalysisUserId(analysisUser.getAnalysisUserId());
		analysisUserImpl.setAnalysisEntryId(analysisUser.getAnalysisEntryId());
		analysisUserImpl.setUserId(analysisUser.getUserId());
		analysisUserImpl.setUserName(analysisUser.getUserName());
		analysisUserImpl.setVoted(analysisUser.getVoted());

		return analysisUserImpl;
	}

	/**
	 * Returns the analysis user with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the analysis user
	 * @return the analysis user
	 * @throws NoSuchUserException if a analysis user with the primary key could not be found
	 */
	@Override
	public AnalysisUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserException {
		AnalysisUser analysisUser = fetchByPrimaryKey(primaryKey);

		if (analysisUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return analysisUser;
	}

	/**
	 * Returns the analysis user with the primary key or throws a {@link NoSuchUserException} if it could not be found.
	 *
	 * @param analysisUserId the primary key of the analysis user
	 * @return the analysis user
	 * @throws NoSuchUserException if a analysis user with the primary key could not be found
	 */
	@Override
	public AnalysisUser findByPrimaryKey(long analysisUserId)
		throws NoSuchUserException {
		return findByPrimaryKey((Serializable)analysisUserId);
	}

	/**
	 * Returns the analysis user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the analysis user
	 * @return the analysis user, or <code>null</code> if a analysis user with the primary key could not be found
	 */
	@Override
	public AnalysisUser fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
				AnalysisUserImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AnalysisUser analysisUser = (AnalysisUser)serializable;

		if (analysisUser == null) {
			Session session = null;

			try {
				session = openSession();

				analysisUser = (AnalysisUser)session.get(AnalysisUserImpl.class,
						primaryKey);

				if (analysisUser != null) {
					cacheResult(analysisUser);
				}
				else {
					entityCache.putResult(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
						AnalysisUserImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
					AnalysisUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return analysisUser;
	}

	/**
	 * Returns the analysis user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param analysisUserId the primary key of the analysis user
	 * @return the analysis user, or <code>null</code> if a analysis user with the primary key could not be found
	 */
	@Override
	public AnalysisUser fetchByPrimaryKey(long analysisUserId) {
		return fetchByPrimaryKey((Serializable)analysisUserId);
	}

	@Override
	public Map<Serializable, AnalysisUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AnalysisUser> map = new HashMap<Serializable, AnalysisUser>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AnalysisUser analysisUser = fetchByPrimaryKey(primaryKey);

			if (analysisUser != null) {
				map.put(primaryKey, analysisUser);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
					AnalysisUserImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AnalysisUser)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ANALYSISUSER_WHERE_PKS_IN);

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

			for (AnalysisUser analysisUser : (List<AnalysisUser>)q.list()) {
				map.put(analysisUser.getPrimaryKeyObj(), analysisUser);

				cacheResult(analysisUser);

				uncachedPrimaryKeys.remove(analysisUser.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AnalysisUserModelImpl.ENTITY_CACHE_ENABLED,
					AnalysisUserImpl.class, primaryKey, nullModel);
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
	 * Returns all the analysis users.
	 *
	 * @return the analysis users
	 */
	@Override
	public List<AnalysisUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AnalysisUser> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AnalysisUser> findAll(int start, int end,
		OrderByComparator<AnalysisUser> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AnalysisUser> findAll(int start, int end,
		OrderByComparator<AnalysisUser> orderByComparator,
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

		List<AnalysisUser> list = null;

		if (retrieveFromCache) {
			list = (List<AnalysisUser>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ANALYSISUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANALYSISUSER;

				if (pagination) {
					sql = sql.concat(AnalysisUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AnalysisUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnalysisUser>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the analysis users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnalysisUser analysisUser : findAll()) {
			remove(analysisUser);
		}
	}

	/**
	 * Returns the number of analysis users.
	 *
	 * @return the number of analysis users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANALYSISUSER);

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
		return AnalysisUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the analysis user persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AnalysisUserImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ANALYSISUSER = "SELECT analysisUser FROM AnalysisUser analysisUser";
	private static final String _SQL_SELECT_ANALYSISUSER_WHERE_PKS_IN = "SELECT analysisUser FROM AnalysisUser analysisUser WHERE analysisUserId IN (";
	private static final String _SQL_SELECT_ANALYSISUSER_WHERE = "SELECT analysisUser FROM AnalysisUser analysisUser WHERE ";
	private static final String _SQL_COUNT_ANALYSISUSER = "SELECT COUNT(analysisUser) FROM AnalysisUser analysisUser";
	private static final String _SQL_COUNT_ANALYSISUSER_WHERE = "SELECT COUNT(analysisUser) FROM AnalysisUser analysisUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "analysisUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AnalysisUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AnalysisUser exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AnalysisUserPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}