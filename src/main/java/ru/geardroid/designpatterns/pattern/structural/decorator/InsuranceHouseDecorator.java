package ru.geardroid.designpatterns.pattern.structural.decorator;

import lombok.RequiredArgsConstructor;
import ru.geardroid.designpatterns.entity.house.House;

@RequiredArgsConstructor
public class InsuranceHouseDecorator extends House {

    public static final int INSURANCE_PRICE = 1000;

    protected final House house;

    @Override
    public int getPrice() {
        return house.getPrice() + INSURANCE_PRICE;
    }

    @Override
    public String getInfo() {
        return house.getInfo() + " + страхование имущества";
    }
}
