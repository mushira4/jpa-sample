package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDao {

	private EntityManager manager;

	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;
	}

	public void adiciona(Movimentacao movimentacao) {
		manager.persist(movimentacao);
	}

	public Movimentacao busca(Movimentacao movimentacao) {
		TypedQuery<Movimentacao> query = manager.createQuery("select m from Movimentcao m where m.id = :idMovimentacao", Movimentacao.class );
		query.setParameter("idMovimentacao", movimentacao.getId());
		return query.getSingleResult();
	}

	public List<Movimentacao>  lista() {
		return manager.createQuery("from Movimentcao", Movimentacao.class ).getResultList();
	}

	public void remove(Movimentacao movimentacao) {
		manager.remove(movimentacao);
	}

}
