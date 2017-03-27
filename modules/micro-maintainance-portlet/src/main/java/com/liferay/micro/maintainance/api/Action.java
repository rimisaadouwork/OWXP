package com.liferay.micro.maintainance.api;

import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
public interface Action {

	public boolean performAction(AnalysisEntry analysisEntry);

}