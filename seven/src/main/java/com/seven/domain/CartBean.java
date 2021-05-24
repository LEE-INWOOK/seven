package com.seven.domain;

import java.sql.Timestamp;

public class CartBean {
	
	private Timestamp cart_date;
	private int cart_count;
	private String member_id;
	private int product_num;
	private float product_price;
	private String product_title;
	private String  product_image;
	private String  product_color;
	private String  product_size;
	
	
	
	
	

	
	
	
	public String getProduct_image() {
		return product_image;
	}
	public String getProduct_color() {
		return product_color;
	}
	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}
	public String getProduct_size() {
		return product_size;
	}
	public void setProduct_size(String product_size) {
		this.product_size = product_size;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public float getProduct_price() {
		return product_price;
	}
	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
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
