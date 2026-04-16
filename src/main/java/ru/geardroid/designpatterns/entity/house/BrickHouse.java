package ru.geardroid.designpatterns.entity.house;

public class BrickHouse extends House {

    public static final int PRICE = 25000;

    public BrickHouse() {
        info = "Кирпичный дом";
    }

    @Override
    public int getPrice() {
        return PRICE;
    }
}
