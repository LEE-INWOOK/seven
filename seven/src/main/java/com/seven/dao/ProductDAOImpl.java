package com.seven.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.seven.domain.PageBean;
import com.seven.domain.ProductBean;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Inject
	private SqlSession sqlSession;
	public static final String productspace = "com.seven.mapper.ProductMapper";
	
	@Override
	public void insertProduct(ProductBean productBean) {
		sqlSession.insert(productspace + ".insertProduct", productBean);
	}
	
	@Override
	public Integer getMaxProduct_num() {
		return sqlSession.selectOne(productspace + ".getMaxProduct_num");
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

	@Override
	public List<ProductBean> getProductList(PageBean pb) {
		return sqlSession.selectList(productspace + ".getProductList", pb);
	}
	
	@Override
	public Integer getProductCount() {
		return sqlSession.selectOne(productspace + ".getProductCount");
	}
}
