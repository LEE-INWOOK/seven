package com.seven.service;

import java.util.List;

import com.seven.domain.ProductBean;

public interface ProductService {
	
	public void insertProduct(ProductBean productBean);
	
	public ProductBean getProduct(String product_num);
	
	public void updateProduct(ProductBean productBean);
	
	public void deleteProduct(ProductBean productBean);
	
	public List<ProductBean> getProductList();

}
