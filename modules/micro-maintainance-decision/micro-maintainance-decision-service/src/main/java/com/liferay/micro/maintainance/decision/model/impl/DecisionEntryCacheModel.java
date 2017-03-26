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

package com.liferay.micro.maintainance.decision.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.decision.model.DecisionEntry;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DecisionEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see DecisionEntry
 * @generated
 */
@ProviderType
public class DecisionEntryCacheModel implements CacheModel<DecisionEntry>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DecisionEntryCacheModel)) {
			return false;
		}

		DecisionEntryCacheModel decisionEntryCacheModel = (DecisionEntryCacheModel)obj;

		if (decisionEntryId == decisionEntryCacheModel.decisionEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, decisionEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", decisionEntryId=");
		sb.append(decisionEntryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", analysisData=");
		sb.append(analysisData);
		sb.append(", wikiPageId=");
		sb.append(wikiPageId);
		sb.append(", wikiPageName=");
		sb.append(wikiPageName);
		sb.append(", outcome=");
		sb.append(outcome);
		sb.append(", handled=");
		sb.append(handled);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DecisionEntry toEntityModel() {
		DecisionEntryImpl decisionEntryImpl = new DecisionEntryImpl();

		if (uuid == null) {
			decisionEntryImpl.setUuid(StringPool.BLANK);
		}
		else {
			decisionEntryImpl.setUuid(uuid);
		}

		decisionEntryImpl.setDecisionEntryId(decisionEntryId);
		decisionEntryImpl.setCompanyId(companyId);
		decisionEntryImpl.setUserId(userId);

		if (userName == null) {
			decisionEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			decisionEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			decisionEntryImpl.setCreateDate(null);
		}
		else {
			decisionEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			decisionEntryImpl.setModifiedDate(null);
		}
		else {
			decisionEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (analysisData == null) {
			decisionEntryImpl.setAnalysisData(StringPool.BLANK);
		}
		else {
			decisionEntryImpl.setAnalysisData(analysisData);
		}

		decisionEntryImpl.setWikiPageId(wikiPageId);

		if (wikiPageName == null) {
			decisionEntryImpl.setWikiPageName(StringPool.BLANK);
		}
		else {
			decisionEntryImpl.setWikiPageName(wikiPageName);
		}

		if (outcome == null) {
			decisionEntryImpl.setOutcome(StringPool.BLANK);
		}
		else {
			decisionEntryImpl.setOutcome(outcome);
		}

		decisionEntryImpl.setHandled(handled);

		decisionEntryImpl.resetOriginalValues();

		return decisionEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		decisionEntryId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		analysisData = objectInput.readUTF();

		wikiPageId = objectInput.readLong();
		wikiPageName = objectInput.readUTF();
		outcome = objectInput.readUTF();

		handled = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(decisionEntryId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (analysisData == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(analysisData);
		}

		objectOutput.writeLong(wikiPageId);

		if (wikiPageName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(wikiPageName);
		}

		if (outcome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(outcome);
		}

		objectOutput.writeBoolean(handled);
	}

	public String uuid;
	public long decisionEntryId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String analysisData;
	public long wikiPageId;
	public String wikiPageName;
	public String outcome;
	public boolean handled;
}