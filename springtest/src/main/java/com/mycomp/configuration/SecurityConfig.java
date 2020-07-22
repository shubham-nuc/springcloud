package com.mycomp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity  //Basically used for web application security
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{

		// getting users details. We can get the users from DB also.
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				auth.inMemoryAuthentication()
					.passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
					.withUser("shubham").password("shubham1").roles("USER")
					.and()
					.withUser("admin").password("admin1").roles("USER", "ADMIN");
		}

		// Authorization : Role -> Access
		protected void configure(HttpSecurity http) throws Exception {
			//http.csrf().disable();
			
			http
			.httpBasic()
			.and()
			.authorizeRequests()
			
			.antMatchers("/app/v1/userapi/users/**").hasRole("USER")
			.antMatchers("/app/v1/userapi/**").hasRole("ADMIN")
			.and()
			.csrf()
			.disable()
			.headers()
			.frameOptions()
			.disable();
			
			//To enable all requests
			/*http.authorizeRequests().antMatchers("/").permitAll().and()
			.csrf()
			.disable()
			.headers()
			.frameOptions()
			.disable();*/
		}
}
