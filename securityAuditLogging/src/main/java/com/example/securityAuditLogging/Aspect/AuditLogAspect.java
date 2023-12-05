package com.example.securityAuditLogging.Aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.securityAuditLogging.User.AuditLog;
import com.example.securityAuditLogging.UserRepo.AuditLogRepo;

@Aspect
@Component
public class AuditLogAspect {
	
	private final AuditLogRepo auditLogRepo;
    private final AuthenticationFacade authenticationFacade;
    
    @Autowired
    public AuditLogAspect(AuditLogRepo auditLogRepo, AuthenticationFacade authenticationFacade) {
        this.auditLogRepo = auditLogRepo;
        this.authenticationFacade = authenticationFacade;
    }
    
    @AfterReturning(pointcut = "@annotation(auditLog)", returning = "result")
    public void logAudit(JoinPoint joinPoint, AuditLogAnnotation auditLog, Object result) {
        String username = authenticationFacade.getAuthenticatedUsername();
        String action = auditLog.action();
        LocalDateTime timestamp = LocalDateTime.now();

        AuditLog logEntry = new AuditLog();
        logEntry.setUsername(username);
        logEntry.setAction(action);
        logEntry.setTimestamp(timestamp);

        auditLogRepo.save(logEntry);
    }


}
