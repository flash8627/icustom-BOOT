package com.gwtjs.springsecurity.support;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import com.gwtjs.springsecurity.SecurityWebSecurityConfig;

/**
 * 该过滤器的主要作用就是通过spring著名的IoC生成securityMetadataSource。
 * securityMetadataSource相当于本包中自定义的MyInvocationSecurityMetadataSourceService。
 * 该MyInvocationSecurityMetadataSourceService的作用提从数据库提取权限和资源，装配到HashMap中，
 * 供Spring Security使用，用于权限校验。
 * 
 * @author aGuang 2010/3/29
 *
 */
@Component
@Configuration
@ConditionalOnClass(MyFilterSecurityInterceptor.class)
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor
		implements Filter {

	@Autowired
	private CustomInvocationSecurityMetadataSourceService customInvocationSecurityMetadataSourceService;

	@Autowired
	private CustomAccessDecisionManager myAccessDecisionManager;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostConstruct
	public void init() {
		super.setAuthenticationManager(authenticationManager);
		super.setAccessDecisionManager(myAccessDecisionManager);
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		invoke(fi);

	}

	public Class<? extends Object> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	public void invoke(FilterInvocation fi) throws IOException,
			ServletException {
		logger.debug("filter..........................");
		InterceptorStatusToken token = super.beforeInvocation(fi);
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}

	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		logger.debug("obtainSecurityMetadataSource");
		return this.customInvocationSecurityMetadataSourceService;
	}

	public void destroy() {
		logger.debug("filter===========================destroy");
	}

	public void init(FilterConfig filterconfig) throws ServletException {
		logger.debug("filter===========================init");
	}

	@Bean @ConditionalOnMissingBean(CustomInvocationSecurityMetadataSourceService.class)
	public CustomInvocationSecurityMetadataSourceService getCustomInvocationSecurityMetadataSourceService() {
		return customInvocationSecurityMetadataSourceService;
	}
	
	@Bean
	public CustomAccessDecisionManager getMyAccessDecisionManager() {
		return myAccessDecisionManager;
	}

	@Override @Bean @ConditionalOnMissingBean(AccessDecisionManager.class)
	public AccessDecisionManager getAccessDecisionManager() {
		// TODO Auto-generated method stub AccessDecisionManager
		return this.myAccessDecisionManager;
	}
	
}
