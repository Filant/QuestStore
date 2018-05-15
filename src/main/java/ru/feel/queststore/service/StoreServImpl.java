
package ru.feel.queststore.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.feel.queststore.dao.StoreDao;
import ru.feel.queststore.model.Store;

/**
 *
 * @author Anton
 */
@Service
public class StoreServImpl implements StoreService{
	private StoreDao storeDao;

	public void setStoreDao(StoreDao storeDao) {
		this.storeDao = storeDao;
	}
	
	@Override
	@Transactional
	public void addStore(Store store) {
		this.storeDao.addStore(store);
	}

	@Override
	@Transactional
	public void updateStore(Store store) {
		this.storeDao.updateStore(store);
	}

	@Override
	@Transactional
	public void removeStore(int id) {
		this.storeDao.removeStore(id);
	}

	@Override
	@Transactional
	public Store getStoreById(int id) {
		return this.storeDao.getStoreById(id);
	}

	@Override
	@Transactional
	public List<Store> listStore() {
		return this.storeDao.listStores();
	}

	@Override
	@Transactional
	public List<Store> listStoresGroupedByName(String name) {
		return this.storeDao.listStoresGroupedByName(name);
	}		
}
