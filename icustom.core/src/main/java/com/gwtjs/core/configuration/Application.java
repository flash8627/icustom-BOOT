package com.gwtjs.core.configuration;

//import com.gwtjs.core.log.ILogger;
//import com.gwtjs.core.log.LoggerFactory;

public class Application implements IApplicationPrincipal {

	/*
	 * private static final ILogger log = LoggerFactory
	 * .getLogger(Application.class);
	 */
	private static final long serialVersionUID = 3088642430828812087L;

	/**
	 * 应用所属的应用ID.该应用请配置为应用中心的”应用ID“。
	 */
	private String appId;

	/* 子应用名称，该名称请配置为应用中心”子应用名称“。 */
	private String appName;

	private String contextPath;
	private int logsTableIndex;
	private String dbType;
	private String serviceVersion;

	/** 应用权限统一 */
	private boolean enableAppPermissionPortal = false;

	/**
	 * 开发环境
	 */
	public static final String DEV = "dev";

	/**
	 * SIT 环境
	 */
	public static final String SIT = "sit";
	/**
	 * UAT 环境
	 */
	public static final String UAT = "uat";
	/**
	 * 生产环境
	 */
	public static final String PRODUCTION = "production";

	/**
	 * 性能测试环境
	 */
	public static final String PERF = "perf";

	public int getLogsTableIndex() {
		return logsTableIndex;
	}

	public void setLogsTableIndex(int logsTableIndex) {
		this.logsTableIndex = logsTableIndex;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	private static Object lockObj = new Object();
	{
		// initJalor5();
	}

	@Override
	public String getAppName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setScope(String cope) {
	}
	
	@Override
	public String getScope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEnviorment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSiteMapViewName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContextPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNetwork() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDbType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServiceVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnableAppPermissionPortal() {
		// TODO Auto-generated method stub
		return false;
	}

}
