package com.seven.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.seven.domain.OrdersBean;
import com.seven.domain.ProductBean;

@Repository
public class OrdersDAOImpl implements OrdersDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.seven.mapper.OrdersMapper";
	
	@Override
	public List<OrdersBean> getOrderList(String member_id) {
		
		return sqlSession.selectList(namespace + ".getOrderList", member_id );
	}

	@Override
	public List<ProductBean> getProductOrderList(String member_id) {
		return sqlSession.selectList(namespace + ".getProductOrderList", member_id );
	}

}