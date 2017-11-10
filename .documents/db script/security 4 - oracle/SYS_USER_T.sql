-- Drop SEQUENCE
declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_sequences
   where sequence_name = 'SYS_USER_S';
  if v_num > 0 then
    execute immediate 'drop SEQUENCE SYS_USER_S';
  end if;
end;
/
-- Create sequence 
create sequence SYS_USER_S minvalue 1 maxvalue 9999999999999999999999999999 start
  with 1 increment by 1 cache 20;

declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_tables
   where table_name = 'SYS_USER_T';
  if v_num > 0 then
    execute immediate 'drop table SYS_USER_T';
  end if;
end;
/

-- Create table
create table SYS_USER_T
(
  user_id          NUMBER(20) not null,
  user_account     VARCHAR2(120),
  email            VARCHAR2(50),
  password         VARCHAR2(120),
  user_name        VARCHAR2(120),
  order_code       INTEGER default 1,
  created_user     NUMBER(20),
  created_date     DATE default SYSDATE,
  update_last_user NUMBER(20),
  update_last_date DATE default SYSDATE,
  effective_date_end   DATE,
  effective_date_start DATE default SYSDATE,
  valid_flag       INTEGER default 1,
  remark               VARCHAR2(1200)
)
tablespace USERS;
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_USER_T
  add primary key (USER_ID)
  using index 
  tablespace USERS;
alter table SYS_USER_T
  add constraint USER_ACCOUNT unique (USER_ACCOUNT)
  using index 
  tablespace USERS;
