package com.liferay.micro.maintainance.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.wiki.model.WikiNode;
import com.liferay.wiki.service.WikiNodeLocalServiceUtil;

public class GrowUtil {

	public static User getGladosUser() {
		if (_glados == null) {
			_glados = UserLocalServiceUtil.fetchUserByScreenName(
				CompanyThreadLocal.getCompanyId(), GLADOS_NAME);
		}

		return _glados;
	}

	public static WikiNode getGrowNode() {
		if (_grow == null) {
			Group growGroup;
			try {
				growGroup = GroupLocalServiceUtil.getCompanyGroup(
					CompanyThreadLocal.getCompanyId());

				_grow = WikiNodeLocalServiceUtil.getNode(
					growGroup.getGroupId(), GROW_NAME);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}

		return _grow;
	}

	public static final String GLADOS_NAME = "glados";
	public static final String GROW_NAME = "grow";

	private static User _glados = null;
	private static WikiNode _grow = null;
}
