package com.gridscape.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityFilterChain {
	
	@Bean
	public SecurityFilterChain mySecurityFilertChainGet(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
				.requestMatchers("/gridscape/registerUser").permitAll()
				.requestMatchers("/gridscape/updateOrganization")
				.hasAnyAuthority("User","Admin")
				.requestMatchers("/gridscape/allUser")
				.hasAnyAuthority("Admin")
				.and()
				.csrf().disable()
				.formLogin()
				.and()
				.httpBasic();
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
