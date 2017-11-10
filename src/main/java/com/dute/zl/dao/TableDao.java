package com.dute.zl.dao;

import java.util.List;

import com.dute.zl.model.TableEntity;

public interface TableDao {
	List<TableEntity> findAll();
	TableEntity findById(int id);
	void deleteById(int id);
	void addUser(TableEntity user);
	void updateUser(TableEntity user);
}
