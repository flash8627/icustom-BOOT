
declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='DSF_DEMAND_ENTITY_T';
if v_num > 0 then
execute immediate 'drop table DSF_DEMAND_ENTITY_T';
end if;
end;
/

-- Create table
create table DSF_DEMAND_ENTITY_T
(
  demand_entity_id   NUMBER(20) not null,
  bg_code            VARCHAR2(30) not null,
  demand_entity_type VARCHAR2(30) not null,
  demand_entity_code VARCHAR2(30) not null,
  attr1              VARCHAR2(100),
  attr2              VARCHAR2(100),
  attr3              VARCHAR2(100),
  attr4              VARCHAR2(100),
  attr5              VARCHAR2(100),
  enable_flag        CHAR(1) not null,
  creation_date      DATE,
  last_update_date   DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table 
comment on table DSF_DEMAND_ENTITY_T
  is '�����������';
-- Add comments to the columns 
comment on column DSF_DEMAND_ENTITY_T.demand_entity_id
  is '��������ID(����)';
comment on column DSF_DEMAND_ENTITY_T.bg_code
  is 'BG(01:��Ӫ��;02:��ҵ��)';
comment on column DSF_DEMAND_ENTITY_T.demand_entity_type
  is '������������(PROJECT/REPOFFICE_ACC/REPOFFICE/REGION_ACC/REGION/GLOBAL)';
comment on column DSF_DEMAND_ENTITY_T.demand_entity_code
  is '�����������(PROJECT_ID/AREA_ORG_CODE/ACCOUNT_DEPT_CODE)';
comment on column DSF_DEMAND_ENTITY_T.attr1
  is '��չ�ֶ�1';
comment on column DSF_DEMAND_ENTITY_T.attr2
  is '��չ�ֶ�2';
comment on column DSF_DEMAND_ENTITY_T.attr3
  is '��չ�ֶ�3';
comment on column DSF_DEMAND_ENTITY_T.attr4
  is '��չ�ֶ�4';
comment on column DSF_DEMAND_ENTITY_T.attr5
  is '��չ�ֶ�5';
comment on column DSF_DEMAND_ENTITY_T.enable_flag
  is '��Ч��ʶ(Y/N)';
comment on column DSF_DEMAND_ENTITY_T.creation_date
  is '����ʱ��';
comment on column DSF_DEMAND_ENTITY_T.last_update_date
  is '����ʱ��';
-- Create/Recreate indexes 
create index DSF_DEMAND_ENTITY_U1 on DSF_DEMAND_ENTITY_T (BG_CODE, DEMAND_ENTITY_TYPE, DEMAND_ENTITY_CODE)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
-- Create/Recreate primary, unique and foreign key constraints 
alter table DSF_DEMAND_ENTITY_T
  add primary key (DEMAND_ENTITY_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
