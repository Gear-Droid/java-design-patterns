package ru.geardroid.design_patterns.entity.car;

import lombok.Getter;
import ru.geardroid.design_patterns.pattern.bridge.CarEngineBridge;

public abstract class Car {

    @Getter
    protected CarEngineBridge engine;

    public Car(CarEngineBridge engine) {
        this.engine = engine;
    }

    abstract public void setEngine();
}
