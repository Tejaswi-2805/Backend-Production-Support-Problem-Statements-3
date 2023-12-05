package com.example.securityAuditLogging.UserService;

import com.example.securityAuditLogging.Dto.LoginDto;
import com.example.securityAuditLogging.Dto.UserDto;
import com.example.securityAuditLogging.User.LoginMessage;

public interface UserService {

	String addUser(UserDto userDto);
	LoginMessage loginUser(LoginDto loginDto);

}
