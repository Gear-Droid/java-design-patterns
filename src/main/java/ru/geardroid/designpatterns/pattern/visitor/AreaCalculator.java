package ru.geardroid.designpatterns.pattern.visitor;

import lombok.Getter;
import ru.geardroid.designpatterns.entity.shape.Circle;
import ru.geardroid.designpatterns.entity.shape.Square;
import ru.geardroid.designpatterns.entity.shape.Triangle;

public class AreaCalculator implements ShapeVisitor {

    @Getter
    private double totalArea = 0;

    @Override
    public void visit(Circle circle) {
        totalArea += Math.PI * Math.pow(circle.getRadius(), 2);
    }

    @Override
    public void visit(Square square) {
        totalArea += Math.pow(square.getSideLength(), 2);
    }

    @Override
    public void visit(Triangle triangle) {
        totalArea += 0.5 * (triangle.getBaseOfTriangle() * triangle.getHeightOfTriangle());
    }
}
