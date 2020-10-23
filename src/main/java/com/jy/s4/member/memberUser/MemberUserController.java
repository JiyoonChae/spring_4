package com.jy.s4.member.memberUser;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jy.s4.member.MemberDTO;

@Controller
@RequestMapping(value="/member/**")
public class MemberUserController {
	@Autowired
	private MemberUserService memberUserService;
	
	@GetMapping("memberLogout")
	public ModelAndView getMemberLogout(HttpSession session) throws Exception{
		//웹브라우저를 종료시키거나 memberDTO를 NULL 로 바꿈.
		//OR 일정시간이 경과(로그인 후에 요청이 발생하면 시간 연장) 
		//유지시간을 강제로 0으로 변경 - 시간이 종료 
		session.invalidate();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	//jsp 이동, getMemberLogin
	@GetMapping("memberLogin")
	public ModelAndView getMemberLogin() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("member/memberLogin");
		
		return mv;
	}
	
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberDTO = memberUserService.getMemberLogin(memberDTO);
		
			String message = "Login Fail";
			if(memberDTO != null) {
				//login성공 ->index 페이지 이동
				//redirect
				session.setAttribute("member", memberDTO);
			//	mv.addObject("member", memberDTO); 이건 요청끝나면 사라지니까 session을 이용해서 더 오래 정보가 전달되게함.
				mv.setViewName("redirect:../");
			}else {
				//login fail 메시지 alert창 띄우고 다시 폼으로 보내기
				mv.addObject("msg", message);
				mv.addObject("path", "./memberLogin");
				mv.setViewName("common/result");
			}
			
		return mv;
	}
}
