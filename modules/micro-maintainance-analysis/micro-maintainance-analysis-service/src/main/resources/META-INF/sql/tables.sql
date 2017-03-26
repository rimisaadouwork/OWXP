create table Analysis_AnalysisEntry (
	uuid_ VARCHAR(75) null,
	analysisEntryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	candidateMaintenanceId LONG,
	analysisData VARCHAR(75) null
);

create table Analysis_AnalysisUser (
	uuid_ VARCHAR(75) null,
	analysisUserId LONG not null primary key,
	analysisEntryId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	voted INTEGER
);