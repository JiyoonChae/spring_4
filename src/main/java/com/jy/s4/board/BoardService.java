package com.jy.s4.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.jy.s4.util.FileSaver;
import com.jy.s4.util.Pager;

public interface BoardService {
	//insert - abstract안써주면 자동입력됨..
		public int setInsert(BoardDTO boardDTO, MultipartFile photo, HttpSession session) throws Exception;
		
		//update
		public int setUpdate(BoardDTO boardDTO) throws Exception;
		
		//delete
		public int setDelete(BoardDTO boardDTO) throws Exception;
		
		//list
		public List<BoardDTO> getList(Pager pager) throws Exception;
		
		//selectOne
		public BoardDTO getOne(BoardDTO boardDTO) throws Exception;
		
		//count 
		public long getCount(Pager pager)throws Exception;
}
