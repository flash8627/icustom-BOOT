
declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='dsf_forecast_region_line_t';
if v_num > 0 then
execute immediate 'drop table dsf_forecast_region_line_t';
end if;
end;
/

create table dsf_forecast_region_line_t 
(
   FORECAST_HEADER_ID   NUMBER(20)           not null,
   BUCKET_ID            NUMBER(20),
   QUANTITY             NUMBER(20,2),
   DELETE_FLAG          CHAR(1),
   CREATED_BY           NUMBER,
   CREATED_NAME         Varchar2(200),
   CREATION_DATE        date,
   LAST_UPDATED_BY      NUMBER,
   LAST_UPDATED_NAME    Varchar2(200),
   LAST_UPDATE_DATE     date,
   constraint PK_DSF_FCST_REGION_LT primary key (FORECAST_HEADER_ID,BUCKET_ID)
) TABLESPACE ISCP_DSF_DATA;

comment on table dsf_forecast_region_line_t is
'地区部预测行';

comment on column dsf_forecast_region_line_t.FORECAST_HEADER_ID is
'预测头ID';

comment on column dsf_forecast_region_line_t.CREATED_BY is
'创建人ID';

comment on column dsf_forecast_region_line_t.CREATED_NAME is
'创建人Name';

comment on column dsf_forecast_region_line_t.CREATION_DATE is
'创建时间';

comment on column dsf_forecast_region_line_t.LAST_UPDATED_BY is
'更新人ID';

comment on column dsf_forecast_region_line_t.LAST_UPDATED_NAME is
'更新人Name';

comment on column dsf_forecast_region_line_t.LAST_UPDATE_DATE is
'更新时间';
