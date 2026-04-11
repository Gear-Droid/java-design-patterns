package ru.geardroid.design_patterns.pattern.bridge;

import ru.geardroid.design_patterns.entity.car.servicable.CarEngine;
import ru.geardroid.design_patterns.entity.car.servicable.engine_device.CoolingController;
import ru.geardroid.design_patterns.entity.car.servicable.engine_device.EngineStarter;
import ru.geardroid.design_patterns.entity.car.servicable.engine_device.FuelInjector;
import ru.geardroid.design_patterns.pattern.facade.ServiceableCarFacade;

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
