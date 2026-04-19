package ru.geardroid.designpatterns.entity.shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.geardroid.designpatterns.pattern.visitor.ShapeVisitor;

@Getter
@AllArgsConstructor
public class Square implements Shape {

    private double sideLength;

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
