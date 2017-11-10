
/*
begin
-- Call the procedure sample
scripts_util.drop_index('dsf_FORE_REGION_header_t_u3');
end;
/
*/

CREATE OR REPLACE PACKAGE scripts_util IS

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : aGuang <br>
* Creation Date : 2013/10/28 <br>
* Description : 删除table <br>
* 如果指定table不存在就直接返回不报错 保证脚本可以反复执行 <br>
*
* Parameter:table_name
* 指定要删除的表名称
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-06-06 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/

PROCEDURE drop_table(table_name IN VARCHAR2);

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : aGuang <br>
* Creation Date : 2013/10/28 <br>
* Description : 删除view <br>
* 如果指定view不存在就直接返回不报错 保证脚本可以反复执行 <br>
*
* Parameter:table_name
* 指定要删除的view名称
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-06-06 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/
PROCEDURE drop_view(view_name IN VARCHAR2);

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : aGuang <br>
* Creation Date : 2013/10/28 <br>
* Description : 删除表字段 <br>
* 如果指定表字段不存在就直接返回不报错 保证脚本可以反复执行 <br>
* Parameter:table_name
* 指定要删除列的所属表名称
*
* Parameter:column_name
* 指定要删除列
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-07-05 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/
PROCEDURE drop_column(table_name IN VARCHAR2,
column_name IN VARCHAR2);

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : aGuang <br>
* Creation Date : 2013/10/28 <br>
* Description : 删除Index <br>
* 如果指定删除Index不存在就直接返回不报错 保证脚本可以反复执行 <br>
*
* Parameter:table_name
* 指定要删除的表名称
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-07-05 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/
PROCEDURE drop_index(index_name IN VARCHAR2);

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : aGuang <br>
* Creation Date : 2013/10/28 <br>
* Description : 删除表约束 <br>
* 如果指定约束不存在就直接返回不报错 保证脚本可以反复执行 <br>
* Parameter:table_name
* 指定要删除约束的所属表名称
*
* Parameter:constraint_name
* 指定要删除的约束
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-07-05 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/
PROCEDURE drop_constraint(table_name IN VARCHAR2,
constraint_name IN VARCHAR2);

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : aGuang <br>
* Creation Date : 2013/10/28 <br>
* Description : 删除sequence <br>
* 如果指定删除sequence不存在就直接返回不报错 保证脚本可以反复执行 <br>
*
* Parameter:sequence_name
* 指定要删除的序列名称
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-07-05 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/
PROCEDURE drop_sequence(sequence_name IN VARCHAR2);

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : aGuang <br>
* Creation Date : 2013/10/28 <br>
* Description : 删除Trigger <br>
* 如果指定删除Trigger不存在就直接返回不报错 保证脚本可以反复执行 <br>
*
* Parameter:trigger_name
* 指定要删除的Trigger名称
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-07-05 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/
PROCEDURE drop_trigger(trigger_name IN VARCHAR2);

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : YangLi <br>
* Creation Date : 2015/07/31 <br>
* Description : 删除同义词 <br>
* 如果指定删除同义词不存在就直接返回不报错 保证脚本可以反复执行 <br>
*
* Parameter:trigger_name
* 指定要删除的同义词名称
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-07-05 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/
PROCEDURE drop_synonym(synonym_name IN VARCHAR2);

END scripts_util;
/

CREATE OR REPLACE PACKAGE BODY scripts_util IS

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : aGuang <br>
* Creation Date : 2013/10/28 <br>
* Description : 删除table <br>
* 如果指定table不存在就直接返回不报错 保证脚本可以反复执行 <br>
*
* Parameter:table_name
* 指定要删除的表名称
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-07-05 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/
PROCEDURE drop_table(table_name IN VARCHAR2) IS
v_tab_name VARCHAR2(120);
v_count NUMBER;
v_bak_table VARCHAR2(30);--Added by yangxiaoqing 2016-08-09 for 新增备份表过程
BEGIN
v_tab_name := upper(TRIM(table_name));
v_count := 0;
v_bak_table := substr(v_tab_name,1,23)||'_'||TO_CHAR(SYSDATE, 'HHMISS');--Added by yangxiaoqing 2016-08-09 for 新增备份表过程

SELECT COUNT(*) INTO v_count FROM user_tables WHERE table_name = v_tab_name;

IF v_count > 0
THEN
EXECUTE IMMEDIATE 'CREATE TABLE ' || v_bak_table||' AS SELECT * FROM '||v_tab_name;--Added by yangxiaoqing 2016-08-09 for 新增备份表过程

EXECUTE IMMEDIATE 'DROP TABLE ' || v_tab_name;
END IF;
EXCEPTION
WHEN OTHERS THEN
RAISE;
END drop_table;

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : aGuang <br>
* Creation Date : 2013/10/28 <br>
* Description : 删除view <br>
* 如果指定view不存在就直接返回不报错 保证脚本可以反复执行 <br>
*
* Parameter:table_name
* 指定要删除的view名称
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-07-05 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/
PROCEDURE drop_view(view_name IN VARCHAR2) IS
v_view_name VARCHAR2(120);
v_count NUMBER;
BEGIN
v_view_name := upper(TRIM(view_name));
v_count := 0;

SELECT COUNT(*) INTO v_count FROM user_views WHERE view_name = v_view_name;

IF v_count > 0
THEN
EXECUTE IMMEDIATE 'DROP VIEW ' || v_view_name;
END IF;
EXCEPTION
WHEN OTHERS THEN
RAISE;
END drop_view;

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : aGuang <br>
* Creation Date : 2013/10/28 <br>
* Description : 删除表字段 <br>
* 如果指定表字段不存在就直接返回不报错 保证脚本可以反复执行 <br>
* Parameter:table_name
* 指定要删除列的所属表名称
*
* Parameter:column_name
* 指定要删除列
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-07-05 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/
PROCEDURE drop_column(table_name IN VARCHAR2,
column_name IN VARCHAR2) IS
v_tab_name VARCHAR2(120);
v_column_name VARCHAR2(120);
v_count NUMBER;
v_bak_table VARCHAR2(30); --Added by yangxiaoqing 2016-08-09 for 新增备份表过程
BEGIN
v_tab_name := upper(TRIM(table_name));
v_column_name := upper(TRIM(column_name));
v_count := 0;
v_bak_table := substr(v_tab_name,1,23)||'_'||TO_CHAR(SYSDATE, 'HHMISS');--Added by yangxiaoqing 2016-08-09 for 新增备份表过程


SELECT COUNT(*)
INTO v_count
FROM user_tab_cols
WHERE table_name = v_tab_name
AND column_name = v_column_name;

IF v_count > 0
THEN
EXECUTE IMMEDIATE 'CREATE TABLE ' || v_bak_table ||' AS SELECT * FROM '||v_tab_name;--Added by yangxiaoqing 2016-08-09 for 新增备份表过程

EXECUTE IMMEDIATE 'ALTER TABLE ' || v_tab_name || ' DROP COLUMN ' || v_column_name;
END IF;
EXCEPTION
WHEN OTHERS THEN
RAISE;
END drop_column;

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : aGuang <br>
* Creation Date : 2013/10/28 <br>
* Description : 删除Index <br>
* 如果指定删除Index不存在就直接返回不报错 保证脚本可以反复执行 <br>
*
* Parameter:index_name
* 指定要删除的索引名称
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-07-05 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/
PROCEDURE drop_index(index_name IN VARCHAR2) IS
v_idx_name VARCHAR2(120);
v_count NUMBER;
BEGIN
v_idx_name := upper(TRIM(index_name));
v_count := 0;

SELECT COUNT(*) INTO v_count FROM user_indexes WHERE index_name = v_idx_name;

IF v_count > 0
THEN
EXECUTE IMMEDIATE 'DROP INDEX ' || v_idx_name;
END IF;
EXCEPTION
WHEN OTHERS THEN
RAISE;
END drop_index;

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : aGuang <br>
* Creation Date : 2013/10/28 <br>
* Description : 删除表约束 <br>
* 如果指定约束不存在就直接返回不报错 保证脚本可以反复执行 <br>
* Parameter:table_name
* 指定要删除约束的所属表名称
*
* Parameter:constraint_name
* 指定要删除的约束
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-07-05 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/
PROCEDURE drop_constraint(table_name IN VARCHAR2,
constraint_name IN VARCHAR2) IS
v_tab_name VARCHAR2(120);
v_constraint_name VARCHAR2(120);
v_count NUMBER;
BEGIN
v_tab_name := upper(TRIM(table_name));
v_constraint_name := upper(TRIM(constraint_name));
v_count := 0;

SELECT COUNT(*)
INTO v_count
FROM user_constraints
WHERE table_name = v_tab_name
AND constraint_name = v_constraint_name;

IF v_count > 0
THEN
EXECUTE IMMEDIATE 'ALTER TABLE ' || v_tab_name || ' DROP CONSTRAINTS ' || v_constraint_name;
END IF;
EXCEPTION
WHEN OTHERS THEN
RAISE;
END drop_constraint;

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : aGuang <br>
* Creation Date : 2013/10/28 <br>
* Description : 删除sequence <br>
* 如果指定删除sequence不存在就直接返回不报错 保证脚本可以反复执行 <br>
*
* Parameter:sequence_name
* 指定要删除的序列名称
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-07-05 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/
PROCEDURE drop_sequence(sequence_name IN VARCHAR2) IS
v_sequence_name VARCHAR2(120);
v_count NUMBER;
BEGIN
v_sequence_name := upper(TRIM(sequence_name));
v_count := 0;

SELECT COUNT(*) INTO v_count FROM user_sequences WHERE sequence_name = v_sequence_name;

IF v_count > 0
THEN
EXECUTE IMMEDIATE 'DROP SEQUENCE ' || v_sequence_name;
END IF;
EXCEPTION
WHEN OTHERS THEN
RAISE;
END drop_sequence;

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : aGuang <br>
* Creation Date : 2013/10/28 <br>
* Description : 删除Trigger <br>
* 如果指定删除Trigger不存在就直接返回不报错 保证脚本可以反复执行 <br>
*
* Parameter:trigger_name
* 指定要删除的Trigger名称
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-07-05 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/
PROCEDURE drop_trigger(trigger_name IN VARCHAR2) IS
v_trigger_name VARCHAR2(120);
v_count NUMBER;
BEGIN
v_trigger_name := upper(TRIM(trigger_name));
v_count := 0;

SELECT COUNT(*) INTO v_count FROM user_triggers WHERE trigger_name = v_trigger_name;

IF v_count > 0
THEN
EXECUTE IMMEDIATE 'DROP TRIGGER ' || v_trigger_name;
END IF;
EXCEPTION
WHEN OTHERS THEN
RAISE;
END drop_trigger;

/*----------------------------------------------------------------------------------------------------------------------------
* 
*
* File Name : scripts_util <br>
* Author : YangLi <br>
* Creation Date : 2015/07/31 <br>
* Description : 删除同义词 <br>
* 如果指定删除同义词不存在就直接返回不报错 保证脚本可以反复执行 <br>
*
* Parameter:trigger_name
* 指定要删除的同义词名称
*
* Modification History : <br>
* Version No. | Date | Modified By | Brief description of change <br>
* ---------------------------------------------------------------------------------------------------
* 1 | 2012-07-05 | aGuang | Package Created <br>
*
----------------------------------------------------------------------------------------------------------------------------*/
PROCEDURE drop_synonym(synonym_name IN VARCHAR2) IS
v_synonym_name VARCHAR2(120);
v_count NUMBER;
BEGIN
v_synonym_name := upper(TRIM(synonym_name));
v_count := 0;

SELECT COUNT(*) INTO v_count FROM user_synonyms WHERE synonym_name = v_synonym_name;

IF v_count > 0
THEN
EXECUTE IMMEDIATE 'DROP SYNONYM ' || v_synonym_name;
END IF;
EXCEPTION
WHEN OTHERS THEN
RAISE;
END drop_synonym;

BEGIN
NULL;
END scripts_util;
/
