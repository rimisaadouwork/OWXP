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
 * This class is a wrapper for {@link AnalysisEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisEntry
 * @generated
 */
@ProviderType
public class AnalysisEntryWrapper implements AnalysisEntry,
	ModelWrapper<AnalysisEntry> {
	public AnalysisEntryWrapper(AnalysisEntry analysisEntry) {
		_analysisEntry = analysisEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return AnalysisEntry.class;
	}

	@Override
	public String getModelClassName() {
		return AnalysisEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("analysisEntryId", getAnalysisEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("candidateMaintenanceId", getCandidateMaintenanceId());
		attributes.put("analysisData", getAnalysisData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long analysisEntryId = (Long)attributes.get("analysisEntryId");

		if (analysisEntryId != null) {
			setAnalysisEntryId(analysisEntryId);
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

		Long candidateMaintenanceId = (Long)attributes.get(
				"candidateMaintenanceId");

		if (candidateMaintenanceId != null) {
			setCandidateMaintenanceId(candidateMaintenanceId);
		}

		String analysisData = (String)attributes.get("analysisData");

		if (analysisData != null) {
			setAnalysisData(analysisData);
		}
	}

	@Override
	public AnalysisEntry toEscapedModel() {
		return new AnalysisEntryWrapper(_analysisEntry.toEscapedModel());
	}

	@Override
	public AnalysisEntry toUnescapedModel() {
		return new AnalysisEntryWrapper(_analysisEntry.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _analysisEntry.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _analysisEntry.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _analysisEntry.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _analysisEntry.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AnalysisEntry> toCacheModel() {
		return _analysisEntry.toCacheModel();
	}

	@Override
	public int compareTo(AnalysisEntry analysisEntry) {
		return _analysisEntry.compareTo(analysisEntry);
	}

	@Override
	public int hashCode() {
		return _analysisEntry.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _analysisEntry.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AnalysisEntryWrapper((AnalysisEntry)_analysisEntry.clone());
	}

	/**
	* Returns the analysis data of this analysis entry.
	*
	* @return the analysis data of this analysis entry
	*/
	@Override
	public java.lang.String getAnalysisData() {
		return _analysisEntry.getAnalysisData();
	}

	/**
	* Returns the user name of this analysis entry.
	*
	* @return the user name of this analysis entry
	*/
	@Override
	public java.lang.String getUserName() {
		return _analysisEntry.getUserName();
	}

	/**
	* Returns the user uuid of this analysis entry.
	*
	* @return the user uuid of this analysis entry
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _analysisEntry.getUserUuid();
	}

	/**
	* Returns the uuid of this analysis entry.
	*
	* @return the uuid of this analysis entry
	*/
	@Override
	public java.lang.String getUuid() {
		return _analysisEntry.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _analysisEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _analysisEntry.toXmlString();
	}

	/**
	* Returns the create date of this analysis entry.
	*
	* @return the create date of this analysis entry
	*/
	@Override
	public Date getCreateDate() {
		return _analysisEntry.getCreateDate();
	}

	/**
	* Returns the modified date of this analysis entry.
	*
	* @return the modified date of this analysis entry
	*/
	@Override
	public Date getModifiedDate() {
		return _analysisEntry.getModifiedDate();
	}

	/**
	* Returns the analysis entry ID of this analysis entry.
	*
	* @return the analysis entry ID of this analysis entry
	*/
	@Override
	public long getAnalysisEntryId() {
		return _analysisEntry.getAnalysisEntryId();
	}

	/**
	* Returns the candidate maintenance ID of this analysis entry.
	*
	* @return the candidate maintenance ID of this analysis entry
	*/
	@Override
	public long getCandidateMaintenanceId() {
		return _analysisEntry.getCandidateMaintenanceId();
	}

	/**
	* Returns the company ID of this analysis entry.
	*
	* @return the company ID of this analysis entry
	*/
	@Override
	public long getCompanyId() {
		return _analysisEntry.getCompanyId();
	}

	/**
	* Returns the primary key of this analysis entry.
	*
	* @return the primary key of this analysis entry
	*/
	@Override
	public long getPrimaryKey() {
		return _analysisEntry.getPrimaryKey();
	}

	/**
	* Returns the user ID of this analysis entry.
	*
	* @return the user ID of this analysis entry
	*/
	@Override
	public long getUserId() {
		return _analysisEntry.getUserId();
	}

	@Override
	public void persist() {
		_analysisEntry.persist();
	}

	/**
	* Sets the analysis data of this analysis entry.
	*
	* @param analysisData the analysis data of this analysis entry
	*/
	@Override
	public void setAnalysisData(java.lang.String analysisData) {
		_analysisEntry.setAnalysisData(analysisData);
	}

	/**
	* Sets the analysis entry ID of this analysis entry.
	*
	* @param analysisEntryId the analysis entry ID of this analysis entry
	*/
	@Override
	public void setAnalysisEntryId(long analysisEntryId) {
		_analysisEntry.setAnalysisEntryId(analysisEntryId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_analysisEntry.setCachedModel(cachedModel);
	}

	/**
	* Sets the candidate maintenance ID of this analysis entry.
	*
	* @param candidateMaintenanceId the candidate maintenance ID of this analysis entry
	*/
	@Override
	public void setCandidateMaintenanceId(long candidateMaintenanceId) {
		_analysisEntry.setCandidateMaintenanceId(candidateMaintenanceId);
	}

	/**
	* Sets the company ID of this analysis entry.
	*
	* @param companyId the company ID of this analysis entry
	*/
	@Override
	public void setCompanyId(long companyId) {
		_analysisEntry.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this analysis entry.
	*
	* @param createDate the create date of this analysis entry
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_analysisEntry.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_analysisEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_analysisEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_analysisEntry.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this analysis entry.
	*
	* @param modifiedDate the modified date of this analysis entry
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_analysisEntry.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_analysisEntry.setNew(n);
	}

	/**
	* Sets the primary key of this analysis entry.
	*
	* @param primaryKey the primary key of this analysis entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_analysisEntry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_analysisEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this analysis entry.
	*
	* @param userId the user ID of this analysis entry
	*/
	@Override
	public void setUserId(long userId) {
		_analysisEntry.setUserId(userId);
	}

	/**
	* Sets the user name of this analysis entry.
	*
	* @param userName the user name of this analysis entry
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_analysisEntry.setUserName(userName);
	}

	/**
	* Sets the user uuid of this analysis entry.
	*
	* @param userUuid the user uuid of this analysis entry
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_analysisEntry.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this analysis entry.
	*
	* @param uuid the uuid of this analysis entry
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_analysisEntry.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnalysisEntryWrapper)) {
			return false;
		}

		AnalysisEntryWrapper analysisEntryWrapper = (AnalysisEntryWrapper)obj;

		if (Objects.equals(_analysisEntry, analysisEntryWrapper._analysisEntry)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _analysisEntry.getStagedModelType();
	}

	@Override
	public AnalysisEntry getWrappedModel() {
		return _analysisEntry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _analysisEntry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _analysisEntry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_analysisEntry.resetOriginalValues();
	}

	private final AnalysisEntry _analysisEntry;
}