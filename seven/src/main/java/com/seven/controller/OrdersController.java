package com.seven.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seven.domain.OrdersBean;
import com.seven.service.OrdersService;

@Controller
public class OrdersController {
	
//	+-----------------+--------------+
//	| Field           | Type         | 
//	+-----------------+--------------+
//	| member_id       | varchar(45)  | 
//	| member_pass     | varchar(45)  | 
//	| member_name     | varchar(100) | 
//	| member_email    | varchar(100) | 
//	| member_address  | varchar(200) | 
//	| member_zipcode  | int(11)      | 
//	| member_address2 | varchar(100) | 
//	| member_phone    | varchar(45)  | 
//	| member_birth    | date         | 
//	| member_joindate | date         | 
//	+-----------------+--------------+


	// 주소 맵핑!/ pagebean 파일 복사 

	@Inject
	private OrdersService ordersService;
	
	
	
	
	//----------- 구매 내역 관련 페이지 -----------
	
	@RequestMapping(value = "/order/cancel",method = RequestMethod.GET )
	public String cancle(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("============cancel()  시작!-==================");
		int orders_num2 = Integer.parseInt(request.getParameter("orders_num2"));
		String id = (String) session.getAttribute("id");

		// 기준키 필
		OrdersBean orderBean = new OrdersBean();
		orderBean.setOrders_status("cancel"); // cancel 로 초기화 => 상태에 따라 다르게 초기화 하여 같은 코드를 공유 하게 한다 
		orderBean.setOrders_num2(orders_num2);
		orderBean.setMember_id(id);
		
		ordersService.updateStatus(orderBean);
		
		return "mypage/mypage"; // mypage.jsp 로 이동
	}
	
	//----------- 구매 내역 관련 페이지 -----------

	
	
	
	
	
	
}
