package com.jy.s4.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cookie/**")
public class CookieController {
	
	@GetMapping("showCookie")
	public void showCookie(@CookieValue(value="name", required=false) Cookie cookie)throws Exception{
//		Cookie [] cookies = request.getCookies();
//		for(Cookie cookie: cookies) {
//			System.out.println(cookie.getName());
//			System.out.println(cookie.getValue());
//			System.out.println("-------------------");
//		}
		
		System.out.println(cookie.getName());
		System.out.println(cookie.getValue());
	
	}
	
	@GetMapping("makeCookie")
	public ModelAndView makeCookie(HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("make Cookie");
		
		Cookie cookie= new Cookie("name", "jin");
		cookie.setMaxAge(60);
		response.addCookie(cookie); //응답이 나갈때 쿠키를 추가해서 같이가라는의미
		
		return mv;
	}
}
