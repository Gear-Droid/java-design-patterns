package ru.geardroid.designpatterns.pattern.abstractfactory;

import ru.geardroid.designpatterns.entity.car.saleable.DELada;
import ru.geardroid.designpatterns.entity.car.saleable.DEPorsche;
import ru.geardroid.designpatterns.entity.car.saleable.Lada;
import ru.geardroid.designpatterns.entity.car.saleable.Porsche;

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
