package com.sh.ebs.supplier.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.sh.ebs.supplier.model.Store;

public interface StoreController {
	
	String supplierStores(Model model);
	
	String addStorePage(Model model);
	
	String addStore(Store newStore, BindingResult bindingResult, Model model);
	
	String deleteStore(long storeId, Model model);
	
	String editStorePage(long storeId, Model model);
	
	String editStore(long storeId, Store editedStore, BindingResult bindingResult, Model model);
}
