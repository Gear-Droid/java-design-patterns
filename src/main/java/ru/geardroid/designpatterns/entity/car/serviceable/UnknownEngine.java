package ru.geardroid.designpatterns.entity.car.serviceable;

import lombok.Getter;
import ru.geardroid.designpatterns.pattern.bridge.CarEngineBridge;
import ru.geardroid.designpatterns.pattern.templatemethod.CarEngineTemplate;

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
