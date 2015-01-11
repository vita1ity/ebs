package com.sh.ebs.supplier.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.sh.ebs.supplier.model.Store;
import com.sh.ebs.supplier.service.StoreService;

public class StringToStoreConverter implements Converter<String, Store> {

    @Autowired
    StoreService storeService;

    @Override
    public Store convert(String source) {
    	Store store = new Store();
    	String[] parts = source.split(" ");
    	int storeId = Integer.parseInt(parts[1]);
    	System.out.println("Store id = " + storeId);
    	
        return store;
    }
}