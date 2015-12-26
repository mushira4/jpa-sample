package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.AccountDAO;
import br.com.caelum.financas.modelo.Account;
import br.com.caelum.financas.util.JPAUtil;

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
