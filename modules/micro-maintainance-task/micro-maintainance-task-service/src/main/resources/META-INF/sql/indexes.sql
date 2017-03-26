create index IX_B9E112EA on Task_CandidateMaintenance (candidateEntryId, taskEntryId);
create index IX_2CBF5AC8 on Task_CandidateMaintenance (taskEntryId);
create index IX_FE335264 on Task_CandidateMaintenance (uuid_[$COLUMN_LENGTH:75$]);

create index IX_25793FFF on Task_TaskEntry (taskEntryId);
create index IX_B4A6BCEF on Task_TaskEntry (taskEntryName[$COLUMN_LENGTH:75$]);
create index IX_6CB32CDB on Task_TaskEntry (uuid_[$COLUMN_LENGTH:75$]);