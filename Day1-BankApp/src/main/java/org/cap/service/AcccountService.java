package org.cap.service;

import org.cap.dto.Account;
import org.cap.dto.Customer;
import org.cap.exception.InsufficientBalanceException;
import org.cap.exception.InvalidInitialAmountException;

public interface AcccountService {
	
	public Account addAccount(Customer customer,double amount)throws InvalidInitialAmountException;
	
	public Account findAccountById(int accountNo);
	
	public Account withdraw(int accountNo, double amount)throws InsufficientBalanceException;
	public Account deposit(int accountNo, double amount);
	public int addNumbers(int num1,int num2);
	public void myLoop();
}
