package com.jy.s4.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileSaver {
		//.MultipartFile 객체의 transferTo메서드 활용
		public String saveTransfer(File dest, MultipartFile files) throws Exception{
			//File 객체를 통해 경로명path를 받음. 
			//받은 경로명이 존재하지 않을 수도 있어서 조건문 걸어줌.
			//존재하지않다면, 그 경로에 만들어주게함. mkdirs()
			if(!dest.exists()) {
				dest.mkdirs();
			}
			
			//저장할 이름 -중복되지않게 unique한 이름 생성 객체 사용.
			String fileName = UUID.randomUUID().toString();
			//파일 형식.jpge이런거 붙여주기위해 오리지널 파일명이 필요, 파일명을 가져오기위해 MultipartFile 매개변수 추가.
			fileName = fileName+"_"+files.getOriginalFilename();
			
			//hdd 저장 방식
			dest = new File(dest, fileName);
			files.transferTo(dest);
			
			return fileName;
		}
	

		//FilecopyUtil.copy 사용
		public String saveCopy(File dest, MultipartFile files) throws Exception {
			if(!dest.exists()) {
				dest.mkdirs();
			}
			
			//저장할 이름
			String fileName = UUID.randomUUID().toString();
			fileName = fileName+"_"+files.getOriginalFilename();
			
			//hdd 에 파일 저장 
			dest = new File(dest, fileName);
			FileCopyUtils.copy(files.getBytes(), dest);
			//(왼쪽에있는 파일을 오른쪽에 저장하겠다)
			//올릴땐 바이트(0,1)로 올려야함.getBytes()
			return fileName;
			
		}
}
