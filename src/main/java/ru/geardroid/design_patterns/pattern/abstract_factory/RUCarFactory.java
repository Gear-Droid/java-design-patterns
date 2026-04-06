package ru.geardroid.design_patterns.pattern.abstract_factory;

import ru.geardroid.design_patterns.entity.car.Lada;
import ru.geardroid.design_patterns.entity.car.Porsche;
import ru.geardroid.design_patterns.entity.car.RULada;
import ru.geardroid.design_patterns.entity.car.RUPorsche;

public class RUCarFactory implements AbstractCarFactory {

    @Override
    public Lada getLada() {
        return new RULada();
    }

    @Override
    public Porsche getPorsche() {
        return new RUPorsche();
    }
}
