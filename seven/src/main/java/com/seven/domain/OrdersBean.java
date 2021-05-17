package com.seven.domain;

import java.sql.Timestamp;

//mysql> desc orders;
//+----------------+--------------+------+-----+---------+-------+
//| Field          | Type         | Null | Key | Default | Extra |
//+----------------+--------------+------+-----+---------+-------+
//| orders_num     | int(11)      | NO   | PRI | NULL    |       |
//| orders_date    | datetime     | YES  |     | NULL    |       |
//| orders_address | varchar(200) | YES  |     | NULL    |       |
//| orders_status  | varchar(45)  | YES  |     | NULL    |       |
//| orders_count   | int(11)      | YES  |     | NULL    |       |
//| member_id      | varchar(45)  | NO   | MUL | NULL    |       |
//| product_num    | int(11)      | NO   | MUL | NULL    |       |
//+----------------+--------------+------+-----+---------+-------+

public class OrdersBean {
	
	private int orders_num;
	private Timestamp orders_date;
	private String orders_address;
	private String orders_status;
	private int orders_count;
	private String member_id;
	private int product_num;
	
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
	public int getOrders_count() {
		return orders_count;
	}
	public String getMember_id() {
		return member_id;
	}
	public int getProduct_num() {
		return product_num;
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
	public void setOrders_count(int orders_count) {
		this.orders_count = orders_count;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}


}
