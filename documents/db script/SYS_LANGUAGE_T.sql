declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_LANGUAGE_T';
if v_num > 0 then
execute immediate 'drop table SYS_LANGUAGE_T';
end if;
end;
/

-- Create table
create table SYS_LANGUAGE_T
(
  lan_id           NUMBER not null,
  lan_code         VARCHAR2(68) not null,
  lan_value        VARCHAR2(68) not null,
  lan_type         INTEGER default 1,
  remarks          VARCHAR2(308),
  attribute1       VARCHAR2(100),
  attribute2       VARCHAR2(100),
  attribute3       VARCHAR2(100),
  attribute4       VARCHAR2(100),
  attribute5       VARCHAR2(100),
  attribute6       VARCHAR2(100),
  attribute7       VARCHAR2(100),
  attribute8       VARCHAR2(100),
  attribute9       VARCHAR2(100),
  attribute10      VARCHAR2(100),
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
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column SYS_LANGUAGE_T.lan_id
  is '����,��������';
comment on column SYS_LANGUAGE_T.lan_code
  is '���Ա���,�����ķ�� icustom.menu.home,Ҳ������������ã�һ��code���԰�����Ӣ��';
comment on column SYS_LANGUAGE_T.lan_value
  is '���Զ�Ӧֵ���磺�˵���ӦӢ��menu';
comment on column SYS_LANGUAGE_T.lan_type
  is '��������,��Ӣ��';
comment on column SYS_LANGUAGE_T.remarks
  is '��ע';
comment on column SYS_LANGUAGE_T.attribute1
  is '��չ����1';
comment on column SYS_LANGUAGE_T.attribute2
  is '��չ����2';
comment on column SYS_LANGUAGE_T.created_user
  is '�����û�';
comment on column SYS_LANGUAGE_T.created_date
  is '��������';
comment on column SYS_LANGUAGE_T.update_last_user
  is '�������û�';
comment on column SYS_LANGUAGE_T.update_last_date
  is '����������';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_LANGUAGE_T
  add primary key (LAN_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SYS_LANGUAGE_T
  add constraint SYS_LANGUAGE_UNIQUE unique (LAN_VALUE, LAN_TYPE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
