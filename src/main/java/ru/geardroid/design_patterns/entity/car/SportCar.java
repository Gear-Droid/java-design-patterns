package ru.geardroid.design_patterns.entity.car;

import ru.geardroid.design_patterns.pattern.bridge.CarEngineBridge;

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
