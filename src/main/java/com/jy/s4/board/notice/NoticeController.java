package com.jy.s4.board.notice;

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
@RequestMapping(value="/notice/**")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("noticeDelete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception {
		int result = noticeService.setDelete(boardDTO);
		
		ModelAndView mv = new ModelAndView();
		String message = "Delete fail";
		if(result>0) {
			message = "Delete success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		
		mv.setViewName("common/result");
	
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardDTO boardDTO) throws Exception {
		boardDTO = noticeService.getOne(boardDTO);
		ModelAndView mv = new ModelAndView();
		
		if(boardDTO != null ) {
			mv.addObject("dto", boardDTO);
			mv.setViewName("board/boardSelect");
			mv.addObject("board", "notice");
			}else {
				mv.setViewName("common/result");
				mv.addObject("msg", "no data");
				mv.addObject("path", "./noticeList");
				
			}
		
		return mv;
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView setInsert(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setInsert(boardDTO);
		
		String message = "Write fail";
		if(result>0) {
			message = "Wrtie success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		
		mv.setViewName("common/result");
	
		return mv;
	}
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
	
		mv.setViewName("board/boardWrite");
		mv.addObject("board", "notice");
		
		return mv;
	}
	
	@GetMapping(value="noticeList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		List<BoardDTO> ar = noticeService.getList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("board", "notice");
		mv.addObject("pager", pager);
		System.out.println("notice list");
		mv.setViewName("board/boardList");
		return mv;
	}
	
}
