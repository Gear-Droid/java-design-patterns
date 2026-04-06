package ru.geardroid.design_patterns.pattern.builder;

import ru.geardroid.design_patterns.entity.pc.PersonalComputer;
import ru.geardroid.design_patterns.entity.pc.X86Processor;

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
