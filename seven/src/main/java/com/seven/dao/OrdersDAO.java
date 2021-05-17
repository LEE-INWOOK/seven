package com.seven.dao;

import java.util.List;

import com.seven.domain.OrdersBean;
import com.seven.domain.ProductBean;

public interface OrdersDAO {

	List<OrdersBean> getOrderList(String member_id);


	List<ProductBean> getProductOrderList(String member_id); 
	
	
}
