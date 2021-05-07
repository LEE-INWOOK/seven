package com.seven.service;

import java.util.List;

import com.seven.domain.PageBean;
import com.seven.domain.ProductBean;
import com.seven.domain.PageBean;

public interface ProductService {
	
<<<<<<< HEAD
	public void insertProduct(ProductBean productBean);
=======
>>>>>>> branch 'namyoung' of https://github.com/LEE-INWOOK/seven.git
	
	public ProductBean getProduct(String product_num);
	
<<<<<<< HEAD
	public void updateProduct(ProductBean productBean);
=======
	public Integer getProductCount();
>>>>>>> branch 'namyoung' of https://github.com/LEE-INWOOK/seven.git
	
<<<<<<< HEAD
	public void deleteProduct(ProductBean productBean);
=======
	public List<ProductBean> getProductList(PageBean pb);
>>>>>>> branch 'namyoung' of https://github.com/LEE-INWOOK/seven.git
	
<<<<<<< HEAD
	public List<ProductBean> getProductList();
	
	public List<ProductBean> getProductList(PageBean pb);
=======
	public List<ProductBean> getPriceList(PageBean pb);
	public List<ProductBean> getLowList(PageBean pb);
	public List<ProductBean> getHighList(PageBean pb);
	public List<ProductBean> getPopularList(PageBean pb);
>>>>>>> branch 'namyoung' of https://github.com/LEE-INWOOK/seven.git

	public Integer getProductCount();
}
