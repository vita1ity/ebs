package com.sh.ebs.user.service;

import com.sh.ebs.user.model.User;

public interface UserService {
	
	boolean validateNewUserUnique(User newUser); 
		
	boolean validatePasswordsEqual(User newUser);
	
	void saveUser(User user);
	
	User getUserByUsername(String username);
}
