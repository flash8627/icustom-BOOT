prompt Importing table SYS_RESOURCE_T...
set feedback off
set define off
insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (1, 'home', 'home', '系统首页，根目录', null, 'zh_cn=HOME,zh_en=Home', '/home', 1, null, to_date('01-07-2017 23:51:49', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('01-07-2017 23:51:49', 'dd-mm-yyyy hh24:mi:ss'), 1, 0, null, null, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (2, 'admin', 'admin', 'admin', null, 'admin', '/admin', 1, null, to_date('01-07-2017 23:51:49', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('01-07-2017 23:51:49', 'dd-mm-yyyy hh24:mi:ss'), 1, 0, null, null, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (3, 'user', 'user', null, null, null, '/user', 1, null, to_date('01-07-2017 23:52:36', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('01-07-2017 23:52:36', 'dd-mm-yyyy hh24:mi:ss'), 1, 0, null, null, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (4, 'hello', null, 'hello', null, 'hello', '/hello', 1, null, to_date('01-07-2017 23:52:36', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('01-07-2017 23:52:36', 'dd-mm-yyyy hh24:mi:ss'), 1, 0, null, null, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (1001, 'test', '/test', 'junit test', 0, 'test', '/test', null, 0, to_date('03-09-2017 15:25:55', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('03-09-2017 15:25:55', 'dd-mm-yyyy hh24:mi:ss'), 1, 0, null, null, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (5, null, null, null, 1, 'SHOP', null, 3, null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (6, null, null, null, 1, 'Product', null, 2, null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (7, null, null, null, 1, 'BLOG', null, 7, null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (8, null, null, null, 1, 'System Manager', null, 6, null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (81, null, null, null, 10, 'zh_cn=资源管理,zh_en=Resources Manager', 'security/resources/ResourceTreeGrid.html', 1, null, to_date('03-09-2017 13:59:26', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 13:59:26', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (82, null, null, null, 10, 'zh_cn=用户管理,zh_en=Users Manager', 'security/user/index.html', 1, null, to_date('03-09-2017 13:59:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 13:59:47', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (83, null, null, null, 10, 'zh_cn=角色管理,zh_en=Role Manager', 'security/role/index.html', 1, null, to_date('03-09-2017 13:59:59', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 13:59:59', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (84, null, null, null, 8, 'zh_cn=Lookup Manager,zh_en=Lookup Manager', 'lookup/index.html', 1, null, to_date('03-09-2017 14:00:19', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 14:00:19', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (10, null, null, null, 8, 'zh_cn=Security Manager,zh_en=Security Manager', null, 1, null, to_date('03-09-2017 14:01:20', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 14:01:20', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (9, null, null, null, 8, 'zh_cn=数据字典,zh_en=Register', 'register/index.html', 1, null, to_date('03-09-2017 14:01:38', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 14:01:38', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (11, null, null, null, 1, 'About Me', null, 11, null, to_date('03-09-2017 14:03:25', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 14:03:25', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (12, null, null, null, 11, 'Contact ', null, 1, null, to_date('03-09-2017 14:03:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 14:03:44', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (13, null, null, null, 8, 'zh_cn=国际化,zh_en=international', 'international/index.html', 1, null, to_date('03-09-2017 15:58:43', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 15:58:43', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS, RESOURCE_DESC, RESOURCE_TYPE)
values (14, null, null, 'demo页面,可以把地址复制过去查看', 8, 'zh_cn=System Menu,zh_en=System Menu', null, 1, null, to_date('03-09-2017 15:58:43', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 15:58:43', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null, null);

prompt Done.
