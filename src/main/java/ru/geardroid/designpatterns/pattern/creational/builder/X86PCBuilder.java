package ru.geardroid.designpatterns.pattern.creational.builder;

import ru.geardroid.designpatterns.entity.pc.PersonalComputer;
import ru.geardroid.designpatterns.entity.pc.X86Processor;

public class X86PCBuilder extends PCBuilder {

    public X86PCBuilder() {
        pc = new PersonalComputer(new X86Processor());
    }

    @Override
    public PersonalComputer build() {
        return pc
                .buildPowerSupply()
                .buildMonitor()
                .buildKeyboard();
    }
}
