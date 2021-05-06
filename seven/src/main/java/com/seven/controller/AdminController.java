package com.seven.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.seven.domain.ProductBean;
import com.seven.service.ProductService;

@Controller
public class AdminController {
	
	@Inject
	private ProductService productService;
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/admin/main", method = RequestMethod.GET)
	public String main() {
		return "admin/main";
	}
	
	@RequestMapping(value = "/admin/insert", method = RequestMethod.GET)
	public String insert() {
		return "admin/insertProductForm";
	}
	
	@RequestMapping(value = "/admin/insertProductPro", method = RequestMethod.POST)
	public String insertPro(HttpServletRequest request, @RequestParam(value = "product_image", required = false) MultipartFile  file, @RequestParam(value = "product_detail_img1", required = false) MultipartFile  file1) throws Exception {
		// ↓ java.util 랜덤문자열 생성기 : 랜덤문자열_파일명 형태로 saveName에 저장 (파일명 중복방지)
		UUID uid = UUID.randomUUID();
		String saveName = uid.toString() + "_" + file.getOriginalFilename();
		String saveName1 = uid.toString() + "_" + file1.getOriginalFilename();
		System.out.println(saveName);
		File target = new File(uploadPath, saveName);
		File target1 = new File(uploadPath, saveName1);
		
		try {
			FileCopyUtils.copy(file.getBytes(), target);
			FileCopyUtils.copy(file1.getBytes(), target1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ProductBean productBean = new ProductBean();
		productBean.setProduct_title(request.getParameter("product_title"));
		productBean.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
		productBean.setProduct_image(saveName);
		productBean.setProduct_color(request.getParameter("product_color"));
		productBean.setProduct_size(request.getParameter("product_size"));
		productBean.setProduct_stock(Integer.parseInt(request.getParameter("product_stock")));
		productBean.setProduct_category(request.getParameter("product_category"));
		productBean.setProduct_detail_text(request.getParameter("product_detail_text"));
		productBean.setProduct_detail_img1(saveName1);
//		productBean.setProduct_detail_img2(request.getParameter("product_detail_img2"));
//		productBean.setProduct_detail_img3(request.getParameter("product_detail_img3"));
//		productBean.setProduct_detail_img4(request.getParameter("product_detail_img4"));
		productBean.setProduct_detail_del_info(request.getParameter("product_detail_del_info"));
		productBean.setProduct_detail_sale(request.getParameter("product_detail_sale"));
		productBean.setProduct_detail_admin_note(request.getParameter("product_detail_admin_note"));
		
		productService.insertProduct(productBean);	
		return "redirect:/product/shop";
	}

}
