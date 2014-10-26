package com.paxotech.bank;

public class SavingAccount extends Account implements IAccount{

	public SavingAccount(String accountNumber) {
		super(accountNumber);
	}

	@Override
	public void deposit(float amount) {
		balance = balance + amount;
	}

	@Override
	public void withdraw(float amount) {
		balance = balance - (amount + 1);
	}

	@Override
	public float getBalance() {
		return balance;
	}
	
	public float getInterest(){
		return (float) (balance * .01);
	}

}
