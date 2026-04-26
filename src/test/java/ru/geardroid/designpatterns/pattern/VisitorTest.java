package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.designpatterns.entity.shape.CircleElement;
import ru.geardroid.designpatterns.entity.shape.ShapeElement;
import ru.geardroid.designpatterns.entity.shape.SquareElement;
import ru.geardroid.designpatterns.entity.shape.TriangleElement;
import ru.geardroid.designpatterns.pattern.behavioral.visitor.AreaCalculatorVisitor;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VisitorTest {

    private static final double PRECISION = 0.001;
    private static final double CIRCLE_RADIUS = 5;
    private static final double SQUARE_SIDE = 4;
    private static final double TRIANGLE_BASE = 3;
    private static final double TRIANGLE_HEIGHT = 6;
    private static final List<ShapeElement> SHAPE_ELEMENTS = List.of(
            new CircleElement(CIRCLE_RADIUS),
            new SquareElement(SQUARE_SIDE),
            new TriangleElement(TRIANGLE_BASE, TRIANGLE_HEIGHT)
    );

    @Test
    void givenShapesAreaCalculator_whenAcceptCalculatorForEachShape_thenCorrectArea() {
        // given:
        double expectedArea = 103.54;
        AreaCalculatorVisitor areaCalculator = new AreaCalculatorVisitor();
        // when:
        SHAPE_ELEMENTS.forEach(shapeElement -> shapeElement.accept(areaCalculator));
        // then:
        assertThat(Math.abs(expectedArea - areaCalculator.getTotalArea()))
                .isLessThan(PRECISION);
    }
}
