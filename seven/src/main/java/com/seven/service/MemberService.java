package com.seven.service;

import java.util.List;

import com.seven.domain.MemberBean;
import com.seven.domain.ProductBean;

public interface MemberService {
	
	
	public void insertMember(MemberBean mb);
	public MemberBean userCheck(MemberBean mb);
	
	public MemberBean getMember(String id);
	
	public void updateMember(MemberBean mb);
	
	public void deleteMember(MemberBean mb);
	
	public List<MemberBean> getMemberList();
	
}
