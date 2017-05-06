package com.gwtjs.core.entity;

import java.io.Serializable;

/**
 * jerser不能接收多个参数,这里再做一层封装,将对象和分页包装起来
 * <p>
 * There was an unexpected error (type=Internal Server Error, status=500).
Validation of the application resource model has failed during application initialization. [[FATAL] Method public abstract com.gwtjs.core.entity.PagedResult 
 * </p>
 * @author aGuang
 *
 * @param <T>
 */
public class ParameterVO<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7278381061013693250L;

	private PageVO pageVO;
	
	public ParameterVO() {
		super();
	}

	public ParameterVO(PageVO pageVO, T t) {
		super();
		this.pageVO = pageVO;
		this.t = t;
	}

	private T t;

	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}
