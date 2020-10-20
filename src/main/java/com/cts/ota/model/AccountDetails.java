package com.cts.ota.model;

public class AccountDetails {

	private String accountNumber;
	private String username;
	private String password;
	private double balance;
	private String accountType;

	public AccountDetails() {
		super();
	}

	public AccountDetails(String accountNumber, String username, String password, double balance, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "AccountDetails [accountNumber=" + accountNumber + ", username=" + username + ", password=" + password
				+ ", balance=" + balance + ", accountType=" + accountType + "]";
	}

}
