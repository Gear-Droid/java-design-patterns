package ru.geardroid.design_patterns.pattern.builder;

import ru.geardroid.design_patterns.entity.pc.PersonalComputer;

public abstract class PCBuilder {

    protected PersonalComputer pc;
    public abstract PersonalComputer build();
}
