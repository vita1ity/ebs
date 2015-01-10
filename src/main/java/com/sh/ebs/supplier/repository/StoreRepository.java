package com.sh.ebs.supplier.repository;

import java.util.List;

import com.sh.ebs.supplier.model.Store;

public interface StoreRepository {

	List<Store> getStoresByCustomerId(long customerId);

	void saveStore(Store newStore);

	void removeStore(long storeId);

	Store getStoreById(long storeId);

	void mergeStore(Store editedStore);

}
