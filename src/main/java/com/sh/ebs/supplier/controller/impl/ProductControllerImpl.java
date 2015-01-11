package com.sh.ebs.supplier.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.ebs.supplier.controller.ProductController;
import com.sh.ebs.supplier.model.Product;
import com.sh.ebs.supplier.model.Store;
import com.sh.ebs.supplier.service.ProductService;
import com.sh.ebs.supplier.service.StoreService;
import com.sh.ebs.user.model.User;

@Controller("productController")
public class ProductControllerImpl implements ProductController{
	
	@Autowired
	private ProductService productService;
	@Autowired
	private StoreService storeService;
	
	@Override
	@RequestMapping(value = "s/products", method=RequestMethod.GET)
	public String supplierProducts(Model model){
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Product> products = productService.getCustomerProducts(user.getCustomer().getCustomerId());
		model.addAttribute("products", products);
		return "supplierProducts";
	}

	@Override
	@RequestMapping(value = "s/product/add", method=RequestMethod.GET)
	public String addProductPage(Model model) {
		Product newProduct = new Product();
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Store> stores = storeService.getCustomerStores(user.getCustomer().getCustomerId());
		
		
		List<String> stringStores = new ArrayList<String>();
		for (Store store: stores) {
			stringStores.add(store.toString());
		}
		newProduct.setStringStores(stringStores);
		
		model.addAttribute("newProduct", newProduct);
		//model.addAttribute("stores", stores);
		return "supplierAddProduct";
	}

	@Override
	@RequestMapping(value = "s/product/add", method=RequestMethod.POST)
	public String addProduct(Model model, @ModelAttribute("newProduct") Product newProduct, BindingResult bindingResult) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		newProduct.setCustomer(user.getCustomer());
		
		List<Store> stores = new ArrayList<Store>();
		List<String> stringStores = newProduct.getStringStores();
		System.out.println("store size: " + stringStores.size());
		for (String stringStore: stringStores) {
			System.out.println(stringStore);
			
			if (stringStore.startsWith("Store")) {
				String[] parts = stringStore.split(" ");
		    	int storeId = Integer.parseInt(parts[1]);
		    	System.out.println("Store id = " + storeId);
		    	Store store = storeService.getStore(storeId);
		    	stores.add(store);
			}
	    	
		}
		newProduct.setStores(stores);
		
		productService.addProduct(newProduct);
		
		return "redirect:/s/products";
		
	}

	@Override
	@RequestMapping(value = "s/product/delete/{productId}")
	public String deleteProduct(@PathVariable long productId, Model model) {
		productService.deleteProduct(productId);
		return "redirect:/s/products";
	}

	@Override
	@RequestMapping(value = "s/product/edit/{productId}", method = RequestMethod.GET)
	public String editProductPage(@PathVariable long productId, Model model) {
		Product product = productService.getProduct(productId);
		List<Store> checkedStores = product.getStores();
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Store> stores = storeService.getCustomerStores(user.getCustomer().getCustomerId());
		List<String> stringStores = new ArrayList<String>();
		for (Store store: checkedStores) {
			stringStores.add(store.toString());
		}
		product.setStringStores(stringStores);
		stringStores = new ArrayList<String>();
		for (Store store: stores) {
			stringStores.add(store.toString());
		}
		
		model.addAttribute("product", product);
		model.addAttribute("stringStores", stringStores);
		return "supplierEditProduct";
	}

	@Override
	@RequestMapping(value = "s/product/edit/{productId}", method = RequestMethod.POST)
	public String editProduct(@PathVariable long productId, @ModelAttribute("product") Product editedProduct,
			BindingResult bindingResult, Model model) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		editedProduct.setCustomer(user.getCustomer());
		
		List<Store> stores = new ArrayList<Store>();
		List<String> stringStores = editedProduct.getStringStores();
		System.out.println("store size: " + stringStores.size());
		for (String stringStore: stringStores) {
			System.out.println(stringStore);
			
			if (stringStore.startsWith("Store")) {
				String[] parts = stringStore.split(" ");
		    	int storeId = Integer.parseInt(parts[1]);
		    	System.out.println("Store id = " + storeId);
		    	Store store = storeService.getStore(storeId);
		    	stores.add(store);
			}
	    	
		}
		editedProduct.setStores(stores);
		
		productService.editProduct(editedProduct);
		return "redirect:/s/products";
	}
}
