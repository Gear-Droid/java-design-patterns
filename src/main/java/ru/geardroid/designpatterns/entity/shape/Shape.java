package ru.geardroid.designpatterns.entity.shape;

import ru.geardroid.designpatterns.pattern.visitor.ShapeVisitor;

public interface Shape {

    void accept(ShapeVisitor visitor);
}
