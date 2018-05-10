/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
	public void addTransaction(Transaction trans) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(trans);
		logger.info("Transaction successfuly added: " + trans);
	}

	@Override
	public void updateTransaction(Transaction trans) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(trans);
		logger.info("Transaction successfuly update: " + trans);	}

	@Override
	public void removeTransaction(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = (Transaction) session.load(Transaction.class, new Integer(id));
		if(trans != null){
			session.delete(trans);
			logger.info("Transaction successfuly deleted: " + trans);
		}			
	}

	@Override
	public Transaction getTransById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = (Transaction) session.load(Transaction.class, new Integer(id));
		logger.info("Transaction successfuly loaded: " + trans);
		return trans;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Transaction> listTranses() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Transaction> listTrans = session.createQuery("from TRANSACTIONS").list();
		
		for(Transaction trans : listTrans){
			logger.info("Transaction info: " + trans);
		}
		return listTrans;
	}
    
}
