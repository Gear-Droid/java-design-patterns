package ru.geardroid.designpatterns.entity.car.serviceable;

import ru.geardroid.designpatterns.pattern.behavioral.templatemethod.CarEngineTemplate;

public class ServiceableCarEngine extends CarEngineTemplate {

    @Override
    public void startEngine() {
        System.out.println("Engine started...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Engine stopped...");
    }
}
