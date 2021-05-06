package com.seven.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import com.seven.domain.PageBean;
import com.seven.dao.ProductDAO;
import com.seven.domain.ProductBean;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Inject
	private ProductDAO productDAO;

	

	@Override
	public ProductBean getProduct(String product_num) {		
		return null;
	}

	

	@Override
	public List<ProductBean> getProductList(PageBean pb) {
		
				pb.setCurrentPage(Integer.parseInt(pb.getPageNum()));
				
				pb.setStartRow((pb.getCurrentPage()-1)*pb.getPageSize());
		
		return productDAO.getProductList(pb);
	}




	@Override
	public Integer getProductCount() {
		
		return productDAO.getProductCount();
	}



	@Override
	public List<ProductBean> getPriceList(PageBean pb) {
		
		return productDAO.getPriceList(pb);
	}



	@Override
	public List<ProductBean> getLowList(PageBean pb) {
		
		return productDAO.getLowList(pb);
	}



	@Override
	public List<ProductBean> getHighList(PageBean pb) {
		
		return productDAO.getHighList(pb);
	}



	@Override
	public List<ProductBean> getPopularList(PageBean pb) {
		
		return productDAO.getPopularList(pb);
	}




}
