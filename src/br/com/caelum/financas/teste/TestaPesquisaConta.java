package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaPesquisaConta {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		ContaDao contaDao = new ContaDao(manager);
		System.out.println( contaDao.busca(1).getNumero());
		
		manager.close();
	}
	
}
