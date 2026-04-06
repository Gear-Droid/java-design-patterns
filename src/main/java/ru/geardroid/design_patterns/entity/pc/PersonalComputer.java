package ru.geardroid.design_patterns.entity.pc;

public record PersonalComputer(Processor processor) {

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
}
