package ru.geardroid.design_patterns.entity.car.servicable;

import lombok.Getter;
import ru.geardroid.design_patterns.pattern.bridge.CarEngineBridge;

public class SportEngine implements CarEngineBridge {

    public static final int SPEED_LIMIT = 300;

    @Getter
    private CarEngine engine;

    @Override
    public void startEngine() {
        engine.startEngine();
    }

    @Override
    public void stopEngine() {
        engine.stopEngine();
    }

    public void setEngine() {
        System.out.println("sport");
        engine = baseEngine(SPEED_LIMIT);
    }
}
