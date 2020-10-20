package com.cts.ota.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.ota.model.AccountDetails;
import com.cts.ota.service.AccountService;

@SpringBootTest
public class AccountDetailsDomainTest {
	static AccountDetails accountDetails = null;

	AccountService accountService = new AccountService();

	@BeforeAll
	public static void setUp() {
		accountDetails = new AccountDetails();
		accountDetails.setAccountNumber("SA000101563143");
		accountDetails.setUsername("jhondavid");
		accountDetails.setPassword("Jhon2406");
		accountDetails.setAccountType("Savings");
		accountDetails.setBalance(25000);
	}

	@Test
	public void TestExpectedUsername() {
		String expectedName = "jhondavid";
		assertEquals(expectedName, accountDetails.getUsername());
	}

	@Test
	public void TestPassword() {
		String expectedPassword = "Jhon2406";
		assertEquals(expectedPassword, accountDetails.getPassword());
	}

	@Test
	public void TestExpectedAccountNumber() {
		String expectedAccountNumber = "SA000101563143";
		assertEquals(expectedAccountNumber, accountDetails.getAccountNumber());
	}

	@Test
	public void TestExpectedAccountType() {
		String expectedAccountType = "Savings";
		assertEquals(expectedAccountType, accountDetails.getAccountType());
	}

	@Test
	public void TestExpectedBalance() {
		double expectedBalance = 25000;
		assertEquals(expectedBalance, accountDetails.getBalance());
	}

	@AfterAll
	public static void tearDown() {
		accountDetails = null;
	}
}
