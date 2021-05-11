package com.seven.dao;

import java.util.List;

import com.seven.domain.WishBean;

public interface WishDAO {

	public List<WishBean> getWishList(String id);
	
}
