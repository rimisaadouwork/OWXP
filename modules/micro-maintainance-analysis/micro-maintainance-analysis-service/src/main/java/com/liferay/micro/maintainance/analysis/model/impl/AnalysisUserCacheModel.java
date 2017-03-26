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

import com.liferay.micro.maintainance.analysis.model.AnalysisUser;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AnalysisUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisUser
 * @generated
 */
@ProviderType
public class AnalysisUserCacheModel implements CacheModel<AnalysisUser>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnalysisUserCacheModel)) {
			return false;
		}

		AnalysisUserCacheModel analysisUserCacheModel = (AnalysisUserCacheModel)obj;

		if (analysisUserId == analysisUserCacheModel.analysisUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, analysisUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", analysisUserId=");
		sb.append(analysisUserId);
		sb.append(", analysisEntryId=");
		sb.append(analysisEntryId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", voted=");
		sb.append(voted);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnalysisUser toEntityModel() {
		AnalysisUserImpl analysisUserImpl = new AnalysisUserImpl();

		if (uuid == null) {
			analysisUserImpl.setUuid(StringPool.BLANK);
		}
		else {
			analysisUserImpl.setUuid(uuid);
		}

		analysisUserImpl.setAnalysisUserId(analysisUserId);
		analysisUserImpl.setAnalysisEntryId(analysisEntryId);
		analysisUserImpl.setUserId(userId);

		if (userName == null) {
			analysisUserImpl.setUserName(StringPool.BLANK);
		}
		else {
			analysisUserImpl.setUserName(userName);
		}

		analysisUserImpl.setVoted(voted);

		analysisUserImpl.resetOriginalValues();

		return analysisUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		analysisUserId = objectInput.readLong();

		analysisEntryId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();

		voted = objectInput.readInt();
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

		objectOutput.writeLong(analysisUserId);

		objectOutput.writeLong(analysisEntryId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeInt(voted);
	}

	public String uuid;
	public long analysisUserId;
	public long analysisEntryId;
	public long userId;
	public String userName;
	public int voted;
}