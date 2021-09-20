package org.cap.test.bankapp;

import static org.junit.Assert.*;

import org.cap.dto.Customer;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BankAppTestCase {

	private AcccountService accountService;
	
	@BeforeClass
	public static void beforeClass_method(){
		//System.out.println("BeforeClass Method.");
	}
	
	@AfterClass
	public static void afterClass_method(){
		//System.out.println("AfterClass Method.");
	}
	
	@Before
	public void setUp(){
		//System.out.println("SetUp Before Method.");
		accountService=new AccountServiceImpl();
		
	}
	
	@After
	public void tearDown(){
	//	System.out.println("TearDown After Method.");
		
	}
	@Category(LoginCategory.class)
	@Test
	public void test_add_numbers_method() {
		
		
		assertEquals(50,accountService.addNumbers(30, 20));
	}

	@Category(LoginCategory.class)
	@Test(expected=IllegalArgumentException.class)
	public void test_add_Account_with_null_customer() throws InvalidInitialAmountException{
		//accountService=new AccountServiceImpl();
		
		Customer customer=null;
		
		accountService.addAccount(customer, 1000);
	}
	
	@Category(ReportCategory.class)
	@Test(expected=InvalidInitialAmountException.class)
	public void test_add_Account_with_null_low_balance() throws InvalidInitialAmountException{
		//accountService=new AccountServiceImpl();
		
		Customer customer=new Customer();
		customer.setCustName("Tom");
		
		accountService.addAccount(customer, 100);
	}
	
	@Ignore
	@Test(timeout=3)
	public void test_myloop(){
		accountService.myLoop();
	}
	
	
	
	
	
	
	
}