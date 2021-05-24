package com.seven.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.seven.dao.MemberDAO;
import com.seven.domain.MemberBean;
import com.seven.domain.PageBean;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO memberDao;

	@Override
	public void insertMember(MemberBean mb) {
		mb.setMember_joindate(new Timestamp(System.currentTimeMillis()));
		memberDao.insertMember(mb);		
	}

	@Override
	public MemberBean userCheck(MemberBean mb) {
		return memberDao.userCheck(mb);
	}

	@Override
	public MemberBean getMember(String id) {
		return memberDao.getMember(id);
	}

	@Override
	public void updateMember(MemberBean mb) {
		memberDao.updateMember(mb);		
	}

	@Override
	public void deleteMember(MemberBean mb) {
		memberDao.deleteMember(mb);
	}

	@Override
	public List<MemberBean> getMemberList() {
		return memberDao.getMemberList();
	}
	
	@Override
	public List<MemberBean> getMemberList_byPeriod(MemberBean mb) {
		return memberDao.getMemberList_byPeriod(mb);
	}
	
	@Override
	public List<MemberBean> getMemberList_byId(MemberBean mb) {
		return memberDao.getMemberList_byPeriod(mb);
	}
	
	@Override
	public List<MemberBean> getMemberList_byName(MemberBean mb) {
		return memberDao.getMemberList_byPeriod(mb);
	}

}
