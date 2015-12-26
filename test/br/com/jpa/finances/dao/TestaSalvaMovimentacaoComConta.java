package br.com.jpa.finances.dao;

import javax.persistence.EntityManager;

import br.com.jpa.finances.dao.TransactionDAO;
import br.com.jpa.finances.model.Transaction;
import br.com.jpa.finances.util.JPAUtil;

public class TestaSalvaMovimentacaoComConta {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		TransactionDAO movimentacaoDao = new TransactionDAO(entityManager);
		Transaction movimentacao = new Transaction();
		movimentacaoDao.add(movimentacao);
		
		entityManager.getTransaction().commit();
		entityManager.close();

	}
	
}
