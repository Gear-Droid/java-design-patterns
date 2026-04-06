package ru.geardroid.design_patterns.entity.pc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.geardroid.design_patterns.pattern.prototype.Copyable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalComputer implements Copyable {

    private Processor processor;

    public PersonalComputer buildPowerSupply() {
        print("Ставим блок питания");
        return this;
    }

    public PersonalComputer buildMonitor() {
        print("Ставим монитор");
        return this;
    }

    public PersonalComputer buildKeyboard() {
        print("Ставим клавиатуру");
        return this;
    }

    private void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public PersonalComputer copy() {
        return new PersonalComputer(processor);
    }
}
