package com.sh.ebs.supplier.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sh.ebs.supplier.model.Product;
import com.sh.ebs.supplier.model.Store;
import com.sh.ebs.supplier.repository.ProductRepository;

@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Product> getProductsByCustomerId(long customerId) {
		TypedQuery<Product> query = em.createNamedQuery(Product.GET_PRODUCTS_BY_CUSTOMER_ID, Product.class);
		query.setParameter("customerId", customerId);
		List<Product> products = query.getResultList();
		return products;
	}

	@Override
	public void saveProduct(Product newProduct) {
		em.persist(newProduct);
		em.flush();
	}

	@Override
	public void removeProduct(long productId) {
		Product product = em.find(Product.class, productId);
		 
	    em.remove(product);
	    em.flush();
	}

	@Override
	public Product getProductById(long productId) {
		Product product = em.find(Product.class, productId);
		return product;
	}

	@Override
	public void mergeProduct(Product editedProduct) {
		em.merge(editedProduct);
		
	}
	
}
