package ru.geardroid.designpatterns.entity.car;

import ru.geardroid.designpatterns.pattern.structural.bridge.CarEngineBridge;

public class UnknownCar extends Car {

    public UnknownCar(CarEngineBridge engine) {
        super(engine);
    }

    @Override
    public void setEngine() {
        System.out.print("UnknownCar engine: ");
        engine.setEngine();
    }
}
