package ru.geardroid.design_patterns.entity.bank;

import lombok.Setter;

@Setter
public class TBank {

    private int balance;

    public int getBalance() {
        System.out.println("TBank balance = " + balance + " USD");
        return balance;
    }
}
