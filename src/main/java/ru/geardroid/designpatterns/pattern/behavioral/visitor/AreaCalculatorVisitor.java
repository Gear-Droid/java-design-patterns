package ru.geardroid.designpatterns.pattern.behavioral.visitor;

import lombok.Getter;
import ru.geardroid.designpatterns.entity.shape.CircleElement;
import ru.geardroid.designpatterns.entity.shape.SquareElement;
import ru.geardroid.designpatterns.entity.shape.TriangleElement;

public class AreaCalculatorVisitor implements ShapeVisitor {

    @Getter
    private double totalArea = 0;

    @Override
    public void visit(CircleElement circle) {
        totalArea += Math.PI * Math.pow(circle.getRadius(), 2);
    }

    @Override
    public void visit(SquareElement square) {
        totalArea += Math.pow(square.getSideLength(), 2);
    }

    @Override
    public void visit(TriangleElement triangle) {
        totalArea += 0.5 * (triangle.getBaseOfTriangle() * triangle.getHeightOfTriangle());
    }
}
