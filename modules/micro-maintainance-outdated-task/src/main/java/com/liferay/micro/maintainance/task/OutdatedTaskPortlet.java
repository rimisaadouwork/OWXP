package com.liferay.micro.maintainance.task;

import com.liferay.micro.maintainance.configuration.OutdatedTaskConfiguration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Map;

import javax.portlet.GenericPortlet;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=micro-maintainance-outdated-task Portlet",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OutdatedTaskPortlet extends GenericPortlet {

	@Activate
	protected void activate(Map<String, Object> properties)
		throws PortalException {

		_configuration = ConfigurableUtil.createConfigurable(
			OutdatedTaskConfiguration.class, properties);

		_outdatedTask = OutdatedTask.getOutdatedTaskInstance();

		_configureTask();

		TaskHandler.getTaskHandlerInstance().registerTask(_outdatedTask);
	}

	@Deactivate
	protected void deactivate() throws PortalException {
		TaskHandler.getTaskHandlerInstance().unregisterTask(_outdatedTask);
	}

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

		PrintWriter printWriter = response.getWriter();

		printWriter.print(
			"micro-maintainance-outdated-task Portlet - Hello World!");
	}

	@Modified
	protected void modified(Map<String, Object> config) {
		_configureTask();
	}

	private void _configureTask() {
		_outdatedTask.setRequiredVotingPercentage(
			_configuration.requiredVotingPercentage());
		_outdatedTask.setRequiredYesVotesPercentage(
			_configuration.requiredYesVotesPercentage());
		_outdatedTask.setVotingPeriodDays(_configuration.votingPeriodDays());
	}

	private static OutdatedTask _outdatedTask;

	private volatile OutdatedTaskConfiguration _configuration;

}