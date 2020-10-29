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
			if(!dest.exists()) {
				dest.mkdirs();
			}
			
			//저장할 이름
			String fileName = UUID.randomUUID().toString();
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
			
			return fileName;
			
		}
}
