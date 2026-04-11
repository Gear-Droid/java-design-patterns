package ru.geardroid.design_patterns.entity.house;

import lombok.Getter;

public abstract class House {

    @Getter
    protected String info;

    public abstract int getPrice();
}
