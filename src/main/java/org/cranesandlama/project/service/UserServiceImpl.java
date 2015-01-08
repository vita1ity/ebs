package org.cranesandlama.project.service;

import org.cranesandlama.project.model.User;
import org.cranesandlama.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	public boolean validateNewUserUnique(User newUser) {
		User dbUser = userRepository.getUserByUsername(newUser.getUsername());
		if (dbUser != null) {
			return false;
		}
		else return true;
		
	}
	public boolean validatePasswordsEqual(User newUser) {
		if (!(newUser.getPassword().equals(newUser.getConfirmPassword()))) {
			return false;
		}
		else return true;
	}
	
	@Override
	@Transactional
	public void saveUser(User user) {
		String passwordString = user.getPassword() + "{" + user.getUsername() + "}";
		System.out.println(passwordString);
		String hashedPassword = org.apache.commons.codec.digest.DigestUtils.sha256Hex(passwordString);
		user.setPassword(hashedPassword);
		userRepository.saveUser(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}

}
