package ru.geardroid.designpatterns.entity.car.command;

import ru.geardroid.designpatterns.entity.car.serviceable.ServiceableCarEngine;
import ru.geardroid.designpatterns.pattern.command.CarEngineCommand;

public class StopCar extends ServiceableCarEngine implements CarEngineCommand {

    public static final String FLAG = "stopped";

    @Override
    public String execute() {
        startEngine();
        return FLAG;
    }
}
