package ru.geardroid.design_patterns.entity.car.saleable;

public class DEPorsche implements Porsche {

    public static final Long PRICE = 70000L;

    @Override
    public long getPrice() {
        return PRICE;
    }
}
