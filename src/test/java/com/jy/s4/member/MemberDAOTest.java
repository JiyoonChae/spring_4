package com.jy.s4.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jy.s4.MyTestCase;
import com.jy.s4.member.memberUser.MemberUserDAO;

public class MemberDAOTest extends MyTestCase {
	@Autowired
	private MemberUserDAO memberUserDAO;
	
	//@Test
	public void memberDAOtest() throws Exception {
		MemberDTO mdto = new MemberDTO();
		mdto.setId("id1");
		mdto.setPw("pw199");
		
		mdto = memberUserDAO.getMemberLogin(mdto);
		
		assertNotNull(mdto);
	}

}
