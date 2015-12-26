package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteOneToMany {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		Conta c1 = manager.find(Conta.class, 2);
		List<Movimentacao> movimentacoes = c1.getMovimentacoes();

		for(Movimentacao movimentacao : movimentacoes  ){
			System.out.println(movimentacao);
		}
		
		manager.close();
	}
}
