package com.seven.domain;

import java.sql.Timestamp;

public class CartBean {
	
	private Timestamp cart_date;
	private int cart_count;
	private int product_product_num;
	private String member_member_id;
	
	public Timestamp getCart_date() {
		return cart_date;
	}
	public int getCart_count() {
		return cart_count;
	}
	public int getProduct_product_num() {
		return product_product_num;
	}
	public String getMember_member_id() {
		return member_member_id;
	}
	public void setCart_date(Timestamp cart_date) {
		this.cart_date = cart_date;
	}
	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}
	public void setProduct_product_num(int product_product_num) {
		this.product_product_num = product_product_num;
	}
	public void setMember_member_id(String member_member_id) {
		this.member_member_id = member_member_id;
	}
	

}
