package ru.geardroid.designpatterns.entity.car.serviceable;

import lombok.Getter;
import ru.geardroid.designpatterns.pattern.structural.bridge.CarEngineBridge;
import ru.geardroid.designpatterns.pattern.behavioral.templatemethod.CarEngineTemplate;

public class UnknownEngine extends CarEngineTemplate implements CarEngineBridge {

    public static final int SPEED_LIMIT = 150;

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

    public void setEngine(){
        System.out.println("unknown");
        engine = baseEngine(SPEED_LIMIT);
    }
}
