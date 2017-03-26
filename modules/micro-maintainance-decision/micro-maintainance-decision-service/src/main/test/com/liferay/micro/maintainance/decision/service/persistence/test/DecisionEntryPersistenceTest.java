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

package com.liferay.micro.maintainance.decision.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.micro.maintainance.decision.exception.NoSuchEntryException;
import com.liferay.micro.maintainance.decision.model.DecisionEntry;
import com.liferay.micro.maintainance.decision.service.DecisionEntryLocalServiceUtil;
import com.liferay.micro.maintainance.decision.service.persistence.DecisionEntryPersistence;
import com.liferay.micro.maintainance.decision.service.persistence.DecisionEntryUtil;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
public class DecisionEntryPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = DecisionEntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DecisionEntry> iterator = _decisionEntries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DecisionEntry decisionEntry = _persistence.create(pk);

		Assert.assertNotNull(decisionEntry);

		Assert.assertEquals(decisionEntry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DecisionEntry newDecisionEntry = addDecisionEntry();

		_persistence.remove(newDecisionEntry);

		DecisionEntry existingDecisionEntry = _persistence.fetchByPrimaryKey(newDecisionEntry.getPrimaryKey());

		Assert.assertNull(existingDecisionEntry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDecisionEntry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DecisionEntry newDecisionEntry = _persistence.create(pk);

		newDecisionEntry.setUuid(RandomTestUtil.randomString());

		newDecisionEntry.setCompanyId(RandomTestUtil.nextLong());

		newDecisionEntry.setUserId(RandomTestUtil.nextLong());

		newDecisionEntry.setUserName(RandomTestUtil.randomString());

		newDecisionEntry.setCreateDate(RandomTestUtil.nextDate());

		newDecisionEntry.setModifiedDate(RandomTestUtil.nextDate());

		newDecisionEntry.setAnalysisData(RandomTestUtil.randomString());

		newDecisionEntry.setWikiPageId(RandomTestUtil.nextLong());

		newDecisionEntry.setWikiPageName(RandomTestUtil.randomString());

		newDecisionEntry.setOutcome(RandomTestUtil.randomString());

		newDecisionEntry.setHandled(RandomTestUtil.randomBoolean());

		_decisionEntries.add(_persistence.update(newDecisionEntry));

		DecisionEntry existingDecisionEntry = _persistence.findByPrimaryKey(newDecisionEntry.getPrimaryKey());

		Assert.assertEquals(existingDecisionEntry.getUuid(),
			newDecisionEntry.getUuid());
		Assert.assertEquals(existingDecisionEntry.getDecisionEntryId(),
			newDecisionEntry.getDecisionEntryId());
		Assert.assertEquals(existingDecisionEntry.getCompanyId(),
			newDecisionEntry.getCompanyId());
		Assert.assertEquals(existingDecisionEntry.getUserId(),
			newDecisionEntry.getUserId());
		Assert.assertEquals(existingDecisionEntry.getUserName(),
			newDecisionEntry.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingDecisionEntry.getCreateDate()),
			Time.getShortTimestamp(newDecisionEntry.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingDecisionEntry.getModifiedDate()),
			Time.getShortTimestamp(newDecisionEntry.getModifiedDate()));
		Assert.assertEquals(existingDecisionEntry.getAnalysisData(),
			newDecisionEntry.getAnalysisData());
		Assert.assertEquals(existingDecisionEntry.getWikiPageId(),
			newDecisionEntry.getWikiPageId());
		Assert.assertEquals(existingDecisionEntry.getWikiPageName(),
			newDecisionEntry.getWikiPageName());
		Assert.assertEquals(existingDecisionEntry.getOutcome(),
			newDecisionEntry.getOutcome());
		Assert.assertEquals(existingDecisionEntry.getHandled(),
			newDecisionEntry.getHandled());
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
	public void testCountByCompanyId() throws Exception {
		_persistence.countByCompanyId(RandomTestUtil.nextLong());

		_persistence.countByCompanyId(0L);
	}

	@Test
	public void testCountByDecisionEntryId() throws Exception {
		_persistence.countByDecisionEntryId(RandomTestUtil.nextLong());

		_persistence.countByDecisionEntryId(0L);
	}

	@Test
	public void testCountByOutcome() throws Exception {
		_persistence.countByOutcome(StringPool.BLANK);

		_persistence.countByOutcome(StringPool.NULL);

		_persistence.countByOutcome((String)null);
	}

	@Test
	public void testCountByWikiPageId() throws Exception {
		_persistence.countByWikiPageId(RandomTestUtil.nextLong());

		_persistence.countByWikiPageId(0L);
	}

	@Test
	public void testCountByWikiPageName() throws Exception {
		_persistence.countByWikiPageName(StringPool.BLANK);

		_persistence.countByWikiPageName(StringPool.NULL);

		_persistence.countByWikiPageName((String)null);
	}

	@Test
	public void testCountByC_H() throws Exception {
		_persistence.countByC_H(RandomTestUtil.nextLong(),
			RandomTestUtil.randomBoolean());

		_persistence.countByC_H(0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByD_C() throws Exception {
		_persistence.countByD_C(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByD_C(0L, 0L);
	}

	@Test
	public void testCountByD_H() throws Exception {
		_persistence.countByD_H(RandomTestUtil.nextLong(),
			RandomTestUtil.randomBoolean());

		_persistence.countByD_H(0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByD_U() throws Exception {
		_persistence.countByD_U(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByD_U(0L, 0L);
	}

	@Test
	public void testCountByD_U_C() throws Exception {
		_persistence.countByD_U_C(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByD_U_C(0L, 0L, 0L);
	}

	@Test
	public void testCountByU_H() throws Exception {
		_persistence.countByU_H(RandomTestUtil.nextLong(),
			RandomTestUtil.randomBoolean());

		_persistence.countByU_H(0L, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByU_H_D() throws Exception {
		_persistence.countByU_H_D(RandomTestUtil.nextLong(),
			RandomTestUtil.randomBoolean(), RandomTestUtil.nextLong());

		_persistence.countByU_H_D(0L, RandomTestUtil.randomBoolean(), 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		DecisionEntry newDecisionEntry = addDecisionEntry();

		DecisionEntry existingDecisionEntry = _persistence.findByPrimaryKey(newDecisionEntry.getPrimaryKey());

		Assert.assertEquals(existingDecisionEntry, newDecisionEntry);
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

	protected OrderByComparator<DecisionEntry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("Decision_DecisionEntry",
			"uuid", true, "decisionEntryId", true, "companyId", true, "userId",
			true, "userName", true, "createDate", true, "modifiedDate", true,
			"analysisData", true, "wikiPageId", true, "wikiPageName", true,
			"outcome", true, "handled", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DecisionEntry newDecisionEntry = addDecisionEntry();

		DecisionEntry existingDecisionEntry = _persistence.fetchByPrimaryKey(newDecisionEntry.getPrimaryKey());

		Assert.assertEquals(existingDecisionEntry, newDecisionEntry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DecisionEntry missingDecisionEntry = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDecisionEntry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		DecisionEntry newDecisionEntry1 = addDecisionEntry();
		DecisionEntry newDecisionEntry2 = addDecisionEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDecisionEntry1.getPrimaryKey());
		primaryKeys.add(newDecisionEntry2.getPrimaryKey());

		Map<Serializable, DecisionEntry> decisionEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, decisionEntries.size());
		Assert.assertEquals(newDecisionEntry1,
			decisionEntries.get(newDecisionEntry1.getPrimaryKey()));
		Assert.assertEquals(newDecisionEntry2,
			decisionEntries.get(newDecisionEntry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DecisionEntry> decisionEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(decisionEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		DecisionEntry newDecisionEntry = addDecisionEntry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDecisionEntry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DecisionEntry> decisionEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, decisionEntries.size());
		Assert.assertEquals(newDecisionEntry,
			decisionEntries.get(newDecisionEntry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DecisionEntry> decisionEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(decisionEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		DecisionEntry newDecisionEntry = addDecisionEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDecisionEntry.getPrimaryKey());

		Map<Serializable, DecisionEntry> decisionEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, decisionEntries.size());
		Assert.assertEquals(newDecisionEntry,
			decisionEntries.get(newDecisionEntry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = DecisionEntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<DecisionEntry>() {
				@Override
				public void performAction(DecisionEntry decisionEntry) {
					Assert.assertNotNull(decisionEntry);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		DecisionEntry newDecisionEntry = addDecisionEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DecisionEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("decisionEntryId",
				newDecisionEntry.getDecisionEntryId()));

		List<DecisionEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		DecisionEntry existingDecisionEntry = result.get(0);

		Assert.assertEquals(existingDecisionEntry, newDecisionEntry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DecisionEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("decisionEntryId",
				RandomTestUtil.nextLong()));

		List<DecisionEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		DecisionEntry newDecisionEntry = addDecisionEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DecisionEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"decisionEntryId"));

		Object newDecisionEntryId = newDecisionEntry.getDecisionEntryId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("decisionEntryId",
				new Object[] { newDecisionEntryId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDecisionEntryId = result.get(0);

		Assert.assertEquals(existingDecisionEntryId, newDecisionEntryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DecisionEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"decisionEntryId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("decisionEntryId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected DecisionEntry addDecisionEntry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DecisionEntry decisionEntry = _persistence.create(pk);

		decisionEntry.setUuid(RandomTestUtil.randomString());

		decisionEntry.setCompanyId(RandomTestUtil.nextLong());

		decisionEntry.setUserId(RandomTestUtil.nextLong());

		decisionEntry.setUserName(RandomTestUtil.randomString());

		decisionEntry.setCreateDate(RandomTestUtil.nextDate());

		decisionEntry.setModifiedDate(RandomTestUtil.nextDate());

		decisionEntry.setAnalysisData(RandomTestUtil.randomString());

		decisionEntry.setWikiPageId(RandomTestUtil.nextLong());

		decisionEntry.setWikiPageName(RandomTestUtil.randomString());

		decisionEntry.setOutcome(RandomTestUtil.randomString());

		decisionEntry.setHandled(RandomTestUtil.randomBoolean());

		_decisionEntries.add(_persistence.update(decisionEntry));

		return decisionEntry;
	}

	private List<DecisionEntry> _decisionEntries = new ArrayList<DecisionEntry>();
	private DecisionEntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}