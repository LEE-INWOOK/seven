package com.seven.service;

import java.util.List;

import javax.inject.Inject;

import com.seven.dao.WishDAO;
import com.seven.domain.WishBean;

public class WishServiceImpl implements WishService {

	@Inject
	private WishDAO wishDAO;
	
	//----------------------서예은--------------------
	@Override
	public List<WishBean> getWishList(String id) {
		// wishList 
		return wishDAO.getWishList(id);
	}
	//----------------------서예은--------------------
}
