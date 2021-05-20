package com.seven.controller;

import java.text.SimpleDateFormat;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seven.domain.OrdersBean;
import com.seven.domain.ProductBean;
import com.seven.domain.WishBean;
import com.seven.service.OrdersService;
import com.seven.service.ProductService;
import com.seven.service.WishService;

@RestController
public class AjaxController {
	
	@Inject
	private WishService wishService;
	
	@Inject
	private OrdersService ordersService;
	
	@Inject
	private ProductService productService;
	
	
	//----------- wish ajax -----------
	
	// 저장되어있는지 확인 
	// 로그인 되어 있지 않으면 추가 할 수 없도록 화면단에서 제어
	@RequestMapping(value = "/wish/ajax", method = RequestMethod.GET)
	public ResponseEntity<String> wishAjaxAdd(HttpSession session, HttpServletRequest request) {
		// false = 테이블에 정보 X | true = 테이블에 정보 O
		System.out.println("wishAjax 시작");
		ResponseEntity<String> entity = null;
		
		try {
			
			String id = (String)session.getAttribute("id");
			String result = "";
			
			WishBean wishB = new WishBean();
			
			wishB.setProduct_num(Integer.parseInt(request.getParameter("product_num")));
			wishB.setMember_id(id);
			
			if(id == null) { // session 값 없음 -> wish에 추가 할 수 없음 
				
				result = "-1";
				
			} else { // session 값 존재 -> 로그인 완료 
				//추가 기능 구현 
				WishBean check = wishService.wishCheck(wishB);
				
				if(check == null ) {  // 존재 하지 않음 => insert 처리
					wishService.wishInsert(wishB);
					result = "1";
				} else { // 이미 존재 => 삭제 처리
					wishService.wishDelete(wishB);
					result = "0";
				}
				
			}
			
			entity = new ResponseEntity<String>(result, HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println("wishAjaxAdd() 오류 발생! ");
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return entity;
		
	}
	
	@RequestMapping(value = "/orders/payment", method = RequestMethod.GET, produces = "application/text; charset=UTF-8")
	public ResponseEntity<String> payment(HttpSession session, HttpServletRequest request) {
		// false = 테이블에 정보 X | true = 테이블에 정보 O
		System.out.println("wishAjax 시작");
		ResponseEntity<String> entity = null;

		try {
			System.out.println("==============wishAjax 시작==================");
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
			int orders_num2 = Integer.parseInt(request.getParameter("orders_num2"));
			String id = (String) session.getAttribute("id");
//			System.out.println("id" + id);
//			System.out.println("orders_num2" + orders_num2);
			// 기준키 필
			OrdersBean orderB = new OrdersBean();
			orderB.setMember_id(id);
			orderB.setOrders_num2(orders_num2);
			System.out.println("==============wishAjax 시작==================");
			OrdersBean ob = ordersService.getPaymentinfo(orderB);
			ProductBean pb = productService.getProduct(ob.getOrders_num());

			String outPut = "<tr> <td> order </td> <td>" + ob.getMember_id() + "</td> </tr>"
					+ "<tr> <td> product name </td> <td>" + pb.getProduct_title() + "</td> </tr>"
					+ "<tr> <td colspan='2'> <img alt=\"제품 사진\" src='<c:url value=\"/resources/upload/" 
					+ pb.getProduct_image() + "/>' </td> </tr>"
					+ "<tr> <td> order date </td> <td>" + sdf.format(ob.getOrders_date()) + "</td> </tr>"
					+ "<tr> <td> payment </td> <td>" + ob.getOrders_payment() + "</td> </tr>"
					+ "<tr> <td> delivery to </td> <td>" + ob.getOrders_address() + "</td> </tr>"
					+ "<tr> <td> color </td> <td>" + ob.getOrders_color() + "</td> </tr>"
					+ "<tr> <td> size </td> <td>"+ ob.getOrders_size() + "</td> </tr>";

			entity = new ResponseEntity<String>(outPut, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String> (HttpStatus.BAD_REQUEST);

		}

		return entity;

	}
	
}	
