package com.driver;

import javax.security.auth.login.AccountException;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;
    private String AccountNumber;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
        this.AccountNumber = "";
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(digits*9 < sum)
        {
            throw new AccountCantBeGeneratedException("Account Number can not be generated");
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < digits;i++)
        {
            int add = Math.min(9,sum);
            sb.append(add);
            sum -= add;
        }
        AccountNumber = sb.toString();
        return AccountNumber;
    }

    public void deposit(double amount) {
        balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance >= amount)
        {
            balance -= amount;
        }
        else
        {
           throw new InsufficentBalanceException("Insufficient Balance");
        }
    }

}