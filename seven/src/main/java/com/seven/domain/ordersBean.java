package com.seven.domain;

import java.sql.Timestamp;

public class ordersBean {
	
	private int orders_num;
	private Timestamp orders_date;
	private String orders_address;
	private String orders_status;
	private int orders_int;
	private String member_member_id;
	private int product_product_num;
	
	public int getOrders_num() {
		return orders_num;
	}
	public Timestamp getOrders_date() {
		return orders_date;
	}
	public String getOrders_address() {
		return orders_address;
	}
	public String getOrders_status() {
		return orders_status;
	}
	public int getOrders_int() {
		return orders_int;
	}
	public String getMember_member_id() {
		return member_member_id;
	}
	public int getProduct_product_num() {
		return product_product_num;
	}
	public void setOrders_num(int orders_num) {
		this.orders_num = orders_num;
	}
	public void setOrders_date(Timestamp orders_date) {
		this.orders_date = orders_date;
	}
	public void setOrders_address(String orders_address) {
		this.orders_address = orders_address;
	}
	public void setOrders_status(String orders_status) {
		this.orders_status = orders_status;
	}
	public void setOrders_int(int orders_int) {
		this.orders_int = orders_int;
	}
	public void setMember_member_id(String member_member_id) {
		this.member_member_id = member_member_id;
	}
	public void setProduct_product_num(int product_product_num) {
		this.product_product_num = product_product_num;
	}
	

}
