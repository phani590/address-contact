package com.crm.purple.army.skill.assessment.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter 
{
	 @Override  
	    public void configure(HttpSecurity http) throws Exception {  
	        http  
	            .authorizeRequests()  
	            .antMatchers( "/public/**").permitAll()  
	            .anyRequest().authenticated()  
	            .and()  
	            .formLogin()  
                .loginPage("/login.html")  
                .failureUrl("/login-error.html")  
                .permitAll(); 
	    }  
	 
	 @Override  
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
	        auth.inMemoryAuthentication()  
	            .withUser("user")  
	            .password("jd@123")
				.authorities("ROLE_USER"); 
	    }  
}
