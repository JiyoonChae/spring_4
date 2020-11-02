package com.jy.s4.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jy.s4.board.BoardDAO;
import com.jy.s4.board.BoardDTO;
import com.jy.s4.board.BoardService;
import com.jy.s4.board.file.BoardFileDTO;
import com.jy.s4.util.FileSaver;
import com.jy.s4.util.Pager;
@Service
public class QnAService implements BoardService{
	@Autowired
	private QnADAO qnaDAO;
	@Autowired
	private FileSaver fileSaver;
	
	//여기가 더 짧은 대신 쿼리문이 길어졌음.. 두개중 속도가 빠른거 선택하면됨.
	//이방법이 더 맥락이있긴함. db컴이 따로있으니까 일을 분산시키는게 좋음.
	public int setReply(BoardDTO boardDTO) throws Exception{
		int result = qnaDAO.setReplyUpdate(boardDTO);
		result = qnaDAO.setReply(boardDTO);
		return result;
	}
	
	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		String path = session.getServletContext().getRealPath("/resources/upload/qna");
		File file = new File(path);
		
		//qna table에 저장
		int result = qnaDAO.setInsert(boardDTO);  //글번호 생성.
		
		//qna file을 file table에 저장
		for(MultipartFile multipartFile: files) {
			if(multipartFile.getSize() !=0) {
				String fileName = fileSaver.saveCopy(file, multipartFile);
				System.out.println(fileName);
				BoardFileDTO boardfileDTO = new BoardFileDTO();
				boardfileDTO.setFileName(fileName);
				boardfileDTO.setOriName(multipartFile.getOriginalFilename());
				boardfileDTO.setNum(boardDTO.getNum());
				qnaDAO.setInsertFile(boardfileDTO);
			
			}
		}
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setDelete(boardDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(qnaDAO.getCount(pager));
		pager.makePage();
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getOne(boardDTO);
	}

	@Override
	public long getCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
