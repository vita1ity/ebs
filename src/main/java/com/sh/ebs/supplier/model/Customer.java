package com.sh.ebs.supplier.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sh.ebs.user.model.User;

@Entity
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long customerId;
	private String name;
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<User> users = new ArrayList<User>();
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Store> stores = new ArrayList<Store>();
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
