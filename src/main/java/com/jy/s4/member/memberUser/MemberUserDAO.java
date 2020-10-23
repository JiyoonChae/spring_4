package com.jy.s4.member.memberUser;

import javax.servlet.http.HttpSession;

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
	public int setMemberJoin(MemberDTO memberDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setMemberJoin", memberDTO);
	}
	
	@Override
	public int setMemberDelete(MemberDTO memberDTO) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"setMemberDelete", memberDTO);
	}
	
	@Override
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setMemberUpdate", memberDTO);
	}
	
	@Override
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getMemberLogin", memberDTO);
	}
	
}
