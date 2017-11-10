package com.dute.zl.util;

import java.util.Hashtable;

import com.dute.zl.model.UserSession;

/**
 * @title 用ThreadLocal提供一个存储线程内变量的地方.
 * @desc  每一个线程将创建一个独立的线程对象，绑定当前用户信息到当前线程
 * 		  WEB请求中，每次发送的HttpRequest都会创建一个独立的线程对象，
 * 		  故而需要对每次请求进行系统过虑，将HttpSession中存储的UserSession对象绑定到该请求线程当中。
 * 		  绑定的目的是为了系统中可以方便的获取用户登录信息，而不依赖于HttpSession
 * @author zl
 * @date 2017-11-19
 */
public class SystemSessionUtil {
	private static ThreadLocal<UserSession> local = new ThreadLocal<UserSession>();   
	// 集合对象，保存session对象的引用
	static Hashtable<String, UserSession> usersOnline = new Hashtable<String, UserSession>();
  
    /**
     * 为当前线程绑定UserSession对象
     * @param session
     */
    public static void setUserSession(UserSession session) {   
    	local.set(session);   
    }   
  
    /**
     * 从当前线程中获取当前线程中绑定的UserSession对象
     * @return
     */
    public static UserSession getUserSession() {   
    	return local.get();
    }   
    
    /**
     * 从当前线程中移除对象
     */
    public static void clear(){   
    	local.remove();   
	}
    
    
    public static void setUsersOnline(Hashtable<String, UserSession> usersOnline){
    	SystemSessionUtil.usersOnline = usersOnline;
    }
    
    /**
	 * 获取在线用户列表
	 * 
	 * @return
	 */
	public static Hashtable<String, UserSession> getUsersOnline() {
		return usersOnline;
	}
}
