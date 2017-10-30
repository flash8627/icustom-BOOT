
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
create table SYS_HTML_AREA_T(
       html_area_id INTEGER not null,
                             category VARCHAR2(1000) not null,
                             name VARCHAR2(1000) not null,
                             description VARCHAR2(4000),
                             content CLOB not null,
                             title VARCHAR2(2000),
                             mapping_url VARCHAR2(200),
                             second_level_type VARCHAR2(1000),
                             third_level_type VARCHAR2(1000),
                             app_name VARCHAR2(20),
                             created_by NUMBER(15) not null,
                             creation_date     DATE default sysdate not null,
                             last_updated_by NUMBER(15) not null,
                             last_update_date  DATE default sysdate not null,
                             attr1 VARCHAR2(200),
                             attr2 VARCHAR2(200),
                             attr3 VARCHAR2(200)
);

-- Add comments to the columns
comment on column SYS_HTML_AREA_T.created_by is '创建人';
comment on column SYS_HTML_AREA_T.creation_date is '创建时间';
comment on column SYS_HTML_AREA_T.last_updated_by is '最后修改人';
comment on column SYS_HTML_AREA_T.last_update_date is '最后修改时间';
