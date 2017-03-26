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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link AnalysisUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisUser
 * @generated
 */
@ProviderType
public class AnalysisUserWrapper implements AnalysisUser,
	ModelWrapper<AnalysisUser> {
	public AnalysisUserWrapper(AnalysisUser analysisUser) {
		_analysisUser = analysisUser;
	}

	@Override
	public Class<?> getModelClass() {
		return AnalysisUser.class;
	}

	@Override
	public String getModelClassName() {
		return AnalysisUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("analysisUserId", getAnalysisUserId());
		attributes.put("analysisEntryId", getAnalysisEntryId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("voted", getVoted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long analysisUserId = (Long)attributes.get("analysisUserId");

		if (analysisUserId != null) {
			setAnalysisUserId(analysisUserId);
		}

		Long analysisEntryId = (Long)attributes.get("analysisEntryId");

		if (analysisEntryId != null) {
			setAnalysisEntryId(analysisEntryId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Integer voted = (Integer)attributes.get("voted");

		if (voted != null) {
			setVoted(voted);
		}
	}

	@Override
	public AnalysisUser toEscapedModel() {
		return new AnalysisUserWrapper(_analysisUser.toEscapedModel());
	}

	@Override
	public AnalysisUser toUnescapedModel() {
		return new AnalysisUserWrapper(_analysisUser.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _analysisUser.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _analysisUser.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _analysisUser.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _analysisUser.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AnalysisUser> toCacheModel() {
		return _analysisUser.toCacheModel();
	}

	@Override
	public int compareTo(AnalysisUser analysisUser) {
		return _analysisUser.compareTo(analysisUser);
	}

	/**
	* Returns the voted of this analysis user.
	*
	* @return the voted of this analysis user
	*/
	@Override
	public int getVoted() {
		return _analysisUser.getVoted();
	}

	@Override
	public int hashCode() {
		return _analysisUser.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _analysisUser.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AnalysisUserWrapper((AnalysisUser)_analysisUser.clone());
	}

	/**
	* Returns the analysis user uuid of this analysis user.
	*
	* @return the analysis user uuid of this analysis user
	*/
	@Override
	public java.lang.String getAnalysisUserUuid() {
		return _analysisUser.getAnalysisUserUuid();
	}

	/**
	* Returns the user name of this analysis user.
	*
	* @return the user name of this analysis user
	*/
	@Override
	public java.lang.String getUserName() {
		return _analysisUser.getUserName();
	}

	/**
	* Returns the user uuid of this analysis user.
	*
	* @return the user uuid of this analysis user
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _analysisUser.getUserUuid();
	}

	/**
	* Returns the uuid of this analysis user.
	*
	* @return the uuid of this analysis user
	*/
	@Override
	public java.lang.String getUuid() {
		return _analysisUser.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _analysisUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _analysisUser.toXmlString();
	}

	/**
	* Returns the analysis entry ID of this analysis user.
	*
	* @return the analysis entry ID of this analysis user
	*/
	@Override
	public long getAnalysisEntryId() {
		return _analysisUser.getAnalysisEntryId();
	}

	/**
	* Returns the analysis user ID of this analysis user.
	*
	* @return the analysis user ID of this analysis user
	*/
	@Override
	public long getAnalysisUserId() {
		return _analysisUser.getAnalysisUserId();
	}

	/**
	* Returns the primary key of this analysis user.
	*
	* @return the primary key of this analysis user
	*/
	@Override
	public long getPrimaryKey() {
		return _analysisUser.getPrimaryKey();
	}

	/**
	* Returns the user ID of this analysis user.
	*
	* @return the user ID of this analysis user
	*/
	@Override
	public long getUserId() {
		return _analysisUser.getUserId();
	}

	@Override
	public void persist() {
		_analysisUser.persist();
	}

	/**
	* Sets the analysis entry ID of this analysis user.
	*
	* @param analysisEntryId the analysis entry ID of this analysis user
	*/
	@Override
	public void setAnalysisEntryId(long analysisEntryId) {
		_analysisUser.setAnalysisEntryId(analysisEntryId);
	}

	/**
	* Sets the analysis user ID of this analysis user.
	*
	* @param analysisUserId the analysis user ID of this analysis user
	*/
	@Override
	public void setAnalysisUserId(long analysisUserId) {
		_analysisUser.setAnalysisUserId(analysisUserId);
	}

	/**
	* Sets the analysis user uuid of this analysis user.
	*
	* @param analysisUserUuid the analysis user uuid of this analysis user
	*/
	@Override
	public void setAnalysisUserUuid(java.lang.String analysisUserUuid) {
		_analysisUser.setAnalysisUserUuid(analysisUserUuid);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_analysisUser.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_analysisUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_analysisUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_analysisUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_analysisUser.setNew(n);
	}

	/**
	* Sets the primary key of this analysis user.
	*
	* @param primaryKey the primary key of this analysis user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_analysisUser.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_analysisUser.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this analysis user.
	*
	* @param userId the user ID of this analysis user
	*/
	@Override
	public void setUserId(long userId) {
		_analysisUser.setUserId(userId);
	}

	/**
	* Sets the user name of this analysis user.
	*
	* @param userName the user name of this analysis user
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_analysisUser.setUserName(userName);
	}

	/**
	* Sets the user uuid of this analysis user.
	*
	* @param userUuid the user uuid of this analysis user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_analysisUser.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this analysis user.
	*
	* @param uuid the uuid of this analysis user
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_analysisUser.setUuid(uuid);
	}

	/**
	* Sets the voted of this analysis user.
	*
	* @param voted the voted of this analysis user
	*/
	@Override
	public void setVoted(int voted) {
		_analysisUser.setVoted(voted);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnalysisUserWrapper)) {
			return false;
		}

		AnalysisUserWrapper analysisUserWrapper = (AnalysisUserWrapper)obj;

		if (Objects.equals(_analysisUser, analysisUserWrapper._analysisUser)) {
			return true;
		}

		return false;
	}

	@Override
	public AnalysisUser getWrappedModel() {
		return _analysisUser;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _analysisUser.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _analysisUser.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_analysisUser.resetOriginalValues();
	}

	private final AnalysisUser _analysisUser;
}