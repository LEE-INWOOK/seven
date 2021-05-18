package com.seven.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.seven.domain.MemberBean;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	public static final String memberspace = "com.seven.mapper.MemberMapper";	
	// memberspace → sql구문을 담고 있는 전체 바구니 ( src/main/resources/mappers/memberMapper.xml )
	
	@Override
	public void insertMember(MemberBean mb) {
		sqlSession.insert(memberspace+".insertMember", mb);						
	// memberspace.+"실행할 sql구문의 id값" (src/main/resources/mappers/memberMapper.xml 파일에서 확인할 수 있어요!)
	}

	@Override
	public MemberBean userCheck(MemberBean mb) {
		return sqlSession.selectOne(memberspace+".userCheck", mb);
	}

	@Override
	public MemberBean getMember(String member_id) {
		return sqlSession.selectOne(memberspace+".getMember", member_id);
	}

	@Override
	public void updateMember(MemberBean mb) {
		sqlSession.update(memberspace+".updateMember", mb);	
	}

	@Override
	public void deleteMember(MemberBean mb) {
		sqlSession.delete(memberspace+".deleteMember", mb);
	}

	@Override
	public List<MemberBean> getMemberList() {
		return sqlSession.selectList(memberspace+".getMemberList");
	}


	//비밀번호변경
	@Override
	public int updatePw(MemberBean mb) throws Exception {
		return sqlSession.update(memberspace+".updatePw", mb);
	}

	@Override
	public MemberBean idCheck(String member_id) {
		return sqlSession.selectOne(memberspace+".idCheck", member_id);
	}
	@Override
	
	public MemberBean readMemberWithIDPW(String member_id, String member_pass) throws Exception {
		//테스트(컨트롤러) 호출 -> 정보를 저장 -> DB로이동

		//String인자를 2개를 가져갈 수 없기때문에 파라미터 두개를 객체인 Map에 넣어서 가지고 넘긴다
		//return sqlSession.selectOne(memberspace+".readMemberWithIDPW", member_id, member_pass);		

		// DB로 정보를 전달하기 위해서는 sqlSeesion 객체 활용
		// * 1개 이상의 정보를 전달할때는 객체 단위로 전달
		// * 객체(VO) 안에 저장이 안되는 정보의 경우 Map을 사용
		// Map은 key-value형태 : 이때 key값은 sql구문의 #{ㅇㅇㅇ} 이름과 같아야함

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("member_id", member_id);
		paramMap.put("mebber_pass", member_pass);

		return sqlSession.selectOne(memberspace+".readMemberWithIDPW", paramMap);		
	}
	
	
	
}
