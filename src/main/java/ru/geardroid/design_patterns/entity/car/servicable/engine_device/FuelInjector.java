package ru.geardroid.design_patterns.entity.car.servicable.engine_device;

public class FuelInjector implements CarEngineDevice {

    private boolean isActive = false;

    @Override
    public boolean isActive() {
        return isActive;
    }

    public void on() {
        isActive = true;
    }

    public void off() {
        isActive = false;
    }

    public void inject() {
        if (isActive) {
            System.out.println("Injected fuel into engine...");
        }
    }
}
