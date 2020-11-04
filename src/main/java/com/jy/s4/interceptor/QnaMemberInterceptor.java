package com.jy.s4.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jy.s4.member.MemberDTO;

@Component
public class QnaMemberInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		//파라미터 못바꾸게 해야함,, 작성자와 같은 번호일 때 수정할 수 있게 하기.보안
		
		
		
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 로그인이 되어있는지 없는지 확인
		System.out.println("qnaMember interceptor");
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");  //로그인 정보 가져옴,,
		
		boolean check = false;
		if(obj !=null) {
			check = true;
		}else {
		 response.sendRedirect("../member/memberLogin");
		}
		 
		 return check;
	}
}
