package com.liferay.micro.maintainance.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=micro-maintainance-notify-creator-action Portlet",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NotifyCreatorActionPortlet extends GenericPortlet {

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

		PrintWriter printWriter = response.getWriter();

		printWriter.print(
			"micro-maintainance-notify-creator-action Portlet - Hello World!");
	}

}