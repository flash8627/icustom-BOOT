prompt Importing table SYS_RESOURCE_T...
set feedback off
set define off
insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (1, 'home', 'home', '系统首页，根目录', null, 'zh_cn=HOME,zh_en=Home', '/home', 1, null, to_date('01-07-2017 23:51:49', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('01-07-2017 23:51:49', 'dd-mm-yyyy hh24:mi:ss'), 1, 0, null, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (2, 'admin', 'admin', null, 8, 'zh_cn=附件管理,zh_en=attachments Manager', 'attachments/', 84, null, to_date('01-07-2017 23:51:49', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('05-11-2017 13:16:42', 'dd-mm-yyyy hh24:mi:ss'), 1, 0, null, 1, 0);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (3, 'user', 'user', null, null, null, '/user', 1, null, to_date('01-07-2017 23:52:36', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('01-07-2017 23:52:36', 'dd-mm-yyyy hh24:mi:ss'), 1, 0, null, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (4, 'hello', null, 'hello', null, 'hello', '/hello', 1, null, to_date('01-07-2017 23:52:36', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('01-07-2017 23:52:36', 'dd-mm-yyyy hh24:mi:ss'), 1, 0, null, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (1001, 'test', '/test', 'junit test', 0, 'test', '/test', null, 0, to_date('08-10-2017 16:29:57', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('08-10-2017 16:29:57', 'dd-mm-yyyy hh24:mi:ss'), 1, 0, null, null, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (1002, null, null, null, 8, 'zh_cn=excel管理,zh_en=excel Manager', 'excel/index.html', 37, 10001, to_date('05-11-2017 13:03:59', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('05-11-2017 13:07:25', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, 0);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (1003, null, null, null, 8, 'zh_cn=富文本管理,zh_en=html area Manager', 'htmlarea/index.html', 33, 10001, to_date('05-11-2017 13:04:16', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('05-11-2017 13:07:38', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, 0);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (1004, null, null, null, 1002, 'zh_cn=我的导入,zh_en=excel import', 'excel/import/index.html', 20, 10001, to_date('05-11-2017 13:09:28', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('05-11-2017 13:09:28', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, 0);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (1005, null, null, null, 1002, 'zh_cn=我的导出,zh_en=excel export', 'excel/export/index.html', 82, 10001, to_date('05-11-2017 13:09:45', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('05-11-2017 13:09:45', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, 0);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (1006, null, null, null, 8, '中控台', null, 78, 10001, to_date('05-11-2017 13:15:12', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('05-11-2017 13:15:12', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, 0);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (1007, null, null, null, 1006, '系统监控', 'metrics/', 30, 10001, to_date('05-11-2017 13:16:36', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('05-11-2017 13:16:36', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, 0);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (1008, null, null, null, 8, '工作流', 'activiti/', 59, 10001, to_date('05-11-2017 13:18:03', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('05-11-2017 13:18:03', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, 0);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (1009, null, null, null, 1006, 'session', 'session/', 47, 10001, to_date('05-11-2017 13:18:51', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('05-11-2017 13:18:51', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, 0);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (1011, null, null, null, 1006, 'redis', 'redis/', 85, 10001, to_date('05-11-2017 13:20:02', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('05-11-2017 13:20:02', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, 0);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (1012, null, null, null, 1006, 'mongodb', 'mongodb/', 80, 10001, to_date('05-11-2017 13:20:25', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('05-11-2017 13:20:25', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, 0);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (5, null, null, null, 1, 'SHOP', null, 3, null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (6, null, null, null, 1, 'Product', null, 2, null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (7, null, null, null, 1, 'BLOG', null, 7, null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (8, null, null, null, 1, 'System Manager', null, 6, null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 13:48:39', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (81, null, null, null, 10, 'zh_cn=资源管理,zh_en=Resources Manager', 'security/resources/ResourceTreeGrid.html', 1, null, to_date('03-09-2017 13:59:26', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 13:59:26', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (82, null, null, null, 10, 'zh_cn=用户管理,zh_en=Users Manager', 'security/user/index.html', 1, null, to_date('03-09-2017 13:59:47', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 13:59:47', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (83, null, null, null, 10, 'zh_cn=角色管理,zh_en=Role Manager', 'security/role/index.html', 1, null, to_date('03-09-2017 13:59:59', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 13:59:59', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (84, null, null, null, 8, 'zh_cn=Lookup Manager,zh_en=Lookup Manager', 'lookup/index.html', 1, null, to_date('03-09-2017 14:00:19', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 14:00:19', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (10, null, null, null, 8, 'zh_cn=Security Manager,zh_en=Security Manager', null, 1, null, to_date('03-09-2017 14:01:20', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 14:01:20', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (9, null, null, null, 8, 'zh_cn=数据字典,zh_en=Register', 'register/index.html', 1, null, to_date('03-09-2017 14:01:38', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 14:01:38', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (11, null, null, null, 1, 'About Me', null, 11, null, to_date('03-09-2017 14:03:25', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 14:03:25', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (12, null, null, null, 11, 'Contact ', null, 1, null, to_date('03-09-2017 14:03:44', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 14:03:44', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (13, null, null, null, 8, 'zh_cn=国际化,zh_en=international', 'international/index.html', 1, null, to_date('03-09-2017 15:58:43', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('03-09-2017 15:58:43', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 1, null);

insert into SYS_RESOURCE_T (RESOURCE_ID, METHOD_NAME, METHOD_PATH, REMARK, PARENT_ID, RESOURCE_NAME, RESOURCE_URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, MAIN_VIEW_FLAG, ICON, USE_STATUS,  RESOURCE_TYPE)
values (14, null, null, 'demo页面,可以把地址复制过去查看', 8, 'zh_cn=System Menu,zh_en=System Menu', null, 1, null, to_date('03-09-2017 15:58:43', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('05-11-2017 13:10:59', 'dd-mm-yyyy hh24:mi:ss'), 1, 1, null, 0, 0);

prompt Done.
