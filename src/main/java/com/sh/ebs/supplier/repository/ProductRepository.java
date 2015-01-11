package com.sh.ebs.supplier.repository;

import java.util.List;

import com.sh.ebs.supplier.model.Product;

public interface ProductRepository {

	List<Product> getProductsByCustomerId(long customerId);

	void saveProduct(Product newProduct);

	void removeProduct(long productId);

	Product getProductById(long productId);

	void mergeProduct(Product editedProduct);

}
