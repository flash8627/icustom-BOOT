SELECT * FROM (
    SELECT TT.* , ROWNUM RN FROM (
        SELECT id            id,
               method_name   methodName,
               method_path   methodPath,
               remark        remark,
               resource_id   resourceId,
               resource_name resourceName,
               resource_url  resourceUrl
          FROM sys_resource_t tt
         WHERE tt.valid_flag = 1
               AND UPPER(tt.resource_url) LIKE UPPER('#{vo.resourceUrl,jdbcType=VARCHAR}') 
 ) TT 
		) WHERE RN<=1 AND RN>=30

begin 
  merge into sys_resource_t tar
  using (
        select 
             1                  id,
             'Ê×Ò³'           method_name,
             '/home'             method_path,
             'sqltest'             remark,
             'home'             resource_name,
             '/'            resource_url,
             1              order_code,
             0              created_user,
             SYSDATE        created_date,
             null           update_last_user,
             SYSDATE        update_last_date,
             1              valid_flag
        from dual 
  ) src
  on (
     tar.id=src.id
  )
  WHEN MATCHED THEN
    UPDATE SET
      tar.method_name = src.method_name,
      tar.method_path = src.method_path,
      tar.remark = src.remark,
      tar.resource_name = src.resource_name,
      tar.resource_url = src.resource_url,
      tar.order_code = src.order_code,
      tar.created_user = src.created_user,
      tar.created_date = src.created_date,
      tar.update_last_user = src.update_last_user,
      tar.update_last_date = src.update_last_date,
      tar.valid_flag = nvl(src.valid_flag,tar.valid_flag)
  WHEN NOT MATCHED THEN
    INSERT
      (id,
       method_name,
       method_path,
       remark,
       resource_name,
       resource_url,
       order_code,
       created_user,
       update_last_user,
       update_last_date,
       valid_flag)
    VALUES
      (src.id,
       src.method_name,
       src.method_path,
       src.remark,
       src.resource_name,
       src.resource_url,
       src.order_code,
       src.created_user,
       src.created_date,
       src.update_last_user,
       src.update_last_date,
       1);
END;

-- Drop SEQUENCE
declare
  v_num number;
begin
  select count(*)
    into v_num
    from user_sequences
   where sequence_name = 'SYS_USER_S';
  if v_num > 0 then
    execute immediate 'drop SEQUENCE SYS_USER_S';
  end if;
end;
/
-- Create sequence 
create sequence SYS_USER_S minvalue 1 maxvalue 9999999999999999999999999999 start
  with 1 increment by 1 cache 20;

