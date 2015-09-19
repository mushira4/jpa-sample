package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaAlteraConta {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();

		ContaDao contaDao = new ContaDao(manager);
		manager.getTransaction().begin();
		Conta busca = contaDao.busca(2);
		busca.setTitular("Eriky");
		manager.getTransaction().commit();
		manager.close();
	}
}
