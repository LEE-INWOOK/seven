package com.seven.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seven.domain.MemberBean;
import com.seven.service.MemberService;

@Controller
public class MemberController {
	
	/*
	 * @RequestMapping
	 * value = "" ← 주소줄에 표시할 가상의 주소
	 * return ""; ← 실제 이동할 물리적 주소 ( 파일의 '이름만' 입력 )
	 * return "redirect:XXX" ← XXX라는 가상의 주소로 이동
	 * (Tip) 하이퍼링크는 모두 GET방식으로 전송됩니다
	 */
	
	@Inject
	private MemberService memberService;
	
	//		●회원가입 시작 ↓
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {		
		return "member/insertForm";
	}
	
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro(MemberBean mb) {
		System.out.println("확인");
		memberService.insertMember(mb);
		return "redirect:/";
	}
	//		●회원가입 끝 ↑
	
	
	//		●로그인 시작 ↓
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {		
		return "member/loginForm";
	}
	
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberBean mb, HttpSession session, Model model) {
		System.out.println("잘되나");
		MemberBean mb2 = memberService.userCheck(mb);
		// userCheck의 결과를 mb2에 담아서 결과가 있으면 ( =ID&PASS가 일치하면 ) 세션 ID 부여 후 home.jsp로 이동
		if(mb2 != null) {
			session.setAttribute("id", mb.getMember_id());
			return "redirect:/";
			// 가상주소 / 으로 이동 → HomeController에 의해 home.jsp 페이지로 이동
		}else {
			model.addAttribute("error", "입력하신 정보가 일치하지 않습니다");
			return "member/error";
		}
	}	
	//		●로그인 끝 ↑
	
	
	//		●로그아웃 시작 ↓
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	//		●로그아웃 끝 ↑
	
	
	//		●회원정보수정 시작 ↓ mypage myInfo.jsp
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		MemberBean mb = memberService.getMember(id);
		model.addAttribute("mb", mb);
		return "member/updateForm";
	}
	
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberBean mb, Model model) {
		
		MemberBean mb2 = memberService.userCheck(mb);
		// userCheck의 결과를 mb2에 담아서 결과가 있으면 ( =ID&PASS가 일치하면 )
		if(mb2 != null) {
			memberService.updateMember(mb);
			return "redirect:/";
			// 가상주소 / 으로 이동 → HomeController에 의해 home.jsp 페이지로 이동
		}else {
			model.addAttribute("error", "입력하신 정보가 일치하지 않습니다");
			return "member/error";
		}
	}
	//		●회원정보수정 끝 ↑
	
	
	//		●회원정보삭제 시작 ↓
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		return "member/deleteForm";
	}
	
	@RequestMapping(value = "/member/deletePro", method = RequestMethod.POST)
	public String deletePro(MemberBean mb, Model model) {
		
		MemberBean mb2 = memberService.userCheck(mb);
		// userCheck의 결과를 mb2에 담아서 결과가 있으면 ( =ID&PASS가 일치하면 )
		if(mb2 != null) {
			memberService.deleteMember(mb);
			return "redirect:/";
			// 가상주소 / 으로 이동 → HomeController에 의해 home.jsp 페이지로 이동
		}else {
			model.addAttribute("error", "입력하신 정보가 일치하지 않습니다");
			return "member/error";
		}
	}
	//		●회원정보삭제 끝 ↑
	
	
	//		●회원List 시작 ↓
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<MemberBean> mbList = memberService.getMemberList();
		model.addAttribute("mbList", mbList);
		return "redirect:/";
	}
	//		●회원List 끝 ↑
	
	/* 비밀번호 찾기 */
	@RequestMapping(value = "/member/findpw", method = RequestMethod.GET)
	public void findPwGET() throws Exception{
	}

	@RequestMapping(value = "/member/findpw", method = RequestMethod.POST)
	public void findPwPOST(@ModelAttribute MemberBean mb, HttpServletResponse response) throws Exception{
		System.out.println(mb.getMember_id());
		System.out.println(mb.getMember_email());
		memberService.findPw(response, mb);
	}
	
	
	
	//회원가입시 아이디중복확인
//		@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
//		public @ResponseBody int idCheck(@RequestParam("id") String id) throws Exception {
//			MemberBean ck = memberService.idCheck(id);
//			if(ck != null) return 1;
//			else return 0;
//		}
//	@RequestMapping("loginForm")
//	public String loginForm() {
//		return "loginForm";
//	}
//	@RequestMapping("success")
//	public String success(@RequestParam("code") String code, HttpSession session) {
//		System.out.println("code : "+code);
//		//code(성공에 대한 결과값)를 이용해서 token 값 얻어올 수 있음
//		//token값 이용하여 사용자 정보 얻어올 수 있음
//		System.out.println("로그인 성공  success 연결 되었습니다");
//		GetKakao kakao = new GetKakao();
//		String accessToken = kakao.getAccessToken(code);
//		HashMap<String , Object> userInfo = kakao.getUserInfo(accessToken);
//		session.setAttribute("userId", userInfo.get("nickname"));
//		return "success";
//	}
//	@RequestMapping(value="/logout")
//	   public ResponseEntity logout(HttpSession session) {
//	       session.removeAttribute("userId");
//	       String str = "<script>alert('로그아웃 되었습니다');";
//	       str+="location.href='https://accounts.kakao.com/weblogin/sso_logout"
//	             + "?continue=http://localhost:8090/root/loginForm'</script>";
//	       ResponseEntity resEnt=null;
//	       HttpHeaders responseHeaders = new HttpHeaders();
//	       responseHeaders.add("Content-Type", "text/html; charset=utf-8");
//	       resEnt = new ResponseEntity(str, responseHeaders, HttpStatus.CREATED);
//	       return resEnt;
//	   }
//

	/* 구글아이디로 로그인 */	
    @ResponseBody
	@RequestMapping(value = "/loginGoogle", method = RequestMethod.POST)
	public String loginGooglePOST(MemberBean mb, HttpSession session, RedirectAttributes rttr, MemberBean memberbean) throws Exception{
		MemberBean returnmb = memberService.loginMemberByGoogle(mb);
		String mvo_ajaxid = mvo.getMember_id(); 
		System.out.println("C: 구글아이디 포스트 db에서 가져온 vo "+ mb);
		System.out.println("C: 구글아이디 포스트 ajax에서 가져온 id "+ mvo_ajaxid);
		
		if(returnmb == null) { //아이디가 DB에 존재하지 않는 경우
			//구글 회원가입
			memberService.joinMemberByGoogle(mb);	
			
			//구글 로그인
			returnmb = memberService.loginMemberByGoogle(mb);
			session.setAttribute("id", returnmb.getMember_id());			
			rttr.addFlashAttribute("mvo", returnmb);
		}
		
		if(mvo_ajaxid.equals(returnmb.getMember_id())){ //아이디가 DB에 존재하는 경우
			//구글 로그인
			memberService.loginMemberByGoogle(mb);
			session.setAttribute("id", returnmb.getMember_id());			
			rttr.addFlashAttribute("mvo", returnmb);
		}else {//아이디가 DB에 존재하지 않는 경우
			//구글 회원가입
			memberService.joinMemberByGoogle(mb);	
			
			//구글 로그인
			returnmb = memberService.loginMemberByGoogle(mb);
			session.setAttribute("id", returnmb.getMember_id());			
			rttr.addFlashAttribute("mvo", returnmb);
		}
		
		return "redirect:/member/main";
	}

	
	
	
	

}
