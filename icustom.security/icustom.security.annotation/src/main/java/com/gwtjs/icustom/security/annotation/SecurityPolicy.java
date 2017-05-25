package com.gwtjs.icustom.security.annotation;

/**
* 安全认证策略
*
* @author aGuang
* @since Dec 20, 2011
*/
public enum SecurityPolicy {
	
	/**
	* 默认安全策略。
	*
	* 如果前一个方法已经进行过安全检查，则本方法不进行安全检查；
	* 否则，如果code不为空，则进行安全检查，code为空，抛出异常。
	*/
	Required,

	/**
	* 强制的。
	*
	* 强制执行安全检查，无论前面是否执行过方法检查。
	*/
	Mandatory,
	/**
	* 所有系统用户，即在系统中有角色的用户
	*/
	AllSystemUser,
	/**
	* 所有已登录用户，即已经认证通过的用户
	*/
	AllLogonUser,
	/**
	* 忽略后续方法的安全检查。
	*
	* 该策略只适合设置在入口方法上。
	* 入口方法一旦遇到这个标记，则后续方法的安全检查将被忽略。
	*
	* IgoreAll的优先级高于Mandatory。
	*/
	IgnoreAll,

	/**
	* ICustom 内部通讯用的
	*/
	Internal
	
}
