package com.seven.domain;

import java.sql.Timestamp;

public class CartBean {
	
	private Timestamp cart_date;
	private int cart_count;
	private String member_id;
	private int product_num;
	
	
	public Timestamp getCart_date() {
		return cart_date;
	}
	public int getCart_count() {
		return cart_count;
	}
	public String getMember_id() {
		return member_id;
	}
	public int getProduct_num() {
		return product_num;
	}
	public void setCart_date(Timestamp cart_date) {
		this.cart_date = cart_date;
	}
	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}
	
	
	

}
