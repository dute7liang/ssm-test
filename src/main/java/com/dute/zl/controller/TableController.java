package com.dute.zl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dute.zl.model.TableEntity;
import com.dute.zl.service.TableService;

@Controller
@RequestMapping("/table")
public class TableController {
	
	@Autowired
    private TableService tableService; 
	
	@RequestMapping("/manager")  
    public String toIndex(HttpServletRequest request,Model model){  
        return "table";  
    }  
	
	@RequestMapping("/dataGrid") 
	@ResponseBody
    public List<TableEntity> login(TableEntity user,HttpServletRequest request){ 
		return tableService.getDataAll();
    } 
	

	
	
	
}
