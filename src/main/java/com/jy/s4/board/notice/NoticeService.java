package com.jy.s4.board.notice;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jy.s4.board.BoardDTO;
import com.jy.s4.board.BoardService;
import com.jy.s4.util.FileSaver;
import com.jy.s4.util.Pager;

@Service
public class NoticeService implements BoardService {
		@Autowired
		private NoticeDAO noticeDAO;
		@Autowired
		private FileSaver fileSaver;
		
	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile files, HttpSession session) throws Exception {
		
		String path = session.getServletContext().getRealPath("/resources/upload/notice/");
		System.out.println(path);
		File file = new File(path);
		
		fileSaver.saveCopy(file, files);
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
		
		return 0; //noticeDAO.setInsert(boardDTO);
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
