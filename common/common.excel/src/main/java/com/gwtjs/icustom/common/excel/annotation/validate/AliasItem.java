package com.gwtjs.icustom.common.excel.annotation.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 配合 Alias使用。source指的是 excel的数据。target指的是 对应的结果
 * 
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AliasItem {
	/**
	 * 要转换的值
	 * @return
	 */
	String source();
	
	/**
	 * 转换成的值
	 * @return
	 */
	String target();
}
