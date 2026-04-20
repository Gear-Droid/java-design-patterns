package ru.geardroid.designpatterns.pattern.creational.builder;

import ru.geardroid.designpatterns.entity.pc.ARMProcessor;
import ru.geardroid.designpatterns.entity.pc.PersonalComputer;

public class ARMPCBuilder extends PCBuilder {

    public ARMPCBuilder() {
        pc = new PersonalComputer(new ARMProcessor());
    }

    @Override
    public PersonalComputer build() {
        return pc
                .buildPowerSupply()
                .buildMonitor()
                .buildKeyboard();
    }
}
