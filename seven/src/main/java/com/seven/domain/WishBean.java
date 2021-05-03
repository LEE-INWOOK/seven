package com.seven.domain;

import java.sql.Timestamp;

public class WishBean {
	
	private Timestamp wish_date;
	private int product_product_num;
	private String member_member_id;
	
	public Timestamp getWish_date() {
		return wish_date;
	}
	public int getProduct_product_num() {
		return product_product_num;
	}
	public String getMember_member_id() {
		return member_member_id;
	}
	public void setWish_date(Timestamp wish_date) {
		this.wish_date = wish_date;
	}
	public void setProduct_product_num(int product_product_num) {
		this.product_product_num = product_product_num;
	}
	public void setMember_member_id(String member_member_id) {
		this.member_member_id = member_member_id;
	}
	
	

}
