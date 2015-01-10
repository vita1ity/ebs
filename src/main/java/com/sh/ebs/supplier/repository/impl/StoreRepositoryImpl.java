package com.sh.ebs.supplier.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sh.ebs.supplier.model.Store;
import com.sh.ebs.supplier.repository.StoreRepository;

@Repository("storeRepository")
public class StoreRepositoryImpl implements StoreRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Store> getStoresByCustomerId(long customerId) {
		TypedQuery<Store> query = em.createNamedQuery(Store.GET_STORES_BY_CUSTOMER_ID, Store.class);
		query.setParameter("customerId", customerId);
		List<Store> stores = query.getResultList();
		return stores;
	}

	@Override
	public void saveStore(Store newStore) {
		em.persist(newStore);
		em.flush();	
	}

	@Override
	public void removeStore(long storeId) {
		Store store = em.find(Store.class, storeId);
	 
	    em.remove(store);
	    em.flush();
		
	}

	@Override
	public Store getStoreById(long storeId) {
		Store store = em.find(Store.class, storeId);
		return store;
	}

	@Override
	public void mergeStore(Store editedStore) {
		em.merge(editedStore);
	}

}
