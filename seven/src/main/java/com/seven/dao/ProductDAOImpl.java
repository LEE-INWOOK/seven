package com.seven.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.seven.domain.ProductBean;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	public static final String productspace = "com.seven.mapper.ProductMapper";

	@Override
	public void insertProduct(ProductBean pb) {
		
	}

	@Override
	public ProductBean getProduct(String product_num) {
		return null;
	}

	@Override
	public void updateProduct(ProductBean pb) {
		
	}

	@Override
	public void deleteProduct(ProductBean pb) {
		
	}

	@Override
	public List<ProductBean> getProductList() {
		return null;
	}

}
