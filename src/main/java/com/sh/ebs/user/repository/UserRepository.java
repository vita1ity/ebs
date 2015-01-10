package com.sh.ebs.user.repository;

import com.sh.ebs.user.model.User;

public interface UserRepository {
	
	void saveUser(User user);
	
	User getUserByUsername(String username);
}
