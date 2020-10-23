package com.jy.s4.member.memberUser;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jy.s4.member.MemberDTO;
import com.jy.s4.member.MemberService;
@Service
public class MemberUserService implements MemberService {
	@Autowired
	private MemberUserDAO memberUserDAO;
	
	@Override
	public int setMemberJoin(MemberDTO memberDTO) throws Exception {
		
		return memberUserDAO.setMemberJoin(memberDTO);
	}
	
	@Override
	public int setMemberDelete(MemberDTO memberDTO) throws Exception {
		
		return memberUserDAO.setMemberDelete(memberDTO);
	}
	
	@Override
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		return memberUserDAO.setMemberUpdate(memberDTO);
	}
	
	@Override
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.getMemberLogin(memberDTO);
		
	}
	
}
