package ru.geardroid.designpatterns.entity.car.command;

import ru.geardroid.designpatterns.entity.car.serviceable.ServiceableCarEngine;
import ru.geardroid.designpatterns.pattern.command.CarEngineCommand;

public class StartCar extends ServiceableCarEngine implements CarEngineCommand {

    public static final String FLAG = "started";

    @Override
    public String execute() {
        startEngine();
        return FLAG;
    }
}
