-- Create table
create table SYS_AUTHORITIES_RESOURCES_T
(
  id               NUMBER(32) not null,
  auth_id          NUMBER(32),
  resource_id      NUMBER(32),
  enabled          INTEGER default 1,
  remarks          VARCHAR2(308),
  attribute1       VARCHAR2(100),
  attribute2       VARCHAR2(100),
  attribute3       VARCHAR2(100),
  attribute4       VARCHAR2(100),
  attribute5       VARCHAR2(100),
  attribute6       VARCHAR2(100),
  attribute7       VARCHAR2(100),
  attribute8       VARCHAR2(100),
  attribute9       VARCHAR2(100),
  attribute10      VARCHAR2(100),
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
-- Add comments to the table 
comment on table SYS_AUTHORITIES_RESOURCES_T
  is '权限资源表';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_AUTHORITIES_RESOURCES_T
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table SYS_AUTHORITIES_RESOURCES_T
  add constraint FK_PUB_AUTHORITIES_RE_UQ unique (AUTH_ID, RESOURCE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table SYS_AUTHORITIES_RESOURCES_T
  add constraint FK_PUB_AUTHORITIES_RE_AU foreign key (AUTH_ID)
  references SYS_AUTHORITIES_T (AUTH_ID);
alter table SYS_AUTHORITIES_RESOURCES_T
  add constraint FK_PUB_AUTHORITIES_RE_RE foreign key (RESOURCE_ID)
  references SYS_RESOURCES_T (RESOURCE_ID);
