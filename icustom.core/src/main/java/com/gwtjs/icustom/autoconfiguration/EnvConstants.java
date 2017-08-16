package com.gwtjs.icustom.autoconfiguration;

public class EnvConstants {
	
	/**
	* 当前激活的标准环境键。
	*/
	public static final String CURRENT_PROFILE = "spring.profiles.active";

	/**
	* 当前应用ID键。 参考应用中心。
	*/
	public static final String APPLICATION_ID = "spring.application.id";

	/**
	* 老版本的配置应用ID参数名。为了兼容老版本配置。
	*/
	public static final String _CONFIG_APPLICATION_ID = "config_appid";

	/**
	* 当前子应用名称键。参考应用中心。
	*/
	public static final String APPLICATION_NAME = "spring.application.name";

	/**
	* 老版本的配置应用名称参数名。为了兼容老版本配置。
	*/
	public static final String _CONFIG_APPLICATION_NAME = "config_subapp";

	/**
	* 当前应用所部署区域。参考配置。
	*/
	public static final String CURRENT_CONFIG_CENTER_REGION = "spring.application.region";

	/**
	* 老版本的配置区域参数名。为了兼容老版本配置。
	*/
	public static final String _CONFIG_REGION = "config_region";

	/**
	* 当前应用所部署环境。参考配置。
	*/
	public static final String CURRENT_CONFIG_CENTER_ENV = "spring.application.env";

	/**
	* 老版本的配置环境参数名。为了兼容老版本配置。
	*/
	public static final String _CONFIG_ENV = "config_env";
	
}
