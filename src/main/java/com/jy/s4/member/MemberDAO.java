package com.jy.s4.member;

public interface MemberDAO {
	
	//join
	public int setMemberJoin(MemberDTO memberDTO) throws Exception;
	
	//LOGIN
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception;
	
	//update
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception;

	//DELETE
	public int setMemberDelete(MemberDTO memberDTO) throws Exception;
	
}
