package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Transaction;

public class TransactionDAO {

	private EntityManager manager;

	public TransactionDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void adiciona(Transaction movimentacao) {
		manager.persist(movimentacao);
	}

	public Transaction busca(Transaction movimentacao) {
		TypedQuery<Transaction> query = manager.createQuery("select m from Transaction m where m.id = :idMovimentacao", Transaction.class );
		query.setParameter("idMovimentacao", movimentacao.getId());
		return query.getSingleResult();
	}

	public List<Transaction>  lista() {
		return manager.createQuery("from Movimentcao", Transaction.class ).getResultList();
	}

	public void remove(Transaction movimentacao) {
		manager.remove(movimentacao);
	}

}
