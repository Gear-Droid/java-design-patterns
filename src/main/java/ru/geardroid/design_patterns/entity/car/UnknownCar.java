package ru.geardroid.design_patterns.entity.car;

import ru.geardroid.design_patterns.pattern.bridge.CarEngineBridge;

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
