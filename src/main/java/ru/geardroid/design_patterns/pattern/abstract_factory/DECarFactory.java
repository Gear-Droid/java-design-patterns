package ru.geardroid.design_patterns.pattern.abstract_factory;

import ru.geardroid.design_patterns.entity.car.DELada;
import ru.geardroid.design_patterns.entity.car.DEPorsche;
import ru.geardroid.design_patterns.entity.car.Lada;
import ru.geardroid.design_patterns.entity.car.Porsche;

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
