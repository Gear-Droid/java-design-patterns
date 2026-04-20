package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.designpatterns.entity.shape.Circle;
import ru.geardroid.designpatterns.entity.shape.Shape;
import ru.geardroid.designpatterns.entity.shape.Square;
import ru.geardroid.designpatterns.entity.shape.Triangle;
import ru.geardroid.designpatterns.pattern.behavioral.visitor.AreaCalculator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VisitorTest {

    private static final double PRECISION = 0.001;
    private static final double CIRCLE_RADIUS = 5;
    private static final double SQUARE_SIDE = 4;
    private static final double TRIANGLE_BASE = 3;
    private static final double TRIANGLE_HEIGHT = 6;
    private static final List<Shape> SHAPES = List.of(
            new Circle(CIRCLE_RADIUS),
            new Square(SQUARE_SIDE),
            new Triangle(TRIANGLE_BASE, TRIANGLE_HEIGHT)
    );

    @Test
    void givenShapesAreaCalculator_whenAcceptCalculatorForEachShape_thenCorrectArea() {
        // given:
        double expectedArea = 103.54;
        AreaCalculator areaCalculator = new AreaCalculator();
        // when:
        SHAPES.forEach(shape -> shape.accept(areaCalculator));
        // then:
        assertThat(Math.abs(expectedArea - areaCalculator.getTotalArea()))
                .isLessThan(PRECISION);
    }
}
