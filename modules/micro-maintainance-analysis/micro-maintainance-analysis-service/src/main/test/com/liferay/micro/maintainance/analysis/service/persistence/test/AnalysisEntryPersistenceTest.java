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

import com.liferay.micro.maintainance.analysis.exception.NoSuchEntryException;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.analysis.service.AnalysisEntryLocalServiceUtil;
import com.liferay.micro.maintainance.analysis.service.persistence.AnalysisEntryPersistence;
import com.liferay.micro.maintainance.analysis.service.persistence.AnalysisEntryUtil;

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
import com.liferay.portal.kernel.util.Time;
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
public class AnalysisEntryPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = AnalysisEntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AnalysisEntry> iterator = _analysisEntries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalysisEntry analysisEntry = _persistence.create(pk);

		Assert.assertNotNull(analysisEntry);

		Assert.assertEquals(analysisEntry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AnalysisEntry newAnalysisEntry = addAnalysisEntry();

		_persistence.remove(newAnalysisEntry);

		AnalysisEntry existingAnalysisEntry = _persistence.fetchByPrimaryKey(newAnalysisEntry.getPrimaryKey());

		Assert.assertNull(existingAnalysisEntry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAnalysisEntry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalysisEntry newAnalysisEntry = _persistence.create(pk);

		newAnalysisEntry.setUuid(RandomTestUtil.randomString());

		newAnalysisEntry.setCompanyId(RandomTestUtil.nextLong());

		newAnalysisEntry.setUserId(RandomTestUtil.nextLong());

		newAnalysisEntry.setUserName(RandomTestUtil.randomString());

		newAnalysisEntry.setCreateDate(RandomTestUtil.nextDate());

		newAnalysisEntry.setModifiedDate(RandomTestUtil.nextDate());

		newAnalysisEntry.setCandidateMaintenanceId(RandomTestUtil.nextLong());

		newAnalysisEntry.setAnalysisData(RandomTestUtil.randomString());

		_analysisEntries.add(_persistence.update(newAnalysisEntry));

		AnalysisEntry existingAnalysisEntry = _persistence.findByPrimaryKey(newAnalysisEntry.getPrimaryKey());

		Assert.assertEquals(existingAnalysisEntry.getUuid(),
			newAnalysisEntry.getUuid());
		Assert.assertEquals(existingAnalysisEntry.getAnalysisEntryId(),
			newAnalysisEntry.getAnalysisEntryId());
		Assert.assertEquals(existingAnalysisEntry.getCompanyId(),
			newAnalysisEntry.getCompanyId());
		Assert.assertEquals(existingAnalysisEntry.getUserId(),
			newAnalysisEntry.getUserId());
		Assert.assertEquals(existingAnalysisEntry.getUserName(),
			newAnalysisEntry.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingAnalysisEntry.getCreateDate()),
			Time.getShortTimestamp(newAnalysisEntry.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingAnalysisEntry.getModifiedDate()),
			Time.getShortTimestamp(newAnalysisEntry.getModifiedDate()));
		Assert.assertEquals(existingAnalysisEntry.getCandidateMaintenanceId(),
			newAnalysisEntry.getCandidateMaintenanceId());
		Assert.assertEquals(existingAnalysisEntry.getAnalysisData(),
			newAnalysisEntry.getAnalysisData());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUuid_C(StringPool.NULL, 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByAnalysisEntryId() throws Exception {
		_persistence.countByAnalysisEntryId(RandomTestUtil.nextLong());

		_persistence.countByAnalysisEntryId(0L);
	}

	@Test
	public void testCountByA_C() throws Exception {
		_persistence.countByA_C(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByA_C(0L, 0L);
	}

	@Test
	public void testCountByA_CM() throws Exception {
		_persistence.countByA_CM(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByA_CM(0L, 0L);
	}

	@Test
	public void testCountByA_U_CM() throws Exception {
		_persistence.countByA_U_CM(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByA_U_CM(0L, 0L, 0L);
	}

	@Test
	public void testCountByCandidateMaintenanceId() throws Exception {
		_persistence.countByCandidateMaintenanceId(RandomTestUtil.nextLong());

		_persistence.countByCandidateMaintenanceId(0L);
	}

	@Test
	public void testCountByCompanyId() throws Exception {
		_persistence.countByCompanyId(RandomTestUtil.nextLong());

		_persistence.countByCompanyId(0L);
	}

	@Test
	public void testCountByCM_U() throws Exception {
		_persistence.countByCM_U(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByCM_U(0L, 0L);
	}

	@Test
	public void testCountByC_U() throws Exception {
		_persistence.countByC_U(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByC_U(0L, 0L);
	}

	@Test
	public void testCountByU_cD() throws Exception {
		_persistence.countByU_cD(RandomTestUtil.nextLong(),
			RandomTestUtil.nextDate());

		_persistence.countByU_cD(0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AnalysisEntry newAnalysisEntry = addAnalysisEntry();

		AnalysisEntry existingAnalysisEntry = _persistence.findByPrimaryKey(newAnalysisEntry.getPrimaryKey());

		Assert.assertEquals(existingAnalysisEntry, newAnalysisEntry);
	}

	@Test(expected = NoSuchEntryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<AnalysisEntry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("Analysis_AnalysisEntry",
			"uuid", true, "analysisEntryId", true, "companyId", true, "userId",
			true, "userName", true, "createDate", true, "modifiedDate", true,
			"candidateMaintenanceId", true, "analysisData", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AnalysisEntry newAnalysisEntry = addAnalysisEntry();

		AnalysisEntry existingAnalysisEntry = _persistence.fetchByPrimaryKey(newAnalysisEntry.getPrimaryKey());

		Assert.assertEquals(existingAnalysisEntry, newAnalysisEntry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalysisEntry missingAnalysisEntry = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAnalysisEntry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		AnalysisEntry newAnalysisEntry1 = addAnalysisEntry();
		AnalysisEntry newAnalysisEntry2 = addAnalysisEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnalysisEntry1.getPrimaryKey());
		primaryKeys.add(newAnalysisEntry2.getPrimaryKey());

		Map<Serializable, AnalysisEntry> analysisEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, analysisEntries.size());
		Assert.assertEquals(newAnalysisEntry1,
			analysisEntries.get(newAnalysisEntry1.getPrimaryKey()));
		Assert.assertEquals(newAnalysisEntry2,
			analysisEntries.get(newAnalysisEntry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AnalysisEntry> analysisEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(analysisEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		AnalysisEntry newAnalysisEntry = addAnalysisEntry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnalysisEntry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AnalysisEntry> analysisEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, analysisEntries.size());
		Assert.assertEquals(newAnalysisEntry,
			analysisEntries.get(newAnalysisEntry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AnalysisEntry> analysisEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(analysisEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		AnalysisEntry newAnalysisEntry = addAnalysisEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAnalysisEntry.getPrimaryKey());

		Map<Serializable, AnalysisEntry> analysisEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, analysisEntries.size());
		Assert.assertEquals(newAnalysisEntry,
			analysisEntries.get(newAnalysisEntry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = AnalysisEntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<AnalysisEntry>() {
				@Override
				public void performAction(AnalysisEntry analysisEntry) {
					Assert.assertNotNull(analysisEntry);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		AnalysisEntry newAnalysisEntry = addAnalysisEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalysisEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("analysisEntryId",
				newAnalysisEntry.getAnalysisEntryId()));

		List<AnalysisEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		AnalysisEntry existingAnalysisEntry = result.get(0);

		Assert.assertEquals(existingAnalysisEntry, newAnalysisEntry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalysisEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("analysisEntryId",
				RandomTestUtil.nextLong()));

		List<AnalysisEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		AnalysisEntry newAnalysisEntry = addAnalysisEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalysisEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"analysisEntryId"));

		Object newAnalysisEntryId = newAnalysisEntry.getAnalysisEntryId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("analysisEntryId",
				new Object[] { newAnalysisEntryId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAnalysisEntryId = result.get(0);

		Assert.assertEquals(existingAnalysisEntryId, newAnalysisEntryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnalysisEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"analysisEntryId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("analysisEntryId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		AnalysisEntry newAnalysisEntry = addAnalysisEntry();

		_persistence.clearCache();

		AnalysisEntry existingAnalysisEntry = _persistence.findByPrimaryKey(newAnalysisEntry.getPrimaryKey());

		Assert.assertEquals(Long.valueOf(
				existingAnalysisEntry.getAnalysisEntryId()),
			ReflectionTestUtil.<Long>invoke(existingAnalysisEntry,
				"getOriginalAnalysisEntryId", new Class<?>[0]));

		Assert.assertEquals(Long.valueOf(
				existingAnalysisEntry.getCandidateMaintenanceId()),
			ReflectionTestUtil.<Long>invoke(existingAnalysisEntry,
				"getOriginalCandidateMaintenanceId", new Class<?>[0]));
	}

	protected AnalysisEntry addAnalysisEntry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AnalysisEntry analysisEntry = _persistence.create(pk);

		analysisEntry.setUuid(RandomTestUtil.randomString());

		analysisEntry.setCompanyId(RandomTestUtil.nextLong());

		analysisEntry.setUserId(RandomTestUtil.nextLong());

		analysisEntry.setUserName(RandomTestUtil.randomString());

		analysisEntry.setCreateDate(RandomTestUtil.nextDate());

		analysisEntry.setModifiedDate(RandomTestUtil.nextDate());

		analysisEntry.setCandidateMaintenanceId(RandomTestUtil.nextLong());

		analysisEntry.setAnalysisData(RandomTestUtil.randomString());

		_analysisEntries.add(_persistence.update(analysisEntry));

		return analysisEntry;
	}

	private List<AnalysisEntry> _analysisEntries = new ArrayList<AnalysisEntry>();
	private AnalysisEntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}