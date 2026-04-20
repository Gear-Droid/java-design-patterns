package ru.geardroid.designpatterns.entity.car.serviceable;

import ru.geardroid.designpatterns.pattern.behavioral.templatemethod.CarEngineTemplate;

public class BrokenCarEngineEngine extends CarEngineTemplate {

    @Override
    public void startEngine() {
        throw new RuntimeException("Car is broken!");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stop engine...");
    }
}
