package com.gwtjs.springsecurity;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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

import com.gwtjs.springsecurity.support.CustomUserDetailsService;
import com.gwtjs.springsecurity.support.LoginSuccessHandler;
import com.gwtjs.springsecurity.support.MyFilterSecurityInterceptor;

@Configuration
@EnableWebSecurity
// @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyFilterSecurityInterceptor mySecurityFilter;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired  
    DataSource dataSource; 

	@Override
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
		http
		/* 哈哈哈，暂时停用 */
		.addFilterBefore(mySecurityFilter, FilterSecurityInterceptor.class)
				// 在正确的位置添加我们自定义的过滤器
				.authorizeRequests()
				.antMatchers("/home")
				.permitAll()
				.anyRequest()
				.authenticated()
				// .antMatchers("/hello").hasAuthority("ADMIN")
				.and().formLogin()
				.loginPage("/login")
				.permitAll()
				.successHandler(loginSuccessHandler())
				.and().logout().logoutSuccessUrl("/home").permitAll()
				.invalidateHttpSession(true)
				//.and().rememberMe().tokenValiditySeconds(1209600)
				 .and().rememberMe().rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository()).tokenValiditySeconds(86400)  
				 .and().exceptionHandling().accessDeniedPage("/Access_Denied")
				.and().csrf().disable()
				/*.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
				.csrf().csrfTokenRepository(csrfTokenRepository())*/;
		/* 哈哈哈，暂时停用 */
	}
	
	/**
	 * 
	 * @return
	 */
	@Bean  
    public PersistentTokenRepository persistentTokenRepository() {  
        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();  
        tokenRepositoryImpl.setDataSource(dataSource);  
        return tokenRepositoryImpl;  
    }  

	/**
	 * 对CSRF进行自定义:
	 * 在服务端要求CSRF令牌应该以Angular想要的格式回传(一个叫做 "X-XRSF-TOKEN" 的消息头，而不是默认的"X-CSRF-TOKEN")
	 * @return
	 */
	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		// 指定密码加密所使用的加密器为passwordEncoder()
		// 需要将密码加密后写入数据库
		auth.userDetailsService(customUserDetailsService).passwordEncoder(
				passwordEncoder());
		// 不删除凭据，以便记住用户
		auth.eraseCredentials(false);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
	}

	@Bean
	public LoginSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler();
	}
}
