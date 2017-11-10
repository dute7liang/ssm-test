package com.dute.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dute.zl.dao.TableDao;
import com.dute.zl.model.TableEntity;
import com.dute.zl.service.TableService;
import com.dute.zl.service.UserService;
@Service("tableService")
public class TableServiceImpl implements TableService{
	
	@Autowired
	private TableDao tableDao;
	
	public List<TableEntity> getDataAll() {
		List<TableEntity> findAll = tableDao.findAll();
		return findAll;
	}

}
