package br.com.jpa.finances.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.jpa.finances.model.Transaction;

public class TransactionDAO {

	private EntityManager manager;

	public TransactionDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void add(Transaction movimentacao) {
		manager.persist(movimentacao);
	}

	public Transaction find(Transaction movimentacao) {
		TypedQuery<Transaction> query = manager.createQuery("select m from Transaction m where m.id = :id", Transaction.class );
		query.setParameter("id", movimentacao.getId());
		return query.getSingleResult();
	}

	public List<Transaction> list() {
		return manager.createQuery("from Transaction", Transaction.class ).getResultList();
	}

	public void remove(Transaction movimentacao) {
		manager.remove(movimentacao);
	}

}
