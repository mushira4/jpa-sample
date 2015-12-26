package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Account;
import br.com.caelum.financas.modelo.Transaction;
import br.com.caelum.financas.util.JPAUtil;

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
