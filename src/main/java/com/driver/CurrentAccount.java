package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only
    private HashMap<Character,Integer> hm = new HashMap<>();

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId = tradeLicenseId;
        if(balance < this.getMinBalance())
        {
            throw new InsufficentBalanceException("Insufficient Balance");
        }
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int n = tradeLicenseId.length();
        int wordLimit = (n+1)/2;
        for(int i = 0;i < n;i++)
        {
            char ch = tradeLicenseId.charAt(i);
            if(hm.containsKey(tradeLicenseId.charAt(i)))
            {
                int quan = hm.get(tradeLicenseId.charAt(i));
                if(quan == wordLimit)
                {
                    throw new InvalidLicenseException("Valid License can not be generated");
                }
                hm.put(ch,hm.get(ch)+1);
            }
            else
            {
               hm.put(ch,1);
            }
        }
        char[] licenseId = new char[n];
        int index = 0;
        for(Character key:hm.keySet())
        {
            int times = hm.get(key);
            for(int i = 0;i < times;i++)
            {
                if(index >= n)index = 1;
                licenseId[index] = key;
                index += 2;
            }
        }
        tradeLicenseId = licenseId.toString();
    }

}
