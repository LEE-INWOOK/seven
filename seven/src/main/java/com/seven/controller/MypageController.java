package com.seven.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seven.domain.MemberBean;
import com.seven.domain.PageBean;
import com.seven.domain.ProductBean;
import com.seven.service.MemberService;
import com.seven.service.ProductService;

@Controller
public class MypageController {
	

	// 주소 맵핑!/ pagebean 파일 복사 
	@Inject
	private MemberService memberService;
	
	@Inject
	private ProductService productService;
	
	// main
	@RequestMapping(value = "/mypage",method = RequestMethod.GET )
	public String main() {
		return "mypage/mypage"; // mypage.jsp 로 이동
	}
	

	//----------- 회원 정보 수정 페이지 관련 -----------
	//update
	@RequestMapping(value = "/mypage/update",method = RequestMethod.GET )
	public String update(HttpSession session, Model model) {
		
		String id =(String)session.getAttribute("id"); // 세션 생성
		MemberBean mb = memberService.getMember(id); // 디비에서 정보 들고 오기
		model.addAttribute("mb", mb); // 데이터를 updateForm 으로 이동 
		
		return "mypage/updateForm";
		
	}
	
	//updatePro
	@RequestMapping(value = "/mypage/updatePro",method = RequestMethod.POST)
	public String updatePro(MemberBean mb, Model model) {

		MemberBean mb2 = memberService.userCheck(mb);

		if(mb2 != null) {
			memberService.updateMember(mb);
		} else {
			model.addAttribute("error", "입력하신 정보가 틀립니다");
			
			return "member/error"; 
		}
		
		return "redirect:/mypage/main";
	}
	
	// deletePro
	@RequestMapping(value = "/mypage/deletePro",method = RequestMethod.POST)
	public String deleteProString(MemberBean mb, HttpSession session) {
	
		MemberBean mb2 = memberService.userCheck(mb);
		
		if(mb2 != null) { // 일치
			memberService.deleteMember(mb);
			session.invalidate();
		}
			
			return "redirect:/mypage/main";
	}
	//----------- 회원 정보 수정 페이지 관련 -----------
	
	
	//----------- 구매 내역 관련 페이지 -----------
	// list
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String historyList(HttpServletRequest request, Model model) {
		
		PageBean pb = new PageBean();
		
		if(request.getParameter("pageNum") != null) {
			//있으면 가져온 값 5
			pb.setPageNum(request.getParameter("pageNum") );
		} else {
			// 없으면 1
			pb.setPageNum("1");
		}
		
		pb.setPageSize(10); // 화면에 보여줄 글의 갯수
		
		List<ProductBean> bbList = productService.getProductList(pb); // 회원의 정보를 받아 회원의 과거 기록 조회 
		
		// count(*) 구하기
		pb.setCount(productService.getProductCount());
		
		model.addAttribute("bbList", bbList);
		model.addAttribute("pb", pb);
		
		return "board/list";
		
	}
		

	//----------- 구매 내역 관련 페이지  -----------
	

	//----------- wish 페이지 -----------
	// list
	@RequestMapping(value = "/mypage/wish", method = RequestMethod.GET)
	public String cartList(HttpServletRequest request, Model model) {
		
		PageBean pb = new PageBean();
		
		if(request.getParameter("pageNum") != null) {
			//있으면 가져온 값 5
			pb.setPageNum(request.getParameter("pageNum") );
		} else {
			// 없으면 1
			pb.setPageNum("1");
		}
		
		pb.setPageSize(10); // 화면에 보여줄 글의 갯수
		
		List<ProductBean> bbList = productService.getProductList(pb); // 회원의 정보를 받아 회원의 과거 기록 조회 
		
		// count(*) 구하기
		pb.setCount(productService.getProductCount());
		
		model.addAttribute("bbList", bbList);
		model.addAttribute("pb", pb);
		
		return "board/list";
		
	}
		

	//----------- wish 페이지  -----------
		
}
