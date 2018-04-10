package com.framework.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.framework.security.AllowAll;

public class ControllerInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (super.preHandle(request, response, handler)) {
			if (handler instanceof HandlerMethod) {
				Method method = ((HandlerMethod) handler).getMethod();
				
				if (method != null && !method.isAnnotationPresent(AllowAll.class)) {
					String name = (String) request.getSession().getAttribute("name");
					
					if (name != null) {
						return true;
					}
					
					System.out.println("跳转");
					request.getRequestDispatcher("/login.do").forward(request, response);  
				}
			}
			
			return true;
		} else {
			return false;
		}
		
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

}
