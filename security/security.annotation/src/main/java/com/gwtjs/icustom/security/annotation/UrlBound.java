package com.gwtjs.icustom.security.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
* 方法绑定url权限控制
* @author aGuang
* @since 2010-12-13
*/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UrlBound {
	
	/** url属性名称 **/
	String ATTR_URL = "url";

	/**
	* 资源绑定url编码
	* @return
	*/
	String url() default "";

}
