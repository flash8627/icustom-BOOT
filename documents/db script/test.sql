
SELECT * FROM sys_user_t;

-- user
INSERT INTO sys_user_t ( id ,account ,email ,PASSWORD ,username ) VALUES ('4', 'test', 'email', 'password', 'test');
 
 COMMIT;

UPDATE sys_user_t SET PASSWORD = '$2a$04$dlCXOqo.jdQFoA1dX5btlOIgokWHVvATDJuv/abGMiItxGEpPXAlq' WHERE id=4;

-- role
INSERT INTO sys_role_t ( id ,rolename ,uid ) VALUES ('1', 'admin', '1');

INSERT INTO sys_role_t ( id ,rolename ,uid ) VALUES ('2', 'super', '2');

INSERT INTO sys_role_t ( id ,rolename ,uid )VALUES ('3', 'user', '3');

--admin ADD role
INSERT INTO sys_role_t (rolename ,uid ) VALUES ('super', '1');
INSERT INTO sys_role_t (rolename ,uid ) VALUES ('user', '1');


-- resource 
INSERT INTO sys_resource_t 
( id ,
  method_name ,
  method_path ,
  remark ,
  resource_id ,
  resource_name ,
  resource_string )
VALUES ('1','/','method_path','remark','1','resource_name','/hello');
 
 
INSERT INTO sys_resource_t 
( id ,
  method_name ,
  method_path ,
  remark ,
  resource_id ,
  resource_name ,
  resource_string )
VALUES ('2','','','remark','2','resource_name','/home'); 
  
INSERT INTO sys_resource_t 
( id ,
   method_name,
  method_path ,
  remark ,
  resource_id ,
  resource_name ,
  resource_string )
VALUES ('3','','method_path','remark','3','resource_name','/admin'); 
 
--  sys_resource_role_t

INSERT INTO `bootsample`.`sys_resource_role_t`
(`id`, `resource_id`, `role_id`) VALUES ( '1','1','3'); 
 
 
 
INSERT INTO `bootsample`.`sys_resource_role_t`
(`id`, `resource_id`, `role_id`)
VALUES ('2','2','2'); 

-- 资源(3)被管理拥有(1)
INSERT INTO `bootsample`.`sys_resource_role_t`
(`id`, `resource_id`, `role_id`)
VALUES ('3', '3','1'); 

-- 资源(3)被管理拥有(1)
INSERT INTO `bootsample`.`sys_resource_role_t`
(`resource_id`, `role_id`)
VALUES ('2','1'); 
INSERT INTO `bootsample`.`sys_resource_role_t`
(`resource_id`, `role_id`)
VALUES ('1','1'); 
   
 COMMIT;
 
 
 SELECT * FROM  sys_resource_t;

 SELECT * FROM sys_resource_role_t;
 
 -- 
 
SELECT 
  u.id      		用户ID,
  r.id      		角色ID,
  sr.id      		资源ID,
  sr.resource_id      	资源标识,
  u.account 		登陆帐户,
  u.username 		用户姓名,
  r.rolename 		用户角色,
  sr.resource_string 	能访问的路径
FROM
  sys_user_t u 
LEFT JOIN sys_role_t r 
	ON (u.id = r.uid) 
LEFT JOIN sys_resource_role_t rr
	ON (r.id = rr.role_id)
LEFT JOIN sys_resource_t sr
	ON (rr.resource_id=sr.resource_id);

 
 