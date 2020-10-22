package com.jy.s4.board.qna;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jy.s4.MyTestCase;
import com.jy.s4.board.BoardDTO;

public class QnaDAOTest extends MyTestCase {
	@Autowired
	private QnADAO qnaDAO;
	@Test
	public void QnaDAOTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("title test");
		boardDTO.setWriter("writer test");
		boardDTO.setContents("contents test");
		int result = qnaDAO.setInsert(boardDTO);
		
		assertEquals(1, result);
	}
}

