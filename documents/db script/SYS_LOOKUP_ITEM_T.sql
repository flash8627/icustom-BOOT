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
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table 
comment on table SYS_LOOKUP_ITEM_T
  is 'lookup��Ŀ��,һ�������Ӧ������';
-- Add comments to the columns 
comment on column SYS_LOOKUP_ITEM_T.item_id
  is '����';
comment on column SYS_LOOKUP_ITEM_T.item_name
  is '����';
comment on column SYS_LOOKUP_ITEM_T.class_id
  is '�����ʶ';
comment on column SYS_LOOKUP_ITEM_T.order_code
  is '����';
comment on column SYS_LOOKUP_ITEM_T.created_user
  is '�����û�';
comment on column SYS_LOOKUP_ITEM_T.created_date
  is '��������';
comment on column SYS_LOOKUP_ITEM_T.update_last_user
  is '�������û�';
comment on column SYS_LOOKUP_ITEM_T.update_last_date
  is '����������';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_LOOKUP_ITEM_T
  add primary key (ITEM_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table SYS_LOOKUP_ITEM_T
  add constraint SYS_LOOKUP_ITEM_CODE_UNIQUE unique (CLASS_ID, ITEM_CODE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table SYS_LOOKUP_ITEM_T
  add constraint SYS_LOOKUP_ITEM_NAME_UNIQUE unique (CLASS_ID, ITEM_NAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
