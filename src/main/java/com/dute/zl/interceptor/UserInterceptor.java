package com.dute.zl.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dute.zl.model.UserSession;
import com.dute.zl.util.SystemSessionUtil;


public class UserInterceptor implements HandlerInterceptor {
	
	private List<String> excludeUrls; // 不需要拦截的资源
	
	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	
	/**
	 * 在controller后拦截
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("拦截器:在controller后拦截");
		
	}
	
	/**
	 * 在调用controller具体方法后拦截
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("在调用controller具体方法后拦截");
		
	}
	
	/**
	 * 在调用controller具体方法前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String requestPath = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestPath.substring(contextPath.length());
		
		HttpSession session = request.getSession();
		UserSession sessionInfo = (UserSession) session.getAttribute("sessionInfo");
		if(url.equals("/")){
			response.sendRedirect(contextPath + "/user/gogo");  //重定向
			return true;
		}
		
		if(excludeUrls.contains(url)){
			SystemSessionUtil.setUserSession(sessionInfo);
			return true;
		}
		
		if(sessionInfo == null || sessionInfo.getIp().equals("") || sessionInfo.getIp() == null){
//			request.getRequestDispatcher("/pages/system/noSession.jsp").forward(request, response);
			response.sendRedirect(contextPath + "/user/gogo");  //重定向
			return false;
		}else{
			SystemSessionUtil.setUserSession(sessionInfo);
		}
		
		return true;
	}

}
