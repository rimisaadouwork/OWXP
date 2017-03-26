create index IX_1711639D on Decision_DecisionEntry (companyId, handled);
create index IX_36CAF140 on Decision_DecisionEntry (decisionEntryId, companyId);
create index IX_891AFA84 on Decision_DecisionEntry (decisionEntryId, handled);
create index IX_453378C6 on Decision_DecisionEntry (decisionEntryId, userId, companyId);
create index IX_E25B449 on Decision_DecisionEntry (outcome[$COLUMN_LENGTH:75$]);
create index IX_6D008408 on Decision_DecisionEntry (userId, handled, decisionEntryId);
create index IX_9815178D on Decision_DecisionEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create index IX_73393C27 on Decision_DecisionEntry (wikiPageId);
create index IX_92584F17 on Decision_DecisionEntry (wikiPageName[$COLUMN_LENGTH:75$]);