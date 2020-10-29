package com.jy.s4.member.memberUser;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jy.s4.member.MemberDTO;
import com.jy.s4.member.MemberService;
import com.jy.s4.member.memberFile.MemberFileDAO;
import com.jy.s4.member.memberFile.MemberFileDTO;
import com.jy.s4.util.FileSaver;
@Service
public class MemberUserService implements MemberService {
	@Autowired
	private MemberUserDAO memberUserDAO;
	@Autowired
	private MemberFileDAO memberFileDAO;
	@Autowired
	private FileSaver fileSaver;
	
//	public MemberFileDTO getOne(MemberDTO memberDTO) throws Exception{
//		return memberFileDAO.getOne(memberDTO);
//	}
	
	public MemberDTO checkMemberId(MemberDTO memberDTO) throws Exception{
		return memberUserDAO.checkMemberId(memberDTO);
	}
	
	@Override
	public int setMemberJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception {
		//hdd 폴더에, 이름
		//경로쓰기,, 경로정리해..
		String path = session.getServletContext().getRealPath("/resources/upload/member/");
		System.out.println(path);
		File file = new File(path);
		String fileName ="";
		
		
		
		int result = memberUserDAO.setMemberJoin(memberDTO);
		if(photo.getSize() != 0) {
			fileName = fileSaver.saveCopy(file, photo);
			//memberFile Insert
			MemberFileDTO memberFileDTO = new MemberFileDTO();
			memberFileDTO.setId(memberDTO.getId());
			memberFileDTO.setFileName(fileName);
			memberFileDTO.setOriName(photo.getOriginalFilename());
			
			result = memberFileDAO.setInsert(memberFileDTO);
		}
		
		//파일이름
		//1. 시간
//		Calendar ca = Calendar.getInstance();
//		long time = ca.getTimeInMillis();
//		String name = photo.getOriginalFilename();
	//	name = time+"_"+name;
	//	System.out.println(name);
		//2. unique한 이름을 생성하는 객체
//		name = UUID.randomUUID().toString();
//		name=name+"_"+photo.getOriginalFilename();
//		System.out.println(name);
//		
//		File file = new File(path, name);
//		
		//HDD저장
		//1.FileCopyUtils 라는 객체의 메서드 활용
		//byte[] ar = photo.getBytes();
 		//FileCopyUtils.copy(ar, file);
		
 		//2.MultipartFile 객체의 메서드 활용
// 		photo.transferTo(file);
		return result;
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
