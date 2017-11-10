
declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_tables
   where table_name = 'SYS_LOOKUP_CLASSIFY_T';
  if v_num > 0 then
    execute immediate 'drop table SYS_LOOKUP_CLASSIFY_T';
  end if;
end;
/

-- Create table
create table SYS_LOOKUP_CLASSIFY_T
(
  class_id         NUMBER not null,
  class_name       VARCHAR2(40),
  class_code       VARCHAR2(100),
  class_desc       VARCHAR2(300),
  order_code       INTEGER default 1,
  created_user     NUMBER,
  created_date     DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       NUMBER(1) default 1
)
tablespace USERS;
-- Add comments to the table 
comment on table SYS_LOOKUP_CLASSIFY_T
  is 'lookup������Ϣ';
-- Add comments to the columns 
comment on column SYS_LOOKUP_CLASSIFY_T.class_id
  is '����';
comment on column SYS_LOOKUP_CLASSIFY_T.class_name
  is '��������';
comment on column SYS_LOOKUP_CLASSIFY_T.class_code
  is '����,icustom.xxx.xxx';
comment on column SYS_LOOKUP_CLASSIFY_T.order_code
  is '������';
comment on column SYS_LOOKUP_CLASSIFY_T.created_user
  is '�����û�';
comment on column SYS_LOOKUP_CLASSIFY_T.created_date
  is '��������';
comment on column SYS_LOOKUP_CLASSIFY_T.update_last_user
  is '�������û�';
comment on column SYS_LOOKUP_CLASSIFY_T.update_last_date
  is '����������';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_LOOKUP_CLASSIFY_T
  add primary key (CLASS_ID)
  using index 
  tablespace USERS;
alter table SYS_LOOKUP_CLASSIFY_T
  add constraint SYS_LOOKUP_CLASS_CODE_UNIQUE unique (CLASS_CODE)
  using index 
  tablespace USERS;
alter table SYS_LOOKUP_CLASSIFY_T
  add constraint SYS_LOOKUP_CLASS_NAME_UNIQUE unique (CLASS_NAME)
  using index 
  tablespace USERS;
