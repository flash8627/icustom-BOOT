-- Create table
create table SYS_RESOURCE_ROLE_T
(
  id               NUMBER(10) not null,
  resource_id      VARCHAR2(50 CHAR),
  role_id          VARCHAR2(50 CHAR),
  update_time      TIMESTAMP(6),
  resource_role_id NUMBER(10) not null
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