package ru.geardroid.design_patterns.entity.car;

public class RULada implements Lada {

    public static final Long PRICE = 1100000L;

    @Override
    public long getPrice() {
        return PRICE;
    }
}
