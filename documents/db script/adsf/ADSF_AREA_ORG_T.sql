
declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='DSF_AREA_ORG_T';
if v_num > 0 then
execute immediate 'drop table DSF_AREA_ORG_T';
end if;
end;
/

-- Create table
create table DSF_AREA_ORG_T
(
  area_org_code           VARCHAR2(30) not null,
  area_org_name_cn        VARCHAR2(240),
  area_org_name_en        VARCHAR2(240),
  area_org_type           VARCHAR2(150) not null,
  parent_area_org_code    VARCHAR2(30),
  parent_area_org_type    VARCHAR2(150),
  enable_flag             CHAR(1) not null,
  source_code             VARCHAR2(30),
  source_last_update_date DATE,
  creation_date           DATE,
  last_update_date        DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table 
comment on table DSF_AREA_ORG_T
  is '区域组织基表(地/代)';
-- Add comments to the columns 
comment on column DSF_AREA_ORG_T.area_org_code
  is '区域组织编码';
comment on column DSF_AREA_ORG_T.area_org_name_cn
  is '区域组织中文名称';
comment on column DSF_AREA_ORG_T.area_org_name_en
  is '区域组织英文名称';
comment on column DSF_AREA_ORG_T.area_org_type
  is '区域组织地/代/办标识';
comment on column DSF_AREA_ORG_T.parent_area_org_code
  is '上层组织的区域组织编码';
comment on column DSF_AREA_ORG_T.parent_area_org_type
  is '上层组织的区域组织地/代标识';
comment on column DSF_AREA_ORG_T.enable_flag
  is '有效标识(Y/N)';
comment on column DSF_AREA_ORG_T.source_code
  is '来源对象代码(IDATA)';
comment on column DSF_AREA_ORG_T.source_last_update_date
  is '来源更新时间';
comment on column DSF_AREA_ORG_T.creation_date
  is '创建时间';
comment on column DSF_AREA_ORG_T.last_update_date
  is '更新时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table DSF_AREA_ORG_T
  add primary key (AREA_ORG_CODE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
