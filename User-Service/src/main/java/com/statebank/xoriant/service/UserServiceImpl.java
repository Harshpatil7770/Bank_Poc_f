package com.statebank.xoriant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statebank.xoriant.dao.UserDao;
import com.statebank.xoriant.dao.util.UserDTO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public String changePassword(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return userDao.changePassword(userDTO);
	}
	
}
