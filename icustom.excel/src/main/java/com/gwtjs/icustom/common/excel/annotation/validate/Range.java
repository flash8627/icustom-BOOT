package com.gwtjs.icustom.common.excel.annotation.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 范围
 * 
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Range {
	/**
	 * 最小值
	 * @return
	 */
	int min();
	
	/**
	 * 最大值
	 * @return
	 */
	int max();
	
	String message() default "";
}
