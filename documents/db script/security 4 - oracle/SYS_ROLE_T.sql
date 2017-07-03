
-- Drop SEQUENCE
declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_sequences
   where sequence_name = 'SYS_ROLE_S';
  if v_num > 0 then
    execute immediate 'drop SEQUENCE SYS_ROLE_S';
  end if;
end;
/
-- Create sequence 
create sequence SYS_ROLE_S minvalue 1 maxvalue 9999999999999999999999999999 start
  with 1 increment by 1 cache 20;

declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_tables
   where table_name = 'SYS_ROLE_T';
  if v_num > 0 then
    execute immediate 'drop table SYS_ROLE_T';
  end if;
end;
/

-- Create table
create table SYS_ROLE_T
(
  role_id          NUMBER(20) not null,
  role_name        VARCHAR2(100),
  role_desc        VARCHAR2(100),
  order_code       INTEGER default 1,
  created_user     NUMBER,
  created_date     DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  remark           VARCHAR2(1000),
  valid_flag       INTEGER default 1
)
tablespace USERS;
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ROLE_T
  add constraint SYS_ROLE_ID_PK primary key (ROLE_ID)
  using index 
  tablespace USERS;
alter table SYS_ROLE_T
  add constraint ROLE_NAME_UNIQUE unique (ROLE_NAME)
  using index 
  tablespace USERS;
