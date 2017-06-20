-- Create table
create table DSF_FORECAST_DIMENSION_T
(
  bg_code                     VARCHAR2(40) not null,
  demand_entity_type          VARCHAR2(30) not null,
  bucket_dimension            VARCHAR2(40) not null,
  forecast_dimension_code     VARCHAR2(100) not null,
  forecast_dimension_desc_cn  VARCHAR2(512),
  forecast_dimension_desc_en  VARCHAR2(512),
  forecast_dimension_category VARCHAR2(100),
  edit_flag                   CHAR(1),
  main_flag                   CHAR(1),
  display_flag                CHAR(1),
  int_flag                    CHAR(1),
  rate_flag                   CHAR(1),
  sort_id                     NUMBER(10),
  enable_flag                 CHAR(1) not null,
  creation_date               DATE,
  last_update_date            DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table 
comment on table DSF_FORECAST_DIMENSION_T
  is '预测维度基表';
-- Add comments to the columns 
comment on column DSF_FORECAST_DIMENSION_T.bg_code
  is 'BG(01:运营商;02:企业网)';
comment on column DSF_FORECAST_DIMENSION_T.demand_entity_type
  is '需求主体类型(PROJECT/REPOFFICE/REPOFFICE_CG/REGION/REGION_CG/GLOBAL)';
comment on column DSF_FORECAST_DIMENSION_T.bucket_dimension
  is 'Bucket维度(M/Q/Y)';
comment on column DSF_FORECAST_DIMENSION_T.forecast_dimension_code
  is '预测维度';
comment on column DSF_FORECAST_DIMENSION_T.forecast_dimension_desc_cn
  is '预测维度中文名称';
comment on column DSF_FORECAST_DIMENSION_T.forecast_dimension_desc_en
  is '预测维度英文名称';
comment on column DSF_FORECAST_DIMENSION_T.forecast_dimension_category
  is '维度分类';
comment on column DSF_FORECAST_DIMENSION_T.edit_flag
  is '编辑标识(Y/N)';
comment on column DSF_FORECAST_DIMENSION_T.main_flag
  is '主界面标识(Y/N)';
comment on column DSF_FORECAST_DIMENSION_T.display_flag
  is '显示标识{Y/N}';
comment on column DSF_FORECAST_DIMENSION_T.int_flag
  is '整数标识(Y/N)';
comment on column DSF_FORECAST_DIMENSION_T.rate_flag
  is '比率标识(Y/N)';
comment on column DSF_FORECAST_DIMENSION_T.sort_id
  is '排序';
comment on column DSF_FORECAST_DIMENSION_T.enable_flag
  is '有效标识(Y/N)';
comment on column DSF_FORECAST_DIMENSION_T.creation_date
  is '创建时间';
comment on column DSF_FORECAST_DIMENSION_T.last_update_date
  is '更新时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table DSF_FORECAST_DIMENSION_T
  add constraint PK_DSF_FORECAST_DIMENSION_T primary key (BG_CODE, DEMAND_ENTITY_TYPE, BUCKET_DIMENSION, FORECAST_DIMENSION_CODE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
