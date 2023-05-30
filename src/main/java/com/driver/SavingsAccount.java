package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(maxWithdrawalLimit < amount)
        {
            throw new MaximumWithdrawException("Maximum Withdraw Limit Exceed");
        }
        if(amount > this.getBalance())
        {
            throw new InsufficentBalanceException("Insufficient Balance");
        }
        double bal = this.getBalance() - amount;
        this.setBalance(bal);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return this.getBalance() + this.getBalance()*rate*years/100;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double bal = this.getBalance();
        double finalAmount = Math.pow((bal*(1+(double)(rate/times))),times*years);
        return finalAmount;
    }

}
