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
 * This class is used by SOAP remote services, specifically {@link com.liferay.micro.maintainance.task.service.http.CandidateMaintenanceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.micro.maintainance.task.service.http.CandidateMaintenanceServiceSoap
 * @generated
 */
@ProviderType
public class CandidateMaintenanceSoap implements Serializable {
	public static CandidateMaintenanceSoap toSoapModel(
		CandidateMaintenance model) {
		CandidateMaintenanceSoap soapModel = new CandidateMaintenanceSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCandidateMaintenanceId(model.getCandidateMaintenanceId());
		soapModel.setCandidateEntryId(model.getCandidateEntryId());
		soapModel.setTaskEntryId(model.getTaskEntryId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static CandidateMaintenanceSoap[] toSoapModels(
		CandidateMaintenance[] models) {
		CandidateMaintenanceSoap[] soapModels = new CandidateMaintenanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CandidateMaintenanceSoap[][] toSoapModels(
		CandidateMaintenance[][] models) {
		CandidateMaintenanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CandidateMaintenanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CandidateMaintenanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CandidateMaintenanceSoap[] toSoapModels(
		List<CandidateMaintenance> models) {
		List<CandidateMaintenanceSoap> soapModels = new ArrayList<CandidateMaintenanceSoap>(models.size());

		for (CandidateMaintenance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CandidateMaintenanceSoap[soapModels.size()]);
	}

	public CandidateMaintenanceSoap() {
	}

	public long getPrimaryKey() {
		return _candidateMaintenanceId;
	}

	public void setPrimaryKey(long pk) {
		setCandidateMaintenanceId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCandidateMaintenanceId() {
		return _candidateMaintenanceId;
	}

	public void setCandidateMaintenanceId(long candidateMaintenanceId) {
		_candidateMaintenanceId = candidateMaintenanceId;
	}

	public long getCandidateEntryId() {
		return _candidateEntryId;
	}

	public void setCandidateEntryId(long candidateEntryId) {
		_candidateEntryId = candidateEntryId;
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

	private String _uuid;
	private long _candidateMaintenanceId;
	private long _candidateEntryId;
	private long _taskEntryId;
	private Date _createDate;
}