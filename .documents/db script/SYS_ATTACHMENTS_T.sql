declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_tables
   where table_name = 'SYS_ATTACHMENTS_T';
  if v_num > 0 then
    execute immediate 'drop table SYS_ATTACHMENTS_T';
  end if;
end;
/

-- Create table
create table SYS_ATTACHMENTS_T
(
  attachmentid     INTEGER not null,
  filename         VARCHAR2(255) not null,
  filepath         VARCHAR2(255) not null,
  filesize         INTEGER not null,
  last_updated_by  NUMBER(15) default 17,
  created_by       NUMBER(15) default 17 not null,
  creation_date    DATE default sysdate not null,
  last_update_date DATE default sysdate not null,
  status           VARCHAR2(102) default 0 not null,
  batch_id         INTEGER,
  attachment_type  VARCHAR2(50),
  app_name         VARCHAR2(20)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ATTACHMENTS_T
  add constraint TPL_ATTACHMENT_PK primary key (ATTACHMENTID)
  using index ;
