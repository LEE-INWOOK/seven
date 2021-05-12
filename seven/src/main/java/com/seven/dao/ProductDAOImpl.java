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
	public void insertProduct(ProductBean pb) {
		sqlSession.insert(productspace + ".insertProduct", pb);
	}
	
	@Override
	public Integer getMaxProduct_num() {
		return sqlSession.selectOne(productspace + ".getMaxProduct_num");
	}
	
	@Override
	public ProductBean getProduct(int product_num) {
		return sqlSession.selectOne(productspace + ".getProduct", product_num);
	}

	@Override
	public Integer getProductCount() {		
		return sqlSession.selectOne(productspace+".getProductCount");
	}




	@Override
	public List<ProductBean> getPriceList(PageBean pb) {
		return sqlSession.selectList(productspace+".getPriceList", pb);
		
	}




	@Override
	public List<ProductBean> getLowList(PageBean pb) {
		
		return sqlSession.selectList(productspace+".getLowList", pb);
	}
	
	@Override
	public List<ProductBean> getHighList(PageBean pb) {
		
		return sqlSession.selectList(productspace+".getHighList", pb);
	}

	@Override
	public List<ProductBean> getPopularList(PageBean pb) {
		
		return sqlSession.selectList(productspace+".getPopularList", pb);
	}

	@Override
	public List<ProductBean> getProductList(PageBean pb) {
		return sqlSession.selectList(productspace + ".getProductList", pb);
	}
	
	
	@Override
	public void updateProduct(ProductBean pb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(ProductBean pb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductBean> getProductList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ProductBean> getCategoryList(PageBean pb) {
		
		return sqlSession.selectList(productspace+".getCategoryList",pb);
	}
	
}
