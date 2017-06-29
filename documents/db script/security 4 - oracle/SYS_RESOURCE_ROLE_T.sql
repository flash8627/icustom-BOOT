
declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_RESOURCE_ROLE_T';
if v_num > 0 then
execute immediate 'drop table SYS_RESOURCE_ROLE_T';
end if;
end;
/

-- Create table
create table SYS_RESOURCE_ROLE_T
(
  id               NUMBER(10) not null,
  resource_id      VARCHAR2(50 CHAR),
  role_id          VARCHAR2(50 CHAR),
  update_time      TIMESTAMP(6),
  resource_role_id NUMBER(10) not null,
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
alter table SYS_RESOURCE_ROLE_T
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;