package com.paxotech.bank;

public class CityBank {

	public static void main(String[] args) {

		String accountType;
		
		accountType = "S";
		
		IAccount account;
		if(accountType.startsWith("S")){
			account = new SavingAccount("923456");
		}
		else if(accountType.startsWith("C")){
			account = new CheckingAccount("123456");
		}
		else
		{
			throw new RuntimeException("Unknown account type");
		}
		
		
		
		
		((Account)account).setFirstName("Iftekhar");
		((Account)account).setLastName("Ivaan");
		
		account.deposit(1000);
		account.withdraw(100);
		System.out.println(account.getAccountNumber());
		System.out.println(account.getBalance());
		
		
		if(account instanceof SavingAccount) {
			System.out.println(((SavingAccount)account).getInterest());
		}
		
		
		
	}

}
