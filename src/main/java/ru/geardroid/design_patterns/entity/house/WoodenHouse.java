package ru.geardroid.design_patterns.entity.house;

public class WoodenHouse extends House {

    public static final int PRICE = 15000;

    public WoodenHouse() {
        info = "Деревянный дом";
    }

    @Override
    public int getPrice() {
        return PRICE;
    }
}
