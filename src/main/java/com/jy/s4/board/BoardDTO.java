package com.jy.s4.board;

import java.sql.Date;
import java.util.List;

import com.jy.s4.board.file.BoardFileDTO;

public class BoardDTO {
	private long num;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private long hit;
	
	List<BoardFileDTO> boardfileDTOs;
	
	

	public List<BoardFileDTO> getBoardfileDTOs() {
		return boardfileDTOs;
	}
	public void setBoardfileDTOs(List<BoardFileDTO> boardfileDTOs) {
		this.boardfileDTOs = boardfileDTOs;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public long getHit() {
		return hit;
	}
	public void setHit(long hit) {
		this.hit = hit;
	}
	
	
}
