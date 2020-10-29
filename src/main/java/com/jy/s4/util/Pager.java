package com.jy.s4.util;

import java.util.List;

public class Pager {
	
	//**** 검색 ****
	private String kind;
	private String search;
	
	private Integer curPage;
	
	private int startRow;
	private int lastRow;
	
	private int perPage;  //한페이지당 글 몇개씩 보여줄건지 : 10개
	
	//JSP에서 사용할 변수들
	private long startNum;
	private long lastNum;
	private boolean beforeCheck;
	private boolean nextCheck;
	
	private long totalCount;
	
	public Pager() {
		this.perPage = 10;
	}
	
	//startRow, lastRow 계산하는 메서드
	public void makeRow() {

		//startRow
		startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		
		//lastRow
		lastRow = this.getCurPage()*this.getPerPage();
		
	}
	
	//******************페이징 계산 *************************
	public void makePage() {
		//1. 전체 글의 갯수 : dao메서드 호출해서 가져옴. service- totalCount - setter로 저장 
		//getTotalCount가 0 이 아니게 조건문 걸어주기
		
		//2. 전체 페이지의 갯수
		long totalPage = this.getTotalCount()/10;  //109면은 몫이 10이나옴,but 11이 필요
		if(this.getTotalCount()%10 != 0) { //101-109번의 공통점: 나머지가 0이 아님!
					totalPage++;
				}
		
		//3. 전체 블럭수 구하기 
				long totalBlock = totalPage/5;
				if(totalPage%5 != 0) {
					totalBlock++;
				}
				
		//4. curPage 를 이용해서 현재 블럭 번호 찾기 ex) 7이면 2번 블록(6-10), 어느블록인지를 찾아야함
			long curBlock = this.getCurPage()/5;  //null이 나올수도 있어서 this로 바꿔주는것.
			if(this.getCurPage()%5 != 0) {
				curBlock++;
			}		
			
		//5. 현재 블록번호로 start/last 번호 찾기
			this.startNum = (curBlock-1)*5+1;
			this.lastNum = curBlock * 5;	
			
			//6.현재 블록번호와 전체 블록번호가 같은지 결정
			this.nextCheck = true;
			if(curBlock == totalBlock) { //총 필요한 블럭중 마지막 블럭에 있으면 [다음]이 안나오게하려고함.
				nextCheck = !nextCheck;
				lastNum = totalPage; //if(마지막 블록)이라면, lastNum을 마지막 페이지로 설정
			}
			
			this.beforeCheck = true;
			if(curBlock == 1) {
				beforeCheck = !beforeCheck;
			}	
			//jsp페이지로 보내줘야함 :startNum, lastNum, nextCheck, beforeCheck > 멤버변수로 셋팅
	}
	
	
	
	//**********getter / setter ***************
	
	
	public long getTotalCount() {
		if(this.totalCount == 0) {
			this.totalCount = 1;
		}
		return totalCount;
	}
	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getCurPage() {
		if(curPage == null) {
			curPage=1;
		}
		return curPage;
	}


	public void setCurPage(Integer curPage) {
		if(curPage == null) {
			curPage=1;
		}
		this.curPage = curPage;
	}


	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}
	public String getKind() { //컬럼명
		if(kind==null) { //컬럼명이 안넘어온다면
			kind="tt"; //title값을 넘겨줌
		}
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(search == null) { //아무것도 안넘어오면 null이 발생
			search=""; //빈문자열을 넘겨줌 = 모든게 다 검색
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}

	public long getStartNum() {
		return startNum;
	}

	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}

	public long getLastNum() {
		return lastNum;
	}

	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isBeforeCheck() {
		return beforeCheck;
	}

	public void setBeforeCheck(boolean beforeCheck) {
		this.beforeCheck = beforeCheck;
	}

	public boolean isNextCheck() {
		return nextCheck;
	}

	public void setNextCheck(boolean nextCheck) {
		this.nextCheck = nextCheck;
	}
	
	
	
}
