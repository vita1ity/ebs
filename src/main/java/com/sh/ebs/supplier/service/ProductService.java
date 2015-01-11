package com.sh.ebs.supplier.service;

import java.util.List;

import com.sh.ebs.supplier.model.Product;

public interface ProductService {

	List<Product> getCustomerProducts(long customerId);

	void addProduct(Product newProduct);

	void deleteProduct(long productId);

	Product getProduct(long productId);

	void editProduct(Product editedProduct);

}
