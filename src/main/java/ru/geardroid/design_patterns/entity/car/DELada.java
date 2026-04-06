package ru.geardroid.design_patterns.entity.car;

public class DELada implements Lada {

    public static final Long PRICE = 23000L;

    @Override
    public long getPrice() {
        return PRICE;
    }
}
