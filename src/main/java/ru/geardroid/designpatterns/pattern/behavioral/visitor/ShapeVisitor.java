package ru.geardroid.designpatterns.pattern.behavioral.visitor;

import ru.geardroid.designpatterns.entity.shape.CircleElement;
import ru.geardroid.designpatterns.entity.shape.SquareElement;
import ru.geardroid.designpatterns.entity.shape.TriangleElement;

public interface ShapeVisitor {

    void visit(CircleElement circle);
    void visit(SquareElement square);
    void visit(TriangleElement triangle);
}
