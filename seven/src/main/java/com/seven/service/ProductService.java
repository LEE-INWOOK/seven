package com.seven.service;

import java.util.List;

import com.seven.domain.ProductBean;
import com.seven.domain.PageBean;

public interface ProductService {
	
	
	public ProductBean getProduct(String product_num);
	
	public Integer getProductCount();
	
	public List<ProductBean> getProductList(PageBean pb);
	
	public List<ProductBean> getPriceList(PageBean pb);
	public List<ProductBean> getLowList(PageBean pb);
	public List<ProductBean> getHighList(PageBean pb);
	public List<ProductBean> getPopularList(PageBean pb);

}
