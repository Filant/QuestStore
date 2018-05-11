/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.feel.queststore.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.feel.queststore.dao.TransactionDao;
import ru.feel.queststore.model.Transaction;

/**
 *
 * @author Anton
 */
@Service
public class TransactionServImpl implements TransactionService{
    private TransactionDao transactionDao;

    @Override
	@Transactional
    public void addTransaction(Transaction transaction) {
		this.transactionDao.addTransaction(transaction);
    }

    @Override
	@Transactional
    public void updateTransaction(Transaction transaction) {
		this.transactionDao.updateTransaction(transaction);
    }

    @Override
	@Transactional
    public void removeTransaction(int id) {
		this.transactionDao.removeTransaction(id);
    }

    @Override
	@Transactional
    public Transaction getTransactionById(int id) {		
		return this.transactionDao.getTransById(id);
    }

    @Override
	@Transactional
    public List<Transaction> listTransaction() {
		return this.transactionDao.listTransaction();
	}

    public void setTransactionDao(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }
}

