package ru.geardroid.design_patterns.pattern.decorator;

import lombok.RequiredArgsConstructor;
import ru.geardroid.design_patterns.entity.house.House;

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
