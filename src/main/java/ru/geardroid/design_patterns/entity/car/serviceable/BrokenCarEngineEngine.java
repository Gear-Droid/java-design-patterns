package ru.geardroid.design_patterns.entity.car.serviceable;

import ru.geardroid.design_patterns.pattern.template_method.CarEngineTemplate;

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
