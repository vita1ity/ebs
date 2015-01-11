package com.sh.ebs.supplier.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity
@NamedQueries({
	@NamedQuery(name=Product.GET_PRODUCTS_BY_CUSTOMER_ID, 
			query="SELECT products "
					+ "FROM Product products "
					+ "WHERE (products.customer.customerId = :customerId)")
})
public class Product {
	public static final String GET_PRODUCTS_BY_CUSTOMER_ID = "getProductsByCustomerId";

	@Id
	@GeneratedValue
	private long productId;
	
	private String productName;
	private String description;
	private boolean validity = true;
	
	@JoinTable(name = "product_store", 
            joinColumns = { 
                   @JoinColumn(name = "productId", referencedColumnName = "productId")
            }, 
            inverseJoinColumns = { 
                   @JoinColumn(name = "storeId", referencedColumnName = "storeId")
            }
     )
    @ManyToMany
    private List<Store> stores;
	
	@Transient
	private List<String> stringStores;	
	
	@ManyToOne
	@JoinColumn(name="customerId", insertable = true, updatable = true, nullable = false)
	private Customer customer;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public List<String> getStringStores() {
		return stringStores;
	}
	public void setStringStores(List<String> stringStores) {
		this.stringStores = stringStores;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public boolean isValidity() {
		return validity;
	}

	public void setValidity(boolean validity) {
		this.validity = validity;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("Product [productId=" + productId + ", productName="
				+ productName + ", description=" + description + "]<br>");
		str.append("Product is available in the following stores: <br>");
		if (stores != null) {
			for (Store store: stores) {
				str.append(store + "<br>");
			}
		}
		return str.toString();
		/*String res = "Product [productId=" + productId + ", productName="
				+ productName + ", description=" + description + "]\n";
		res += "Product is available in the following stores: \n";
		for (Store store: stores) {
			res += store + "\n";
		}
		return res;*/
	}
}
