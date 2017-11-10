
declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='DSF_FORECAST_REGION_HEADER_T';
if v_num > 0 then
execute immediate 'drop table DSF_FORECAST_REGION_HEADER_T';
end if;
end;
/

-- Create table
create table DSF_FORECAST_REGION_HEADER_T
(
  forecast_header_id      NUMBER(20) not null,
  demand_entity_id        NUMBER(20) not null,
  pdt_type                VARCHAR2(40) not null,
  pdt_id                  NUMBER(20) not null,
  supply_entity_id        NUMBER(20) not null,
  bucket_dimension        VARCHAR2(40) not null,
  forecast_dimension_code VARCHAR2(40) not null,
  forecast_status         VARCHAR2(20),
  delete_flag             CHAR(1),
  created_by              NUMBER,
  created_name            VARCHAR2(200),
  creation_date           DATE,
  last_updated_by         NUMBER,
  last_updated_name       VARCHAR2(200),
  last_update_date        DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table 
comment on table DSF_FORECAST_REGION_HEADER_T
  is '地区部预测头';
-- Add comments to the columns 
comment on column DSF_FORECAST_REGION_HEADER_T.forecast_header_id
  is '预测头ID';
comment on column DSF_FORECAST_REGION_HEADER_T.demand_entity_id
  is '需求主体ID';
comment on column DSF_FORECAST_REGION_HEADER_T.pdt_type
  is '预测对象类型(COARSE/FINE)';
comment on column DSF_FORECAST_REGION_HEADER_T.pdt_id
  is '预测对象ID(远粗对象和近细对象ID)';
comment on column DSF_FORECAST_REGION_HEADER_T.supply_entity_id
  is '供应主体ID';
comment on column DSF_FORECAST_REGION_HEADER_T.bucket_dimension
  is 'Bucket维度(M/Q/Y)';
comment on column DSF_FORECAST_REGION_HEADER_T.forecast_dimension_code
  is '预测维度(FCST_CURRENT:当期预测;FCST_COARSE:远粗拆分预测;)';
comment on column DSF_FORECAST_REGION_HEADER_T.forecast_status
  is '预测状态(DRAFT/SUBMIT)';
comment on column DSF_FORECAST_REGION_HEADER_T.delete_flag
  is '删除标识(Y/N)';
comment on column DSF_FORECAST_REGION_HEADER_T.created_by
  is '创建人ID';
comment on column DSF_FORECAST_REGION_HEADER_T.created_name
  is '创建人Name';
comment on column DSF_FORECAST_REGION_HEADER_T.creation_date
  is '创建时间';
comment on column DSF_FORECAST_REGION_HEADER_T.last_updated_by
  is '更新人ID';
comment on column DSF_FORECAST_REGION_HEADER_T.last_updated_name
  is '更新人Name';
comment on column DSF_FORECAST_REGION_HEADER_T.last_update_date
  is '更新时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table DSF_FORECAST_REGION_HEADER_T
  add primary key (FORECAST_HEADER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
