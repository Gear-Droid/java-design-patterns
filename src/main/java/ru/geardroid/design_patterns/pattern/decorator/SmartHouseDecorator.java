package ru.geardroid.design_patterns.pattern.decorator;

import lombok.RequiredArgsConstructor;
import ru.geardroid.design_patterns.entity.house.House;

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
