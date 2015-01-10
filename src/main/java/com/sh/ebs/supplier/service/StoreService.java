package com.sh.ebs.supplier.service;

import java.util.List;

import com.sh.ebs.supplier.model.Store;

public interface StoreService {

	 List<Store> getCustomerStores(long customerId);

	void addStore(Store newStore);

	void deleteStore(long storeId);

	Store getStore(long storeId);

	void editStore(Store editedStore);

}
