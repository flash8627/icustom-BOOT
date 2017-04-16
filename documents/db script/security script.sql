
/*数据库表不用角色,项目启动可以直接创建表*/

/**user init data*/
-- user init 1
INSERT INTO `sys_user`
(`id`, `dob`, `email`, `password`, `username`)
VALUES (1,  '2017-04-16',  'flash8627@hotmail.com',  '$2a$04$xVl8HQu/OCQqQSd/oB6h8.LxEh.IaaAcHz3MoQlZ3efUnZMTX2rA6',  'admin');

INSERT INTO `sys_user` (`id`, `dob`, `email`, `password`, `username`)
VALUES (2,  '2017-04-16',  'flash8627@hotmail.com',  '$2a$04$xVl8HQu/OCQqQSd/oB6h8.LxEh.IaaAcHz3MoQlZ3efUnZMTX2rA6',  'TEST');

INSERT INTO `sys_user`
(`id`, `dob`, `email`, `password`, `username`)
VALUES (3,  '2017-04-16','flash8627@hotmail.com',  '$2a$04$xVl8HQu/OCQqQSd/oB6h8.LxEh.IaaAcHz3MoQlZ3efUnZMTX2rA6',  'user');

  
COMMIT;
  
-- role init 
 
INSERT INTO `sys_role` (`id`, `name`, `uid`) VALUES ('1',  'admin',  '1');

    
INSERT INTO `sys_role` (`id`, `name`, `uid`) VALUES ('2',  'super',  '2');    
 
    
INSERT INTO `sys_role` (`id`, `name`, `uid`) VALUES ('3',  'user',  '3');    

  
  COMMIT;
  

-- resource init 1  
INSERT INTO `sysys_resource`
( `remark`, `resource_id`, `resource_name`, `resource_string`)
VALUES (  'remark test',  '4',  'resource_name_test0',  '/'); 

  
INSERT INTO `sys_resource`
( `remark`, `resource_id`, `resource_name`, `resource_string`)
VALUES (  'remark test',  '1',  'resource_name_test1',  '/home'); 
  

-- resource init 2  
INSERT INTO `sys_resource`
( `remark`, `resource_id`, `resource_name`, `resource_string`)
VALUES (
  'remark test',  '2',  'resource_name_test2', '/hello'); 
 

-- resource init 3  
INSERT INTO `sys_resource`
( `remark`, `resource_id`, `resource_name`, `resource_string`)
VALUES ( 'remark test',  '3',  'resource_name_test3',  '/user'); 
 
  
COMMIT;
  
  
SELECT
  `id`,
  `method_name`,
  `method_path`,
  `remark`,
  `resource_id`,
  `resource_name`,
  `resource_string`
FROM `sys_resource`; 
  
-- init sys_resource_role
INSERT INTO `sys_resource_role`
( `resource_id`, `role_id`, `update_time`)
VALUES (  '4',  '1',  '2017-04-16');  
  
  
INSERT INTO `sys_resource_role`
( `resource_id`, `role_id`, `update_time`)
VALUES (  '1',  '1',  '2017-04-16');  
  
INSERT INTO `sys_resource_role`
( `resource_id`, `role_id`, `update_time`)
VALUES (  '2',  '1',  '2017-04-16');    
  
INSERT INTO `sys_resource_role`
( `resource_id`, `role_id`,   `update_time`)
VALUES (  '3',  '1',  '2017-04-16');
  
-- init sys_resource_role
INSERT INTO `sys_resource_role`
( `resource_id`, `role_id`, `update_time`)
VALUES (  '2',  '2',  '2017-04-16');  
  
INSERT INTO `sys_resource_role`
( `resource_id`, `role_id`, `update_time`)
VALUES (  '3',  '3',  '2017-04-16');    
  
COMMIT;

SELECT
  `id`,
  `resource_id`,
  `role_id`,
  `update_time`
FROM `sys_resource_role`;

