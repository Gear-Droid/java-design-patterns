package ru.geardroid.design_patterns.pattern.facade;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.geardroid.design_patterns.entity.car.servicable.CarEngine;
import ru.geardroid.design_patterns.entity.car.servicable.CoolingController;
import ru.geardroid.design_patterns.entity.car.servicable.EngineStarter;
import ru.geardroid.design_patterns.entity.car.servicable.FuelInjector;

import java.util.concurrent.*;

@Slf4j
@Getter
@RequiredArgsConstructor
public class ServiceableCarFacade implements CarEngine {

    private static final int DEFAULT_COOLING_TEMP = 90;
    private static final int MAX_ALLOWED_TEMP = 50;

    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final EngineStarter starter;
    private final FuelInjector fuelInjector;
    private final CoolingController coolingController;

    public void startEngine() {
        fuelInjector.on();
        fuelInjector.inject();
        runStarter();
        coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
        coolingController.run();
    }

    private void runStarter() {
        CompletableFuture.runAsync(starter::start, executor)
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
