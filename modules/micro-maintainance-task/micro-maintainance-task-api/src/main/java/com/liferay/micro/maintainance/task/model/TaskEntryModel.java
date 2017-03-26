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

package com.liferay.micro.maintainance.task.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the TaskEntry service. Represents a row in the &quot;Task_TaskEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.micro.maintainance.task.model.impl.TaskEntryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.micro.maintainance.task.model.impl.TaskEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskEntry
 * @see com.liferay.micro.maintainance.task.model.impl.TaskEntryImpl
 * @see com.liferay.micro.maintainance.task.model.impl.TaskEntryModelImpl
 * @generated
 */
@ProviderType
public interface TaskEntryModel extends BaseModel<TaskEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a task entry model instance should use the {@link TaskEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this task entry.
	 *
	 * @return the primary key of this task entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this task entry.
	 *
	 * @param primaryKey the primary key of this task entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this task entry.
	 *
	 * @return the uuid of this task entry
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this task entry.
	 *
	 * @param uuid the uuid of this task entry
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the task entry ID of this task entry.
	 *
	 * @return the task entry ID of this task entry
	 */
	public long getTaskEntryId();

	/**
	 * Sets the task entry ID of this task entry.
	 *
	 * @param taskEntryId the task entry ID of this task entry
	 */
	public void setTaskEntryId(long taskEntryId);

	/**
	 * Returns the create date of this task entry.
	 *
	 * @return the create date of this task entry
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this task entry.
	 *
	 * @param createDate the create date of this task entry
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the task entry name of this task entry.
	 *
	 * @return the task entry name of this task entry
	 */
	@AutoEscape
	public String getTaskEntryName();

	/**
	 * Sets the task entry name of this task entry.
	 *
	 * @param taskEntryName the task entry name of this task entry
	 */
	public void setTaskEntryName(String taskEntryName);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(TaskEntry taskEntry);

	@Override
	public int hashCode();

	@Override
	public CacheModel<TaskEntry> toCacheModel();

	@Override
	public TaskEntry toEscapedModel();

	@Override
	public TaskEntry toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}