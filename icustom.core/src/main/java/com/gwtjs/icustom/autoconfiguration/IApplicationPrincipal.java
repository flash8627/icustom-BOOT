package com.gwtjs.icustom.autoconfiguration;

import java.io.Serializable;

/**
 * 应用程序凭证，含应用名、权限Scope、当前环境等信息
 */
public interface IApplicationPrincipal extends Serializable {

	/**
	 * 获得日志表格名称
	 * 
	 * @since 2013-6-7
	 * @return
	 */
	int getLogsTableIndex();

	/**
	 * 获取应用名
	 * 
	 * @return
	 */
	String getAppName();

	/**
	 * 获取权限的Scope
	 * 
	 * @return
	 */
	String getScope();

	/**
	 * 获取当前的环境
	 * 
	 * @return
	 */
	String getEnviorment();

	/**
	 * 获取栏目视图名称，无视图时可能返回NULL
	 * 
	 * @return
	 */
	String getSiteMapViewName();

	/**
	 * 应用上下文根，包含最后的/
	 * 
	 * @author l54883
	 * @since 2012-3-29
	 * @return
	 */
	String getContextPath();

	/**
	 * 获取当前网络环境 internet/intranet
	 * 
	 * @author l54883
	 * @since 2012-6-29
	 * @return
	 */
	String getNetwork();

	/**
	 * 获取数据库类型[oracle,mysql]
	 * 
	 * @author zWX304259
	 * @since 2016年2月25日
	 * @return
	 */
	String getDbType();

	/**
	 * 获取服务版本
	 * 
	 * @author gwx244051
	 * @since 2016年03月10日
	 * @return
	 */
	String getServiceVersion();

	boolean isEnableAppPermissionPortal();

}
