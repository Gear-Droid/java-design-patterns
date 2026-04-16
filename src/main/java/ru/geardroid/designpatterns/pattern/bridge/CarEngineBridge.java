package ru.geardroid.designpatterns.pattern.bridge;

import ru.geardroid.designpatterns.entity.car.serviceable.CarEngine;
import ru.geardroid.designpatterns.entity.car.serviceable.engine_device.CoolingController;
import ru.geardroid.designpatterns.entity.car.serviceable.engine_device.EngineStarter;
import ru.geardroid.designpatterns.entity.car.serviceable.engine_device.FuelInjector;
import ru.geardroid.designpatterns.pattern.facade.ServiceableCarFacade;

public interface CarEngineBridge extends CarEngine {

    void setEngine();

    default CarEngine baseEngine(int speedLimit) {
        return new ServiceableCarFacade(
                new EngineStarter(),
                new FuelInjector(),
                new CoolingController(),
                speedLimit
        );
    }
}
