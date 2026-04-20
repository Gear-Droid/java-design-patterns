package ru.geardroid.designpatterns.pattern.structural.decorator;

import lombok.RequiredArgsConstructor;
import ru.geardroid.designpatterns.entity.house.House;

@RequiredArgsConstructor
public class SmartHouseDecorator extends House {

    public static final int SMART_HOUSE_PRICE = 10000;

    protected final House house;

    @Override
    public int getPrice() {
        return house.getPrice() + SMART_HOUSE_PRICE;
    }

    @Override
    public String getInfo() {
        return house.getInfo() + " + система 'Умный дом'";
    }
}
