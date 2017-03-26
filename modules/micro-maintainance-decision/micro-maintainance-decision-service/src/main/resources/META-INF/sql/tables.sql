create table Decision_DecisionEntry (
	uuid_ VARCHAR(75) null,
	decisionEntryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	analysisData VARCHAR(75) null,
	wikiPageId LONG,
	wikiPageName VARCHAR(75) null,
	outcome VARCHAR(75) null,
	handled BOOLEAN
);