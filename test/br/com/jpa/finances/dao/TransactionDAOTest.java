package br.com.jpa.finances.dao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.jpa.finances.model.Account;
import br.com.jpa.finances.model.Transaction;
import br.com.jpa.finances.model.TransactionType;

public class TransactionDAOTest {

	private EntityManager manager;

	private AccountDAO accountDao;
	
	private TransactionDAO transactionDao;

	@Test
	public void shouldInsertTransaction() {
		Account conta = accountDao.find(2);
		Transaction movimentacao = new Transaction();
		movimentacao.setAccount(conta);
		movimentacao.setDate(Calendar.getInstance());
		movimentacao.setDescription("Descritivo");
		movimentacao.setTransactionType(TransactionType.IN);
		movimentacao.setValue(new BigDecimal("1000.00"));

		manager.getTransaction().begin();
		transactionDao.add(movimentacao);

		manager.getTransaction().commit();
		manager.close();
	}
}
