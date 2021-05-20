package com.seven.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMethodMappingNamingStrategy;

import com.seven.domain.CartBean;
import com.seven.domain.MemberBean;
import com.seven.domain.OrdersBean;
import com.seven.domain.PageBean;
import com.seven.domain.ProductBean;
import com.seven.service.CartService;
import com.seven.service.MemberService;
import com.seven.service.OrdersService;
import com.seven.service.ProductService;

@Controller
public class ProductController {
	
	@Inject
	private ProductService productService;
	@Inject
	private CartService cartservice;	
	@Inject
	private MemberService memberService;
	
	@Inject
	private OrdersService ordersService;
	
	// 기본 맵핑 시작 ↓
	
	
	
	// 카트로 넘어가면 리스트 형식으로 보이기 - 금환
		@RequestMapping(value = "/product/cart", method = RequestMethod.GET)
		public String cart(HttpSession session,Model model, HttpServletRequest request,CartBean cb) {
			// List<MemberBean> mbList = 회원전체 정보 조회 getMemberList()  
			
			String id=(String)session.getAttribute("id");
			cb.setCart_count(1);
			cb.setMember_id(id);
			cb.setCart_date(new Timestamp(System.currentTimeMillis()));
			
			CartBean cb2=cartservice.cartcheck(cb);
			if(cb2!=null) {
				System.out.println("dd");
				cartservice.updateCheckCount(cb);
				
				
			}else {
				
				cartservice.insertCart(cb);
			}
			
			
			System.out.println(id);
			
			
				return "redirect:/product/cartList";
			
			
		}
	
	 
	
	
	// 카트로 넘어가면 리스트 형식으로 보이기 - 금환
	@RequestMapping(value = "/product/cartList", method = RequestMethod.GET)
	public String cartList(HttpSession session,Model model, HttpServletRequest request) {
		// List<MemberBean> mbList = 회원전체 정보 조회 getMemberList()  
		
		String id=(String)session.getAttribute("id");
		MemberBean mb = memberService.getMember(id);
		
		
		if(mb != null) {
		
				
				
				List<CartBean> cbList=cartservice.getCartList(id);
				
				List<ProductBean> pbList = cartservice.getProductList(id);
				
				
				model.addAttribute("cbList",cbList);
				model.addAttribute("pbList",pbList);
				float total= 0;
				for(int i = 0; i < cbList.size(); i++) {
					CartBean cb=cbList.get(i);
					total =total+(cb.getCart_count()*cb.getProduct_price());
				}
				
				model.addAttribute("total",total);
				return "product/cart";
				// 가상주소 / 으로 이동 → HomeController에 의해 home.jsp 페이지로 이동
			
			

		}else {
			
			return "redirect:/member/login";
		}
		
	}
	
	
	
	// deletePro
	@RequestMapping(value = "/product/deletePro",method = RequestMethod.GET)
	public String deleteProduct(CartBean cb,HttpSession session) {
			
			String id=(String)session.getAttribute("id");
			cb.setMember_id(id);
			cartservice.deleteCart(cb);
			
			return "redirect:/product/cartList";
		
			
	}
	
	
	
	  @RequestMapping(value = "/product/cartupdate", method = RequestMethod.GET)
	  public String cartupdate(HttpSession session,Model model,CartBean cb) {
	  
		  String id=(String)session.getAttribute("id");
		  cb.setMember_id(id);
		
		  cartservice.cartupdate(cb);
	  
	  return "redirect:/product/cartList"; 
	  
	  }
	 
	
	
	
	
	
	
	
	@RequestMapping(value = "/product/detail", method = RequestMethod.GET)
	public String detail(HttpServletRequest request, Model model) {
		int product_num = Integer.parseInt(request.getParameter("product_num"));
		ProductBean pb = productService.getProduct(product_num);
		model.addAttribute("pb", pb);
		System.out.println(product_num);
		
		return "product/detail";
	}
	
	
//	@RequestMapping(value = "/product/shop", method = RequestMethod.GET)
//	public String shop(HttpServletRequest request, Model model){	
//		
//			PageBean pb=new PageBean();
//			if(request.getParameter("pageNum")!=null) {
//				
//				pb.setPageNum(request.getParameter("pageNum"));
//			}else {
//				
//				pb.setPageNum("1");
//			}
//			pb.setPageSize(12);
//					
//			List<ProductBean> pbList=productService.getProductList(pb);
//			
//			
//			pb.setCount(productService.getProductCount());
//			
//			model.addAttribute("pbList",pbList);
//			model.addAttribute("pb",pb);
//			
//			
//		
//		return "product/shop";
//	}
	
//파라미터값 받아서 가는걸로 수정중......
	@RequestMapping(value = "/product/shop", method = RequestMethod.GET)
	public String shop(HttpServletRequest request,Model model) {	
		PageBean pb=new PageBean();
		
		if(request.getParameter("category1")!=null) {
			System.out.println(request.getParameter("category1"));
			
			pb.setCategory(request.getParameter("category1"));
			
			if(request.getParameter("pageNum")!=null) {
				
				pb.setPageNum(request.getParameter("pageNum"));
			}else {
			pb.setPageNum("1");
			}
			pb.setPageSize(12);
					
			List<ProductBean> productList=productService.getCategoryList(pb);
			
			
			pb.setCount(productService.getProductCount());
			
			model.addAttribute("productList",productList);
			model.addAttribute("pb",pb);
			return "product/shop";
			}
			
			
		
		//가격설정정렬
		
		if(request.getParameter("lower")!=null&&request.getParameter("upper")!=null) {
		System.out.println(request.getParameter("lower"));
		System.out.println(request.getParameter("upper"));
			
		pb.setLower(Float.parseFloat(request.getParameter("lower")));
		pb.setUpper(Float.parseFloat(request.getParameter("upper")));
		
		if(request.getParameter("pageNum")!=null) {
			
			pb.setPageNum(request.getParameter("pageNum"));
		}else {
		pb.setPageNum("1");
		}
		pb.setPageSize(12);
				
		List<ProductBean> productList=productService.getPriceList(pb);
		
		
		pb.setCount(productService.getProductCount());
		
		System.out.println(pb.getLower());
		System.out.println(pb.getUpper());
		
		model.addAttribute("productList",productList);
		model.addAttribute("pb",pb);
		return "product/shop";
		}
		
		
		//정렬순
		if(request.getParameter("sorting")!=null) {
			System.out.println(request.getParameter("sorting"));
			
		if(request.getParameter("sorting").equals("low-high")) {
			pb.setSorting(request.getParameter("sorting"));
			
			if(request.getParameter("pageNum")!=null) {
				
				pb.setPageNum(request.getParameter("pageNum"));
			}else {
				
				pb.setPageNum("1");
			}
			pb.setPageSize(12);
					
			List<ProductBean> productList=productService.getLowList(pb);
			
			
			pb.setCount(productService.getProductCount());
			
			model.addAttribute("productList",productList);
			model.addAttribute("pb",pb);	
			return "product/shop";
			
			
		}else if(request.getParameter("sorting").equals("high-low")) {
			pb.setSorting(request.getParameter("sorting"));
			
			if(request.getParameter("pageNum")!=null) {
				
				pb.setPageNum(request.getParameter("pageNum"));
			}else {
				
				pb.setPageNum("1");
			}
			pb.setPageSize(12);
					
			List<ProductBean> productList=productService.getHighList(pb);
			
			
			pb.setCount(productService.getProductCount());
			
			model.addAttribute("productList",productList);
			model.addAttribute("pb",pb);
			return "product/shop";
		
		}else if(request.getParameter("sorting").equals("popularity")) {
			pb.setSorting(request.getParameter("sorting"));
			
			if(request.getParameter("pageNum")!=null) {
				
				pb.setPageNum(request.getParameter("pageNum"));
			}else {
				
				pb.setPageNum("1");
			}
			pb.setPageSize(12);
					
			List<ProductBean> productList=productService.getPopularList(pb);
			
			
			pb.setCount(productService.getProductCount());
			
			model.addAttribute("productList",productList);
			model.addAttribute("pb",pb);
			return "product/shop";
		}
			
		}
			
		
		
		if(request.getParameter("pageNum")!=null) {
				
				pb.setPageNum(request.getParameter("pageNum"));
			}else {
				
				pb.setPageNum("1");
			}
			pb.setPageSize(12);
			
			List<ProductBean> productList=productService.getProductList(pb);
			
			
			pb.setCount(productService.getProductCount());
			
			model.addAttribute("productList",productList);
			model.addAttribute("pb",pb);
		
		
		//메인 정렬
		
		
		
		return "product/shop";
		
		
		
	}
	
	
	@RequestMapping(value = "/product/wish", method = RequestMethod.GET)
	public String wish() {	
		return "product/wish";
	}
	// 기본 맵핑 끝 ↑
	
	

}
