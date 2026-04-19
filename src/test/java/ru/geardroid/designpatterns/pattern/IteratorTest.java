package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.designpatterns.entity.numbers.FibonacciNumbers;
import ru.geardroid.designpatterns.pattern.iterator.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

public class IteratorTest {

    private static final FibonacciNumbers FIBONACCI = new FibonacciNumbers();

    @Test
    void givenFibonacciIterator_whenGetLastElement_thenCorrectValue() {
        // given:
        Iterator iterator = FIBONACCI.getIterator();
        int expectedLastElement = FibonacciNumbers.getMaxValue();
        // when:
        int element = 0;
        while (iterator.hasNext()) {
            element = (int) iterator.next();
        }
        // then:
        assertThat(element)
                .isEqualTo(expectedLastElement);
    }
}
