package com.seven.service;

import java.util.List;

import com.seven.domain.PageBean;
import com.seven.domain.ProductBean;

public interface ProductService {
	
	public void insertProduct(ProductBean productBean);
	public ProductBean getProduct(String product_num);
	
	public void updateProduct(ProductBean productBean);
	public void deleteProduct(ProductBean productBean);
	public List<ProductBean> getProductList();
	
	public List<ProductBean> getProductList(PageBean pb);
	public List<ProductBean> getPriceList(PageBean pb);
	public List<ProductBean> getLowList(PageBean pb);
	public List<ProductBean> getHighList(PageBean pb);
	public List<ProductBean> getPopularList(PageBean pb);

	public Integer getProductCount();
}
