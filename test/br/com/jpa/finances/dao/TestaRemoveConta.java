package br.com.jpa.finances.dao;

import javax.persistence.EntityManager;

import br.com.jpa.finances.dao.AccountDAO;
import br.com.jpa.finances.model.Account;
import br.com.jpa.finances.util.JPAUtil;

public class TestaRemoveConta {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		AccountDAO contaDao = new AccountDAO(manager);

		manager.getTransaction().begin();
		Account conta = contaDao.find(1);
		contaDao.remove(conta);
		manager.getTransaction().commit();
		manager.close();

	}
}
