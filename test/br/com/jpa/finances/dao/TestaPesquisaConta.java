package br.com.jpa.finances.dao;

import javax.persistence.EntityManager;

import br.com.jpa.finances.dao.AccountDAO;
import br.com.jpa.finances.util.JPAUtil;

public class TestaPesquisaConta {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		AccountDAO contaDao = new AccountDAO(manager);
		System.out.println( contaDao.find(1).getNumber());
		
		manager.close();
	}
	
}
