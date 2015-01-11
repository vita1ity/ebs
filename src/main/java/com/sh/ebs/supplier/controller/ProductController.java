package com.sh.ebs.supplier.controller;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.sh.ebs.supplier.model.Product;

public interface ProductController {
	
	String supplierProducts(Model model);
	
	String addProductPage(Model model);
	
	String addProduct(Model model, Product newProduct, BindingResult bindingResult);
	
	String deleteProduct(long productId, Model model);
	
	String editProductPage(long productId, Model model);
	
	String editProduct(long productId, Product editedProduct, BindingResult bindingResult, Model model);
}
