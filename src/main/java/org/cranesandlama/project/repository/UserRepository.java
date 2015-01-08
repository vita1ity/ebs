package org.cranesandlama.project.repository;

import org.cranesandlama.project.model.User;

public interface UserRepository {
	
	void saveUser(User user);
	
	User getUserByUsername(String username);
}
