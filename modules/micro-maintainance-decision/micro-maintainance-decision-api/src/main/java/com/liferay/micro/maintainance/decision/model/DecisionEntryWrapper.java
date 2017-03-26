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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link DecisionEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DecisionEntry
 * @generated
 */
@ProviderType
public class DecisionEntryWrapper implements DecisionEntry,
	ModelWrapper<DecisionEntry> {
	public DecisionEntryWrapper(DecisionEntry decisionEntry) {
		_decisionEntry = decisionEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return DecisionEntry.class;
	}

	@Override
	public String getModelClassName() {
		return DecisionEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("decisionEntryId", getDecisionEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("analysisData", getAnalysisData());
		attributes.put("wikiPageId", getWikiPageId());
		attributes.put("wikiPageName", getWikiPageName());
		attributes.put("outcome", getOutcome());
		attributes.put("handled", getHandled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long decisionEntryId = (Long)attributes.get("decisionEntryId");

		if (decisionEntryId != null) {
			setDecisionEntryId(decisionEntryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String analysisData = (String)attributes.get("analysisData");

		if (analysisData != null) {
			setAnalysisData(analysisData);
		}

		Long wikiPageId = (Long)attributes.get("wikiPageId");

		if (wikiPageId != null) {
			setWikiPageId(wikiPageId);
		}

		String wikiPageName = (String)attributes.get("wikiPageName");

		if (wikiPageName != null) {
			setWikiPageName(wikiPageName);
		}

		String outcome = (String)attributes.get("outcome");

		if (outcome != null) {
			setOutcome(outcome);
		}

		Boolean handled = (Boolean)attributes.get("handled");

		if (handled != null) {
			setHandled(handled);
		}
	}

	@Override
	public DecisionEntry toEscapedModel() {
		return new DecisionEntryWrapper(_decisionEntry.toEscapedModel());
	}

	@Override
	public DecisionEntry toUnescapedModel() {
		return new DecisionEntryWrapper(_decisionEntry.toUnescapedModel());
	}

	/**
	* Returns the handled of this decision entry.
	*
	* @return the handled of this decision entry
	*/
	@Override
	public boolean getHandled() {
		return _decisionEntry.getHandled();
	}

	@Override
	public boolean isCachedModel() {
		return _decisionEntry.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _decisionEntry.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this decision entry is handled.
	*
	* @return <code>true</code> if this decision entry is handled; <code>false</code> otherwise
	*/
	@Override
	public boolean isHandled() {
		return _decisionEntry.isHandled();
	}

	@Override
	public boolean isNew() {
		return _decisionEntry.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _decisionEntry.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<DecisionEntry> toCacheModel() {
		return _decisionEntry.toCacheModel();
	}

	@Override
	public int compareTo(DecisionEntry decisionEntry) {
		return _decisionEntry.compareTo(decisionEntry);
	}

	@Override
	public int hashCode() {
		return _decisionEntry.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _decisionEntry.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DecisionEntryWrapper((DecisionEntry)_decisionEntry.clone());
	}

	/**
	* Returns the analysis data of this decision entry.
	*
	* @return the analysis data of this decision entry
	*/
	@Override
	public java.lang.String getAnalysisData() {
		return _decisionEntry.getAnalysisData();
	}

	/**
	* Returns the outcome of this decision entry.
	*
	* @return the outcome of this decision entry
	*/
	@Override
	public java.lang.String getOutcome() {
		return _decisionEntry.getOutcome();
	}

	/**
	* Returns the user name of this decision entry.
	*
	* @return the user name of this decision entry
	*/
	@Override
	public java.lang.String getUserName() {
		return _decisionEntry.getUserName();
	}

	/**
	* Returns the user uuid of this decision entry.
	*
	* @return the user uuid of this decision entry
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _decisionEntry.getUserUuid();
	}

	/**
	* Returns the uuid of this decision entry.
	*
	* @return the uuid of this decision entry
	*/
	@Override
	public java.lang.String getUuid() {
		return _decisionEntry.getUuid();
	}

	/**
	* Returns the wiki page name of this decision entry.
	*
	* @return the wiki page name of this decision entry
	*/
	@Override
	public java.lang.String getWikiPageName() {
		return _decisionEntry.getWikiPageName();
	}

	@Override
	public java.lang.String toString() {
		return _decisionEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _decisionEntry.toXmlString();
	}

	/**
	* Returns the create date of this decision entry.
	*
	* @return the create date of this decision entry
	*/
	@Override
	public Date getCreateDate() {
		return _decisionEntry.getCreateDate();
	}

	/**
	* Returns the modified date of this decision entry.
	*
	* @return the modified date of this decision entry
	*/
	@Override
	public Date getModifiedDate() {
		return _decisionEntry.getModifiedDate();
	}

	/**
	* Returns the company ID of this decision entry.
	*
	* @return the company ID of this decision entry
	*/
	@Override
	public long getCompanyId() {
		return _decisionEntry.getCompanyId();
	}

	/**
	* Returns the decision entry ID of this decision entry.
	*
	* @return the decision entry ID of this decision entry
	*/
	@Override
	public long getDecisionEntryId() {
		return _decisionEntry.getDecisionEntryId();
	}

	/**
	* Returns the primary key of this decision entry.
	*
	* @return the primary key of this decision entry
	*/
	@Override
	public long getPrimaryKey() {
		return _decisionEntry.getPrimaryKey();
	}

	/**
	* Returns the user ID of this decision entry.
	*
	* @return the user ID of this decision entry
	*/
	@Override
	public long getUserId() {
		return _decisionEntry.getUserId();
	}

	/**
	* Returns the wiki page ID of this decision entry.
	*
	* @return the wiki page ID of this decision entry
	*/
	@Override
	public long getWikiPageId() {
		return _decisionEntry.getWikiPageId();
	}

	@Override
	public void persist() {
		_decisionEntry.persist();
	}

	/**
	* Sets the analysis data of this decision entry.
	*
	* @param analysisData the analysis data of this decision entry
	*/
	@Override
	public void setAnalysisData(java.lang.String analysisData) {
		_decisionEntry.setAnalysisData(analysisData);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_decisionEntry.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this decision entry.
	*
	* @param companyId the company ID of this decision entry
	*/
	@Override
	public void setCompanyId(long companyId) {
		_decisionEntry.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this decision entry.
	*
	* @param createDate the create date of this decision entry
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_decisionEntry.setCreateDate(createDate);
	}

	/**
	* Sets the decision entry ID of this decision entry.
	*
	* @param decisionEntryId the decision entry ID of this decision entry
	*/
	@Override
	public void setDecisionEntryId(long decisionEntryId) {
		_decisionEntry.setDecisionEntryId(decisionEntryId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_decisionEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_decisionEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_decisionEntry.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets whether this decision entry is handled.
	*
	* @param handled the handled of this decision entry
	*/
	@Override
	public void setHandled(boolean handled) {
		_decisionEntry.setHandled(handled);
	}

	/**
	* Sets the modified date of this decision entry.
	*
	* @param modifiedDate the modified date of this decision entry
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_decisionEntry.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_decisionEntry.setNew(n);
	}

	/**
	* Sets the outcome of this decision entry.
	*
	* @param outcome the outcome of this decision entry
	*/
	@Override
	public void setOutcome(java.lang.String outcome) {
		_decisionEntry.setOutcome(outcome);
	}

	/**
	* Sets the primary key of this decision entry.
	*
	* @param primaryKey the primary key of this decision entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_decisionEntry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_decisionEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this decision entry.
	*
	* @param userId the user ID of this decision entry
	*/
	@Override
	public void setUserId(long userId) {
		_decisionEntry.setUserId(userId);
	}

	/**
	* Sets the user name of this decision entry.
	*
	* @param userName the user name of this decision entry
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_decisionEntry.setUserName(userName);
	}

	/**
	* Sets the user uuid of this decision entry.
	*
	* @param userUuid the user uuid of this decision entry
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_decisionEntry.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this decision entry.
	*
	* @param uuid the uuid of this decision entry
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_decisionEntry.setUuid(uuid);
	}

	/**
	* Sets the wiki page ID of this decision entry.
	*
	* @param wikiPageId the wiki page ID of this decision entry
	*/
	@Override
	public void setWikiPageId(long wikiPageId) {
		_decisionEntry.setWikiPageId(wikiPageId);
	}

	/**
	* Sets the wiki page name of this decision entry.
	*
	* @param wikiPageName the wiki page name of this decision entry
	*/
	@Override
	public void setWikiPageName(java.lang.String wikiPageName) {
		_decisionEntry.setWikiPageName(wikiPageName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DecisionEntryWrapper)) {
			return false;
		}

		DecisionEntryWrapper decisionEntryWrapper = (DecisionEntryWrapper)obj;

		if (Objects.equals(_decisionEntry, decisionEntryWrapper._decisionEntry)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _decisionEntry.getStagedModelType();
	}

	@Override
	public DecisionEntry getWrappedModel() {
		return _decisionEntry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _decisionEntry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _decisionEntry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_decisionEntry.resetOriginalValues();
	}

	private final DecisionEntry _decisionEntry;
}