package com.liferay.micro.maintainance.api;

import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.wiki.model.WikiPage;

import java.util.List;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
public interface AutoFlaggable {

	public List<Action> autoFlaggedAnalyze(AnalysisEntry analysisEntry);

	public long getTaskId();

	public String getTaskName();

	public boolean isAutoFlaggable(WikiPage wikiPage);

	public boolean isAutoFlaggedAnalyseReady(
		CandidateMaintenance candidateMaintenance);

	public void setTaskId(long taskId);

}