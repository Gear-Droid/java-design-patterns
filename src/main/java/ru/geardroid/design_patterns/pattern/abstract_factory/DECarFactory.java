package ru.geardroid.design_patterns.pattern.abstract_factory;

import ru.geardroid.design_patterns.entity.car.saleable.DELada;
import ru.geardroid.design_patterns.entity.car.saleable.DEPorsche;
import ru.geardroid.design_patterns.entity.car.saleable.Lada;
import ru.geardroid.design_patterns.entity.car.saleable.Porsche;

public class DECarFactory implements AbstractCarFactory {

    @Override
    public Lada getLada() {
        return new DELada();
    }

    @Override
    public Porsche getPorsche() {
        return new DEPorsche();
    }
}
