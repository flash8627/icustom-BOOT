package com.gwtjs.icustom.springsecurity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import com.gwtjs.icustom.springsecurity.support.CustomUserDetailsService;
import com.gwtjs.icustom.springsecurity.support.LoginSuccessHandler;
import com.gwtjs.icustom.springsecurity.support.MyFilterSecurityInterceptor;

@Configuration
@EnableWebSecurity
@ConditionalOnClass(SecurityWebSecurityConfig.class)
// @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableGlobalMethodSecurity(prePostEnabled = true,jsr250Enabled=true)
public class SecurityWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyFilterSecurityInterceptor mySecurityFilter;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	/*@Inject
    private UserIpAuthenticationProvider userIpAuthenticationProvider;*/
	
	@Autowired  
    DataSource dataSource; 

	@Bean @Override @ConditionalOnMissingBean(AuthenticationManager.class)
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http .authorizeRequests() .antMatchers("/api/*").hasRole("ADMIN") .and()
	 * .addFilterAfter(new CsrfTokenResponseHeaderBindingFilter(),
	 * CsrfFilter.class) .exceptionHandling()
	 * .authenticationEntryPoint(restAuthenticationEntryPoint) .and()
	 * .formLogin() .successHandler(authenticationSuccessHandler)
	 * .failureHandler(new SimpleUrlAuthenticationFailureHandler());
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/* 哈哈哈，暂时停用 */
		http.addFilterBefore(mySecurityFilter, FilterSecurityInterceptor.class)
				// 在正确的位置添加我们自定义的过滤器
				.authorizeRequests().antMatchers("/login").permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/",true)
				.and().logout().logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				.and().rememberMe().rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository()).tokenValiditySeconds(86400)  
				.and().exceptionHandling().accessDeniedPage("/accessDenied")
				.and().csrf().disable()
				/*
				 * .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
				.csrf().csrfTokenRepository(csrfTokenRepository())*/;
	}
	
	/**
	 * 
	 * @return
	 */
	@Bean @ConditionalOnMissingBean(PersistentTokenRepository.class)
    public PersistentTokenRepository persistentTokenRepository() {  
        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();  
        tokenRepositoryImpl.setDataSource(dataSource);  
        return tokenRepositoryImpl;  
    }  

	/**
	 * 对CSRF进行自定义:
	 * 在服务端要求CSRF令牌应该以Angular想要的格式回传(一个叫做 "X-XRSF-TOKEN" 的消息头，而不是默认的"X-CSRF-TOKEN")
	 * @return
	 */ @ConditionalOnMissingBean(CsrfTokenRepository.class)
	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		List<String> list=new ArrayList<String>();
        list.add("/js/**");
        list.add("/scripts/**");
        list.add("/css/**");
        list.add("/image/**");
        list.add("/images/**");
        list.add("/resources/**");
        list.add("/font/**");
        list.add("/fonts/**");
        list.add("/**/favicon.ico");
		web.ignoring().antMatchers(list.toArray(new String[list.size()]));
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		// 指定密码加密所使用的加密器为passwordEncoder()
		// 需要将密码加密后写入数据库
		auth.userDetailsService(customUserDetailsService).passwordEncoder(
				passwordEncoder());
		// 不删除凭据，以便记住用户
		//auth.eraseCredentials(false);
		//auth.authenticationProvider(userIpAuthenticationProvider);
	}

	@Bean @ConditionalOnMissingBean(BCryptPasswordEncoder.class)
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
	}

	@Bean @ConditionalOnMissingBean(LoginSuccessHandler.class)
	public LoginSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler();
	}
}
