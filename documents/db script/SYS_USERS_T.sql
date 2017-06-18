-- Create table
create table SYS_USERS_T
(
  user_id          NUMBER(32) not null,
  user_account     VARCHAR2(30),
  user_name        VARCHAR2(40),
  user_password    VARCHAR2(100),
  user_desc        VARCHAR2(998),
  valid_start      DATE,
  valid_end        DATE,
  enabled          INTEGER default 1,
  issys            INTEGER default 0,
  user_dept        VARCHAR2(20),
  user_duty        VARCHAR2(10),
  sub_system       VARCHAR2(30),
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
comment on table SYS_USERS_T
  is '系统用户表';
-- Add comments to the columns 
comment on column SYS_USERS_T.user_id
  is '用户id';
comment on column SYS_USERS_T.user_account
  is '用户账户';
comment on column SYS_USERS_T.user_name
  is '用户名';
comment on column SYS_USERS_T.user_password
  is '用户密码';
comment on column SYS_USERS_T.user_desc
  is '用户描述或简介';
comment on column SYS_USERS_T.enabled
  is '用户是否能用';
comment on column SYS_USERS_T.issys
  is '是否超级用户-这个字段没什么用';
comment on column SYS_USERS_T.user_dept
  is '所属的单位';
comment on column SYS_USERS_T.user_duty
  is '用户职位';
comment on column SYS_USERS_T.sub_system
  is '用户分管的子系统';
comment on column SYS_USERS_T.order_code
  is '排序码';
comment on column SYS_USERS_T.created_user
  is '创建用户';
comment on column SYS_USERS_T.created_date
  is '创建日期';
comment on column SYS_USERS_T.update_last_user
  is '最后更新用户';
comment on column SYS_USERS_T.update_last_date
  is '最后更新日期';
comment on column SYS_USERS_T.valid_flag
  is '删除状态';
-- Create/Recreate indexes 
create unique index USER_ACCOUNT_UNIQUE on SYS_USERS_T (USER_ACCOUNT)
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
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_USERS_T
  add primary key (USER_ID)
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
