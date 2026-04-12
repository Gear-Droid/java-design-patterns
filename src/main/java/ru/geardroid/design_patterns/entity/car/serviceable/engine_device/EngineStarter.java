package ru.geardroid.design_patterns.entity.car.serviceable.engine_device;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class EngineStarter implements CarEngineDevice {

    public static final int WORK_TIME_SECONDS = 1;
    public static final Duration WORK_TIME_DURATION = Duration.of(WORK_TIME_SECONDS, ChronoUnit.SECONDS);

    private volatile boolean isActive;

    @Override
    public boolean isActive() {
        return isActive;
    }

    public void start() {
        isActive = true;

        try {
            Thread.sleep(WORK_TIME_DURATION.toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            isActive = false;
        }
    }

    public void stop() {
        isActive = false;
    }
}
