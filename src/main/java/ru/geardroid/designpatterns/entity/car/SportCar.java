package ru.geardroid.designpatterns.entity.car;

import ru.geardroid.designpatterns.pattern.structural.bridge.CarEngineBridge;

public class SportCar extends Car {

    public SportCar(CarEngineBridge engine) {
        super(engine);
    }

    @Override
    public void setEngine() {
        System.out.print("SportCar engine: ");
        engine.setEngine();
    }
}
