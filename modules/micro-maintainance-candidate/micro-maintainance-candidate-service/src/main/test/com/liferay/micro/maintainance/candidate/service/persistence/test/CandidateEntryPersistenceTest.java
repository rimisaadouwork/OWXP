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

package com.liferay.micro.maintainance.candidate.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.micro.maintainance.candidate.exception.NoSuchEntryException;
import com.liferay.micro.maintainance.candidate.model.CandidateEntry;
import com.liferay.micro.maintainance.candidate.service.CandidateEntryLocalServiceUtil;
import com.liferay.micro.maintainance.candidate.service.persistence.CandidateEntryPersistence;
import com.liferay.micro.maintainance.candidate.service.persistence.CandidateEntryUtil;

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
import java.util.Objects;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CandidateEntryPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = CandidateEntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CandidateEntry> iterator = _candidateEntries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CandidateEntry candidateEntry = _persistence.create(pk);

		Assert.assertNotNull(candidateEntry);

		Assert.assertEquals(candidateEntry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CandidateEntry newCandidateEntry = addCandidateEntry();

		_persistence.remove(newCandidateEntry);

		CandidateEntry existingCandidateEntry = _persistence.fetchByPrimaryKey(newCandidateEntry.getPrimaryKey());

		Assert.assertNull(existingCandidateEntry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCandidateEntry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CandidateEntry newCandidateEntry = _persistence.create(pk);

		newCandidateEntry.setUuid(RandomTestUtil.randomString());

		newCandidateEntry.setGroupId(RandomTestUtil.nextLong());

		newCandidateEntry.setCompanyId(RandomTestUtil.nextLong());

		newCandidateEntry.setUserId(RandomTestUtil.nextLong());

		newCandidateEntry.setUserName(RandomTestUtil.randomString());

		newCandidateEntry.setCreateDate(RandomTestUtil.nextDate());

		newCandidateEntry.setModifiedDate(RandomTestUtil.nextDate());

		newCandidateEntry.setWikiPageId(RandomTestUtil.nextLong());

		_candidateEntries.add(_persistence.update(newCandidateEntry));

		CandidateEntry existingCandidateEntry = _persistence.findByPrimaryKey(newCandidateEntry.getPrimaryKey());

		Assert.assertEquals(existingCandidateEntry.getUuid(),
			newCandidateEntry.getUuid());
		Assert.assertEquals(existingCandidateEntry.getCandidateEntryId(),
			newCandidateEntry.getCandidateEntryId());
		Assert.assertEquals(existingCandidateEntry.getGroupId(),
			newCandidateEntry.getGroupId());
		Assert.assertEquals(existingCandidateEntry.getCompanyId(),
			newCandidateEntry.getCompanyId());
		Assert.assertEquals(existingCandidateEntry.getUserId(),
			newCandidateEntry.getUserId());
		Assert.assertEquals(existingCandidateEntry.getUserName(),
			newCandidateEntry.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingCandidateEntry.getCreateDate()),
			Time.getShortTimestamp(newCandidateEntry.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingCandidateEntry.getModifiedDate()),
			Time.getShortTimestamp(newCandidateEntry.getModifiedDate()));
		Assert.assertEquals(existingCandidateEntry.getWikiPageId(),
			newCandidateEntry.getWikiPageId());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUUID_G(StringPool.NULL, 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUuid_C(StringPool.NULL, 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testCountByCompanyId() throws Exception {
		_persistence.countByCompanyId(RandomTestUtil.nextLong());

		_persistence.countByCompanyId(0L);
	}

	@Test
	public void testCountByC_ctD() throws Exception {
		_persistence.countByC_ctD(RandomTestUtil.nextLong(),
			RandomTestUtil.nextDate());

		_persistence.countByC_ctD(0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByC_U() throws Exception {
		_persistence.countByC_U(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByC_U(0L, 0L);
	}

	@Test
	public void testCountByG_P() throws Exception {
		_persistence.countByG_P(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByG_P(0L, 0L);
	}

	@Test
	public void testCountByG_U_P() throws Exception {
		_persistence.countByG_U_P(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByG_U_P(0L, 0L, 0L);
	}

	@Test
	public void testCountByU_cD() throws Exception {
		_persistence.countByU_cD(RandomTestUtil.nextLong(),
			RandomTestUtil.nextDate());

		_persistence.countByU_cD(0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testCountByU_P() throws Exception {
		_persistence.countByU_P(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByU_P(0L, 0L);
	}

	@Test
	public void testCountByWikiPageId() throws Exception {
		_persistence.countByWikiPageId(RandomTestUtil.nextLong());

		_persistence.countByWikiPageId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CandidateEntry newCandidateEntry = addCandidateEntry();

		CandidateEntry existingCandidateEntry = _persistence.findByPrimaryKey(newCandidateEntry.getPrimaryKey());

		Assert.assertEquals(existingCandidateEntry, newCandidateEntry);
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

	protected OrderByComparator<CandidateEntry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("Candidate_CandidateEntry",
			"uuid", true, "candidateEntryId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "wikiPageId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CandidateEntry newCandidateEntry = addCandidateEntry();

		CandidateEntry existingCandidateEntry = _persistence.fetchByPrimaryKey(newCandidateEntry.getPrimaryKey());

		Assert.assertEquals(existingCandidateEntry, newCandidateEntry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CandidateEntry missingCandidateEntry = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCandidateEntry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		CandidateEntry newCandidateEntry1 = addCandidateEntry();
		CandidateEntry newCandidateEntry2 = addCandidateEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCandidateEntry1.getPrimaryKey());
		primaryKeys.add(newCandidateEntry2.getPrimaryKey());

		Map<Serializable, CandidateEntry> candidateEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, candidateEntries.size());
		Assert.assertEquals(newCandidateEntry1,
			candidateEntries.get(newCandidateEntry1.getPrimaryKey()));
		Assert.assertEquals(newCandidateEntry2,
			candidateEntries.get(newCandidateEntry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CandidateEntry> candidateEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(candidateEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		CandidateEntry newCandidateEntry = addCandidateEntry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCandidateEntry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CandidateEntry> candidateEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, candidateEntries.size());
		Assert.assertEquals(newCandidateEntry,
			candidateEntries.get(newCandidateEntry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CandidateEntry> candidateEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(candidateEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		CandidateEntry newCandidateEntry = addCandidateEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCandidateEntry.getPrimaryKey());

		Map<Serializable, CandidateEntry> candidateEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, candidateEntries.size());
		Assert.assertEquals(newCandidateEntry,
			candidateEntries.get(newCandidateEntry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = CandidateEntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<CandidateEntry>() {
				@Override
				public void performAction(CandidateEntry candidateEntry) {
					Assert.assertNotNull(candidateEntry);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		CandidateEntry newCandidateEntry = addCandidateEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CandidateEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("candidateEntryId",
				newCandidateEntry.getCandidateEntryId()));

		List<CandidateEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		CandidateEntry existingCandidateEntry = result.get(0);

		Assert.assertEquals(existingCandidateEntry, newCandidateEntry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CandidateEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("candidateEntryId",
				RandomTestUtil.nextLong()));

		List<CandidateEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		CandidateEntry newCandidateEntry = addCandidateEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CandidateEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"candidateEntryId"));

		Object newCandidateEntryId = newCandidateEntry.getCandidateEntryId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("candidateEntryId",
				new Object[] { newCandidateEntryId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCandidateEntryId = result.get(0);

		Assert.assertEquals(existingCandidateEntryId, newCandidateEntryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CandidateEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"candidateEntryId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("candidateEntryId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CandidateEntry newCandidateEntry = addCandidateEntry();

		_persistence.clearCache();

		CandidateEntry existingCandidateEntry = _persistence.findByPrimaryKey(newCandidateEntry.getPrimaryKey());

		Assert.assertTrue(Objects.equals(existingCandidateEntry.getUuid(),
				ReflectionTestUtil.invoke(existingCandidateEntry,
					"getOriginalUuid", new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingCandidateEntry.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingCandidateEntry,
				"getOriginalGroupId", new Class<?>[0]));

		Assert.assertEquals(Long.valueOf(existingCandidateEntry.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingCandidateEntry,
				"getOriginalGroupId", new Class<?>[0]));
		Assert.assertEquals(Long.valueOf(existingCandidateEntry.getWikiPageId()),
			ReflectionTestUtil.<Long>invoke(existingCandidateEntry,
				"getOriginalWikiPageId", new Class<?>[0]));

		Assert.assertEquals(Long.valueOf(existingCandidateEntry.getWikiPageId()),
			ReflectionTestUtil.<Long>invoke(existingCandidateEntry,
				"getOriginalWikiPageId", new Class<?>[0]));
	}

	protected CandidateEntry addCandidateEntry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CandidateEntry candidateEntry = _persistence.create(pk);

		candidateEntry.setUuid(RandomTestUtil.randomString());

		candidateEntry.setGroupId(RandomTestUtil.nextLong());

		candidateEntry.setCompanyId(RandomTestUtil.nextLong());

		candidateEntry.setUserId(RandomTestUtil.nextLong());

		candidateEntry.setUserName(RandomTestUtil.randomString());

		candidateEntry.setCreateDate(RandomTestUtil.nextDate());

		candidateEntry.setModifiedDate(RandomTestUtil.nextDate());

		candidateEntry.setWikiPageId(RandomTestUtil.nextLong());

		_candidateEntries.add(_persistence.update(candidateEntry));

		return candidateEntry;
	}

	private List<CandidateEntry> _candidateEntries = new ArrayList<CandidateEntry>();
	private CandidateEntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}