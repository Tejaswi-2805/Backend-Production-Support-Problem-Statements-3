package com.example.securityAuditLogging.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.securityAuditLogging.Dto.LoginDto;
import com.example.securityAuditLogging.Dto.UserDto;
import com.example.securityAuditLogging.User.LoginMessage;
import com.example.securityAuditLogging.UserService.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@PostMapping("/register")
	public String saveUser(@RequestBody UserDto userDto) {
		String id = userService.addUser(userDto);
		return id;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
		LoginMessage loginMessage= userService.loginUser(loginDto);
		return ResponseEntity.ok(loginMessage);
	}
}
