package br.com.jpa.finances.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.jpa.finances.model.Account;
import br.com.jpa.finances.model.Transaction;
import br.com.jpa.finances.util.JPAUtil;

public class TesteOneToMany {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		Account c1 = manager.find(Account.class, 2);
		List<Transaction> transactions = c1.getTransactions();

		for(Transaction movimentacao : transactions){
			System.out.println(movimentacao);
		}
		
		manager.close();
	}
}
