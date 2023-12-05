package com.example.securityAuditLogging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableAspectJAutoProxy
public class SecurityAuditLoggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityAuditLoggingApplication.class, args);
	}

}
