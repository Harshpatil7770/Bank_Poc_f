package com.statebank.xoriant.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.statebank.xoriant.dao.util.UserDTO;

 

@FeignClient(name = "user-service")
public interface UserServiceProxy {
	
	@GetMapping("/api/user/changePassword")
	public int changePassword(@RequestBody UserDTO userDTO);

}
