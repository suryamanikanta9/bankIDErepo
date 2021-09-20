package org.cap.test.bankapp;

import org.cap.dao.AccountDao;
import org.cap.dto.Account;
import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InsufficientBalanceException;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BankAppMocitoTestCase {
	
	@Mock
	private AccountDao accountDao;
	private AcccountService accountService;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		accountService=new AccountServiceImpl(accountDao);
	}
	
	@Test
	public void test_findAccountById(){
		
		Account account=new Account();
		account.setAccountNo(1001);
		Customer customer=new Customer();
		customer.setCustName("Jack");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		account.setAmount(3000);
		
		//Declaration
		Mockito.when(accountDao.findAccountById(1001))
				.thenReturn(account);
		
		
		//Actual Logic
		Account find_account=accountService.findAccountById(1001);
		
		
		//Verification
		Mockito.verify(accountDao).findAccountById(1001);
		Assert.assertEquals(account.getAmount(), find_account.getAmount(),0.0);
		
	}
	
	@Test
	public void test_withdraw() throws InsufficientBalanceException{
		
		Account account=new Account();
		account.setAccountNo(1001);
		Customer customer=new Customer();
		customer.setCustName("Jack");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		account.setAmount(3000);
		
		//Declaration
		Mockito.when(accountDao.findAccountById(1001))
				.thenReturn(account);
		
		
		//Actual Logic
		Account find_account=accountService.withdraw(1001,1500);
		
		
		//Verification
		Mockito.verify(accountDao).findAccountById(1001);
		Assert.assertEquals(1500, find_account.getAmount(),0.0);
		
	}
	
	@Test
	public void test_deposit() throws InsufficientBalanceException{
		
		Account account=new Account();
		account.setAccountNo(1001);
		Customer customer=new Customer();
		customer.setCustName("Jack");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		account.setAmount(3000);
		
		//Declaration
		Mockito.when(accountDao.findAccountById(1001))
				.thenReturn(account);
		
		
		//Actual Logic
		Account find_account=accountService.deposit(1001,2500);
		
		
		//Verification
		Mockito.verify(accountDao).findAccountById(1001);
		Assert.assertEquals(5500, find_account.getAmount(),0.0);
		
	}
	
	@Test
	public void test_AddAccount_method() throws InvalidInitialAmountException{
		
		Account account=new Account();
		//account.setAccountNo(1001);
		Customer customer=new Customer();
		customer.setCustName("Jack");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		account.setAmount(3000);
		
		
		//verification
		Mockito.when(accountDao.createAccount(account)).thenReturn(true);
		
		
		//Actual
		Account new_Account=accountService.addAccount(customer, 3000);
		
		Mockito.verify(accountDao).createAccount(account);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
