package com.seven.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.seven.domain.PageBean;
import com.seven.domain.ProductBean;
import com.seven.service.ProductService;

@Controller
public class ProductController {
	
	@Inject
	private ProductService productService;
	
	// 기본 맵핑 시작 ↓
	@RequestMapping(value = "/product/cart", method = RequestMethod.GET)
	public String cart() {
		return "product/cart";
	}
	
	@RequestMapping(value = "/product/checkout", method = RequestMethod.GET)
	public String checkout() {
		return "product/checkoutForm";
	}
	
	@RequestMapping(value = "/product/detail", method = RequestMethod.GET)
	public String detail() {		
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
	public String price(HttpServletRequest request,Model model) {	
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
		
		model.addAttribute("productList",productList);
		model.addAttribute("pb",pb);
		
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
		
		
		}
			
		}	
		
		//메인 정렬
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
		
		
		return "product/shop";
		
		
		
	}
	
	@RequestMapping(value = "/product/wish", method = RequestMethod.GET)
	public String wish() {	
		return "product/wish";
	}
	// 기본 맵핑 끝 ↑
	
	

}
