package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.AccountDAO;
import br.com.caelum.financas.util.JPAUtil;

public class TestaPesquisaConta {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		AccountDAO contaDao = new AccountDAO(manager);
		System.out.println( contaDao.find(1).getNumber());
		
		manager.close();
	}
	
}
