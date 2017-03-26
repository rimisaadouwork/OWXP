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
 * This class is a wrapper for {@link CandidateEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateEntry
 * @generated
 */
@ProviderType
public class CandidateEntryWrapper implements CandidateEntry,
	ModelWrapper<CandidateEntry> {
	public CandidateEntryWrapper(CandidateEntry candidateEntry) {
		_candidateEntry = candidateEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return CandidateEntry.class;
	}

	@Override
	public String getModelClassName() {
		return CandidateEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("candidateEntryId", getCandidateEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("wikiPageId", getWikiPageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long candidateEntryId = (Long)attributes.get("candidateEntryId");

		if (candidateEntryId != null) {
			setCandidateEntryId(candidateEntryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Long wikiPageId = (Long)attributes.get("wikiPageId");

		if (wikiPageId != null) {
			setWikiPageId(wikiPageId);
		}
	}

	@Override
	public CandidateEntry toEscapedModel() {
		return new CandidateEntryWrapper(_candidateEntry.toEscapedModel());
	}

	@Override
	public CandidateEntry toUnescapedModel() {
		return new CandidateEntryWrapper(_candidateEntry.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _candidateEntry.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _candidateEntry.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _candidateEntry.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _candidateEntry.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CandidateEntry> toCacheModel() {
		return _candidateEntry.toCacheModel();
	}

	@Override
	public int compareTo(CandidateEntry candidateEntry) {
		return _candidateEntry.compareTo(candidateEntry);
	}

	@Override
	public int hashCode() {
		return _candidateEntry.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _candidateEntry.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CandidateEntryWrapper((CandidateEntry)_candidateEntry.clone());
	}

	/**
	* Returns the user name of this candidate entry.
	*
	* @return the user name of this candidate entry
	*/
	@Override
	public java.lang.String getUserName() {
		return _candidateEntry.getUserName();
	}

	/**
	* Returns the user uuid of this candidate entry.
	*
	* @return the user uuid of this candidate entry
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _candidateEntry.getUserUuid();
	}

	/**
	* Returns the uuid of this candidate entry.
	*
	* @return the uuid of this candidate entry
	*/
	@Override
	public java.lang.String getUuid() {
		return _candidateEntry.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _candidateEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _candidateEntry.toXmlString();
	}

	/**
	* Returns the create date of this candidate entry.
	*
	* @return the create date of this candidate entry
	*/
	@Override
	public Date getCreateDate() {
		return _candidateEntry.getCreateDate();
	}

	/**
	* Returns the modified date of this candidate entry.
	*
	* @return the modified date of this candidate entry
	*/
	@Override
	public Date getModifiedDate() {
		return _candidateEntry.getModifiedDate();
	}

	/**
	* Returns the candidate entry ID of this candidate entry.
	*
	* @return the candidate entry ID of this candidate entry
	*/
	@Override
	public long getCandidateEntryId() {
		return _candidateEntry.getCandidateEntryId();
	}

	/**
	* Returns the company ID of this candidate entry.
	*
	* @return the company ID of this candidate entry
	*/
	@Override
	public long getCompanyId() {
		return _candidateEntry.getCompanyId();
	}

	/**
	* Returns the group ID of this candidate entry.
	*
	* @return the group ID of this candidate entry
	*/
	@Override
	public long getGroupId() {
		return _candidateEntry.getGroupId();
	}

	/**
	* Returns the primary key of this candidate entry.
	*
	* @return the primary key of this candidate entry
	*/
	@Override
	public long getPrimaryKey() {
		return _candidateEntry.getPrimaryKey();
	}

	/**
	* Returns the user ID of this candidate entry.
	*
	* @return the user ID of this candidate entry
	*/
	@Override
	public long getUserId() {
		return _candidateEntry.getUserId();
	}

	/**
	* Returns the wiki page ID of this candidate entry.
	*
	* @return the wiki page ID of this candidate entry
	*/
	@Override
	public long getWikiPageId() {
		return _candidateEntry.getWikiPageId();
	}

	@Override
	public void persist() {
		_candidateEntry.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_candidateEntry.setCachedModel(cachedModel);
	}

	/**
	* Sets the candidate entry ID of this candidate entry.
	*
	* @param candidateEntryId the candidate entry ID of this candidate entry
	*/
	@Override
	public void setCandidateEntryId(long candidateEntryId) {
		_candidateEntry.setCandidateEntryId(candidateEntryId);
	}

	/**
	* Sets the company ID of this candidate entry.
	*
	* @param companyId the company ID of this candidate entry
	*/
	@Override
	public void setCompanyId(long companyId) {
		_candidateEntry.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this candidate entry.
	*
	* @param createDate the create date of this candidate entry
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_candidateEntry.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_candidateEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_candidateEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_candidateEntry.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this candidate entry.
	*
	* @param groupId the group ID of this candidate entry
	*/
	@Override
	public void setGroupId(long groupId) {
		_candidateEntry.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this candidate entry.
	*
	* @param modifiedDate the modified date of this candidate entry
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_candidateEntry.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_candidateEntry.setNew(n);
	}

	/**
	* Sets the primary key of this candidate entry.
	*
	* @param primaryKey the primary key of this candidate entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_candidateEntry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_candidateEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this candidate entry.
	*
	* @param userId the user ID of this candidate entry
	*/
	@Override
	public void setUserId(long userId) {
		_candidateEntry.setUserId(userId);
	}

	/**
	* Sets the user name of this candidate entry.
	*
	* @param userName the user name of this candidate entry
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_candidateEntry.setUserName(userName);
	}

	/**
	* Sets the user uuid of this candidate entry.
	*
	* @param userUuid the user uuid of this candidate entry
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_candidateEntry.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this candidate entry.
	*
	* @param uuid the uuid of this candidate entry
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_candidateEntry.setUuid(uuid);
	}

	/**
	* Sets the wiki page ID of this candidate entry.
	*
	* @param wikiPageId the wiki page ID of this candidate entry
	*/
	@Override
	public void setWikiPageId(long wikiPageId) {
		_candidateEntry.setWikiPageId(wikiPageId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateEntryWrapper)) {
			return false;
		}

		CandidateEntryWrapper candidateEntryWrapper = (CandidateEntryWrapper)obj;

		if (Objects.equals(_candidateEntry,
					candidateEntryWrapper._candidateEntry)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _candidateEntry.getStagedModelType();
	}

	@Override
	public CandidateEntry getWrappedModel() {
		return _candidateEntry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _candidateEntry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _candidateEntry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_candidateEntry.resetOriginalValues();
	}

	private final CandidateEntry _candidateEntry;
}