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

package com.liferay.micro.maintainance.task.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.micro.maintainance.task.model.CandidateMaintenance;

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
 * The cache model class for representing CandidateMaintenance in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateMaintenance
 * @generated
 */
@ProviderType
public class CandidateMaintenanceCacheModel implements CacheModel<CandidateMaintenance>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateMaintenanceCacheModel)) {
			return false;
		}

		CandidateMaintenanceCacheModel candidateMaintenanceCacheModel = (CandidateMaintenanceCacheModel)obj;

		if (candidateMaintenanceId == candidateMaintenanceCacheModel.candidateMaintenanceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, candidateMaintenanceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", candidateMaintenanceId=");
		sb.append(candidateMaintenanceId);
		sb.append(", candidateEntryId=");
		sb.append(candidateEntryId);
		sb.append(", taskEntryId=");
		sb.append(taskEntryId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CandidateMaintenance toEntityModel() {
		CandidateMaintenanceImpl candidateMaintenanceImpl = new CandidateMaintenanceImpl();

		if (uuid == null) {
			candidateMaintenanceImpl.setUuid(StringPool.BLANK);
		}
		else {
			candidateMaintenanceImpl.setUuid(uuid);
		}

		candidateMaintenanceImpl.setCandidateMaintenanceId(candidateMaintenanceId);
		candidateMaintenanceImpl.setCandidateEntryId(candidateEntryId);
		candidateMaintenanceImpl.setTaskEntryId(taskEntryId);

		if (createDate == Long.MIN_VALUE) {
			candidateMaintenanceImpl.setCreateDate(null);
		}
		else {
			candidateMaintenanceImpl.setCreateDate(new Date(createDate));
		}

		candidateMaintenanceImpl.resetOriginalValues();

		return candidateMaintenanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		candidateMaintenanceId = objectInput.readLong();

		candidateEntryId = objectInput.readLong();

		taskEntryId = objectInput.readLong();
		createDate = objectInput.readLong();
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

		objectOutput.writeLong(candidateMaintenanceId);

		objectOutput.writeLong(candidateEntryId);

		objectOutput.writeLong(taskEntryId);
		objectOutput.writeLong(createDate);
	}

	public String uuid;
	public long candidateMaintenanceId;
	public long candidateEntryId;
	public long taskEntryId;
	public long createDate;
}