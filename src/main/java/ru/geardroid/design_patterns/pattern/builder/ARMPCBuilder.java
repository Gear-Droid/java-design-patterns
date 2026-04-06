package ru.geardroid.design_patterns.pattern.builder;

import ru.geardroid.design_patterns.entity.pc.ARMProcessor;
import ru.geardroid.design_patterns.entity.pc.PersonalComputer;

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
