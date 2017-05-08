package com.liferay.micro.maintainance.api;

import java.util.List;

import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;

public interface AutoFlaggable {

	public List<Action> autoFlaggedAnalyze(AnalysisEntry analysisEntry);

	public long getTaskId();

	public String getTaskName();

	public boolean isAutoFlaggable();

	public boolean isAutoFlaggedAnalyseReady(
		CandidateMaintenance candidateMaintenance);

	public void setTaskId(long taskId);
}
