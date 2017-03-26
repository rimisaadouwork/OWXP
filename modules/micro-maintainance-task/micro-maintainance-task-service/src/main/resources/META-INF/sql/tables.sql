create table Task_CandidateMaintenance (
	uuid_ VARCHAR(75) null,
	candidateMaintenanceId LONG not null primary key,
	candidateEntryId LONG,
	taskEntryId LONG,
	createDate DATE null
);

create table Task_TaskEntry (
	uuid_ VARCHAR(75) null,
	taskEntryId LONG not null primary key,
	createDate DATE null,
	taskEntryName VARCHAR(75) null
);