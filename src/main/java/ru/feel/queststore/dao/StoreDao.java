/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.feel.queststore.dao;

import java.util.List;
import ru.feel.queststore.model.Store;

/**
 *
 * @autho Anton
 */
public interface StoreDao {
	public void addStore(Store store);
	
	public void updateStore(Store store);
	
	public void removeStore(int id);
	
	public Store getStoreById(int id);
	
	public List<Store> listStores();
	
	public List<Store> listStoresGroupedBy(String field,String groupBy);
    
}
