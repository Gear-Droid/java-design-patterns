package ru.geardroid.designpatterns.pattern.creational.abstractfactory;

import ru.geardroid.designpatterns.entity.car.saleable.Lada;
import ru.geardroid.designpatterns.entity.car.saleable.Porsche;

public interface AbstractCarFactory {

    Lada getLada();
    Porsche getPorsche();
}
