package com.seven.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.seven.domain.WishBean;

public class WishDAOImpl implements WishDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mapper.WishMapper";

	//----------------------서예은--------------------
	@Override
	public List<WishBean> getWishList(String id) {
		// WishList
		return sqlSession.selectList(namespace+".getWishList", id );
		
	}

	//----------------------서예은--------------------
	
	
}
