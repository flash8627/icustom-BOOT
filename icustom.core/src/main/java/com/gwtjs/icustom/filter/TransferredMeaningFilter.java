package com.gwtjs.icustom.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;

/**
 * 字符转义过滤器 过滤危险的字符
 * 
 * @author aGuang
 *
 */
@WebFilter(urlPatterns = "*", filterName = "TransferredMeaningFilter")
public class TransferredMeaningFilter implements Filter {

	private static final ICustomLogger log = ICustomLoggerFactory.getLogger(TransferredMeaningFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("TransferredMeaningFilter do filter---");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
