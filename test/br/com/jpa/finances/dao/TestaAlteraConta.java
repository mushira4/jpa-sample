package br.com.jpa.finances.dao;

import javax.persistence.EntityManager;

import br.com.jpa.finances.dao.AccountDAO;
import br.com.jpa.finances.model.Account;
import br.com.jpa.finances.util.JPAUtil;

public class TestaAlteraConta {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();

		AccountDAO contaDao = new AccountDAO(manager);
		manager.getTransaction().begin();
		Account busca = contaDao.find(2);
		busca.setOwner("Eriky");
		manager.getTransaction().commit();
		manager.close();
	}
}
