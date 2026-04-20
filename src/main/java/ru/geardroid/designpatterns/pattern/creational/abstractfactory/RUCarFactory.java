package ru.geardroid.designpatterns.pattern.creational.abstractfactory;

import ru.geardroid.designpatterns.entity.car.saleable.Lada;
import ru.geardroid.designpatterns.entity.car.saleable.Porsche;
import ru.geardroid.designpatterns.entity.car.saleable.RULada;
import ru.geardroid.designpatterns.entity.car.saleable.RUPorsche;

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
