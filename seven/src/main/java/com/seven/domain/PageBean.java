package com.seven.domain;

public class PageBean {

	private int pageSize;
	private String pageNum;
	private int currentPage;
	private int startRow;

	private int count;
	private int pageBlock;
	private int startPage;
	private int endPage;
	private int pageCount;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		
		init();
	}
	
	public void init() {
		pageBlock = 10;//한페이지 보여줄 페이지 개수 설정

		//현페이지번호 (currentPage)  한페이지 보여줄 페이지 개수(pageBlock) => startPage
		startPage = (currentPage - 1) / pageBlock * pageBlock + 1; //한페이지 시작하는 페이지 번호 구하기

		//startPage    pageBlock  => endPage
		endPage = startPage + pageBlock - 1;// 한페이지 끝나는 페이지 번호 구하기

		//전체글 개수 / pageSize  =>
		pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1); // 전체페이지수 구하기 

		//끝페이지번호   전체페이지수  비교 
		//10     >      5
		//끝페이지번호 대신에 전체페이지수 넣기
		//10 <= 5 변경
		if (endPage > pageCount) {
			endPage = pageCount;
		}
		
	}
	
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	
	
	
}
