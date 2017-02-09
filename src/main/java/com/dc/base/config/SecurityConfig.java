/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dc.base.config;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import com.dc.function.user.service.UserService;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public TokenBasedRememberMeServices rememberMeServices() {
        return new TokenBasedRememberMeServices("remember-me-key", userService());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
	}
	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/static/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login.html")
				.successForwardUrl("/home.html")
				.permitAll()
				.and()
			.logout()
				.permitAll()
				.and()
            .rememberMe()
                .rememberMeServices(rememberMeServices())
                .key("remember-me-key");
		
		
		http.authorizeRequests().accessDecisionManager(new AccessDecisionManager() {
			
			@Override
			public boolean supports(Class<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean supports(ConfigAttribute arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void decide(Authentication arg0, Object arg1, Collection<ConfigAttribute> arg2)
					throws AccessDeniedException, InsufficientAuthenticationException {
				// TODO Auto-generated method stub
				
			}
		});
	}
	// @formatter:on

	// @formatter:off
	@Autowired
	public void configureGlobal(
			AuthenticationManagerBuilder auth) throws Exception {
		/*auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");*/
		
		
		auth
		.jdbcAuthentication()
			.dataSource(dataSource)
			.withDefaultSchema()
			.authoritiesByUsernameQuery("select u.username, r.name as role from user u,user_role ur, role r where u.id=ur.user_Id and r.id = ur.role_Id and u.username=?")
			.usersByUsernameQuery("select username,password,1 as enabled from user WHERE username=?");
		
			/*.withUser("user").password("password").roles("USER").and()
			.withUser("admin").password("password").roles("USER", "ADMIN");*/
	}
	// @formatter:on
}
