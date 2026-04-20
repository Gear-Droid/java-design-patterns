package ru.geardroid.designpatterns.pattern.behavioral.templatemethod;

import ru.geardroid.designpatterns.entity.car.serviceable.CarEngine;

public abstract class CarEngineTemplate implements CarEngine {

    public boolean checkStart() {
        try {
            startEngine();
        } catch (RuntimeException e) {
            return false;
        } finally {
            stopEngine();
        }

        return true;
    }
}
