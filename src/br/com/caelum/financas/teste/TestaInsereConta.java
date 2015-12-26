package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.AccountDAO;
import br.com.caelum.financas.modelo.Account;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();

		AccountDAO contaDao = new AccountDAO(manager);
		
		Account conta = new Account();
		conta.setOwner("Jose Roberto");
		conta.setBankName("Banco do Brasil");
		conta.setNumber("12345-6");
		conta.setAgency("099");
		
		manager.getTransaction().begin();
		contaDao.add(conta);
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Adicionado com sucesso.");
	}
}
