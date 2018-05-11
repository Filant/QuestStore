/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.feel.queststore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.feel.queststore.model.Transaction;
import ru.feel.queststore.service.TransactionService;

/**
 *
 * @author Anton
 */
@Controller
public class TransactionController {
	private TransactionService transactionService;
	
	@Autowired(required = true)
	@Qualifier(value = "transactionService")
	public void setTransService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@RequestMapping(value = "transactions", method = RequestMethod.GET)
	public String listTransaction(Model model){
		model.addAttribute("transaction", new Transaction());
		model.addAttribute("listTransaction", this.transactionService.listTransaction());
		return "transactions";
	}
	
	@RequestMapping(value = "transactions/add", method = RequestMethod.POST)
	public String addTransaction(@ModelAttribute("transaction") Transaction transaction){
		if(transaction.getId() == 0){
			this.transactionService.addTransaction(transaction);
		}else{
			this.transactionService.updateTransaction(transaction);
		}
		
		return "redirect:/transactions";
	}
	
	@RequestMapping("/remove/{id}")
	public String removeTransaction(@PathVariable("id") int id){
		this.transactionService.removeTransaction(id);
		
		return "redirect:/transactions";
	}
	
	@RequestMapping("edit/{id}")
	public String editTransaction(@PathVariable("id") int id, Model model){
		model.addAttribute("transaction", this.transactionService.getTransactionById(id));
		model.addAttribute("listTransaction", this.transactionService.listTransaction());
		
		return "transactions";
	}
	
	@RequestMapping("transactiondata/{id}")
	public String transactionData(@PathVariable("id") int id, Model model){
		model.addAttribute("transaction", this.transactionService.getTransactionById(id));
		
		return "transactiondata";
	}
}

