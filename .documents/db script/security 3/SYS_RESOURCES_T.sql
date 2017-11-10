-- Create table
create table SYS_RESOURCES_T
(
  resource_id      NUMBER(32) not null,
  resource_name    VARCHAR2(100),
  resource_desc    VARCHAR2(1008),
  resource_type    VARCHAR2(40),
  resource_string  VARCHAR2(200),
  icon             VARCHAR2(30),
  parent_id        NUMBER(32) default 0,
  res_url          VARCHAR2(1200),
  priority         NUMBER(1) default 1,
  enabled          INTEGER default 1,
  issys            INTEGER default 0,
  module           VARCHAR2(4),
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
  valid_flag       INTEGER default 1,
  use_status       INTEGER default 1
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SYS_RESOURCES_T
  is '资源表';
-- Add comments to the columns 
comment on column SYS_RESOURCES_T.priority
  is '（暂不用，保留）';
comment on column SYS_RESOURCES_T.module
  is '所属的子系统，比如平台里面包括10个系统，分别为成本、作业、集输等。 （暂不用，保留）';
comment on column SYS_RESOURCES_T.use_status
  is '是否可用，0为不可用，1为可用';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_RESOURCES_T
  add primary key (RESOURCE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SYS_RESOURCES_T
  add constraint SYS_RESOURCE_TREE_UNIQUE unique (RESOURCE_NAME, PARENT_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
