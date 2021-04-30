package com.seven.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/product/shop", method = RequestMethod.GET)
	public String shop() {	
		return "product/shop";
	}
	
	@RequestMapping(value = "/product/wish", method = RequestMethod.GET)
	public String wish() {	
		return "product/wish";
	}
	// 기본 맵핑 끝 ↑
	
	

}
