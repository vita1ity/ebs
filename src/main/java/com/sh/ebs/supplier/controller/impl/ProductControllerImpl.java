package com.sh.ebs.supplier.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("productController")
public class ProductControllerImpl {
	
	@RequestMapping(value = "s/products", method=RequestMethod.GET)
	public String supplierProducts(Model model){
		return "supplierProducts";
	}
}
