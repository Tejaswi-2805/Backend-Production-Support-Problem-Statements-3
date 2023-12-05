package com.example.securityAuditLogging.UserRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securityAuditLogging.User.AuditLog;

@Repository
public interface AuditLogRepo extends JpaRepository<AuditLog, Long> {

}
