package com.sh.ebs.user.model;

import java.util.LinkedHashMap;
import java.util.Map;

public enum UserRole {
	ADMIN,
	SUPPLIER,
	CORPORATE,
	EMPLOYEE;
	
	public static Map<String,UserRole> getRoleList() {
		Map<String,UserRole> roleList = new LinkedHashMap<String,UserRole>();
		roleList.put("Admin", UserRole.ADMIN);
		roleList.put("Supplier", UserRole.SUPPLIER);
		roleList.put("Corporate", UserRole.CORPORATE);
		roleList.put("Employee", UserRole.EMPLOYEE);
		return roleList;
	}
}
