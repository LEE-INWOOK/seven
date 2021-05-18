package com.seven.service;

import java.util.List;

import com.seven.domain.OrdersBean;
import com.seven.domain.ProductBean;

public interface OrdersService {

	List<OrdersBean> getOrderList(String member_id);
	List<OrdersBean> getPaymentinfo(OrdersBean orderBean);

	List<ProductBean> getProductOrderList(String member_id); 
	
}
