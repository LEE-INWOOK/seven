package com.seven.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.seven.dao.OrdersDAO;
import com.seven.domain.OrdersBean;
import com.seven.domain.ProductBean;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Inject
	private OrdersDAO orderDAO;


	@Override
	public List<OrdersBean> getOrderList(String member_id) {
		
		
		return orderDAO.getOrderList(member_id);
	}


	@Override
	public List<ProductBean> getProductOrderList(String member_id) {
		return orderDAO.getProductOrderList(member_id);
	}


	@Override
	public void insertOrders(OrdersBean ob) {
		// TODO Auto-generated method stub
		
		orderDAO.insertOrders(ob);
		
	}


	@Override
	public void deleteOrders(OrdersBean ob) {
		// TODO Auto-generated method stub
		orderDAO.deleteOrders(ob);
		
	}

	@Override
	public OrdersBean getPaymentinfo(OrdersBean orderBean) {
		// TODO Auto-generated method stub
		return orderDAO.getPaymentinfo(orderBean);
	}


	@Override
	public void updateStatus(OrdersBean orderBean) {
		// TODO Auto-generated method stub
		orderDAO.updateStatus(orderBean);
	}

}
