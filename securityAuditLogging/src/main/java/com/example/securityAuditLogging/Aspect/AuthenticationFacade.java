package com.example.securityAuditLogging.Aspect;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.securityAuditLogging.User.AuditLog;
import com.example.securityAuditLogging.User.User;

@Component
public class AuthenticationFacade {
	
	User user=new User();
	AuditLog auditLog=new AuditLog();
	
	 public Authentication getAuthentication() {
	        return SecurityContextHolder.getContext().getAuthentication();
	    }
	 
	 public String getAuthenticatedUsername() {
	        Authentication authentication = getAuthentication();
//	        return authentication.getName();
	        if (authentication != null && authentication.isAuthenticated()) {
	        	 String username = authentication.getName();
	             System.out.println("Authenticated username: " + username);
	             return username;
	        }
	        return user.getUsername(); // or handle the case when authentication is null
	    }

}
