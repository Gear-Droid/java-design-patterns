package ru.geardroid.design_patterns.pattern.abstract_factory;

import ru.geardroid.design_patterns.entity.car.Lada;
import ru.geardroid.design_patterns.entity.car.Porsche;

public interface AbstractCarFactory {

    Lada getLada();
    Porsche getPorsche();
}
