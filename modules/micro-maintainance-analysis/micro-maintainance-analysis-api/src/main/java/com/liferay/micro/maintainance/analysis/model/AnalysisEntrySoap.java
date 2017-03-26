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

package com.liferay.micro.maintainance.analysis.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.micro.maintainance.analysis.service.http.AnalysisEntryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.micro.maintainance.analysis.service.http.AnalysisEntryServiceSoap
 * @generated
 */
@ProviderType
public class AnalysisEntrySoap implements Serializable {
	public static AnalysisEntrySoap toSoapModel(AnalysisEntry model) {
		AnalysisEntrySoap soapModel = new AnalysisEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAnalysisEntryId(model.getAnalysisEntryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCandidateMaintenanceId(model.getCandidateMaintenanceId());
		soapModel.setAnalysisData(model.getAnalysisData());

		return soapModel;
	}

	public static AnalysisEntrySoap[] toSoapModels(AnalysisEntry[] models) {
		AnalysisEntrySoap[] soapModels = new AnalysisEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnalysisEntrySoap[][] toSoapModels(AnalysisEntry[][] models) {
		AnalysisEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnalysisEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnalysisEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnalysisEntrySoap[] toSoapModels(List<AnalysisEntry> models) {
		List<AnalysisEntrySoap> soapModels = new ArrayList<AnalysisEntrySoap>(models.size());

		for (AnalysisEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnalysisEntrySoap[soapModels.size()]);
	}

	public AnalysisEntrySoap() {
	}

	public long getPrimaryKey() {
		return _analysisEntryId;
	}

	public void setPrimaryKey(long pk) {
		setAnalysisEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAnalysisEntryId() {
		return _analysisEntryId;
	}

	public void setAnalysisEntryId(long analysisEntryId) {
		_analysisEntryId = analysisEntryId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCandidateMaintenanceId() {
		return _candidateMaintenanceId;
	}

	public void setCandidateMaintenanceId(long candidateMaintenanceId) {
		_candidateMaintenanceId = candidateMaintenanceId;
	}

	public String getAnalysisData() {
		return _analysisData;
	}

	public void setAnalysisData(String analysisData) {
		_analysisData = analysisData;
	}

	private String _uuid;
	private long _analysisEntryId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _candidateMaintenanceId;
	private String _analysisData;
}