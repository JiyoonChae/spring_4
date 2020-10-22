package com.jy.s4.board;

import java.util.List;

import com.jy.s4.util.Pager;

public interface BoardDAO {
	//추상메서드 abstract, 메서드의 선언부까지만
	
	//DAO 공통기능 
	//insert - abstract안써주면 자동입력됨..
	public abstract int setInsert(BoardDTO boardDTO) throws Exception;
	
	//update
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	//list
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//selectOne
	public BoardDTO getOne(BoardDTO boardDTO) throws Exception;
	
	//count 
	public long getCount(Pager pager)throws Exception;
}
