package com.jy.s4.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class QnaInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//controller 집입 전에 실행됨. DS - CONTROLLER 사이에서 들어갈때 
		System.out.println("controller 집입 전");
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// Controller에서 나갈 때 실행됨. DS - CONTROLLER 사이에서 나갈때
		System.out.println("controller 진입 후");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// JSP (VIEW)만든 후 RESPONSE로 나가기 전 
		System.out.println("jsp 렌더링 후");
		super.afterCompletion(request, response, handler, ex);
	}


}
