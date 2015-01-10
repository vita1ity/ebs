package com.sh.ebs.supplier.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@Override
	public String toString() {
		return "Store [contactNumbers=" + contactNumbers + ", email=" + email
				+ ", mall=" + mall + ", place=" + place + ", city=" + city
				+ ", country=" + country + ", x=" + x + ", y=" + y + "]";
	}
	
	
}
