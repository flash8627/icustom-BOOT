-- Create table
create table SYS_ROLES_T
(
  role_id          NUMBER(32) not null,
  role_name        VARCHAR2(40),
  role_code        VARCHAR2(100),
  role_desc        VARCHAR2(1008),
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
  valid_flag       INTEGER default 1
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
comment on table SYS_ROLES_T
  is '角色表';
-- Add comments to the columns 
comment on column SYS_ROLES_T.module
  is '所属的子系统，比如平台里面包括10个系统，分别为成本、作业、集输等。';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ROLES_T
  add primary key (ROLE_ID)
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
alter table SYS_ROLES_T
  add unique (ROLE_NAME)
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
alter table SYS_ROLES_T
  add unique (ROLE_CODE)
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
