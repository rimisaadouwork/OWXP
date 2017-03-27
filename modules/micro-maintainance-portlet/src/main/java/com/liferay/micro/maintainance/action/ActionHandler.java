package com.liferay.micro.maintainance.action;

import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;

import java.util.List;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
public class ActionHandler {

	public static void performActions(
		List<Action> actions, AnalysisEntry analysisEntry) {

		for (Action action : actions) {
			action.performAction(analysisEntry);
		}
	}

}