package com.seven.service;

import java.util.List;

import com.seven.domain.MemberBean;
import com.seven.domain.PageBean;

public interface MemberService {
	
	public void insertMember(MemberBean mb);
	
	public MemberBean userCheck(MemberBean mb);
	
	public MemberBean getMember(String id);
	
	public void updateMember(MemberBean mb);
	
	public void deleteMember(MemberBean mb);
	
	public List<MemberBean> getMemberList();
	
	public List<MemberBean> getMemberList_byPeriod(MemberBean mb);
	
	public List<MemberBean> getMemberList_byId(MemberBean mb);
	
	public List<MemberBean> getMemberList_byName(MemberBean mb);
	
}
