package ru.geardroid.designpatterns.pattern.creational.builder;

import ru.geardroid.designpatterns.entity.pc.PersonalComputer;

public abstract class PCBuilder {

    protected PersonalComputer pc;
    public abstract PersonalComputer build();
}
