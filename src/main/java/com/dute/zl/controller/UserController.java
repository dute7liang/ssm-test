package com.dute.zl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dute.zl.model.UserEntity;
import com.dute.zl.model.UserSession;
import com.dute.zl.model.system.Json;
import com.dute.zl.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService; 
	
	@RequestMapping("/gogo")  
    public String toIndex(HttpServletRequest request,HttpServletResponse response,Model model){  
		UserSession sessionInfo = (UserSession) request.getSession().getAttribute("sessionInfo");
		if(sessionInfo != null){
			try {
				response.sendRedirect("/table/manager");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return "login";  
    }  
	
	@RequestMapping("/login") 
	@ResponseBody
    public Json login(UserEntity user,HttpServletRequest request,HttpSession session){ 
		Json j = new Json();
		if("admin".equals(user.getUserName())
				&& "admin".equals(user.getPassWord())){
			UserSession sessionInfo = new UserSession();
			sessionInfo.setUserName(user.getUserName());
			sessionInfo.setIp("ip");  //去获取 ip 地址
			
			session.setAttribute("sessionInfo", sessionInfo);
			j.setSuccess(true);
		}else{
			j.setSuccess(false);
		}
        return j;  
    } 
	
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public void logout(HttpSession session,HttpServletRequest request,HttpServletResponse response,String name) {
		if (session != null) {
	        session.removeAttribute("sessionInfo");
			session.invalidate();
		}
		try {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/user/gogo");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
