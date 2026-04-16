package ru.geardroid.designpatterns.entity.car.saleable;

public class DELada implements Lada {

    public static final Long PRICE = 23000L;

    @Override
    public long getPrice() {
        return PRICE;
    }
}
