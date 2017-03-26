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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AnalysisEntry. This utility wraps
 * {@link com.liferay.micro.maintainance.analysis.service.impl.AnalysisEntryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AnalysisEntryLocalService
 * @see com.liferay.micro.maintainance.analysis.service.base.AnalysisEntryLocalServiceBaseImpl
 * @see com.liferay.micro.maintainance.analysis.service.impl.AnalysisEntryLocalServiceImpl
 * @generated
 */
@ProviderType
public class AnalysisEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.micro.maintainance.analysis.service.impl.AnalysisEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the analysis entry to the database. Also notifies the appropriate model listeners.
	*
	* @param analysisEntry the analysis entry
	* @return the analysis entry that was added
	*/
	public static com.liferay.micro.maintainance.analysis.model.AnalysisEntry addAnalysisEntry(
		com.liferay.micro.maintainance.analysis.model.AnalysisEntry analysisEntry) {
		return getService().addAnalysisEntry(analysisEntry);
	}

	/**
	* Adds an analysis entry, which will store the votes
	*
	* @param userId: the id of the user who flagged the page
	* @param candidateMaintenanceId: the id of the CandidateMaintenance entry, in which the
	assignment between a task and a candidate is stored.
	* @return the AnalysisEntry that was added
	* @throws PortalException
	*/
	public static com.liferay.micro.maintainance.analysis.model.AnalysisEntry addAnalysisEntry(
		long userId, long candidateMaintenanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().addAnalysisEntry(userId, candidateMaintenanceId);
	}

	/**
	* Creates a new analysis entry with the primary key. Does not add the analysis entry to the database.
	*
	* @param analysisEntryId the primary key for the new analysis entry
	* @return the new analysis entry
	*/
	public static com.liferay.micro.maintainance.analysis.model.AnalysisEntry createAnalysisEntry(
		long analysisEntryId) {
		return getService().createAnalysisEntry(analysisEntryId);
	}

	/**
	* Deletes the analysis entry from the database. Also notifies the appropriate model listeners.
	*
	* @param analysisEntry the analysis entry
	* @return the analysis entry that was removed
	*/
	public static com.liferay.micro.maintainance.analysis.model.AnalysisEntry deleteAnalysisEntry(
		com.liferay.micro.maintainance.analysis.model.AnalysisEntry analysisEntry) {
		return getService().deleteAnalysisEntry(analysisEntry);
	}

	/**
	* Deletes the analysis entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analysisEntryId the primary key of the analysis entry
	* @return the analysis entry that was removed
	* @throws PortalException if a analysis entry with the primary key could not be found
	*/
	public static com.liferay.micro.maintainance.analysis.model.AnalysisEntry deleteAnalysisEntry(
		long analysisEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteAnalysisEntry(analysisEntryId);
	}

	public static com.liferay.micro.maintainance.analysis.model.AnalysisEntry fetchAnalysisEntry(
		long analysisEntryId) {
		return getService().fetchAnalysisEntry(analysisEntryId);
	}

	/**
	* Returns the analysis entry with the matching UUID and company.
	*
	* @param uuid the analysis entry's UUID
	* @param companyId the primary key of the company
	* @return the matching analysis entry, or <code>null</code> if a matching analysis entry could not be found
	*/
	public static com.liferay.micro.maintainance.analysis.model.AnalysisEntry fetchAnalysisEntryByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().fetchAnalysisEntryByUuidAndCompanyId(uuid, companyId);
	}

	public static com.liferay.micro.maintainance.analysis.model.AnalysisEntry getAnalysisByCandidateMaintenance(
		long candidateMaintenanceId) {
		return getService()
				   .getAnalysisByCandidateMaintenance(candidateMaintenanceId);
	}

	/**
	* Returns the analysis entry with the primary key.
	*
	* @param analysisEntryId the primary key of the analysis entry
	* @return the analysis entry
	* @throws PortalException if a analysis entry with the primary key could not be found
	*/
	public static com.liferay.micro.maintainance.analysis.model.AnalysisEntry getAnalysisEntry(
		long analysisEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAnalysisEntry(analysisEntryId);
	}

	/**
	* Returns the analysis entry with the matching UUID and company.
	*
	* @param uuid the analysis entry's UUID
	* @param companyId the primary key of the company
	* @return the matching analysis entry
	* @throws PortalException if a matching analysis entry could not be found
	*/
	public static com.liferay.micro.maintainance.analysis.model.AnalysisEntry getAnalysisEntryByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAnalysisEntryByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Updates the analysis entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param analysisEntry the analysis entry
	* @return the analysis entry that was updated
	*/
	public static com.liferay.micro.maintainance.analysis.model.AnalysisEntry updateAnalysisEntry(
		com.liferay.micro.maintainance.analysis.model.AnalysisEntry analysisEntry) {
		return getService().updateAnalysisEntry(analysisEntry);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of analysis entries.
	*
	* @return the number of analysis entries
	*/
	public static int getAnalysisEntriesCount() {
		return getService().getAnalysisEntriesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.analysis.model.impl.AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.analysis.model.impl.AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the analysis entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.micro.maintainance.analysis.model.impl.AnalysisEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analysis entries
	* @param end the upper bound of the range of analysis entries (not inclusive)
	* @return the range of analysis entries
	*/
	public static java.util.List<com.liferay.micro.maintainance.analysis.model.AnalysisEntry> getAnalysisEntries(
		int start, int end) {
		return getService().getAnalysisEntries(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static AnalysisEntryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AnalysisEntryLocalService, AnalysisEntryLocalService> _serviceTracker =
		ServiceTrackerFactory.open(AnalysisEntryLocalService.class);
}