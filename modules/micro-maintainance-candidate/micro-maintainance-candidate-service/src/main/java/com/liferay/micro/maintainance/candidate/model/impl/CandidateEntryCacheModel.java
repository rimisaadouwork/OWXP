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

package com.liferay.micro.maintainance.candidate.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.candidate.model.CandidateEntry;

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
 * The cache model class for representing CandidateEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateEntry
 * @generated
 */
@ProviderType
public class CandidateEntryCacheModel implements CacheModel<CandidateEntry>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateEntryCacheModel)) {
			return false;
		}

		CandidateEntryCacheModel candidateEntryCacheModel = (CandidateEntryCacheModel)obj;

		if (candidateEntryId == candidateEntryCacheModel.candidateEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, candidateEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", candidateEntryId=");
		sb.append(candidateEntryId);
		sb.append(", groupId=");
		sb.append(groupId);
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
		sb.append(", wikiPageId=");
		sb.append(wikiPageId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CandidateEntry toEntityModel() {
		CandidateEntryImpl candidateEntryImpl = new CandidateEntryImpl();

		if (uuid == null) {
			candidateEntryImpl.setUuid(StringPool.BLANK);
		}
		else {
			candidateEntryImpl.setUuid(uuid);
		}

		candidateEntryImpl.setCandidateEntryId(candidateEntryId);
		candidateEntryImpl.setGroupId(groupId);
		candidateEntryImpl.setCompanyId(companyId);
		candidateEntryImpl.setUserId(userId);

		if (userName == null) {
			candidateEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			candidateEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			candidateEntryImpl.setCreateDate(null);
		}
		else {
			candidateEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			candidateEntryImpl.setModifiedDate(null);
		}
		else {
			candidateEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		candidateEntryImpl.setWikiPageId(wikiPageId);

		candidateEntryImpl.resetOriginalValues();

		return candidateEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		candidateEntryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		wikiPageId = objectInput.readLong();
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

		objectOutput.writeLong(candidateEntryId);

		objectOutput.writeLong(groupId);

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

		objectOutput.writeLong(wikiPageId);
	}

	public String uuid;
	public long candidateEntryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long wikiPageId;
}