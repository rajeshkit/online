package com.cts.ota.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.cts.ota.model.AccountDetails;

public class AccountServiceTest {
	AccountService accountService=new AccountService();
	private List<AccountDetails> accountsList = new ArrayList<AccountDetails>();

	
	@BeforeMethod
	public void setUp() {
		accountsList.add(new AccountDetails("SA000101563143", "jhondavid", "Jhon2406", 25000.00, "Savings"));
		accountsList.add(new AccountDetails("CA201405567893", "xavior", "Xavi1203", 255000.00, "Current"));
		accountsList.add(new AccountDetails("SA457901789562", "michael", "Mich1312", 75000.00, "Savings"));
		accountsList.add(new AccountDetails("CA311556768934", "lupita", "Lupi0801", 1500000.00, "Current"));
		accountsList.add(new AccountDetails("CA000601356143", "juliana", "Juli2409", 7500.00, "Current"));

	}

	@Test
	public void testGetAccountByUsername() {
		assertNotNull(accountService.getAccountByUsername("juliana"));
	}


	@AfterMethod
	public void tearDown() {
		accountsList = null;
		accountService = null;
	}


}
