package org.cranesandlama.project.service;

import org.cranesandlama.project.model.User;

public interface UserService {
	
	boolean validateNewUserUnique(User newUser); 
		
	boolean validatePasswordsEqual(User newUser);
	
	void saveUser(User user);
	
	User getUserByUsername(String username);
}
