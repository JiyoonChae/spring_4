package com.jy.s4.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class QnaMemberInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 로그인이 되어있는지 없는지 확인
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");  //로그인 정보 가져옴,,
		
		boolean check = false;
		if(obj !=null) {
			check = true;
		}
		
		return check;
	}
}
