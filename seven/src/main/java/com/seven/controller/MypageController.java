package com.seven.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seven.service.MemberService;

public class MypageController {

	@Inject
	private MemberService memberService;
//	
//	@Inject
//	private ProductService productService;
	
	
	// mypage main
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String main() {		
		return "mypage/mypage";
	}

	//history 구매기록 보기 list
	@RequestMapping(value = "/mypage/history", method = RequestMethod.GET)
	public String history(HttpServletRequest request) {		
		return "mypage/history";
	}
	
	
	
}
