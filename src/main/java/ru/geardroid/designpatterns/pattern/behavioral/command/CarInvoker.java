package ru.geardroid.designpatterns.pattern.behavioral.command;

public class CarInvoker {

    public CarEngineCommand command;

    public CarInvoker(CarEngineCommand command) {
        this.command = command;
    }

    public String execute() {
        return this.command.execute();
    }
}
