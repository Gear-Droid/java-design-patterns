package ru.geardroid.design_patterns.pattern.template_method;

import ru.geardroid.design_patterns.entity.car.serviceable.CarEngine;

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
