package org.cranesandlama.project.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.cranesandlama.project.model.User;
import org.cranesandlama.project.model.UserRole;
import org.cranesandlama.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model) throws IOException{
		System.out.println("LOGIN CONTROLLER");
		return "login";
	}
	@RequestMapping(value = "/admin", method=RequestMethod.GET)
	public String adminPage(Model model) throws IOException{
		System.out.println("ADMIN CONTROLLER");
		User newUser = new User();
		
		Map<String,UserRole> roleList = UserRole.getRoleList();
		
		model.addAttribute("roleList", roleList);
		model.addAttribute("newUser", newUser);
		return "admin";
	}
	
	@RequestMapping(value = "/admin", method=RequestMethod.POST)
	public String addUser( @ModelAttribute("newUser") @Valid User newUser, BindingResult bindingResult, Model model) {
		System.out.println("SIGNUP CONTROLLER");
		
		Map<String,UserRole> roleList = UserRole.getRoleList();
		
		model.addAttribute("roleList", roleList);
		model.addAttribute("newUser", newUser);
		
		if(bindingResult.hasErrors()){
			return "admin";
		}
		if (!userService.validateNewUserUnique(newUser)) {
			bindingResult.rejectValue("username", "error.UserAlreadyExist", "User with such username already exist. Please choose a different username");
			System.out.println("Username is already exist");

			return "admin";
		}
		if (!userService.validatePasswordsEqual(newUser)) {
			bindingResult.rejectValue("password", "error.PasswordsDontMatch", "Passwords are not equal");
			System.out.println("Passwords are not equal");
			
			return "admin";
		}
		
		userService.saveUser(newUser);
		
		return "redirect:/admin";
	}
	
	@RequestMapping(value = "supplier", method=RequestMethod.GET)
	public String supplierPage(Model model) throws IOException{
		return "supplier";
	}
	
	@RequestMapping(value = "corporate", method=RequestMethod.GET)
	public String corporatePage(Model model) throws IOException{
		return "corporate";
	}
	@RequestMapping(value = "employee", method=RequestMethod.GET)
	public String employeePage(Model model) throws IOException{
		return "employee";
	}
}
