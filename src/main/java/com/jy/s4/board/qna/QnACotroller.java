package com.jy.s4.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jy.s4.board.BoardDTO;
import com.jy.s4.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnACotroller {
	@Autowired
	private QnAService qnaService;
	
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(BoardDTO boardDTO) throws Exception {
			ModelAndView mv = new ModelAndView();
		int result = qnaService.setInsert(boardDTO);
		
		String message = "Write fail";
		if(result>0) {
			message = "Wrtie success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		
		mv.setViewName("common/result");
	
		return mv;
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		mv.addObject("board", "qna");
		return mv;
	}
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		BoardDTO boardDTO = ar.get(0); // 이거뭐임??
		QnADTO qnaDTO = (QnADTO)boardDTO;
		System.out.println(qnaDTO.getDepth());
		//EL은 타입을 추측해줌.
		
		mv.addObject("list", ar);
		mv.addObject("board", "qna");
		mv.addObject("pager", pager);
		System.out.println("qna list");
		mv.setViewName("board/boardList");
		return mv;
	}
}
