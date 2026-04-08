package ru.geardroid.design_patterns.entity.bank;

import lombok.Setter;

@Setter
public class ABank {

    private int balance;

    public int getBalance() {
        System.out.println("ABank balance = " + balance + " RUB");
        return balance;
    }
}
