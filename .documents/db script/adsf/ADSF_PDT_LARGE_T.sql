
declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='DSF_PDT_LARGE_T';
if v_num > 0 then
execute immediate 'drop table DSF_PDT_LARGE_T';
end if;
end;
/

-- Create table
create table DSF_PDT_LARGE_T
(
  pdt_large_id         NUMBER(20) not null,
  pdt_org_id           NUMBER(20) not null,
  attr1                VARCHAR2(100),
  attr2                VARCHAR2(100),
  attr3                VARCHAR2(100),
  attr4                VARCHAR2(100),
  attr5                VARCHAR2(100),
  enable_flag          CHAR(1) not null,
  created_by           NUMBER(20),
  created_name         VARCHAR2(200),
  creation_date        DATE,
  last_updated_by      NUMBER(20),
  last_updated_name    VARCHAR2(200),
  last_update_date     DATE,
  pdt_large_code       VARCHAR2(100),
  pdt_large_name_cn    VARCHAR2(512),
  pdt_large_name_en    VARCHAR2(512),
  pdt_large_uom        VARCHAR2(30),
  pdt_large_remark     VARCHAR2(512),
  pdt_large_data_rule  VARCHAR2(512),
  pdt_large_owner_name VARCHAR2(200)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table 
comment on table DSF_PDT_LARGE_T
  is '远粗预测对象';
-- Add comments to the columns 
comment on column DSF_PDT_LARGE_T.pdt_large_id
  is '远粗预测对象ID(内码)';
comment on column DSF_PDT_LARGE_T.pdt_org_id
  is '所属产品ID';
comment on column DSF_PDT_LARGE_T.attr1
  is '扩展字段1';
comment on column DSF_PDT_LARGE_T.attr2
  is '扩展字段2';
comment on column DSF_PDT_LARGE_T.attr3
  is '扩展字段3';
comment on column DSF_PDT_LARGE_T.attr4
  is '扩展字段4';
comment on column DSF_PDT_LARGE_T.attr5
  is '扩展字段5';
comment on column DSF_PDT_LARGE_T.enable_flag
  is '有效标识(Y/N)';
comment on column DSF_PDT_LARGE_T.created_by
  is '创建人ID';
comment on column DSF_PDT_LARGE_T.created_name
  is '创建人Name';
comment on column DSF_PDT_LARGE_T.creation_date
  is '创建时间';
comment on column DSF_PDT_LARGE_T.last_updated_by
  is '更新人ID';
comment on column DSF_PDT_LARGE_T.last_updated_name
  is '更新人Name';
comment on column DSF_PDT_LARGE_T.last_update_date
  is '更新时间';
comment on column DSF_PDT_LARGE_T.pdt_large_code
  is '远粗预测对象编码(编码规则)';
comment on column DSF_PDT_LARGE_T.pdt_large_name_cn
  is '远粗预测对象中文名称';
comment on column DSF_PDT_LARGE_T.pdt_large_name_en
  is '远粗预测对象英文名称';
comment on column DSF_PDT_LARGE_T.pdt_large_uom
  is '远粗对象量纲';
comment on column DSF_PDT_LARGE_T.pdt_large_remark
  is '远粗对象备注';
comment on column DSF_PDT_LARGE_T.pdt_large_data_rule
  is '远粗对象取数口径';
comment on column DSF_PDT_LARGE_T.pdt_large_owner_name
  is '近细对象负责人Name';
-- Create/Recreate primary, unique and foreign key constraints 
alter table DSF_PDT_LARGE_T
  add constraint PDT_COARSE_PK primary key (PDT_LARGE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table DSF_PDT_LARGE_T
  add constraint PDT_COARSE_UK unique (PDT_LARGE_CODE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
