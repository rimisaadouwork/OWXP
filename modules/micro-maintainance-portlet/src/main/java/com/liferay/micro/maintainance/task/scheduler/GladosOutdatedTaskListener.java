package com.liferay.micro.maintainance.task.scheduler;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.micro.maintainance.api.TaskHandler;
import com.liferay.micro.maintainance.candidate.model.CandidateEntry;
import com.liferay.micro.maintainance.candidate.service.CandidateEntryLocalServiceUtil;
import com.liferay.micro.maintainance.configuration.MicroMaintenanceConfiguration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseSchedulerEntryMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.StorageTypeAware;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiPageLocalServiceUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
@Component(
	configurationPid = "com.liferay.micro.maintainance.configuration.MicroMaintenanceConfiguration",
	immediate = true, property = {"cron.expression=0 0 0 0 * ?"},
	service = TaskMessageListener.class
)
public class GladosOutdatedTaskListener
	extends BaseSchedulerEntryMessageListener {

	/**
	 * activate: Called whenever the properties for the component change (ala
	 * Config Admin) * or OSGi is activating the component.
	 *
	 * @param properties
	 *            The properties map from Config Admin.
	 * @throws SchedulerException
	 *             in case of error.
	 */
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties)
		throws SchedulerException {

		_configuration = ConfigurableUtil.createConfigurable(
			MicroMaintenanceConfiguration.class, properties);

		// extract the cron expression from the properties

		String cronExpression = String.format(
			"0 0 0 1/%s * ? *", _configuration.checkingPeriodDay());

		// create a new trigger definition for the job.

		String listenerClass = getEventListenerClass();

		Trigger jobTrigger = _triggerFactory.createTrigger(
			listenerClass, listenerClass, new Date(), null, cronExpression);

		// wrap the current scheduler entry in our new wrapper.
		// use the persisted storaget type and set the wrapper
		// back to the class field.

		schedulerEntryImpl = new StorageTypeAwareSchedulerEntryImpl(
			schedulerEntryImpl, StorageType.PERSISTED);

		// update the trigger for the scheduled job.

		schedulerEntryImpl.setTrigger(jobTrigger);

		// if we were initialized
		// (i.e. if this is called due to CA modification)

		if (_initialized) {

			// first deactivate the current job before we schedule.

			deactivate();
		}

		// register the scheduled task

		_schedulerEngineHelper.register(
			this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);

		// set the initialized flag.

		_initialized = true;
	}

	/**
	 * deactivate: Called when OSGi is deactivating the component.
	 */
	@Deactivate
	protected void deactivate() {

		// if we previously were initialized

		if (_initialized) {

			// unschedule the job so it is cleaned up

			try {
				_schedulerEngineHelper.unschedule(
					schedulerEntryImpl, getStorageType());
			}
			catch (SchedulerException se) {
				if (_log.isWarnEnabled()) {
					_log.warn("Unable to unschedule trigger", se);
				}
			}

			// unregister this listener

			_schedulerEngineHelper.unregister(this);
		}

		// clear the initialized flag

		_initialized = false;
	}

	/**
	 * doReceive: This is where the magic happens, this is where you want to do
	 * the work for the scheduled job.
	 *
	 * @param message
	 *            This is the message object tied to the job. If you stored data
	 *            with the job, the message will contain that data.
	 * @throws Exception
	 *             In case there is some sort of error processing the task.
	 */
	@Override
	protected void doReceive(Message message) throws Exception {

		// TODO Add logic for Glados.
		// Get all wikipages
		// // check if wikipage is already a candidate
		// if yes skip it.
		// if not check the tag outdate or the view count.
		// condition met? add to the candidate list.

		List<CandidateEntry> candidates =
			CandidateEntryLocalServiceUtil.getCandidateEntries(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		List<Long> wikipageIds = candidates.stream().map(
			p -> p.getWikiPageId()).collect(Collectors.toList());

		List<WikiPage> wikiPages = WikiPageLocalServiceUtil.getWikiPages(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (WikiPage wikipage : wikiPages) {
			if (!wikipageIds.contains(wikipage.getPageId())) {
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
					WikiPage.class.getName(), wikipage.getPageId());

				// New Configuration?

				if (assetEntry.getViewCount() > 20 &&
					assetEntry.getTagNames().equals("Tag")) {

					// Add as flagged.

				}
			}
		}

		if (_log.isInfoEnabled()) {
			_log.info("Scheduled task executed...");
		}
	}

	/**
	 * getStorageType: Utility method to get the storage type from the scheduler
	 * entry wrapper.
	 *
	 * @return StorageType The storage type to use.
	 */
	protected StorageType getStorageType() {
		if (schedulerEntryImpl instanceof StorageTypeAware) {
			return ((StorageTypeAware)schedulerEntryImpl).getStorageType();
		}

		return StorageType.MEMORY_CLUSTERED;
	}

	/**
	 * setModuleServiceLifecycle: So this requires some explanation...
	 *
	 * OSGi will start a component once all of it's dependencies are satisfied.
	 * However, there are times where you want to hold off until the portal is
	 * completely ready to go.
	 *
	 * This reference declaration is waiting for the ModuleServiceLifecycle's
	 * PORTAL_INITIALIZED component which will not be available until, surprise
	 * surprise, the portal has finished initializing.
	 *
	 * With this reference, this component activation waits until portal
	 * initialization has completed.
	 *
	 * @param moduleServiceLifecycle
	 */
	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	@Reference(unbind = "-")
	protected void setSchedulerEngineHelper(
		SchedulerEngineHelper schedulerEngineHelper) {

		_schedulerEngineHelper = schedulerEngineHelper;
	}

	@Reference(unbind = "-")
	protected void setTaskHandler(TaskHandler taskHandler) {
		_taskHandler = taskHandler;
	}

	@Reference(unbind = "-")
	protected void setTriggerFactory(TriggerFactory triggerFactory) {
		_triggerFactory = triggerFactory;
	}

	// the default cron expression is to run daily at midnight

	private static final String _DEFAULT_CRON_EXPRESSION = "0 0 0 0 * ?";

	private static final Log _log = LogFactoryUtil.getLog(
		GladosOutdatedTaskListener.class);

	private volatile MicroMaintenanceConfiguration _configuration;
	private volatile boolean _initialized;
	private SchedulerEngineHelper _schedulerEngineHelper;
	private TaskHandler _taskHandler;
	private TriggerFactory _triggerFactory;

}