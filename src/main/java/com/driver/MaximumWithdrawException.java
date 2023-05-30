package com.driver;

public class MaximumWithdrawException extends Exception {
    public MaximumWithdrawException(String maximumWithdrawLimitExceed) {
        super(maximumWithdrawLimitExceed);
    }
}
