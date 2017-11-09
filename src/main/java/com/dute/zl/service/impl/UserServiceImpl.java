package com.dute.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dute.zl.dao.UserDao;
import com.dute.zl.model.UserEntity;
import com.dute.zl.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<UserEntity> getDataAll() {
		List<UserEntity> findAll = userDao.findAll();
		return findAll;
	}

}
