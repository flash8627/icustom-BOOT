package com.gwtjs.icustom.common.excel.annotation.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 这里是导入对象的annoation
 * 所有需要导入的字段需要使用该注解
 * 
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelImportField {

	 /**
	  * 设置排序 可以手动调整标题的顺序
	  * @return
	  */
	 int order () default 9999;
}
