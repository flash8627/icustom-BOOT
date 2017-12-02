


-- Drop SEQUENCE
declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_sequences
   where sequence_name = 'SYS_HTML_AREA_S';
  if v_num > 0 then
    execute immediate 'drop SEQUENCE SYS_HTML_AREA_S';
  end if;
end;
/


-- Create sequence 
create sequence SYS_HTML_AREA_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_tables
   where table_name = 'SYS_HTML_AREA_T';
  if v_num > 0 then
    execute immediate 'drop table SYS_HTML_AREA_T';
  end if;
end;
/

-- Create table
create table SYS_HTML_AREA_T
(
  html_area_id          INTEGER not null,
  name                  VARCHAR2(1000) not null,
  title                 VARCHAR2(2000),
  mapping_url           VARCHAR2(200),
  content               CLOB not null,
  category              VARCHAR2(1000),
  description           VARCHAR2(4000),
  program_filter_enable NUMBER default 1,
  valid_from_date       DATE default sysdate,
  valid_to_date         DATE,
  second_level_type     VARCHAR2(1000),
  third_level_type      VARCHAR2(1000),
  app_name              VARCHAR2(20),
  attribute1            VARCHAR2(200),
  attribute2            VARCHAR2(200),
  attribute3            VARCHAR2(200),
  created_by            NUMBER(15) not null,
  creation_date         DATE default sysdate not null,
  update_last_user      NUMBER(15) not null,
  update_last_date      DATE default sysdate not null
)
tablespace USERS;
-- Add comments to the columns 
comment on column SYS_HTML_AREA_T.title
  is 'html title';
comment on column SYS_HTML_AREA_T.mapping_url
  is '映射路径,js,css,html等资源都可以用映射路径替换原来的内容';
comment on column SYS_HTML_AREA_T.content
  is '主体内容';
comment on column SYS_HTML_AREA_T.program_filter_enable
  is '程序过滤器开关,1打开,0关闭';
comment on column SYS_HTML_AREA_T.valid_from_date
  is '从什么时间开始';
comment on column SYS_HTML_AREA_T.valid_to_date
  is '到什么时间结束';
comment on column SYS_HTML_AREA_T.created_by
  is '创建人';
comment on column SYS_HTML_AREA_T.creation_date
  is '创建时间';
comment on column SYS_HTML_AREA_T.update_last_user
  is '最后修改人';
comment on column SYS_HTML_AREA_T.update_last_date
  is '最后修改时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_HTML_AREA_T
  add primary key (HTML_AREA_ID)
  using index 
  tablespace USERS;
alter table SYS_HTML_AREA_T
  add constraint HTML_AREA_MAP_UK unique (MAPPING_URL)
  using index 
  tablespace USERS;