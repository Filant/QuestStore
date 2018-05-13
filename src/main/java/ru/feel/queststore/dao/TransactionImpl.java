
package ru.feel.queststore.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.feel.queststore.model.Transaction;

/**
 *
 * @author Anton
 */
@Repository
public class TransactionImpl implements TransactionDao{
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addTransaction(Transaction transaction) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(transaction);
		logger.info("Transaction successfuly added: " + transaction);
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(transaction);
		logger.info("Transaction successfuly update: " + transaction);	
	}

	@Override
	public void removeTransaction(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = (Transaction) session.load(Transaction.class, new Integer(id));
		
		if(transaction != null){
			session.delete(transaction);
			logger.info("Transaction successfuly deleted: " + transaction);
		}			
	}

	@Override
	public Transaction getTransById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = (Transaction) session.load(Transaction.class, new Integer(id));
		logger.info("Transaction successfuly loaded: " + transaction);
		return transaction;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Transaction> listTranses() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Transaction> listTrans = session.createQuery("from Transaction").list();
		
		for(Transaction transaction : listTrans){
			logger.info("Transaction info: " + transaction);
		}
		return listTrans;
	}
}
