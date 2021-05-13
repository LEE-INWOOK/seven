package com.seven.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seven.domain.WishBean;
import com.seven.service.WishService;

//ajax 관련 controller
@RestController
public class AjaxController {
	
	@Inject
	private WishService wishService;
	
	//----------- wish ajax -----------
	
	// 저장되어있는지 확인 
	// 로그인 되어 있지 않으면 추가 할 수 없도록 화면단에서 제어
	@RequestMapping(value = "/wish/add", method = RequestMethod.GET)
	public int wishAjaxAdd(WishBean wishB, HttpSession session, HttpServletRequest request) {
		// false = 테이블에 정보 X | true = 테이블에 정보 O
		int result = -1;
		String id = (String)session.getAttribute("id");
		
		try {
			
			if(id == null) { // session 값 없음 -> wish에 추가 할 수 없음 
				result = -1;
				
			} else { // session 값 존재 -> 로그인 완료 
				//추가 기능 구현 
//				wishService
				WishBean check = wishService.wishCheck(wishB);
				
				if(check != null ) { // 이미 존재 => 삭제 처리
					wishService.wishDelete(wishB);
					result = 0;
				} else { // 존재 하지 않음 => insert 처리
					wishService.wishInsert(wishB);
					result = 1;
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("wishAjaxAdd() 오류 발생! ");
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	//----------- wish ajax -----------
	
}
