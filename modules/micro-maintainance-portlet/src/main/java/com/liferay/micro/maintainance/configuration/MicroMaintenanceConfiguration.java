package com.liferay.micro.maintainance.configuration;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
@Meta.OCD(
	id = "com.liferay.micro.maintainance.configuration.MicroMaintenanceConfiguration"
)
public interface MicroMaintenanceConfiguration {

	@Meta.AD(deflt = "1", required = false)
	public int checkingPeriodHours();

}