package com.jy.s4.memo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jy.s4.MyTestCase;
import com.jy.s4.board.memo.MemoDAO;
import com.jy.s4.board.memo.MemoDTO;
import com.jy.s4.util.Pager;

public class memoDAOTest extends MyTestCase {
	@Autowired
	private MemoDAO memoDAO;
	
	//@Test
	public void getListTest() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		List<MemoDTO> ar= memoDAO.getList(pager);
	
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void setInsertTest() throws Exception {
		for(int i =0; i<100; i++) {
			MemoDTO memoDTO = new MemoDTO();
			memoDTO.setContents("contents"+i);
			memoDTO.setWriter("writer"+i);
			memoDAO.setInsert(memoDTO);
			
			if(i%10 ==0) {
				Thread.sleep(1000);
			}
		}
		System.out.println("insert finish");
	}

}
