package com.sh.ebs.supplier.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=Store.GET_STORES_BY_CUSTOMER_ID, 
			query="SELECT stores "
					+ "FROM Store stores "
					+ "WHERE (stores.customer.customerId = :customerId)")
})
public class Store {
	public static final String GET_STORES_BY_CUSTOMER_ID = "getStoresByCustomerId";

	@Id
	@GeneratedValue
	private long storeId;
	
	private String contactNumbers;
	private String email;
	
	private String mall;
	private String place;
	private String city;
	private String country;
	
	private double x;
	private double y;
	
	@ManyToOne
	@JoinColumn(name="customerId", insertable = true, updatable = true, nullable = false)
	private Customer customer;
	
	@ManyToMany(mappedBy = "stores")
	private List<Product> products;
	
	
	/*@ManyToMany
	@JoinColumn(name = "productId", referencedColumnName = "productId")
	private List<Product> products;*/
	
	public long getStoreId() {
		return storeId;
	}
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}
	public String getContactNumbers() {
		return contactNumbers;
	}
	public void setContactNumbers(String contactNumbers) {
		this.contactNumbers = contactNumbers;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMall() {
		return mall;
	}
	public void setMall(String mall) {
		this.mall = mall;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Store " + storeId + " [contactNumbers=" + contactNumbers + ", email=" + email
				+ ", mall=" + mall + ", place=" + place + ", city=" + city
				+ ", country=" + country + ", x=" + x + ", y=" + y + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (storeId ^ (storeId >>> 32));
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		if (storeId != other.storeId)
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	
	
	
}
