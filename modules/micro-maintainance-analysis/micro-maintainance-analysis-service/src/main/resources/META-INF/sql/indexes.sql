create index IX_A1139A67 on Analysis_AnalysisEntry (analysisEntryId, candidateMaintenanceId);
create index IX_37D41440 on Analysis_AnalysisEntry (analysisEntryId, companyId);
create index IX_DA08FCA1 on Analysis_AnalysisEntry (analysisEntryId, userId, candidateMaintenanceId);
create index IX_42BB2292 on Analysis_AnalysisEntry (candidateMaintenanceId, userId);
create index IX_553831E9 on Analysis_AnalysisEntry (companyId, userId);
create index IX_8FB35351 on Analysis_AnalysisEntry (userId, createDate);
create index IX_AF4DB78D on Analysis_AnalysisEntry (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_2AA2864B on Analysis_AnalysisUser (analysisEntryId, userId);
create index IX_61CD26B9 on Analysis_AnalysisUser (analysisEntryId, voted);
create index IX_4B2ACFC6 on Analysis_AnalysisUser (analysisUserId);
create index IX_F98BC6CA on Analysis_AnalysisUser (userId);
create index IX_CE32BCFA on Analysis_AnalysisUser (userName[$COLUMN_LENGTH:75$]);
create index IX_7F45A924 on Analysis_AnalysisUser (uuid_[$COLUMN_LENGTH:75$]);