
declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_ROLE_T';
if v_num > 0 then
execute immediate 'drop table SYS_ROLE_T';
end if;
end;
/

-- Create table
create table SYS_ROLE_T
(
  role_id		NUMBER(10) not null,
  role_name		VARCHAR2(100 CHAR),
  user_id		NUMBER(10),
  u_id			NUMBER(10) not null,
  order_code		INTEGER default 1,
  created_user		NUMBER,
  created_date		DATE default SYSDATE,
  update_last_user	NUMBER,
  update_last_date	DATE default SYSDATE,
  valid_flag		INTEGER default 1
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ROLE_T
  add primary key (ROLE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table SYS_ROLE_T
  add constraint FK_PNISAUKSX1OHBHC00JJ659MWE foreign key (U_ID)
  references SYS_USER_T (USER_ID);
