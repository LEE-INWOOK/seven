package com.seven.dao;

import java.util.List;

import com.seven.domain.PageBean;
import com.seven.domain.ProductBean;

public interface ProductDAO {
	

	public ProductBean getProduct(String product_num);
public void insertProduct(ProductBean pb);
	
	public Integer getMaxProduct_num();
	
	public Integer getProductCount();
	public List<ProductBean> getProductList(PageBean pb);
	public List<ProductBean> getPriceList(PageBean pb);
	public List<ProductBean> getLowList(PageBean pb);
	public List<ProductBean> getHighList(PageBean pb);
	public List<ProductBean> getPopularList(PageBean pb);

}
