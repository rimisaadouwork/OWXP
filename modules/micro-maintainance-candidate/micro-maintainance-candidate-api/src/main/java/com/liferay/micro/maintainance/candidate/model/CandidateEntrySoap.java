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

package com.liferay.micro.maintainance.candidate.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.micro.maintainance.candidate.service.http.CandidateEntryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.micro.maintainance.candidate.service.http.CandidateEntryServiceSoap
 * @generated
 */
@ProviderType
public class CandidateEntrySoap implements Serializable {
	public static CandidateEntrySoap toSoapModel(CandidateEntry model) {
		CandidateEntrySoap soapModel = new CandidateEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCandidateEntryId(model.getCandidateEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setWikiPageId(model.getWikiPageId());

		return soapModel;
	}

	public static CandidateEntrySoap[] toSoapModels(CandidateEntry[] models) {
		CandidateEntrySoap[] soapModels = new CandidateEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CandidateEntrySoap[][] toSoapModels(CandidateEntry[][] models) {
		CandidateEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CandidateEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CandidateEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CandidateEntrySoap[] toSoapModels(List<CandidateEntry> models) {
		List<CandidateEntrySoap> soapModels = new ArrayList<CandidateEntrySoap>(models.size());

		for (CandidateEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CandidateEntrySoap[soapModels.size()]);
	}

	public CandidateEntrySoap() {
	}

	public long getPrimaryKey() {
		return _candidateEntryId;
	}

	public void setPrimaryKey(long pk) {
		setCandidateEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCandidateEntryId() {
		return _candidateEntryId;
	}

	public void setCandidateEntryId(long candidateEntryId) {
		_candidateEntryId = candidateEntryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public long getWikiPageId() {
		return _wikiPageId;
	}

	public void setWikiPageId(long wikiPageId) {
		_wikiPageId = wikiPageId;
	}

	private String _uuid;
	private long _candidateEntryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _wikiPageId;
}