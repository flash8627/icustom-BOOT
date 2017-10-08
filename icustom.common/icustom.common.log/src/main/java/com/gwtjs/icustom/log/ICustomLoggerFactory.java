package com.gwtjs.icustom.log;

/**
 * 继承LoggerFactory
 * 
 * @author aGuang
 * @since 2013-8-26
 */
public final class ICustomLoggerFactory {
	
	private ICustomLoggerFactory() {
	}

	/**
	 * 通过名字获取Logger
	 * 
	 * @param name
	 * @return
	 */
	public static ICustomLogger getLogger(String name) {
		return ICustomLog4j.getLog(name);
	}

	/**
	 * 通过Class获取日志记录器
	 * 
	 * @param clazz
	 * @return
	 */
	public static ICustomLogger getLogger(Class<?> clazz) {
		return getLogger(clazz.getName());
	}
}
