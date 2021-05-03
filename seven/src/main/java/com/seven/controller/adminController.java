package com.seven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class adminController {
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String main() {
		return "admin/main";
	}
	
	@RequestMapping(value = "/admin/insert", method = RequestMethod.GET)
	public String insert() {
		return "admin/insertProductForm";
	}

}
