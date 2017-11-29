
-- Drop SEQUENCE
declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_sequences
   where sequence_name = 'SYS_LOOKUP_ITEM_S';
  if v_num > 0 then
    execute immediate 'drop SEQUENCE SYS_LOOKUP_ITEM_S';
  end if;
end;
/


-- Create sequence 
create sequence SYS_LOOKUP_ITEM_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_tables
   where table_name = 'SYS_LOOKUP_ITEM_T';
  if v_num > 0 then
    execute immediate 'drop table SYS_LOOKUP_ITEM_T';
  end if;
end;
/

-- Create table
create table SYS_LOOKUP_ITEM_T
(
  item_id          VARCHAR2(32) not null,
  item_code        INTEGER,
  item_name        VARCHAR2(40),
  item_lan         INTEGER,
  class_id         VARCHAR2(32) not null,
  item_status      INTEGER default 1,
  remarks          VARCHAR2(308),
  order_code       INTEGER default 1,
  created_user     NUMBER,
  created_date     DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       NUMBER(1) default 1
)
tablespace USERS;
-- Add comments to the table 
comment on table SYS_LOOKUP_ITEM_T
  is 'lookup条目类,一个分类对应多条　';
-- Add comments to the columns 
comment on column SYS_LOOKUP_ITEM_T.item_id
  is '主键';
comment on column SYS_LOOKUP_ITEM_T.item_name
  is '名称';
comment on column SYS_LOOKUP_ITEM_T.class_id
  is '分类标识';
comment on column SYS_LOOKUP_ITEM_T.order_code
  is '排序';
comment on column SYS_LOOKUP_ITEM_T.created_user
  is '创建用户';
comment on column SYS_LOOKUP_ITEM_T.created_date
  is '创建日期';
comment on column SYS_LOOKUP_ITEM_T.update_last_user
  is '最后更新用户';
comment on column SYS_LOOKUP_ITEM_T.update_last_date
  is '最后更新日期';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_LOOKUP_ITEM_T
  add primary key (ITEM_ID)
  using index 
  tablespace USERS;
alter table SYS_LOOKUP_ITEM_T
  add constraint SYS_LOOKUP_ITEM_CODE_UNIQUE unique (CLASS_ID, ITEM_CODE)
  using index 
  tablespace USERS;
alter table SYS_LOOKUP_ITEM_T
  add constraint SYS_LOOKUP_ITEM_NAME_UNIQUE unique (CLASS_ID, ITEM_NAME)
  using index 
  tablespace USERS;
