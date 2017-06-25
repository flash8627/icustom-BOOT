
declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='DSF_PDT_ORG_T';
if v_num > 0 then
execute immediate 'drop table DSF_PDT_ORG_T';
end if;
end;
/

-- Create table
create table DSF_PDT_ORG_T
(
  pdt_org_id          NUMBER(20) not null,
  parent_pdt_org_id   NUMBER(20) not null,
  pdt_org_code        VARCHAR2(30) not null,
  parent_pdt_org_code VARCHAR2(30) not null,
  pdt_org_name_cn     VARCHAR2(512),
  pdt_org_name_en     VARCHAR2(512),
  type_name           VARCHAR2(100),
  level_type          VARCHAR2(30),
  lv0_org_code        VARCHAR2(30),
  lv0_org_name_cn     VARCHAR2(512),
  lv0_org_name_en     VARCHAR2(512),
  lv0_type_name       VARCHAR2(100),
  lv1_org_code        VARCHAR2(30),
  lv1_org_name_cn     VARCHAR2(512),
  lv1_org_name_en     VARCHAR2(512),
  lv1_type_name       VARCHAR2(100),
  lv2_org_code        VARCHAR2(30),
  lv2_org_name_cn     VARCHAR2(512),
  lv2_org_name_en     VARCHAR2(512),
  lv2_type_name       VARCHAR2(100),
  lv3_org_code        VARCHAR2(30),
  lv3_org_name_cn     VARCHAR2(512),
  lv3_org_name_en     VARCHAR2(512),
  lv3_type_name       VARCHAR2(100),
  lv4_org_code        VARCHAR2(30),
  lv4_org_name_cn     VARCHAR2(512),
  lv4_org_name_en     VARCHAR2(512),
  lv4_type_name       VARCHAR2(100),
  enable_flag         CHAR(1) not null,
  creation_date       DATE,
  last_update_date    DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table 
comment on table DSF_PDT_ORG_T
  is '产品层级';
-- Add comments to the columns 
comment on column DSF_PDT_ORG_T.pdt_org_id
  is '产品层级ID';
comment on column DSF_PDT_ORG_T.parent_pdt_org_id
  is '产品层级父项ID';
comment on column DSF_PDT_ORG_T.pdt_org_code
  is '产品层级编码';
comment on column DSF_PDT_ORG_T.parent_pdt_org_code
  is '产品层级父项编码';
comment on column DSF_PDT_ORG_T.pdt_org_name_cn
  is '产品层级中文名称';
comment on column DSF_PDT_ORG_T.pdt_org_name_en
  is '产品层级英文名称';
comment on column DSF_PDT_ORG_T.type_name
  is '产品层级类型名称';
comment on column DSF_PDT_ORG_T.level_type
  is '产品层级所在水平层级';
comment on column DSF_PDT_ORG_T.lv0_org_code
  is 'LV0编码';
comment on column DSF_PDT_ORG_T.lv0_org_name_cn
  is 'LV0中文名称';
comment on column DSF_PDT_ORG_T.lv0_org_name_en
  is 'LV0英文名称';
comment on column DSF_PDT_ORG_T.lv0_type_name
  is 'LV0类型名称';
comment on column DSF_PDT_ORG_T.lv1_org_code
  is 'LV1编码';
comment on column DSF_PDT_ORG_T.lv1_org_name_cn
  is 'LV1中文名称';
comment on column DSF_PDT_ORG_T.lv1_org_name_en
  is 'LV0英文名称';
comment on column DSF_PDT_ORG_T.lv1_type_name
  is 'LV1类型名称';
comment on column DSF_PDT_ORG_T.lv2_org_code
  is 'LV2编码';
comment on column DSF_PDT_ORG_T.lv2_org_name_cn
  is 'LV2中文名称';
comment on column DSF_PDT_ORG_T.lv2_org_name_en
  is 'LV2英文名称';
comment on column DSF_PDT_ORG_T.lv2_type_name
  is 'LV2类型名称';
comment on column DSF_PDT_ORG_T.lv3_org_code
  is 'LV3编码';
comment on column DSF_PDT_ORG_T.lv3_org_name_cn
  is 'LV3中文名称';
comment on column DSF_PDT_ORG_T.lv3_org_name_en
  is 'LV3英文名称';
comment on column DSF_PDT_ORG_T.lv3_type_name
  is 'LV3类型名称';
comment on column DSF_PDT_ORG_T.lv4_org_code
  is 'LV4编码';
comment on column DSF_PDT_ORG_T.lv4_org_name_cn
  is 'LV4中文名称';
comment on column DSF_PDT_ORG_T.lv4_org_name_en
  is 'LV4英文名称';
comment on column DSF_PDT_ORG_T.lv4_type_name
  is 'LV4类型名称';
comment on column DSF_PDT_ORG_T.enable_flag
  is '有效标识(Y/N)';
comment on column DSF_PDT_ORG_T.creation_date
  is '创建时间';
comment on column DSF_PDT_ORG_T.last_update_date
  is '更新时间';
-- Create/Recreate indexes 
create index DSF_PDT_ORG_T_U1 on DSF_PDT_ORG_T (PDT_ORG_CODE)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
-- Create/Recreate primary, unique and foreign key constraints 
alter table DSF_PDT_ORG_T
  add constraint PK_DSF_PDT_ORG_T primary key (PDT_ORG_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
