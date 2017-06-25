
declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_RESOURCE_T';
if v_num > 0 then
execute immediate 'drop table SYS_RESOURCE_T';
end if;
end;
/

-- Create table
create table SYS_RESOURCE_T
(
  id              NUMBER(10) not null,
  method_name     VARCHAR2(400 CHAR),
  method_path     VARCHAR2(1000 CHAR),
  remark          VARCHAR2(200 CHAR),
  resource_id     VARCHAR2(50 CHAR),
  resource_name   VARCHAR2(400 CHAR),
  resource_string VARCHAR2(1000 CHAR)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_RESOURCE_T
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
