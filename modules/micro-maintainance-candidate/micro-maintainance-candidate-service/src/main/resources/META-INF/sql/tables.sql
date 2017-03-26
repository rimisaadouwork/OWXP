create table Candidate_CandidateEntry (
	uuid_ VARCHAR(75) null,
	candidateEntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	wikiPageId LONG
);