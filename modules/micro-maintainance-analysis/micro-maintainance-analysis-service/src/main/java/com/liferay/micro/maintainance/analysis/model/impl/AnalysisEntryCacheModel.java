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

package com.liferay.micro.maintainance.analysis.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;

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
 * The cache model class for representing AnalysisEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisEntry
 * @generated
 */
@ProviderType
public class AnalysisEntryCacheModel implements CacheModel<AnalysisEntry>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnalysisEntryCacheModel)) {
			return false;
		}

		AnalysisEntryCacheModel analysisEntryCacheModel = (AnalysisEntryCacheModel)obj;

		if (analysisEntryId == analysisEntryCacheModel.analysisEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, analysisEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", analysisEntryId=");
		sb.append(analysisEntryId);
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
		sb.append(", candidateMaintenanceId=");
		sb.append(candidateMaintenanceId);
		sb.append(", analysisData=");
		sb.append(analysisData);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnalysisEntry toEntityModel() {
		AnalysisEntryImpl analysisEntryImpl = new AnalysisEntryImpl();

		if (uuid == null) {
			analysisEntryImpl.setUuid(StringPool.BLANK);
		}
		else {
			analysisEntryImpl.setUuid(uuid);
		}

		analysisEntryImpl.setAnalysisEntryId(analysisEntryId);
		analysisEntryImpl.setCompanyId(companyId);
		analysisEntryImpl.setUserId(userId);

		if (userName == null) {
			analysisEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			analysisEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			analysisEntryImpl.setCreateDate(null);
		}
		else {
			analysisEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			analysisEntryImpl.setModifiedDate(null);
		}
		else {
			analysisEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		analysisEntryImpl.setCandidateMaintenanceId(candidateMaintenanceId);

		if (analysisData == null) {
			analysisEntryImpl.setAnalysisData(StringPool.BLANK);
		}
		else {
			analysisEntryImpl.setAnalysisData(analysisData);
		}

		analysisEntryImpl.resetOriginalValues();

		return analysisEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		analysisEntryId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		candidateMaintenanceId = objectInput.readLong();
		analysisData = objectInput.readUTF();
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

		objectOutput.writeLong(analysisEntryId);

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

		objectOutput.writeLong(candidateMaintenanceId);

		if (analysisData == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(analysisData);
		}
	}

	public String uuid;
	public long analysisEntryId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long candidateMaintenanceId;
	public String analysisData;
}