package com.paxotech.bank;

public class CheckingAccount extends Account implements IAccount{

	public CheckingAccount(String accountNumber) {
		super(accountNumber);
	}

	@Override
	public void deposit(float amount) {
		balance = balance + amount;
	}

	@Override
	public void withdraw(float amount) {
		balance = balance - amount;
	}

	@Override
	public float getBalance() {
		return balance;
	}

}
