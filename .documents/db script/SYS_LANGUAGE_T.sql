


-- Drop SEQUENCE
declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_sequences
   where sequence_name = 'SYS_LANGUAGE_S';
  if v_num > 0 then
    execute immediate 'drop SEQUENCE SYS_LANGUAGE_S';
  end if;
end;
/


-- Create sequence 
create sequence SYS_LANGUAGE_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 141
increment by 1
cache 20;



declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_tables
   where table_name = 'SYS_LANGUAGE_T';
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
tablespace USERS;
-- Add comments to the columns 
comment on column SYS_LANGUAGE_T.lan_id
  is '主键,序列自增';
comment on column SYS_LANGUAGE_T.lan_code
  is '语言编码,带包的风格 icustom.menu.home,也可以做组的作用，一个code可以包括中英法';
comment on column SYS_LANGUAGE_T.lan_value
  is '语言对应值：如：菜单对应英文menu';
comment on column SYS_LANGUAGE_T.lan_type
  is '语言类型,中英法';
comment on column SYS_LANGUAGE_T.remarks
  is '备注';
comment on column SYS_LANGUAGE_T.attribute1
  is '扩展属性1';
comment on column SYS_LANGUAGE_T.attribute2
  is '扩展属性2';
comment on column SYS_LANGUAGE_T.created_user
  is '创建用户';
comment on column SYS_LANGUAGE_T.created_date
  is '创建日期';
comment on column SYS_LANGUAGE_T.update_last_user
  is '最后更新用户';
comment on column SYS_LANGUAGE_T.update_last_date
  is '最后更新日期';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_LANGUAGE_T
  add primary key (LAN_ID)
  using index 
  tablespace USERS;
alter table SYS_LANGUAGE_T
  add constraint SYS_LANGUAGE_UNIQUE unique (LAN_CODE,LAN_VALUE, LAN_TYPE)
  using index 
  tablespace USERS;

