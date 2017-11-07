package com.gwtjs.icustom.security.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 受访问控制的操作
 * 
 * @author aGuang
 * @since 2011-9-13
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityOperation {

	/** code属性名称 **/
	String ATTR_CODE = "code";

	/** desc属性名称 **/
	String ATTR_DESC = "desc";

	/**
	 * 操作编码
	 * 
	 * @return
	 */
	String code() default "";

	/**
	 * 操作描述
	 * 
	 * @return
	 */
	String desc() default "";

	/**
	 * 安全策略
	 * 
	 * @author aGuang
	 * @since Dec 20, 2011
	 * @return
	 */
	SecurityPolicy policy() default SecurityPolicy.Required;

}
