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

package com.liferay.micro.maintainance.task.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.micro.maintainance.task.exception.NoSuchCandidateMaintenanceException;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.micro.maintainance.task.service.CandidateMaintenanceLocalServiceUtil;
import com.liferay.micro.maintainance.task.service.persistence.CandidateMaintenancePersistence;
import com.liferay.micro.maintainance.task.service.persistence.CandidateMaintenanceUtil;

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
public class CandidateMaintenancePersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = CandidateMaintenanceUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CandidateMaintenance> iterator = _candidateMaintenances.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CandidateMaintenance candidateMaintenance = _persistence.create(pk);

		Assert.assertNotNull(candidateMaintenance);

		Assert.assertEquals(candidateMaintenance.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CandidateMaintenance newCandidateMaintenance = addCandidateMaintenance();

		_persistence.remove(newCandidateMaintenance);

		CandidateMaintenance existingCandidateMaintenance = _persistence.fetchByPrimaryKey(newCandidateMaintenance.getPrimaryKey());

		Assert.assertNull(existingCandidateMaintenance);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCandidateMaintenance();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CandidateMaintenance newCandidateMaintenance = _persistence.create(pk);

		newCandidateMaintenance.setUuid(RandomTestUtil.randomString());

		newCandidateMaintenance.setCandidateEntryId(RandomTestUtil.nextLong());

		newCandidateMaintenance.setTaskEntryId(RandomTestUtil.nextLong());

		newCandidateMaintenance.setCreateDate(RandomTestUtil.nextDate());

		_candidateMaintenances.add(_persistence.update(newCandidateMaintenance));

		CandidateMaintenance existingCandidateMaintenance = _persistence.findByPrimaryKey(newCandidateMaintenance.getPrimaryKey());

		Assert.assertEquals(existingCandidateMaintenance.getUuid(),
			newCandidateMaintenance.getUuid());
		Assert.assertEquals(existingCandidateMaintenance.getCandidateMaintenanceId(),
			newCandidateMaintenance.getCandidateMaintenanceId());
		Assert.assertEquals(existingCandidateMaintenance.getCandidateEntryId(),
			newCandidateMaintenance.getCandidateEntryId());
		Assert.assertEquals(existingCandidateMaintenance.getTaskEntryId(),
			newCandidateMaintenance.getTaskEntryId());
		Assert.assertEquals(Time.getShortTimestamp(
				existingCandidateMaintenance.getCreateDate()),
			Time.getShortTimestamp(newCandidateMaintenance.getCreateDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByCandidateEntryIds() throws Exception {
		_persistence.countByCandidateEntryIds(RandomTestUtil.nextLong());

		_persistence.countByCandidateEntryIds(0L);
	}

	@Test
	public void testCountByTaskEntryIds() throws Exception {
		_persistence.countByTaskEntryIds(RandomTestUtil.nextLong());

		_persistence.countByTaskEntryIds(0L);
	}

	@Test
	public void testCountByC_T() throws Exception {
		_persistence.countByC_T(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByC_T(0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CandidateMaintenance newCandidateMaintenance = addCandidateMaintenance();

		CandidateMaintenance existingCandidateMaintenance = _persistence.findByPrimaryKey(newCandidateMaintenance.getPrimaryKey());

		Assert.assertEquals(existingCandidateMaintenance,
			newCandidateMaintenance);
	}

	@Test(expected = NoSuchCandidateMaintenanceException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<CandidateMaintenance> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("Task_CandidateMaintenance",
			"uuid", true, "candidateMaintenanceId", true, "candidateEntryId",
			true, "taskEntryId", true, "createDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CandidateMaintenance newCandidateMaintenance = addCandidateMaintenance();

		CandidateMaintenance existingCandidateMaintenance = _persistence.fetchByPrimaryKey(newCandidateMaintenance.getPrimaryKey());

		Assert.assertEquals(existingCandidateMaintenance,
			newCandidateMaintenance);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CandidateMaintenance missingCandidateMaintenance = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCandidateMaintenance);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		CandidateMaintenance newCandidateMaintenance1 = addCandidateMaintenance();
		CandidateMaintenance newCandidateMaintenance2 = addCandidateMaintenance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCandidateMaintenance1.getPrimaryKey());
		primaryKeys.add(newCandidateMaintenance2.getPrimaryKey());

		Map<Serializable, CandidateMaintenance> candidateMaintenances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, candidateMaintenances.size());
		Assert.assertEquals(newCandidateMaintenance1,
			candidateMaintenances.get(newCandidateMaintenance1.getPrimaryKey()));
		Assert.assertEquals(newCandidateMaintenance2,
			candidateMaintenances.get(newCandidateMaintenance2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CandidateMaintenance> candidateMaintenances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(candidateMaintenances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		CandidateMaintenance newCandidateMaintenance = addCandidateMaintenance();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCandidateMaintenance.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CandidateMaintenance> candidateMaintenances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, candidateMaintenances.size());
		Assert.assertEquals(newCandidateMaintenance,
			candidateMaintenances.get(newCandidateMaintenance.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CandidateMaintenance> candidateMaintenances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(candidateMaintenances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		CandidateMaintenance newCandidateMaintenance = addCandidateMaintenance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCandidateMaintenance.getPrimaryKey());

		Map<Serializable, CandidateMaintenance> candidateMaintenances = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, candidateMaintenances.size());
		Assert.assertEquals(newCandidateMaintenance,
			candidateMaintenances.get(newCandidateMaintenance.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = CandidateMaintenanceLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<CandidateMaintenance>() {
				@Override
				public void performAction(
					CandidateMaintenance candidateMaintenance) {
					Assert.assertNotNull(candidateMaintenance);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		CandidateMaintenance newCandidateMaintenance = addCandidateMaintenance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CandidateMaintenance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("candidateMaintenanceId",
				newCandidateMaintenance.getCandidateMaintenanceId()));

		List<CandidateMaintenance> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		CandidateMaintenance existingCandidateMaintenance = result.get(0);

		Assert.assertEquals(existingCandidateMaintenance,
			newCandidateMaintenance);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CandidateMaintenance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("candidateMaintenanceId",
				RandomTestUtil.nextLong()));

		List<CandidateMaintenance> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		CandidateMaintenance newCandidateMaintenance = addCandidateMaintenance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CandidateMaintenance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"candidateMaintenanceId"));

		Object newCandidateMaintenanceId = newCandidateMaintenance.getCandidateMaintenanceId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("candidateMaintenanceId",
				new Object[] { newCandidateMaintenanceId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCandidateMaintenanceId = result.get(0);

		Assert.assertEquals(existingCandidateMaintenanceId,
			newCandidateMaintenanceId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CandidateMaintenance.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"candidateMaintenanceId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("candidateMaintenanceId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CandidateMaintenance newCandidateMaintenance = addCandidateMaintenance();

		_persistence.clearCache();

		CandidateMaintenance existingCandidateMaintenance = _persistence.findByPrimaryKey(newCandidateMaintenance.getPrimaryKey());

		Assert.assertEquals(Long.valueOf(
				existingCandidateMaintenance.getCandidateEntryId()),
			ReflectionTestUtil.<Long>invoke(existingCandidateMaintenance,
				"getOriginalCandidateEntryId", new Class<?>[0]));
		Assert.assertEquals(Long.valueOf(
				existingCandidateMaintenance.getTaskEntryId()),
			ReflectionTestUtil.<Long>invoke(existingCandidateMaintenance,
				"getOriginalTaskEntryId", new Class<?>[0]));
	}

	protected CandidateMaintenance addCandidateMaintenance()
		throws Exception {
		long pk = RandomTestUtil.nextLong();

		CandidateMaintenance candidateMaintenance = _persistence.create(pk);

		candidateMaintenance.setUuid(RandomTestUtil.randomString());

		candidateMaintenance.setCandidateEntryId(RandomTestUtil.nextLong());

		candidateMaintenance.setTaskEntryId(RandomTestUtil.nextLong());

		candidateMaintenance.setCreateDate(RandomTestUtil.nextDate());

		_candidateMaintenances.add(_persistence.update(candidateMaintenance));

		return candidateMaintenance;
	}

	private List<CandidateMaintenance> _candidateMaintenances = new ArrayList<CandidateMaintenance>();
	private CandidateMaintenancePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}