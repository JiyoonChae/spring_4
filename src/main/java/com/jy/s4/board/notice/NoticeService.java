package com.jy.s4.board.notice;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jy.s4.board.BoardDTO;
import com.jy.s4.board.BoardService;
import com.jy.s4.board.file.BoardFileDTO;
import com.jy.s4.util.FileSaver;
import com.jy.s4.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class NoticeService implements BoardService {
		@Autowired
		private NoticeDAO noticeDAO;
		@Autowired
		private FileSaver fileSaver;
		@Value("#{fileSave['notice']}")
		private String filePath;
		
		public boolean summernoteDelete(String file, HttpSession session) throws Exception{
			String path = session.getServletContext().getRealPath("resources/upload/notice");
			File file2 = new File(path, file);
			boolean result = false;
			if(file2.exists()) {
				result = file2.delete();
			}
			return result;
		}
		
		public String summernote(MultipartFile file, HttpSession session) throws Exception{
			String path = session.getServletContext().getRealPath("/resources/upload/notice");
			File file2 = new File(path);
			
			String fileName = fileSaver.saveCopy(file2, file);
			
			return fileName;
		
		}
		
	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		
		String path = session.getServletContext().getRealPath(filePath);
		System.out.println(path);
		File file = new File(path);
		
		//--sequence 받아오기
//		boardDTO.setNum(noticeDAO.getNum());
		
		//Notice Insert
		int result = noticeDAO.setInsert(boardDTO);
		System.out.println("num:"+boardDTO.getNum());
		
		//NoticeFile Insert 
		//배열이라서 fileSaver못쓰는줄 알았는데 여기서 하나씩 꺼내서 보내는거 가능,,
		for(MultipartFile multipartFile:files) {
			if(multipartFile.getSize() !=0) {
			String fileName = fileSaver.saveCopy(file, multipartFile);
			System.out.println(fileName);
			BoardFileDTO boardfileDTO = new BoardFileDTO();
			boardfileDTO.setFileName(fileName);
			boardfileDTO.setOriName(multipartFile.getOriginalFilename());
			boardfileDTO.setNum(boardDTO.getNum());
			
			noticeDAO.setInsertFile(boardfileDTO);
			}
		}
		
		
		//fileSaver.saveTransfer(file, files);
		
//		String fileName= UUID.randomUUID().toString();
//		for(int i=0; i<files.length; i++) {
//			fileName = fileName+"-"+files[i].getOriginalFilename();
//			file = new File(file, fileName);
//			files[i].transferTo(file);
//		}
		
		
		//dao로 insert할 때 저장된 파일명을 가지고 와야함. 
//		Calendar ca = Calendar.getInstance();
//		long time = ca.getTimeInMillis();
//		System.out.println(files);
//		String name = files.getOriginalFilename();
//		name= time+"_"+name;
//		System.out.println(name);
//		File file = new File(path, name);
//		
//		byte[] ar = files.getBytes();
//		FileCopyUtils.copy(ar, file);
		
		return result; //noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		 System.out.println(boardDTO.getNum());
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(noticeDAO.getCount(pager));
		pager.makePage();
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getOne(boardDTO);
	}

	@Override
	public long getCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
