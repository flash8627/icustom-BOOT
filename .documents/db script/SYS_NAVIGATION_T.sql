declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_tables
   where table_name = 'SYS_NAVIGATION_T';
  if v_num > 0 then
    execute immediate 'drop table SYS_NAVIGATION_T';
  end if;
end;
/

-- Create table
create table SYS_NAVIGATION_T(item_id NUMBER(30) not null,
                              item_name VARCHAR2(60) not null,
                              parent_id NUMBER(30),
                              icon VARCHAR2(30),
                              url VARCHAR2(200),
                              order_code NUMBER(20),
                              resource_type NUMBER(1),
                              created_user NUMBER(30),
                              created_date     DATE default SYSDATE,
                              update_last_user NUMBER(30),
                              update_last_date DATE default SYSDATE,
                              valid_flag NUMBER(1)) tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage(initial 64K next 1M
                                                                                                                minextents 1
                                                                                                                maxextents
                                                                                                                unlimited);
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_NAVIGATION_T add primary key(ITEM_ID)
  using index tablespace USERS pctfree 10 initrans 2 maxtrans 255 storage(initial 64K next 1M
                                                                          minextents 1
                                                                          maxextents
                                                                          unlimited);
alter table SYS_NAVIGATION_T add constraint SYS_NAVIGATION_T_UNIQUE unique(PARENT_ID,
                                                                           ITEM_NAME)
  using index tablespace USERS pctfree 10 initrans 2 maxtrans 255 storage(initial 64K next 1M
                                                                          minextents 1
                                                                          maxextents
                                                                          unlimited);
