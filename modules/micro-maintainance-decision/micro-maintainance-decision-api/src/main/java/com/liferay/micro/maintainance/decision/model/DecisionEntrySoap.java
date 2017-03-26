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

package com.liferay.micro.maintainance.decision.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.micro.maintainance.decision.service.http.DecisionEntryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.micro.maintainance.decision.service.http.DecisionEntryServiceSoap
 * @generated
 */
@ProviderType
public class DecisionEntrySoap implements Serializable {
	public static DecisionEntrySoap toSoapModel(DecisionEntry model) {
		DecisionEntrySoap soapModel = new DecisionEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDecisionEntryId(model.getDecisionEntryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAnalysisData(model.getAnalysisData());
		soapModel.setWikiPageId(model.getWikiPageId());
		soapModel.setWikiPageName(model.getWikiPageName());
		soapModel.setOutcome(model.getOutcome());
		soapModel.setHandled(model.getHandled());

		return soapModel;
	}

	public static DecisionEntrySoap[] toSoapModels(DecisionEntry[] models) {
		DecisionEntrySoap[] soapModels = new DecisionEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DecisionEntrySoap[][] toSoapModels(DecisionEntry[][] models) {
		DecisionEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DecisionEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new DecisionEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DecisionEntrySoap[] toSoapModels(List<DecisionEntry> models) {
		List<DecisionEntrySoap> soapModels = new ArrayList<DecisionEntrySoap>(models.size());

		for (DecisionEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DecisionEntrySoap[soapModels.size()]);
	}

	public DecisionEntrySoap() {
	}

	public long getPrimaryKey() {
		return _decisionEntryId;
	}

	public void setPrimaryKey(long pk) {
		setDecisionEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDecisionEntryId() {
		return _decisionEntryId;
	}

	public void setDecisionEntryId(long decisionEntryId) {
		_decisionEntryId = decisionEntryId;
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

	public String getAnalysisData() {
		return _analysisData;
	}

	public void setAnalysisData(String analysisData) {
		_analysisData = analysisData;
	}

	public long getWikiPageId() {
		return _wikiPageId;
	}

	public void setWikiPageId(long wikiPageId) {
		_wikiPageId = wikiPageId;
	}

	public String getWikiPageName() {
		return _wikiPageName;
	}

	public void setWikiPageName(String wikiPageName) {
		_wikiPageName = wikiPageName;
	}

	public String getOutcome() {
		return _outcome;
	}

	public void setOutcome(String outcome) {
		_outcome = outcome;
	}

	public boolean getHandled() {
		return _handled;
	}

	public boolean isHandled() {
		return _handled;
	}

	public void setHandled(boolean handled) {
		_handled = handled;
	}

	private String _uuid;
	private long _decisionEntryId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _analysisData;
	private long _wikiPageId;
	private String _wikiPageName;
	private String _outcome;
	private boolean _handled;
}