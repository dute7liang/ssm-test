package com.dute.zl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.registry.infomodel.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dute.zl.model.UserEntity;
import com.dute.zl.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService; 
	
	@RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request,Model model){  
        List<UserEntity> dataAll = userService.getDataAll(); 
        model.addAttribute("user", dataAll);  
        return "showUser";  
    }  
}
