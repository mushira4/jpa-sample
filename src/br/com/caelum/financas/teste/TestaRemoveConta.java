package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.AccountDAO;
import br.com.caelum.financas.modelo.Account;
import br.com.caelum.financas.util.JPAUtil;

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
