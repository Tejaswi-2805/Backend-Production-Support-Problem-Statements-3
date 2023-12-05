package com.example.securityAuditLogging.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
	
	   protected void configure(HttpSecurity http) throws Exception {
	       http
	           .authorizeRequests()
	               .requestMatchers("/auditlogs").authenticated()
	               .anyRequest().permitAll()
	           .and()
	           .formLogin()
	           .and()
	           .logout();
	   }

	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}
