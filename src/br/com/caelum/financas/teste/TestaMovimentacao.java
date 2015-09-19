package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaMovimentacao {
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		ContaDao contaDao = new ContaDao(entityManager);

		Conta conta = contaDao.busca(2);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Descritivo");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal("1000.00"));
		
		entityManager.getTransaction().begin();
		entityManager.persist(movimentacao);
		
		entityManager.getTransaction().commit();
		entityManager.close();

	}
}
