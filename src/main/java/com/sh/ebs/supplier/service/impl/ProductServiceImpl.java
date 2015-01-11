package com.sh.ebs.supplier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sh.ebs.supplier.model.Product;
import com.sh.ebs.supplier.repository.ProductRepository;
import com.sh.ebs.supplier.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getCustomerProducts(long customerId) {
		
		return productRepository.getProductsByCustomerId(customerId);
	}
	
	@Override
	@Transactional
	public void addProduct(Product newProduct) {
		productRepository.saveProduct(newProduct);
		
	}

	@Override
	@Transactional
	public void deleteProduct(long productId) {
		productRepository.removeProduct(productId);
	}

	@Override
	public Product getProduct(long productId) {
		return productRepository.getProductById(productId);
	}

	@Override
	@Transactional
	public void editProduct(Product editedProduct) {
		productRepository.mergeProduct(editedProduct);
		
	}

}
