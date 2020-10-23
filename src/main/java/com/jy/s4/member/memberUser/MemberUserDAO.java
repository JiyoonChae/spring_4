package com.jy.s4.member.memberUser;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jy.s4.member.MemberDAO;
import com.jy.s4.member.MemberDTO;

@Repository
public class MemberUserDAO implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.jy.s4.member.memberUser.MemberUserDAO.";
	
	@Override
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getMemberLogin", memberDTO);
	}
	
}
