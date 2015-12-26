package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		ContaDao contaDao = new ContaDao(manager);
		
		Conta conta = new Conta();
		conta.setTitular("Jose Roberto");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("12345-6");
		conta.setAgencia("099");
		
		manager.getTransaction().begin();
		contaDao.adiciona(conta);
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Adicionado com sucesso.");
	}
}
