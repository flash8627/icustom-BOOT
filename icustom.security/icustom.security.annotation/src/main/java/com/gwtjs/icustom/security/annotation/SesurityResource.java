package com.gwtjs.icustom.security.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 受访问控制的资源
 * 
 * @author aGuang
 * @since 2011-9-13
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface SesurityResource {

	/** code属性名称 **/
	String ATTR_CODE = "code";

	/** desc属性名称 **/
	String ATTR_DESC = "desc";

	/**
	 * 资源编码
	 * 
	 * @return
	 */
	String code();

	/**
	 * 资源描述
	 * 
	 * @return
	 */
	String desc();

}
