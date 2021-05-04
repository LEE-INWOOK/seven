package com.seven.service;

import java.util.List;

import com.seven.domain.PageBean;
import com.seven.domain.ProductBean;

public interface ProductService {
	
	public void insertProduct(ProductBean pb);
	
	public ProductBean getProduct(String product_num);
	
	public void updateProduct(ProductBean pb);
	
	public void deleteProduct(ProductBean pb);
	
	public List<ProductBean> getProductList();
	
	public List<ProductBean> getProductList(PageBean pb);

	public Integer getProductCount();
}
