package com.paxotech.bank;

public abstract class Account {
	
	protected String firstName;
	protected String lastName;
	protected String accountNumber;
	
	protected float balance;
	
	public Account(String accountNumber){
		setAccountNumber(accountNumber);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public abstract float getBalance();
	

}
