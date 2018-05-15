
package ru.feel.queststore.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.feel.queststore.model.Store;

/**
 *
 * @author Anton
 */
@Repository
public class StoreImpl implements StoreDao{
	
	private static final Logger logger = LoggerFactory.getLogger(StoreImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addStore(Store store) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(store);
		logger.info("Store successfuly added: " + store);
	}

	@Override
	public void updateStore(Store store) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(store);
		logger.info("Store successfuly update: " + store);
	}

	@Override
	public void removeStore(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Store store = (Store) session.load(Store.class, new Integer(id));
		
		if(store != null){
			session.delete(store);
			logger.info("Store successfuly deleted: " + store);
		}
	}

	@Override
	public Store getStoreById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Store store = (Store) session.load(Store.class, new Integer(id));
		
		logger.info("Store successfuly loaded: " + store);
		return store;
	}

	@Override
	public List<Store> listStores() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Store> list = session.createQuery("from Store").list();
		
		for(Store store: list){
			logger.info("Store info: " + store);
		}
		return list;
	}

	@Override
	public List<Store> listStoresGroupedBy(String field, String groupBy) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Store.class);
		criteria.add(Restrictions.eq(field, groupBy));		
		List<Store> list = criteria.list();	
		
		return list;
	}
	
	
}
