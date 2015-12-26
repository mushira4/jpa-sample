package br.com.jpa.finances.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.jpa.finances.model.Account;

public class AccountDAO {

	private EntityManager entityManager;

	public AccountDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Account find(int id){
		return this.entityManager.find(Account.class, id);
	}
	
	public List<Account>list(){
		return this.entityManager.createQuery("from Account", Account.class).getResultList();
	}
	
	public void add(Account conta){
		this.entityManager.persist(conta);
	}
	
	public void remove(Account conta){
		this.entityManager.remove(conta);
	}

}
