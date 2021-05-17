package com.seven.service;

import java.util.List;

import com.seven.domain.CartBean;
import com.seven.domain.ProductBean;



public interface CartService {
	
	public List<CartBean> getCartList(String id);
	
	public void deleteCart(ProductBean pb);
	
	public List<ProductBean> getProductList(String id);
	
	public ProductBean ProductCheck(ProductBean pb);
	
	
}
