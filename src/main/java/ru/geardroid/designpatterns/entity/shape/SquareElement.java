package ru.geardroid.designpatterns.entity.shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.geardroid.designpatterns.pattern.behavioral.visitor.ShapeVisitor;

@Getter
@AllArgsConstructor
public class SquareElement implements ShapeElement {

    private double sideLength;

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
