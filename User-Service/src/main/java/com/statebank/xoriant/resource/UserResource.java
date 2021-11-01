package com.statebank.xoriant.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.statebank.xoriant.dao.util.UserDTO;
import com.statebank.xoriant.service.UserService;



@RestController
@RequestMapping("/api/user")
@CrossOrigin
@RefreshScope
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@PutMapping("/changePassword")
	public String changePassword(@RequestBody UserDTO userDTO) {
		
		String result = userService.changePassword(userDTO);
		return result;
	}

}
