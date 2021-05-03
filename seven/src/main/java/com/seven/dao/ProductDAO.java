package com.seven.dao;

import java.util.List;

import com.seven.domain.PageBean;
import com.seven.domain.ProductBean;

public interface ProductDAO {
	

	public ProductBean getProduct(String product_num);
	
	
	public Integer getProductCount();
	public List<ProductBean> getProductList(PageBean pb);

}
