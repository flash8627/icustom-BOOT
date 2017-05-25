package com.gwtjs.core.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "icustom.core")
public class CoreProperties {

	/**
	 * icustom应用的名称，该应用的名称请参考UPC系统中记录的应用名称。
	 */
	@Value("${" + EnvConstants.APPLICATION_NAME + "}")
	private String appName;

	/**
	 * 所属业务领域
	 */
	private String scope = "isc";

	/**
	 * 所属网络环境
	 */

	private String network;
	/** IApplicationPrincipal实例 **/
	private static volatile IApplicationPrincipal appPrincipal = null;

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * 获取当前应用的身份
	 *
	 * @author l54883
	 * @since 2012-6-26
	 * @return
	 */
	public static IApplicationPrincipal getCurrent() {
		if (appPrincipal != null) {
			return appPrincipal;
		}

		/*
		 * synchronized (lockObj) { if (appPrincipal == null) { appPrincipal =
		 * ICustom.getContext().getBean("applicationPrincipal",
		 * IApplicationPrincipal.class); } }
		 */
		return appPrincipal;
	}

}
