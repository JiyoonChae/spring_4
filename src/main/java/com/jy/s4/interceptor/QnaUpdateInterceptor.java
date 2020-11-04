package com.jy.s4.interceptor;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jy.s4.board.BoardDTO;
import com.jy.s4.board.qna.QnADAO;
import com.jy.s4.member.MemberDTO;
@Component
public class QnaUpdateInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private QnADAO qnaDAO;
	
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			
			long num =Long.parseLong(request.getParameter("num"));
			
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setNum(num);
			boardDTO =  qnaDAO.getOne(boardDTO);
			
			//session
			HttpSession session = request.getSession();
			MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
			
					boolean check=false;
			if(boardDTO.getWriter().equals(memberDTO.getId())) {
				check=true;
			}else {
				request.setAttribute("msg", "작성자가 아님");
				request.setAttribute("path", "./");
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
				view.forward(request, response);
			}
			
					
			return check;
		}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// method형식
		String method = request.getMethod(); // get or post형식 들어가있음.
		if(method.equals("POST")) {
			
			return ; // 이걸 만나면 그즉시 종료
		}
		
		// 로그인한 사용자 ID 꺼내기
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		String id = memberDTO.getId();
		
		//작성자 꺼내기 controller에서 dt 가기전
		Map<String, Object>model = modelAndView.getModel();
		BoardDTO boardDTO = (BoardDTO)model.get("dto");
		
		String writer = boardDTO.getWriter();
		String board = (String)model.get("board");
		if(!id.equals(writer)) {
			modelAndView.addObject("msg", "작성자가 아닙니다");
			modelAndView.addObject("path", board+"List");
			modelAndView.setViewName("common/result");
		}else {
			
		}
		
	}
}
