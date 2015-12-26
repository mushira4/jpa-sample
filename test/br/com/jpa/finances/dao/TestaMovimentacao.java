package br.com.jpa.finances.dao;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.jpa.finances.dao.AccountDAO;
import br.com.jpa.finances.model.Account;
import br.com.jpa.finances.model.Transaction;
import br.com.jpa.finances.model.TransactionType;
import br.com.jpa.finances.util.JPAUtil;

public class TestaMovimentacao {
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		AccountDAO contaDao = new AccountDAO(entityManager);

		Account conta = contaDao.find(2);
		
		Transaction movimentacao = new Transaction();
		movimentacao.setAccount(conta);
		movimentacao.setDate(Calendar.getInstance());
		movimentacao.setDescription("Descritivo");
		movimentacao.setTransactionType(TransactionType.IN);
		movimentacao.setValue(new BigDecimal("1000.00"));
		
		entityManager.getTransaction().begin();
		entityManager.persist(movimentacao);
		
		entityManager.getTransaction().commit();
		entityManager.close();

	}
}
