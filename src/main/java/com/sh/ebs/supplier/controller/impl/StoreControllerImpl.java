package com.sh.ebs.supplier.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.ebs.supplier.controller.StoreController;
import com.sh.ebs.supplier.model.Store;
import com.sh.ebs.supplier.service.StoreService;
import com.sh.ebs.user.model.User;
@Controller("storeController")
public class StoreControllerImpl implements StoreController{
	@Autowired 
	private StoreService storeService;
	
	@Override
	@RequestMapping(value = "s/stores", method=RequestMethod.GET)
	public String supplierStores(Model model){
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Store> stores = storeService.getCustomerStores(user.getCustomer().getCustomerId());
		model.addAttribute("stores", stores);
		return "supplierStores";
	}

	@Override
	@RequestMapping(value="s/store/add", method=RequestMethod.GET)
	public String addStorePage(Model model) {
		Store newStore = new Store();
		model.addAttribute("newStore", newStore);
		return "supplierAddStore";
	}

	@Override
	@RequestMapping(value="s/store/add", method=RequestMethod.POST)
	public String addStore(@ModelAttribute("newStore") @Valid Store newStore, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			return "supplierAddStore";
		}
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		newStore.setCustomer(user.getCustomer());
		storeService.addStore(newStore);
		return "redirect:/s/stores";
	}

	@Override
	@RequestMapping(value="s/store/delete/{storeId}", method=RequestMethod.GET)
	public String deleteStore(@PathVariable long storeId, Model model) {
		storeService.deleteStore(storeId);
		return "redirect:/s/stores";
	}

	@Override
	@RequestMapping(value="s/store/edit/{storeId}", method=RequestMethod.GET)
	public String editStorePage(@PathVariable long storeId, Model model) {
		Store store = storeService.getStore(storeId);
		model.addAttribute("store", store);
		return "supplierEditStore";
	}

	@Override
	@RequestMapping(value="s/store/edit/{storeId}", method=RequestMethod.POST)
	public String editStore(@PathVariable long storeId, @ModelAttribute("store") 
		@Valid Store editedStore, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			return "supplierEditStore";
		}
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		editedStore.setCustomer(user.getCustomer());
		storeService.editStore(editedStore);
		return "redirect:/s/stores";
	}

}
