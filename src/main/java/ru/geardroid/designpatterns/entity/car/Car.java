package ru.geardroid.designpatterns.entity.car;

import lombok.Getter;
import ru.geardroid.designpatterns.pattern.structural.bridge.CarEngineBridge;

public abstract class Car {

    @Getter
    protected CarEngineBridge engine;

    public Car(CarEngineBridge engine) {
        this.engine = engine;
    }

    abstract public void setEngine();
}
