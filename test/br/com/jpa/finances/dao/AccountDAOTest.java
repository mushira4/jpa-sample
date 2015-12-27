package br.com.jpa.finances.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import br.com.jpa.finances.model.Account;
import br.com.jpa.finances.model.Transaction;
import br.com.jpa.finances.util.JPAUtil;

public class AccountDAOTest {

	private EntityManager manager;

	private AccountDAO accountDao;

	@Before
	public void before() {
		manager = JPAUtil.getEntityManager();
		accountDao = new AccountDAO(manager);
	}

	@Test
	public void shouldSaveAccountData() {
		Account account = new Account();
		account.setOwner("Jose Roberto");
		account.setBankName("Banco do Brasil");
		account.setNumber("12345-6");
		account.setAgency("099");

		manager.getTransaction().begin();
		accountDao.add(account);
		manager.getTransaction().commit();
		manager.close();

		System.out.println(account.getId());
	}

	@Test
	public void shouldUpdateAccountData() {
		Account account = accountDao.find(2);
				
		manager.getTransaction().begin();
		account.setOwner("Eriky");
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println(account.getOwner());
	}
	
	@Test
	public void shouldFindAccountsIntoDatabase(){
		System.out.println(accountDao.find(1).getNumber());
	}
	
	@Test
	public void shouldRemoveAccountData(){
		manager.getTransaction().begin();
		Account conta = accountDao.find(1);
		accountDao.remove(conta);
		manager.getTransaction().commit();

	}

	@Test
	public void shouldReturnAllTransactionsOfTheAccount(){
		Account c1 = accountDao.find(2);
		List<Transaction> transactions = c1.getTransactions();

		for(Transaction movimentacao : transactions){
			System.out.println(movimentacao);
		}
		
		manager.close();
	}
	
}
