package com.gwtjs.icustom.common.excel.annotation.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 这里是导出对象的annoation
 * 所有需要导出的字段需要使用该注解
 * 
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelField {
	
	/**
	 * 注释在属性上的title
	 * 用来设置标题
	 * @return
	 */
	 String title();
	
	 /**
	  * 设置排序 可以手动调整标题的顺序
	  * @return
	  */
	 int order () default 99999;

}
