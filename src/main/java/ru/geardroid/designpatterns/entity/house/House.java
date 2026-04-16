package ru.geardroid.designpatterns.entity.house;

import lombok.Getter;

public abstract class House {

    @Getter
    protected String info;

    public abstract int getPrice();
}
