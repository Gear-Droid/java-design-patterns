package ru.geardroid.design_patterns.entity.car.saleable;

public class RUPorsche implements Porsche {

    public static final Long PRICE = 7700000L;

    @Override
    public long getPrice() {
        return PRICE;
    }
}
