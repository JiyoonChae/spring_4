package com.jy.s4.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jy.s4.MyTestCase;
import com.jy.s4.board.BoardDTO;
import com.jy.s4.board.file.BoardFileDTO;
import com.jy.s4.util.Pager;


public class NoticeDAOTest extends MyTestCase {
	@Autowired
	private NoticeDAO noticeDAO;
	@Test
	public void setInsertFileTest() throws Exception{
		BoardFileDTO boardfileDTO = new BoardFileDTO();
		boardfileDTO.setFileName("test file name");
		boardfileDTO.setNum(5);
		int result = noticeDAO.setInsertFile(boardfileDTO);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void getListTest() throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardDTO> ar = noticeDAO.getList(pager);
		
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void setInsertTest() throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("title test");
		boardDTO.setWriter("writer test");
		boardDTO.setContents("contents test");
		int result = noticeDAO.setInsert(boardDTO);
		
		assertEquals(1, result);
	}
	
	
}
