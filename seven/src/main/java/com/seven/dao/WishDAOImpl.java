package com.seven.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.seven.domain.ProductBean;
import com.seven.domain.WishBean;

public class WishDAOImpl implements WishDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mapper.WishMapper";

	//----------------------서예은--------------------
//	@Override
//	public List<WishBean> getWishList(String member_id) {  // wish 테이블의 정보만 가져옴 -> product관련 정보 없음
//		// WishList
//		System.out.println("WishDAOImpl | List<WishBean> getWishList(String id) ");
//		return sqlSession.selectList(namespace+".getWishList", member_id );
//	}
	
	@Override
	public List<ProductBean> getWishProductList(String member_id) {
		// WishView get product information 
		System.out.println("WishDAOImpl | List<ProductBean> getWishProductList(String member_id) ");
		return sqlSession.selectList(namespace+".getWishProductList", member_id );
	}

	@Override
	public WishBean wishCheck(WishBean wishB) { 
		// 테이블에 존재하는지 판단하여 삭제 혹은 추가 할지 결정 할 용도로 사용 
		System.out.println("WishDAOImpl | WishBean wishCheck(WishBean wishB) ");
		return sqlSession.selectOne(namespace+".wishCheck", wishB);
	}

	@Override
	public void wishDelete(WishBean wishB) { // wish 테이블에서 삭제 
		System.out.println("WishDAOImpl | public void wishDelete(WishBean wishB) ");
		sqlSession.delete(namespace + ".wishDelete", wishB);
	}

	@Override
	public void wishInsert(WishBean wishB) { // wish 테이블에 추가 
		System.out.println("WishDAOImpl | public void wishInsert(WishBean wishB) ");
		sqlSession.insert(namespace + ".wishInsert", wishB);
	}

	//----------------------서예은--------------------
	
	
}
