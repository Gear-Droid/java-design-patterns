package ru.geardroid.design_patterns.pattern.facade;

import lombok.extern.slf4j.Slf4j;
import ru.geardroid.design_patterns.entity.car.serviceable.CarEngine;
import ru.geardroid.design_patterns.entity.car.serviceable.engine_device.CoolingController;
import ru.geardroid.design_patterns.entity.car.serviceable.engine_device.EngineStarter;
import ru.geardroid.design_patterns.entity.car.serviceable.engine_device.FuelInjector;

import java.util.concurrent.*;

@Slf4j
public record ServiceableCarFacade(EngineStarter starter,
                                   FuelInjector fuelInjector,
                                   CoolingController coolingController,
                                   int speedLimit) implements CarEngine {

    private static final int DEFAULT_COOLING_TEMP = 90;
    private static final int MAX_ALLOWED_TEMP = 50;

    public void startEngine() {
        fuelInjector.on();
        fuelInjector.inject();
        runStarter();
        coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
        coolingController.run();
    }

    private void runStarter() {
        CompletableFuture.runAsync(starter::start)
                .exceptionally(ex -> {
                    log.error("Фоновая задача завершилась ошибкой", ex);
                    return null;
                });
    }

    public void stopEngine() {
        fuelInjector.off();
        starter.stop();
        coolingController.cool(MAX_ALLOWED_TEMP);
        coolingController.stop();
    }
}
