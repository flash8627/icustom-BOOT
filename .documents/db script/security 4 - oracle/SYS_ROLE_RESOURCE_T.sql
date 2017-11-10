-- Drop SEQUENCE
declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_sequences
   where sequence_name = 'SYS_ROLE_RESOURCE_S';
  if v_num > 0 then
    execute immediate 'drop SEQUENCE SYS_ROLE_RESOURCE_S';
  end if;
end;
/
-- Create sequence 
create sequence SYS_ROLE_RESOURCE_S minvalue 1 maxvalue 9999999999999999999999999999 start
  with 1 increment by 1 cache 20;

declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_tables
   where table_name = 'SYS_ROLE_RESOURCE_RESOURCE_T';
  if v_num > 0 then
    execute immediate 'drop table SYS_ROLE_RESOURCE_RESOURCE_T';
  end if;
end;
/

-- Create table
create table SYS_ROLE_RESOURCE_RESOURCE_T
(
  id               NUMBER(20) not null,
  resource_id      VARCHAR2(20),
  role_id          VARCHAR2(20),
  update_time      DATE default SYSDATE,
  order_code       INTEGER default 1,
  created_user     NUMBER(20),
  created_date     DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       INTEGER default 1
)
tablespace USERS;
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ROLE_RESOURCE_RESOURCE_T
  add constraint SYS_ROLE_RESOURCE_RESOURCE_T_PK primary key (ID)
  using index 
  tablespace USERS;
alter table SYS_ROLE_RESOURCE_RESOURCE_T
  add constraint SYS_ROLE_RESOURCE_RESOURCE_T_UNQ unique (RESOURCE_ID, ROLE_ID)
  using index 
  tablespace USERS;
  