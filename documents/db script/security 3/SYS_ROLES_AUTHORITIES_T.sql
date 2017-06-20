-- Create table
create table SYS_ROLES_AUTHORITIES_T
(
  id      NUMBER(32) not null,
  role_id NUMBER(32),
  auth_id NUMBER(32),
  enabled INTEGER default 1
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table 
comment on table SYS_ROLES_AUTHORITIES_T
  is '角色权限表';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ROLES_AUTHORITIES_T
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table SYS_ROLES_AUTHORITIES_T
  add constraint FK_ROLES_AUTH_UNIQUE unique (ROLE_ID, AUTH_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table SYS_ROLES_AUTHORITIES_T
  add constraint FK_PUB_ROLES_AUTHORITIES_AU foreign key (AUTH_ID)
  references SYS_AUTHORITIES_T (AUTH_ID);
alter table SYS_ROLES_AUTHORITIES_T
  add constraint FK_PUB_ROLES_AUTHORITIES_ROLES foreign key (ROLE_ID)
  references SYS_ROLES_T (ROLE_ID);
