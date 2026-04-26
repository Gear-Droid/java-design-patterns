package ru.geardroid.designpatterns.entity.shape;

import ru.geardroid.designpatterns.pattern.behavioral.visitor.ShapeVisitor;

public interface ShapeElement {

    void accept(ShapeVisitor visitor);
}
