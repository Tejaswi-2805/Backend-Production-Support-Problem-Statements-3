package com.example.securityAuditLogging.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securityAuditLogging.User.AuditLog;
import com.example.securityAuditLogging.UserRepo.AuditLogRepo;


@RestController
@RequestMapping("/logs")
public class AuditLogController {
	
	private final AuditLogRepo auditLogRepo;
	
	@Autowired
    public AuditLogController(AuditLogRepo auditLogRepo) {
        this.auditLogRepo = auditLogRepo;
    }
	
	 @GetMapping("/auditlogs")
	   public List<AuditLog> getAuditLogs(Model model) {
	        List<AuditLog> auditLogs = auditLogRepo.findAll();
	        model.addAttribute("auditLogs", auditLogs);
	        System.out.println(auditLogs);
	        return auditLogs;
	    }
}
