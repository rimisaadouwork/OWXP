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

package com.liferay.micro.maintainance.task.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.task.model.TaskEntry;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TaskEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TaskEntry
 * @generated
 */
@ProviderType
public class TaskEntryCacheModel implements CacheModel<TaskEntry>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskEntryCacheModel)) {
			return false;
		}

		TaskEntryCacheModel taskEntryCacheModel = (TaskEntryCacheModel)obj;

		if (taskEntryId == taskEntryCacheModel.taskEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taskEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", taskEntryId=");
		sb.append(taskEntryId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", taskEntryName=");
		sb.append(taskEntryName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaskEntry toEntityModel() {
		TaskEntryImpl taskEntryImpl = new TaskEntryImpl();

		if (uuid == null) {
			taskEntryImpl.setUuid(StringPool.BLANK);
		}
		else {
			taskEntryImpl.setUuid(uuid);
		}

		taskEntryImpl.setTaskEntryId(taskEntryId);

		if (createDate == Long.MIN_VALUE) {
			taskEntryImpl.setCreateDate(null);
		}
		else {
			taskEntryImpl.setCreateDate(new Date(createDate));
		}

		if (taskEntryName == null) {
			taskEntryImpl.setTaskEntryName(StringPool.BLANK);
		}
		else {
			taskEntryImpl.setTaskEntryName(taskEntryName);
		}

		taskEntryImpl.resetOriginalValues();

		return taskEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		taskEntryId = objectInput.readLong();
		createDate = objectInput.readLong();
		taskEntryName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(taskEntryId);
		objectOutput.writeLong(createDate);

		if (taskEntryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taskEntryName);
		}
	}

	public String uuid;
	public long taskEntryId;
	public long createDate;
	public String taskEntryName;
}