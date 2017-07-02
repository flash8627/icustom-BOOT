

-- Drop SEQUENCE
declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_sequences
   where sequence_name = 'SYS_RESOURCE_S';
  if v_num > 0 then
    execute immediate 'drop SEQUENCE SYS_RESOURCE_S';
  end if;
end;
/

-- Create sequence 
create sequence SYS_RESOURCE_S minvalue 1 maxvalue 9999999999999999999999999999 start
  with 1 increment by 1 cache 20;



declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_tables
   where table_name = 'SYS_RESOURCE_T';
  if v_num > 0 then
    execute immediate 'drop table SYS_RESOURCE_T';
  end if;
end;
/

-- Create table
create table SYS_RESOURCE_T
(
  resource_id      NUMBER(20) not null,
  method_name      VARCHAR2(400),
  method_path      VARCHAR2(1000),
  remark           VARCHAR2(200),
  parent_id        NUMBER(20),
  resource_name    VARCHAR2(400),
  resource_url     VARCHAR2(1000),
  order_code       INTEGER default 1,
  created_user     NUMBER,
  created_date     DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       INTEGER default 1
)
tablespace USERS;
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_RESOURCE_T
  add constraint SYS_RESOURCE_T_PK primary key (resource_id)
  using index 
  tablespace USERS;
alter table SYS_RESOURCE_T
  add constraint SYS_RESOURCE_T_UN1 unique (METHOD_NAME, METHOD_PATH)
  using index 
  tablespace USERS;
alter table SYS_RESOURCE_T
  add constraint SYS_RESOURCE_T_UN2 unique (RESOURCE_NAME, RESOURCE_URL)
  using index 
  tablespace USERS;

