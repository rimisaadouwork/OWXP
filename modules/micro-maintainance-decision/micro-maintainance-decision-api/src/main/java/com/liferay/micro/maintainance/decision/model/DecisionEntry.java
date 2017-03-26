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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the DecisionEntry service. Represents a row in the &quot;Decision_DecisionEntry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DecisionEntryModel
 * @see com.liferay.micro.maintainance.decision.model.impl.DecisionEntryImpl
 * @see com.liferay.micro.maintainance.decision.model.impl.DecisionEntryModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.micro.maintainance.decision.model.impl.DecisionEntryImpl")
@ProviderType
public interface DecisionEntry extends DecisionEntryModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.micro.maintainance.decision.model.impl.DecisionEntryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DecisionEntry, Long> DECISION_ENTRY_ID_ACCESSOR =
		new Accessor<DecisionEntry, Long>() {
			@Override
			public Long get(DecisionEntry decisionEntry) {
				return decisionEntry.getDecisionEntryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DecisionEntry> getTypeClass() {
				return DecisionEntry.class;
			}
		};
}