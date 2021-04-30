package com.seven.domain;

import java.sql.Timestamp;

public class review_boardBean {
	
	private int review_board_num;
	private String review_board_title;
	private String review_board_content;
	private int review_board_score;
	private Timestamp review_board_date;
	private String review_board_image;
	private String member_member_id;
	private int product_product_num;
	public int getReview_board_num() {
		return review_board_num;
	}
	public String getReview_board_title() {
		return review_board_title;
	}
	public String getReview_board_content() {
		return review_board_content;
	}
	public int getReview_board_score() {
		return review_board_score;
	}
	public Timestamp getReview_board_date() {
		return review_board_date;
	}
	public String getReview_board_image() {
		return review_board_image;
	}
	public String getMember_member_id() {
		return member_member_id;
	}
	public int getProduct_product_num() {
		return product_product_num;
	}
	public void setReview_board_num(int review_board_num) {
		this.review_board_num = review_board_num;
	}
	public void setReview_board_title(String review_board_title) {
		this.review_board_title = review_board_title;
	}
	public void setReview_board_content(String review_board_content) {
		this.review_board_content = review_board_content;
	}
	public void setReview_board_score(int review_board_score) {
		this.review_board_score = review_board_score;
	}
	public void setReview_board_date(Timestamp review_board_date) {
		this.review_board_date = review_board_date;
	}
	public void setReview_board_image(String review_board_image) {
		this.review_board_image = review_board_image;
	}
	public void setMember_member_id(String member_member_id) {
		this.member_member_id = member_member_id;
	}
	public void setProduct_product_num(int product_product_num) {
		this.product_product_num = product_product_num;
	}
	
	
	
	

}
