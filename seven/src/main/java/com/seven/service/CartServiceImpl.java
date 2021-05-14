package com.seven.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.seven.dao.CartDAO;
import com.seven.domain.CartBean;
import com.seven.domain.ProductBean;

@Service
public class CartServiceImpl implements CartService{
	
	@Inject
	private CartDAO cartDAO;
	
	@Override
	public List<CartBean> getCartList(String id) {
		// TODO Auto-generated method stub
		return cartDAO.getCartList(id);
	}

	@Override
	public void deleteCart(ProductBean pb) {
		// TODO Auto-generated method stub
		cartDAO.deleteCart(pb);
	}

	@Override
	public List<ProductBean> getProductList(String id) {
		List<CartBean> cbList=cartDAO.getCartList(id);
		List<ProductBean> pbList=new ArrayList<ProductBean>();
		for(int i=0; i < cbList.size(); i++) {
			CartBean cb=cbList.get(i);
			int num=cb.getProduct_num();
			
			pbList.add(cartDAO.getProduct(num));
		}
		return pbList;
	}

	@Override
	public ProductBean ProductCheck(ProductBean pb) {
		// TODO Auto-generated method stub
		return cartDAO.ProductCheck(pb);
	}

	
	
}
