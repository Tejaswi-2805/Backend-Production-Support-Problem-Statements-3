package com.example.securityAuditLogging.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securityAuditLogging.Aspect.AuditLogAnnotation;
import com.example.securityAuditLogging.Dto.LoginDto;
import com.example.securityAuditLogging.Dto.UserDto;
import com.example.securityAuditLogging.User.LoginMessage;
import com.example.securityAuditLogging.User.User;
import com.example.securityAuditLogging.UserRepo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@AuditLogAnnotation(action = "new user registered")
	public String addUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
		User user=new User(
				userDto.getUserId(),
				userDto.getUsername(),
				userDto.getEmail(),
				this.passwordEncoder.encode(userDto.getPassword())
				);
			userRepo.save(user);
		
		
		return user.getUsername();
	}

	@Override
	@AuditLogAnnotation(action = "user logged in")
	public LoginMessage loginUser(LoginDto loginDto) {
		
		User user1= userRepo.findByEmail(loginDto.getEmail());
		if(user1!=null) {
			String pwd = loginDto.getPassword();
			String encodedPassword = user1.getPassword();
			Boolean isPwdRight = passwordEncoder.matches(pwd, encodedPassword);
			if(isPwdRight) {
				Optional<User> user = userRepo.findByEmailAndPassword(loginDto.getEmail(), encodedPassword);
				if(user.isPresent()) {
					return new LoginMessage("login success", true);
				}
				else {
					return new LoginMessage("Login failed", false);
				}
			} else {
				return new LoginMessage("password not match", false);
			}
		}else {
			return new LoginMessage("Email not exists", false);

		}
	}

}
