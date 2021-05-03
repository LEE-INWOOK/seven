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
	public ProductBean getProduct(String product_num) {
		return null;
	}




	@Override
	public Integer getProductCount() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<ProductBean> getProductList(PageBean pb) {
		return sqlSession.selectList(productspace+".getProductList", pb);
		
	}

}
