-- Create table
create table SYS_ROLE_T
(
  role_id   NUMBER(10) not null,
  role_name VARCHAR2(100 CHAR),
  user_id   NUMBER(10),
  u_id      NUMBER(10) not null
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
