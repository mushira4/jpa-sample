package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaSalvaMovimentacaoComConta {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(entityManager);
		Movimentacao movimentacao = new Movimentacao();
		movimentacaoDao.adiciona(movimentacao);
		
		entityManager.getTransaction().commit();
		entityManager.close();

	}
	
}
