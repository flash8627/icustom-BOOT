-- Create table
create table PERSISTENT_LOGINS
(
  username  VARCHAR2(64) not null,
  series    VARCHAR2(64) not null,
  token     VARCHAR2(64) not null,
  last_used TIMESTAMP(6) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Create/Recreate primary, unique and foreign key constraints 
alter table PERSISTENT_LOGINS
  add primary key (SERIES)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;