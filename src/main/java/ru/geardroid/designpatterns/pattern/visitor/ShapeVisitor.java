package ru.geardroid.designpatterns.pattern.visitor;

import ru.geardroid.designpatterns.entity.shape.Circle;
import ru.geardroid.designpatterns.entity.shape.Square;
import ru.geardroid.designpatterns.entity.shape.Triangle;

public interface ShapeVisitor {

    void visit(Circle circle);
    void visit(Square square);
    void visit(Triangle triangle);
}
