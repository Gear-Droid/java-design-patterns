package ru.geardroid.designpatterns.entity.bank;

import lombok.Setter;

@Setter
public class ABank {

    private int balance;

    public int getBalance() {
        System.out.println("ABank balance = " + balance + " RUB");
        return balance;
    }
}
