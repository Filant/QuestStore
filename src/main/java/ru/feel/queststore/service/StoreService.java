
package ru.feel.queststore.service;

import java.util.List;
import ru.feel.queststore.model.Store;

/**
 *
 * @author Anton
 */
public interface StoreService {
	public void addStore(Store store);
	
	public void updateStore(Store store);
	
	public void removeStore(int id);
	
	public Store getStoreById(int id);
	
	public List<Store> listStore();
	
	public List<Store> listStoresGroupedBy(String field, String groupBy);
}
