package com.seven.dao;

import java.util.List;

import com.seven.domain.CartBean;
import com.seven.domain.ProductBean;


public interface CartDAO {
	public List<CartBean> getCartList(String id);
	
	public void deleteCart(ProductBean pb);
	
	public ProductBean getProduct(int num);
	
	public ProductBean ProductCheck(ProductBean pb);
	
	
}
