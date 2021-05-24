package com.seven.controller;

import java.sql.Date;
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

import com.seven.dao.Review_BoardDAO;
import com.seven.domain.CartBean;
import com.seven.domain.MemberBean;
import com.seven.domain.PageBean;
import com.seven.domain.ProductBean;
import com.seven.domain.Review_boardBean;
import com.seven.domain.WishBean;
import com.seven.service.CartService;
import com.seven.service.MemberService;
import com.seven.service.ProductService;
import com.seven.service.Review_BoardService;
import com.seven.service.Review_BoardServiceImpl;
import com.seven.service.WishService;

@Controller
public class ProductController {
	
	@Inject
	private ProductService productService;
	@Inject
	private CartService cartservice;	
	@Inject
	private MemberService memberService;
	@Inject
	private Review_BoardService review_boardService;
	@Inject
	private WishService wishService;
	
	// 기본 맵핑 시작 ↓
	
	@RequestMapping(value = "/product/checkout", method = RequestMethod.GET)
	public String checkout() {
		return "product/checkoutForm";
	}
	
	// 카트로 넘어가면 리스트 형식으로 보이기 - 금환
	@RequestMapping(value = "/product/cart", method = RequestMethod.GET)
	public String cart(HttpSession session,Model model, HttpServletRequest request) {
		// List<MemberBean> mbList = 회원전체 정보 조회 getMemberList()  
		
		String id=(String)session.getAttribute("id");
		MemberBean mb = memberService.getMember(id);
		System.out.println(id);
		
		if(mb != null) {
		
				
				
				List<CartBean> cbList=cartservice.getCartList(id);
				
				List<ProductBean> pbList = cartservice.getProductList(id);
				
				
				model.addAttribute("cbList",cbList);
				model.addAttribute("pbList",pbList);
				
				return "product/cart";
				// 가상주소 / 으로 이동 → HomeController에 의해 home.jsp 페이지로 이동
			
			

		}else {
			
			return "redirect:/member/login";
		}
		
	}
	
	// deletePro
	@RequestMapping(value = "/product/deletePro",method = RequestMethod.GET)
	public String deleteProduct(ProductBean pb) {
		
		System.out.println(pb.getProduct_num());
			cartservice.deleteCart(pb);
			
			return "redirect:/product/cart";
		
			
	}
	
	@RequestMapping(value = "/product/detail", method = RequestMethod.GET)
	public String detail(HttpServletRequest request, Model model, HttpSession session) {
		int product_num = Integer.parseInt(request.getParameter("product_num"));
		ProductBean pb = productService.getProduct(product_num);
//		model.addAttribute("pb", pb);
		// ------wish 관련 -------
				String id = (String)session.getAttribute("id");
				String wishCheck = "";
				
				WishBean wishB = new WishBean();
				
				wishB.setProduct_num(product_num);
				wishB.setMember_id(id);
				
				if(id == null) { // session 값 없음 -> wish에 추가 할 수 없음 
					
					wishCheck = "-1";
					
				} else { // session 값 존재 -> 로그인 완료 
					//추가 기능 구현 
					WishBean check = wishService.wishCheck(wishB);
					
					if(check != null ) { 
						wishCheck = "1";
					} else { 
						wishCheck = "0";
					}
					
				}
				
				model.addAttribute("pb", pb);
				model.addAttribute("wishCheck", wishCheck);
		
		return "product/detail";
	}
	
	@RequestMapping(value = "/product/review", method = RequestMethod.POST)
	public String reviewList(HttpSession session, HttpServletRequest request, Model model, Review_boardBean rb) {
		
		String id=(String)session.getAttribute("id");
		MemberBean mb = memberService.getMember(id);
		int product_num = Integer.parseInt(request.getParameter("product_num"));
		rb.setMember_id(id);
		rb.setProduct_num(product_num);
		rb.setReview_board_content(request.getParameter("repCon"));
//		int product_num = Integer.parseInt(request.getParameter("product_num"));
//		ProductBean pb = productService.getProduct(product_num);
		

		
//		MemberBean mb = (MemberBean) session.getAttribute("member_id");
		
//		mb = memberService.getMember("member_id"); // 디비에서 정보 들고 오기
//		model.addAttribute("mb", mb); // 데이터 이동 	
		
//		MemberBean mb = (MemberBean) session.getAttribute("member_id");
//		rb.setMember_id(mb.getMember_id());
		
//		review_boardBean.setMember_id("member_id");
//		review_boardBean.setReview_board_content("review_board_content");
		review_boardService.insertReview_Board(rb);
		
		return "redirect:/product/detail?product_num="+product_num;
		
	}
	
	@RequestMapping(value = "/product/reviewList", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {
		PageBean pb=new PageBean();
		if(request.getParameter("pageNum")!=null) {
			// 있으면 가져온값 5
			pb.setPageNum(request.getParameter("pageNum"));
		}else {
			// 없으면 1
			pb.setPageNum("1");
		}
		pb.setPageSize(10);
				
		List<Review_boardBean> bbList=review_boardService.Review_boardList(pb);
		
		System.out.println("출력됨"+bbList.get(0).getMember_id());
		
		// count(*) 구하기 => set메서드 호출 => pageBlock, startPage, endPage, pageCount구하기
		pb.setCount(review_boardService.getReview_BoardCount());
		
		model.addAttribute("bbList",bbList);
		model.addAttribute("pb",pb);
		
		//  /WEB-INF/views/board/list.jsp 
		return "product/detail";
	}
	
//	@RequestMapping(value = "/product/wish", method = RequestMethod.GET)
//	public String wish(HttpSession session, HttpServletRequest request, Model model) {
//		
//		int product_num = Integer.parseInt(request.getParameter("product_num"));
//		String id =(String)session.getAttribute("id"); // 세션 생성
//		MemberBean mb = memberService.getMember(id); // 디비에서 정보 들고 오기
//		model.addAttribute("mb", mb); // 데이터 이동 
//		
//		
//		return "redirect:/product/detail?product_num="+product_num;
//		
//	}
	
//	@RequestMapping(value = "/product/reviewPro", method = RequestMethod.POST)
//	public String insertReview_Board(Review_boardBean rb) {
//		
////		int product_num = Integer.parseInt(request.getParameter("product_num"));
////		
////		Review_boardBean review_boardBean = new Review_boardBean();
//		
//		
//		review_boardService.insertReview_Board(rb);
//		
//		return "/product/review";
//	}
	
	
//	@RequestMapping(value = "/product/review", method = RequestMethod.GET)
//	public String review(HttpServletRequest request, HttpSession session, Model model) {
//		
//		int product_num = Integer.parseInt(request.getParameter("product_num"));
//		ProductBean pb = productService.getProduct(product_num);
//		model.addAttribute("pb", pb);
//		String id=(String)session.getAttribute("id");
//		MemberBean mb = memberService.getMember(id);
//		
//		if(mb != null) {
//			
//			List<Review_boardBean> rbList=review_boardService.getBoardList(id);
//
//			model.addAttribute("rbList",rbList);
//			
//			return "product/review";
//			
//			}else {
//			
//				return "redirect:/member/login";
//		}
//}
	
	//===================================================================================================
//	
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
	
	

	
	

}
