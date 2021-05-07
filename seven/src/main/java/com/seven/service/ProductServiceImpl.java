package com.seven.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.seven.dao.ProductDAO;
import com.seven.domain.ProductBean;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Inject
	private ProductDAO productDAO;

	@Override
	public void insertProduct(ProductBean productBean) {
		if(productDAO.getMaxProduct_num() != null) {
			productBean.setProduct_num(productDAO.getMaxProduct_num() + 1);			
		}else {
			productBean.setProduct_num(1);
		}	// 상품번호가 존재한다면 최대값에서 +1, 상품번호가 존재하지 않으면 번호를 1로 설정
		productBean.setProduct_detail_date(new Timestamp(System.currentTimeMillis()));
		productDAO.insertProduct(productBean);
		
	}

	@Override
	public ProductBean getProduct(String product_num) {		
		return null;
	}

	@Override
	public void updateProduct(ProductBean productBean) {
		
	}

	@Override
	public void deleteProduct(ProductBean productBean) {
				
	}

	@Override
	public List<ProductBean> getProductList() {
		return null;
	}

}
