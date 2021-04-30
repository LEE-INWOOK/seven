package com.seven.dao;

import java.util.List;

import com.seven.domain.ProductBean;

public interface ProductDAO {
	
	public void insertProduct(ProductBean pb);
	
	public ProductBean getProduct(String product_num);
	
	public void updateProduct(ProductBean pb);
	
	public void deleteProduct(ProductBean pb);
	
	public List<ProductBean> getProductList();

}
