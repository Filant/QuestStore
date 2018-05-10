/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.feel.queststore.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.feel.queststore.dao.TransactionDao;
import ru.feel.queststore.model.Transaction;

/**
 *
 * @author Anton
 */
@Service
public class TransactionServImpl implements TransactionService{
	private TransactionDao transDao;

	@Override
	public void addTransaction(Transaction trans) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void updateTransaction(Transaction trans) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void removeTransaction(int id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Transaction getTransactionById(int id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<Transaction> listTransaction() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}

