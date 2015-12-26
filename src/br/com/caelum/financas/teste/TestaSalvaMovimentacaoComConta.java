package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.TransactionDAO;
import br.com.caelum.financas.modelo.Transaction;
import br.com.caelum.financas.util.JPAUtil;

public class TestaSalvaMovimentacaoComConta {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		TransactionDAO movimentacaoDao = new TransactionDAO(entityManager);
		Transaction movimentacao = new Transaction();
		movimentacaoDao.adiciona(movimentacao);
		
		entityManager.getTransaction().commit();
		entityManager.close();

	}
	
}
