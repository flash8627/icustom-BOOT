package com.gwtjs.icustom.common.excel.annotation.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 邮箱
 * 
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Email {
	/**
	 * 邮箱格式(默认不校验)
	 * @return
	 */
	String message() default "";
}
