package com.jy.s4.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jy.s4.board.BoardDTO;
import com.jy.s4.board.file.BoardFileDTO;
import com.jy.s4.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnACotroller {
	@Autowired
	private QnAService qnaService;
	
	@PostMapping("summernoteDelete")
	public ModelAndView summernoteDelete(String file, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		boolean result = qnaService.summernoteDelete(file, session);
		mv.addObject("msg", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	
	@PostMapping("summernote")
	public ModelAndView summernote(MultipartFile file, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		String fileName = qnaService.summernote(file, session);
		System.out.println(fileName);
		
		String name= session.getServletContext().getContextPath()+File.separator; 
		name = name+"resources"+File.separator+"upload"+File.separator;
		name = name+"qna"+File.separator+fileName;
		System.out.println(name);
		
		
		mv.addObject("msg", name);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	
	@GetMapping("fileDown")
	public ModelAndView fileDown(BoardFileDTO boardfileDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
	
		mv.addObject("board", "qna");
		mv.addObject("fileDTO", boardfileDTO);
		mv.setViewName("fileDown");
		
		return mv;
	}
	
	@PostMapping("qnaUpdate")
	public ModelAndView setUpdate2(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setUpdate(boardDTO);
		if(result>0) {
			mv.addObject("msg", "update success");
			mv.addObject("path", "./qnaList");
		}else {
			mv.addObject("msg", "update fail");
			mv.addObject("path", "./qnaUpdate");
		}
		
		mv.setViewName("common/result");
		
		 return mv;
	}
	
	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getOne(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/boardUpdate");
		mv.addObject("board", "qna");
		
		
		return mv;
	}
	
	@RequestMapping("qnaDelete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setDelete(boardDTO);
		
		String message = "Delete Fail";
		if(result >0) {
			message ="Delete Success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	//@RequestMapping(value="qnaReply", method=RequestMethod.POST)
	@PostMapping("qnaReply")
	public ModelAndView setReply(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setReply(boardDTO);
		
		String message = "reply write fail";
		
		if(result >0) {
			message = "reply write success";
			
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("qnaReply")
	public ModelAndView setReply() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardReply");
		mv.addObject("board", "qna");
		
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getOne(BoardDTO boardDTO) throws Exception {
		boardDTO = qnaService.getOne(boardDTO);
		
		ModelAndView mv = new ModelAndView();
		
		if(boardDTO != null ) {
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/boardSelect");
		mv.addObject("board", "qna");
		}else {
			mv.setViewName("common/result");
			mv.addObject("msg", "no data");
			mv.addObject("path", "./qnaList");
			
		}
		return mv;
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
			ModelAndView mv = new ModelAndView();
		int result = qnaService.setInsert(boardDTO, files, session);
		
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
		
		//ar=null;
		BoardDTO boardDTO = ar.get(0); // 이거뭐임??
		QnADTO qnaDTO = (QnADTO)boardDTO;
		
		//EL은 타입을 추측해줌.
		
		mv.addObject("list", ar);
		mv.addObject("board", "qna");
		mv.addObject("pager", pager);
		System.out.println("qna list");
		mv.setViewName("board/boardList");
		return mv;
	}
	
	
}
