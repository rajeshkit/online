package com.cts.ota.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.ota.model.AccountDetails;

@Service
public class AccountService {
	private static List<AccountDetails> accountsList = new ArrayList<AccountDetails>();

	static {
		accountsList.add(new AccountDetails("SA000101563143", "jhondavid", "Jhon2406", 25000.00, "Savings"));
		accountsList.add(new AccountDetails("CA201405567893", "xavior", "Xavi1203", 255000.00, "Current"));
		accountsList.add(new AccountDetails("SA457901789562", "michael", "Mich1312", 75000.00, "Savings"));
		accountsList.add(new AccountDetails("CA311556768934", "lupita", "Lupi0801", 1500000.00, "Current"));
		accountsList.add(new AccountDetails("CA000601356143", "juliana", "Juli2409", 7500.00, "Current"));
	}

	public String checkAccountType(String accountNumber) {
		String accountType = "";
		for (AccountDetails accountDetails : accountsList) {
			if (accountDetails.getAccountNumber().equalsIgnoreCase(accountNumber)) {
				accountType = accountDetails.getAccountType();
			}
		}
		// Add Exception handling code here for invalid account number
		System.out.println("Account Type of " + accountNumber + " is :" + accountType);
		return accountType;
	}

	public boolean validateUser(String userName, String password) {
		boolean loginStatus = false;
		for (AccountDetails accountDetails : accountsList) {
			if (accountDetails.getUsername().equalsIgnoreCase(userName)) {
				if (accountDetails.getPassword().equals(password)) {
					loginStatus = true;
				}
			}
		}
		System.out.println("Login Status : " + loginStatus);
		return loginStatus;
	}

	public AccountDetails getAccountByUsername(String username) {
		AccountDetails accountDetail = new AccountDetails();
		for (AccountDetails accountDetails : accountsList) {
			if (accountDetails.getUsername().equalsIgnoreCase(username)) {
				accountDetail = accountDetails;
			}
		}
		return accountDetail;

	}
}
