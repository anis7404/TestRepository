package com.paxotech.bank;

public interface IAccount {
	
	public abstract void deposit(float amount);
	public abstract void withdraw(float amount);
	public abstract float getBalance();
	public abstract String getAccountNumber();

}
