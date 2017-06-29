
declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_USER_T';
if v_num > 0 then
execute immediate 'drop table SYS_USER_T';
end if;
end;
/

-- Create table
create table SYS_USER_T
(
  user_id      NUMBER(10) not null,
  user_account VARCHAR2(120 CHAR),
  email        VARCHAR2(50 CHAR),
  password     VARCHAR2(120 CHAR),
  user_name    VARCHAR2(120 CHAR),
  order_code       INTEGER default 1,
  created_user     NUMBER,
  created_date     DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       INTEGER default 1
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_USER_T
  add primary key (USER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
