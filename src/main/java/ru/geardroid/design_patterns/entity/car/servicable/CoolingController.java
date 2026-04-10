package ru.geardroid.design_patterns.entity.car.servicable;

public class CoolingController implements CarEngineDevice {

    private boolean isActive = false;

    @Override
    public boolean isActive() {
        return isActive;
    }

    public void run() {
        isActive = true;
    }

    public void stop() {
        isActive = false;
    }

    public void setTemperatureUpperLimit(int defaultCoolingTemp) {
        if (isActive) {
            System.out.printf("Keep engine temperature near %d temperature...", defaultCoolingTemp);
        }
    }

    public void cool(int maxAllowedTemp) {
        if (isActive) {
            System.out.printf("Cooling engine to %d temperature...", maxAllowedTemp);
        }
    }
}
