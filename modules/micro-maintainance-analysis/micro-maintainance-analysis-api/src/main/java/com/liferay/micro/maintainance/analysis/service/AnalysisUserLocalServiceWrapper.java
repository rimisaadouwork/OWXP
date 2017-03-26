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

package com.liferay.micro.maintainance.analysis.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnalysisUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisUserLocalService
 * @generated
 */
@ProviderType
public class AnalysisUserLocalServiceWrapper implements AnalysisUserLocalService,
	ServiceWrapper<AnalysisUserLocalService> {
	public AnalysisUserLocalServiceWrapper(
		AnalysisUserLocalService analysisUserLocalService) {
		_analysisUserLocalService = analysisUserLocalService;
	}

	/**
	* Adds the analysis user to the database. Also notifies the appropriate model listeners.
	*
	* @param analysisUser the analysis user
	* @return the analysis user that was added
	*/
	@Override
	public com.liferay.micro.maintainance.analysis.model.AnalysisUser addAnalysisUser(
		com.liferay.micro.maintainance.analysis.model.AnalysisUser analysisUser) {
		return _analysisUserLocalService.addAnalysisUser(analysisUser);
	}

	/**
	* Adds a user's vote to an analysis
	*/
	@Override
	public com.liferay.micro.maintainance.analysis.model.AnalysisUser addAnalysisUser(
		long analysisEntryId, long userId, int vote)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _analysisUserLocalService.addAnalysisUser(analysisEntryId,
			userId, vote);
	}

	/**
	* Creates a new analysis user with the primary key. Does not add the analysis user to the database.
	*
	* @param analysisUserId the primary key for the new analysis user
	* @return the new analysis user
	*/
	@Override
	public com.liferay.micro.maintainance.analysis.model.AnalysisUser createAnalysisUser(
		long analysisUserId) {
		return _analysisUserLocalService.createAnalysisUser(analysisUserId);
	}

	/**
	* Deletes the analysis user from the database. Also notifies the appropriate model listeners.
	*
	* @param analysisUser the analysis user
	* @return the analysis user that was removed
	*/
	@Override
	public com.liferay.micro.maintainance.analysis.model.AnalysisUser deleteAnalysisUser(
		com.liferay.micro.maintainance.analysis.model.AnalysisUser analysisUser) {
		return _analysisUserLocalService.deleteAnalysisUser(analysisUser);
	}

	/**
	* Deletes the analysis user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analysisUserId the primary key of the analysis user
	* @return the analysis user that was removed
	* @throws PortalException if a analysis user with the primary key could not be found
	*/
	@Override
	public com.liferay.micro.maintainance.analysis.model.AnalysisUser deleteAnalysisUser(
		long analysisUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _analysisUserLocalService.deleteAnalysisUser(analysisUserId);
	}

	@Override
	public com.liferay.micro.maintainance.analysis.model.AnalysisUser fetchAnalysisUser(
		long analysisUserId) {
		return _analysisUserLocalService.fetchAnalysisUser(analysisUserId);
	}

	@Override
	public com.liferay.micro.maintainance.analysis.model.AnalysisUser getAnalysisUser(
		long analysisEntryId, long userId) {
		return _analysisUserLocalService.getAnalysisUser(analysisEntryId, userId);
	}

	/**
	* Returns the analysis user with the primary key.
	*
	* @param analysisUserId the primary key of the analysis user
	* @return the analysis user
	* @throws PortalException if a analysis user with the primary key could not be found
	*/
	@Override
	public com.liferay.micro.maintainance.analysis.model.AnalysisUser getAnalysisUser(
		long analysisUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _analysisUserLocalService.getAnalysisUser(analysisUserId);
	}

	/**
	* Updates the analysis user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param analysisUser the analysis user
	* @return the analysis user that was updated
	*/
	@Override
	public com.liferay.micro.maintainance.analysis.model.AnalysisUser updateAnalysisUser(
		com.liferay.micro.maintainance.analysis.model.AnalysisUser analysisUser) {
		return _analysisUserLocalService.updateAnalysisUser(analysisUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _analysisUserLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _analysisUserLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _analysisUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _analysisUserLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _analysisUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of analysis users.
	*
	* @return the number of analysis users
	*/
	@Override
	public int getAnalysisUsersCount() {
		return _analysisUserLocalService.getAnalysisUsersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _analysisUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _analysisUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.analysis.model.impl.AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _analysisUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.analysis.model.impl.AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _analysisUserLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the analysis users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.analysis.model.impl.AnalysisUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analysis users
	* @param end the upper bound of the range of analysis users (not inclusive)
	* @return the range of analysis users
	*/
	@Override
	public java.util.List<com.liferay.micro.maintainance.analysis.model.AnalysisUser> getAnalysisUsers(
		int start, int end) {
		return _analysisUserLocalService.getAnalysisUsers(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _analysisUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _analysisUserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public AnalysisUserLocalService getWrappedService() {
		return _analysisUserLocalService;
	}

	@Override
	public void setWrappedService(
		AnalysisUserLocalService analysisUserLocalService) {
		_analysisUserLocalService = analysisUserLocalService;
	}

	private AnalysisUserLocalService _analysisUserLocalService;
}