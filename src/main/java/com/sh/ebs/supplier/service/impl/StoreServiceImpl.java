package com.sh.ebs.supplier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sh.ebs.supplier.model.Store;
import com.sh.ebs.supplier.repository.StoreRepository;
import com.sh.ebs.supplier.service.StoreService;

@Service("storeService")
public class StoreServiceImpl implements StoreService{
	@Autowired
	private StoreRepository storeRepository;

	@Override
	public List<Store> getCustomerStores(long customerId) {
		List<Store> stores = storeRepository.getStoresByCustomerId(customerId);
		return stores;
	}

	@Override
	@Transactional
	public void addStore(Store newStore) {
		storeRepository.saveStore(newStore);
	}

	@Override
	@Transactional
	public void deleteStore(long storeId) {
		storeRepository.removeStore(storeId);
	}

	@Override
	public Store getStore(long storeId) {
		
		return storeRepository.getStoreById(storeId);
	}

	@Override
	@Transactional
	public void editStore(Store editedStore) {
		storeRepository.mergeStore(editedStore);
	}
	
}
