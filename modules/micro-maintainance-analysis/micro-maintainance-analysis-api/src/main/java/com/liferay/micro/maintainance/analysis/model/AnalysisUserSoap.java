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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.micro.maintainance.analysis.service.http.AnalysisUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.micro.maintainance.analysis.service.http.AnalysisUserServiceSoap
 * @generated
 */
@ProviderType
public class AnalysisUserSoap implements Serializable {
	public static AnalysisUserSoap toSoapModel(AnalysisUser model) {
		AnalysisUserSoap soapModel = new AnalysisUserSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAnalysisUserId(model.getAnalysisUserId());
		soapModel.setAnalysisEntryId(model.getAnalysisEntryId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setVoted(model.getVoted());

		return soapModel;
	}

	public static AnalysisUserSoap[] toSoapModels(AnalysisUser[] models) {
		AnalysisUserSoap[] soapModels = new AnalysisUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnalysisUserSoap[][] toSoapModels(AnalysisUser[][] models) {
		AnalysisUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnalysisUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnalysisUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnalysisUserSoap[] toSoapModels(List<AnalysisUser> models) {
		List<AnalysisUserSoap> soapModels = new ArrayList<AnalysisUserSoap>(models.size());

		for (AnalysisUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnalysisUserSoap[soapModels.size()]);
	}

	public AnalysisUserSoap() {
	}

	public long getPrimaryKey() {
		return _analysisUserId;
	}

	public void setPrimaryKey(long pk) {
		setAnalysisUserId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAnalysisUserId() {
		return _analysisUserId;
	}

	public void setAnalysisUserId(long analysisUserId) {
		_analysisUserId = analysisUserId;
	}

	public long getAnalysisEntryId() {
		return _analysisEntryId;
	}

	public void setAnalysisEntryId(long analysisEntryId) {
		_analysisEntryId = analysisEntryId;
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

	public int getVoted() {
		return _voted;
	}

	public void setVoted(int voted) {
		_voted = voted;
	}

	private String _uuid;
	private long _analysisUserId;
	private long _analysisEntryId;
	private long _userId;
	private String _userName;
	private int _voted;
}