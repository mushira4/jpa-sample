package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.AccountDAO;
import br.com.caelum.financas.modelo.Account;
import br.com.caelum.financas.modelo.Transaction;
import br.com.caelum.financas.modelo.TransactionType;
import br.com.caelum.financas.util.JPAUtil;

public class TestaMovimentacao {
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		AccountDAO contaDao = new AccountDAO(entityManager);

		Account conta = contaDao.find(2);
		
		Transaction movimentacao = new Transaction();
		movimentacao.setAccount(conta);
		movimentacao.setDate(Calendar.getInstance());
		movimentacao.setDescription("Descritivo");
		movimentacao.setTransactionType(TransactionType.ENTRADA);
		movimentacao.setValue(new BigDecimal("1000.00"));
		
		entityManager.getTransaction().begin();
		entityManager.persist(movimentacao);
		
		entityManager.getTransaction().commit();
		entityManager.close();

	}
}
