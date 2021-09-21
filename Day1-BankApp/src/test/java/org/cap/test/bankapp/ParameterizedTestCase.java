package org.cap.test.bankapp;

import java.util.Arrays;
import java.util.List;

import org.cap.dto.Account;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTestCase {
	
	private AcccountService account=new AccountServiceImpl();
	
	private int input1;
	private int input2;
	private int output;
	
	public ParameterizedTestCase(int input1, int input2, int output) {
		super();
		this.input1 = input1;
		this.input2 = input2;
		this.output = output;
	}
	
	@Parameters
	public static List<Object[]> myInputs(){
		return Arrays.asList(new Object[][]{
			{2,2,4},
			{-1,-3,-4},
			{0,5,5}
		});
	}
	
	@Test
	public void test_AddNumbers(){
		Assert.assertEquals(output, account.addNumbers(input1, input2));
	}
	

}
