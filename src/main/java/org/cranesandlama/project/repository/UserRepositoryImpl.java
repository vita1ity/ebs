package org.cranesandlama.project.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.cranesandlama.project.model.User;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void saveUser(User user) {
		if (user.getUserId() == null) {
			em.persist(user);
			em.flush(); 
		}
		else {
			user = em.merge(user);
		}
	}

	@Override
	public User getUserByUsername(String username) {
		TypedQuery<User> query = em.createNamedQuery(User.GET_USER_BY_USERNAME, User.class);
		query.setParameter("username", username);
		List<User> users = query.getResultList();
		if (users.size() != 0) {
			User user = users.get(0);
			return user;
		}
		else return null;
		
	}

}
