package com.jy.s4.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jy.s4.board.BoardDTO;
import com.jy.s4.util.Pager;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@PostMapping("noticeUpdate")
	public ModelAndView setUpdate2(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("NOTICE POST UPDATE");
		mv.addObject("board", "notice");
		int result = noticeService.setUpdate(boardDTO);
		
		
		if(result>0) {
			mv.addObject("msg", "update success");
			mv.addObject("path", "./noticeList");
		}else {
			mv.addObject("msg", "update fail");
			mv.addObject("path", "./noticeUpdate");
		}
		
		mv.setViewName("common/result");
		
		return mv;
	
	}
	
	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception {
		System.out.println("notice get update");
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getOne(boardDTO);
	//	System.out.println(boardDTO.getNum());
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
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
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception {
		for(int i=0; i<files.length; i++) {
			System.out.println(files[i].getOriginalFilename());
		}
		
		
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setInsert(boardDTO, files, session);
		
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
	//	System.out.println("notice list");
		mv.setViewName("board/boardList");
		return mv;
	}
	
}
