

declare
  v_num number;
begin
      select count(*) into v_num from user_tables where table_name='SYS_USER_ROLES_T';
  if v_num > 0 then
     execute immediate 'drop table SYS_USER_ROLES_T';
  end if;
end;
/


create table SYS_USER_ROLES_T 
(
   ur_id              NUMBER(20)           not null,
   user_id            NUMBER(20),
   role_id            NUMBER(20),
   constraint PK_SYS_USER_ROLES_T primary key (ur_id),
   constraint AK_USER_ROLE_UQ_SYS_USER unique (user_id, role_id),
  created_user     NUMBER,
  created_date     DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       INTEGER default 1
);

