/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.feel.queststore.service;

import java.util.List;
import ru.feel.queststore.model.Transaction;

/**
 *
 * @author Ростислав
 */
public interface TransactionService {
	
	public void addTransaction(Transaction trans);
	
	public void updateTransaction(Transaction trans);
	
	public void removeTransaction(int id);
	
	public Transaction getTransactionById(int id);
	
	public List<Transaction> listTransaction();
}
