package com.sh.ebs.supplier.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.ebs.supplier.controller.ProfileController;
@Controller("profileController")
public class ProfileControllerImpl implements ProfileController{
	@RequestMapping(value = "s/profile", method=RequestMethod.GET)
	public String supplierProfile(Model model){
		return "supplierProfile";
	}
	
	
}
