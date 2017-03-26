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

import com.liferay.micro.maintainance.task.exception.NoSuchEntryException;
import com.liferay.micro.maintainance.task.model.TaskEntry;
import com.liferay.micro.maintainance.task.service.TaskEntryLocalServiceUtil;
import com.liferay.micro.maintainance.task.service.persistence.TaskEntryPersistence;
import com.liferay.micro.maintainance.task.service.persistence.TaskEntryUtil;

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
public class TaskEntryPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = TaskEntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<TaskEntry> iterator = _taskEntries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TaskEntry taskEntry = _persistence.create(pk);

		Assert.assertNotNull(taskEntry);

		Assert.assertEquals(taskEntry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		TaskEntry newTaskEntry = addTaskEntry();

		_persistence.remove(newTaskEntry);

		TaskEntry existingTaskEntry = _persistence.fetchByPrimaryKey(newTaskEntry.getPrimaryKey());

		Assert.assertNull(existingTaskEntry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTaskEntry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TaskEntry newTaskEntry = _persistence.create(pk);

		newTaskEntry.setUuid(RandomTestUtil.randomString());

		newTaskEntry.setCreateDate(RandomTestUtil.nextDate());

		newTaskEntry.setTaskEntryName(RandomTestUtil.randomString());

		_taskEntries.add(_persistence.update(newTaskEntry));

		TaskEntry existingTaskEntry = _persistence.findByPrimaryKey(newTaskEntry.getPrimaryKey());

		Assert.assertEquals(existingTaskEntry.getUuid(), newTaskEntry.getUuid());
		Assert.assertEquals(existingTaskEntry.getTaskEntryId(),
			newTaskEntry.getTaskEntryId());
		Assert.assertEquals(Time.getShortTimestamp(
				existingTaskEntry.getCreateDate()),
			Time.getShortTimestamp(newTaskEntry.getCreateDate()));
		Assert.assertEquals(existingTaskEntry.getTaskEntryName(),
			newTaskEntry.getTaskEntryName());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByTasksById() throws Exception {
		_persistence.countByTasksById(RandomTestUtil.nextLong());

		_persistence.countByTasksById(0L);
	}

	@Test
	public void testCountByTasksByName() throws Exception {
		_persistence.countByTasksByName(StringPool.BLANK);

		_persistence.countByTasksByName(StringPool.NULL);

		_persistence.countByTasksByName((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		TaskEntry newTaskEntry = addTaskEntry();

		TaskEntry existingTaskEntry = _persistence.findByPrimaryKey(newTaskEntry.getPrimaryKey());

		Assert.assertEquals(existingTaskEntry, newTaskEntry);
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

	protected OrderByComparator<TaskEntry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("Task_TaskEntry", "uuid",
			true, "taskEntryId", true, "createDate", true, "taskEntryName", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		TaskEntry newTaskEntry = addTaskEntry();

		TaskEntry existingTaskEntry = _persistence.fetchByPrimaryKey(newTaskEntry.getPrimaryKey());

		Assert.assertEquals(existingTaskEntry, newTaskEntry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TaskEntry missingTaskEntry = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingTaskEntry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		TaskEntry newTaskEntry1 = addTaskEntry();
		TaskEntry newTaskEntry2 = addTaskEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTaskEntry1.getPrimaryKey());
		primaryKeys.add(newTaskEntry2.getPrimaryKey());

		Map<Serializable, TaskEntry> taskEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, taskEntries.size());
		Assert.assertEquals(newTaskEntry1,
			taskEntries.get(newTaskEntry1.getPrimaryKey()));
		Assert.assertEquals(newTaskEntry2,
			taskEntries.get(newTaskEntry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, TaskEntry> taskEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(taskEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		TaskEntry newTaskEntry = addTaskEntry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTaskEntry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, TaskEntry> taskEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, taskEntries.size());
		Assert.assertEquals(newTaskEntry,
			taskEntries.get(newTaskEntry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, TaskEntry> taskEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(taskEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		TaskEntry newTaskEntry = addTaskEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTaskEntry.getPrimaryKey());

		Map<Serializable, TaskEntry> taskEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, taskEntries.size());
		Assert.assertEquals(newTaskEntry,
			taskEntries.get(newTaskEntry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = TaskEntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<TaskEntry>() {
				@Override
				public void performAction(TaskEntry taskEntry) {
					Assert.assertNotNull(taskEntry);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		TaskEntry newTaskEntry = addTaskEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(TaskEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("taskEntryId",
				newTaskEntry.getTaskEntryId()));

		List<TaskEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		TaskEntry existingTaskEntry = result.get(0);

		Assert.assertEquals(existingTaskEntry, newTaskEntry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(TaskEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("taskEntryId",
				RandomTestUtil.nextLong()));

		List<TaskEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		TaskEntry newTaskEntry = addTaskEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(TaskEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("taskEntryId"));

		Object newTaskEntryId = newTaskEntry.getTaskEntryId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("taskEntryId",
				new Object[] { newTaskEntryId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTaskEntryId = result.get(0);

		Assert.assertEquals(existingTaskEntryId, newTaskEntryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(TaskEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("taskEntryId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("taskEntryId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		TaskEntry newTaskEntry = addTaskEntry();

		_persistence.clearCache();

		TaskEntry existingTaskEntry = _persistence.findByPrimaryKey(newTaskEntry.getPrimaryKey());

		Assert.assertEquals(Long.valueOf(existingTaskEntry.getTaskEntryId()),
			ReflectionTestUtil.<Long>invoke(existingTaskEntry,
				"getOriginalTaskEntryId", new Class<?>[0]));

		Assert.assertTrue(Objects.equals(existingTaskEntry.getTaskEntryName(),
				ReflectionTestUtil.invoke(existingTaskEntry,
					"getOriginalTaskEntryName", new Class<?>[0])));
	}

	protected TaskEntry addTaskEntry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TaskEntry taskEntry = _persistence.create(pk);

		taskEntry.setUuid(RandomTestUtil.randomString());

		taskEntry.setCreateDate(RandomTestUtil.nextDate());

		taskEntry.setTaskEntryName(RandomTestUtil.randomString());

		_taskEntries.add(_persistence.update(taskEntry));

		return taskEntry;
	}

	private List<TaskEntry> _taskEntries = new ArrayList<TaskEntry>();
	private TaskEntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}