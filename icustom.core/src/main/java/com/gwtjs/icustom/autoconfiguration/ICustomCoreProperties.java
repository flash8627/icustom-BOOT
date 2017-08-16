package com.gwtjs.icustom.autoconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "icustom.core")
public class ICustomCoreProperties {

	/**
	 * icustom应用的名称，该应用的名称请参考UPC系统中记录的应用名称。
	 */
	@Value("${" + EnvConstants.APPLICATION_NAME + "}")
	private String appName;

	/**
	 * 所属业务领域
	 */
	private String scope = "icustom";

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

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public static IApplicationPrincipal getAppPrincipal() {
		return appPrincipal;
	}

	public void setAppPrincipal(IApplicationPrincipal appPrincipal) {
		ICustomCoreProperties.appPrincipal = appPrincipal;
	}

}
