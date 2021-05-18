package com.seven.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.seven.domain.MemberBean;

public interface MemberService {
	
	public void insertMember(MemberBean mb);

	public MemberBean userCheck(MemberBean mb);
	
	public MemberBean getMember(String member_id);
	
	public void updateMember(MemberBean mb);
	
	public void deleteMember(MemberBean mb);
	
	public List<MemberBean> getMemberList();
	
	//이메일발송
	public void sendEmail(MemberBean mb, String div) throws Exception;

	//비밀번호찾기
	public void findPw(HttpServletResponse resp, MemberBean mb) throws Exception;


	public MemberBean idCheck(String member_id);
	
	//구글회원가입
		public void joinMemberByGoogle(MemberBean mb);
		
		//구글로그인
		public MemberBean loginMemberByGoogle(MemberBean mb);
	
	
	
	
}
