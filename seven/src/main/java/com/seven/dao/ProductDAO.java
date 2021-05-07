package com.seven.dao;

import java.util.List;

import com.seven.domain.PageBean;
import com.seven.domain.ProductBean;

public interface ProductDAO {
	
	public void insertProduct(ProductBean productBean);
	
	public Integer getMaxProduct_num();
	
	public ProductBean getProduct(String product_num);
	
	public void updateProduct(ProductBean productBean);
	
	public void deleteProduct(ProductBean productBean);
	
	public List<ProductBean> getProductList();
	
	public List<ProductBean> getProductList(PageBean pb);

	public Integer getProductCount();

}
