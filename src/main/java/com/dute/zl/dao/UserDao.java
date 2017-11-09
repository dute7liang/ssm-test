package com.dute.zl.dao;

import java.util.List;

import com.dute.zl.model.UserEntity;

public interface UserDao {
	List<UserEntity> findAll();
	UserEntity findById(int id);
	void deleteById(int id);
	void addUser(UserEntity user);
	void updateUser(UserEntity user);
}
