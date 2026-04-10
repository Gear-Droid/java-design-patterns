package ru.geardroid.design_patterns.pattern.abstract_factory;

import ru.geardroid.design_patterns.entity.car.saleable.Lada;
import ru.geardroid.design_patterns.entity.car.saleable.Porsche;
import ru.geardroid.design_patterns.entity.car.saleable.RULada;
import ru.geardroid.design_patterns.entity.car.saleable.RUPorsche;

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
