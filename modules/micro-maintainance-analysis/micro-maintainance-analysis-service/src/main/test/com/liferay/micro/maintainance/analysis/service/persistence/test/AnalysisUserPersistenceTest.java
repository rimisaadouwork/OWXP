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

package com.liferay.micro.maintainance.analysis.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.micro.maintainance.analysis.exception.NoSuchUserException;
import com.liferay.micro.maintainance.analysis.model.AnalysisUser;
import com.liferay.micro.maintainance.analysis.service.AnalysisUserLocalServiceUtil;
import com.liferay.micro.maintainance.analysis.service.persistence.AnalysisUserPersistence;
import com.liferay.micro.maintainance.analysis.service.persistence.AnalysisUserUtil;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.TransactionalTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AnalysisUserPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = AnalysisUserUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnalysisUser> iterator = _analysisUsers.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalysisUser analysisUser = _persistence.create(pk);

		Assert.assertNotNull(analysisUser);

		Assert.assertEquals(analysisUser.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnalysisUser newAnalysisUser = addAnalysisUser();

		_persistence.remove(newAnalysisUser);

		AnalysisUser existingAnalysisUser = _persistence.fetchByPrimaryKey(newAnalysisUser.getPrimaryKey());

		Assert.assertNull(existingAnalysisUser);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnalysisUser();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalysisUser newAnalysisUser = _persistence.create(pk);

		newAnalysisUser.setUuid(RandomTestUtil.randomString());

		newAnalysisUser.setAnalysisEntryId(RandomTestUtil.nextLong());

		newAnalysisUser.setUserId(RandomTestUtil.nextLong());

		newAnalysisUser.setUserName(RandomTestUtil.randomString());

		newAnalysisUser.setVoted(RandomTestUtil.nextInt());

		_analysisUsers.add(_persistence.update(newAnalysisUser));

		AnalysisUser existingAnalysisUser = _persistence.findByPrimaryKey(newAnalysisUser.getPrimaryKey());

		Assert.assertEquals(existingAnalysisUser.getUuid(),
			newAnalysisUser.getUuid());
		Assert.assertEquals(existingAnalysisUser.getAnalysisUserId(),
			newAnalysisUser.getAnalysisUserId());
		Assert.assertEquals(existingAnalysisUser.getAnalysisEntryId(),
			newAnalysisUser.getAnalysisEntryId());
		Assert.assertEquals(existingAnalysisUser.getUserId(),
			newAnalysisUser.getUserId());
		Assert.assertEquals(existingAnalysisUser.getUserName(),
			newAnalysisUser.getUserName());
		Assert.assertEquals(existingAnalysisUser.getVoted(),
			newAnalysisUser.getVoted());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByAnalysisEntryId() throws Exception {
		_persistence.countByAnalysisEntryId(RandomTestUtil.nextLong());

		_persistence.countByAnalysisEntryId(0L);
	}

	@Test
	public void testCountByUserId() throws Exception {
		_persistence.countByUserId(RandomTestUtil.nextLong());

		_persistence.countByUserId(0L);
	}

	@Test
	public void testCountByUserName() throws Exception {
		_persistence.countByUserName(StringPool.BLANK);

		_persistence.countByUserName(StringPool.NULL);

		_persistence.countByUserName((String)null);
	}

	@Test
	public void testCountByAU() throws Exception {
		_persistence.countByAU(RandomTestUtil.nextLong());

		_persistence.countByAU(0L);
	}

	@Test
	public void testCountByA_U() throws Exception {
		_persistence.countByA_U(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByA_U(0L, 0L);
	}

	@Test
	public void testCountByVoted() throws Exception {
		_persistence.countByVoted(RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByVoted(0L, 0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnalysisUser newAnalysisUser = addAnalysisUser();

		AnalysisUser existingAnalysisUser = _persistence.findByPrimaryKey(newAnalysisUser.getPrimaryKey());

		Assert.assertEquals(existingAnalysisUser, newAnalysisUser);
	}

	@Test(expected = NoSuchUserException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<AnalysisUser> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("Analysis_AnalysisUser",
			"uuid", true, "analysisUserId", true, "analysisEntryId", true,
			"userId", true, "userName", true, "voted", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnalysisUser newAnalysisUser = addAnalysisUser();

		AnalysisUser existingAnalysisUser = _persistence.fetchByPrimaryKey(newAnalysisUser.getPrimaryKey());

		Assert.assertEquals(existingAnalysisUser, newAnalysisUser);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalysisUser missingAnalysisUser = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAnalysisUser);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		AnalysisUser newAnalysisUser1 = addAnalysisUser();
		AnalysisUser newAnalysisUser2 = addAnalysisUser();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnalysisUser1.getPrimaryKey());
		primaryKeys.add(newAnalysisUser2.getPrimaryKey());

		Map<Serializable, AnalysisUser> analysisUsers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, analysisUsers.size());
		Assert.assertEquals(newAnalysisUser1,
			analysisUsers.get(newAnalysisUser1.getPrimaryKey()));
		Assert.assertEquals(newAnalysisUser2,
			analysisUsers.get(newAnalysisUser2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnalysisUser> analysisUsers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(analysisUsers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		AnalysisUser newAnalysisUser = addAnalysisUser();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnalysisUser.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnalysisUser> analysisUsers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, analysisUsers.size());
		Assert.assertEquals(newAnalysisUser,
			analysisUsers.get(newAnalysisUser.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnalysisUser> analysisUsers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(analysisUsers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		AnalysisUser newAnalysisUser = addAnalysisUser();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnalysisUser.getPrimaryKey());

		Map<Serializable, AnalysisUser> analysisUsers = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, analysisUsers.size());
		Assert.assertEquals(newAnalysisUser,
			analysisUsers.get(newAnalysisUser.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = AnalysisUserLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<AnalysisUser>() {
				@Override
				public void performAction(AnalysisUser analysisUser) {
					Assert.assertNotNull(analysisUser);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		AnalysisUser newAnalysisUser = addAnalysisUser();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalysisUser.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("analysisUserId",
				newAnalysisUser.getAnalysisUserId()));

		List<AnalysisUser> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnalysisUser existingAnalysisUser = result.get(0);

		Assert.assertEquals(existingAnalysisUser, newAnalysisUser);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalysisUser.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("analysisUserId",
				RandomTestUtil.nextLong()));

		List<AnalysisUser> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		AnalysisUser newAnalysisUser = addAnalysisUser();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalysisUser.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"analysisUserId"));

		Object newAnalysisUserId = newAnalysisUser.getAnalysisUserId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("analysisUserId",
				new Object[] { newAnalysisUserId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAnalysisUserId = result.get(0);

		Assert.assertEquals(existingAnalysisUserId, newAnalysisUserId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalysisUser.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"analysisUserId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("analysisUserId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		AnalysisUser newAnalysisUser = addAnalysisUser();

		_persistence.clearCache();

		AnalysisUser existingAnalysisUser = _persistence.findByPrimaryKey(newAnalysisUser.getPrimaryKey());

		Assert.assertEquals(Long.valueOf(
				existingAnalysisUser.getAnalysisUserId()),
			ReflectionTestUtil.<Long>invoke(existingAnalysisUser,
				"getOriginalAnalysisUserId", new Class<?>[0]));

		Assert.assertEquals(Long.valueOf(
				existingAnalysisUser.getAnalysisEntryId()),
			ReflectionTestUtil.<Long>invoke(existingAnalysisUser,
				"getOriginalAnalysisEntryId", new Class<?>[0]));
		Assert.assertEquals(Long.valueOf(existingAnalysisUser.getUserId()),
			ReflectionTestUtil.<Long>invoke(existingAnalysisUser,
				"getOriginalUserId", new Class<?>[0]));
	}

	protected AnalysisUser addAnalysisUser() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalysisUser analysisUser = _persistence.create(pk);

		analysisUser.setUuid(RandomTestUtil.randomString());

		analysisUser.setAnalysisEntryId(RandomTestUtil.nextLong());

		analysisUser.setUserId(RandomTestUtil.nextLong());

		analysisUser.setUserName(RandomTestUtil.randomString());

		analysisUser.setVoted(RandomTestUtil.nextInt());

		_analysisUsers.add(_persistence.update(analysisUser));

		return analysisUser;
	}

	private List<AnalysisUser> _analysisUsers = new ArrayList<AnalysisUser>();
	private AnalysisUserPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}