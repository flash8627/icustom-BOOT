-- Create table
create table SYS_AUTHORITIES_T
(
  auth_id          NUMBER(32) not null,
  auth_name        VARCHAR2(60),
  auth_desc        VARCHAR2(1008),
  parent_id        NUMBER(32),
  auth_code        VARCHAR2(60),
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
comment on table SYS_AUTHORITIES_T
  is '权限表';
-- Add comments to the columns 
comment on column SYS_AUTHORITIES_T.module
  is '所属的子系统，比如平台里面包括10个系统，分别为成本、作业、集输等。';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_AUTHORITIES_T
  add primary key (AUTH_ID)
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
alter table SYS_AUTHORITIES_T
  add constraint AUTH_NAME_UNIQUE unique (PARENT_ID, AUTH_NAME, AUTH_CODE)
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
