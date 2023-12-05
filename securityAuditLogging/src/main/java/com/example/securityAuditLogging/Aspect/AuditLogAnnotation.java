package com.example.securityAuditLogging.Aspect;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AuditLogAnnotation {
    String action();
}
