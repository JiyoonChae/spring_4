package com.jy.s3.member.memberFile;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jy.s4.MyTestCase;
import com.jy.s4.member.memberFile.MemberFileDAO;
import com.jy.s4.member.memberFile.MemberFileDTO;

public class MemberFileDAOTest extends MyTestCase{
	@Autowired
	private MemberFileDAO memberFileDAO;
	@Test(expected = RuntimeException.class)
	public void setInsertTest()throws Exception {
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId("id2");
		memberFileDTO.setFileName("filename");
		memberFileDTO.setOriName("oriname");
		int result = memberFileDAO.setInsert(memberFileDTO);
		
		assertEquals(1, result);
	}

}
