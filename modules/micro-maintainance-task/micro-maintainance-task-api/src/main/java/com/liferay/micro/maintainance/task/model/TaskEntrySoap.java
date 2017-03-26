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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.micro.maintainance.task.service.http.TaskEntryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.micro.maintainance.task.service.http.TaskEntryServiceSoap
 * @generated
 */
@ProviderType
public class TaskEntrySoap implements Serializable {
	public static TaskEntrySoap toSoapModel(TaskEntry model) {
		TaskEntrySoap soapModel = new TaskEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTaskEntryId(model.getTaskEntryId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setTaskEntryName(model.getTaskEntryName());

		return soapModel;
	}

	public static TaskEntrySoap[] toSoapModels(TaskEntry[] models) {
		TaskEntrySoap[] soapModels = new TaskEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaskEntrySoap[][] toSoapModels(TaskEntry[][] models) {
		TaskEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaskEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaskEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaskEntrySoap[] toSoapModels(List<TaskEntry> models) {
		List<TaskEntrySoap> soapModels = new ArrayList<TaskEntrySoap>(models.size());

		for (TaskEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaskEntrySoap[soapModels.size()]);
	}

	public TaskEntrySoap() {
	}

	public long getPrimaryKey() {
		return _taskEntryId;
	}

	public void setPrimaryKey(long pk) {
		setTaskEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTaskEntryId() {
		return _taskEntryId;
	}

	public void setTaskEntryId(long taskEntryId) {
		_taskEntryId = taskEntryId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getTaskEntryName() {
		return _taskEntryName;
	}

	public void setTaskEntryName(String taskEntryName) {
		_taskEntryName = taskEntryName;
	}

	private String _uuid;
	private long _taskEntryId;
	private Date _createDate;
	private String _taskEntryName;
}