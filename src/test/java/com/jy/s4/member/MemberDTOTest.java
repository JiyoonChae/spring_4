package com.jy.s4.member;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jy.s4.MyTestCase;

public class MemberDTOTest extends MyTestCase {

	@Test
	public void MemberDTOtest() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("nini");
		memberDTO.setName("NINA");
		memberDTO.setEmail("email");
		
	}

}
