package ru.geardroid.design_patterns.pattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;
import ru.geardroid.design_patterns.pattern.flyweight.Flyweight;
import ru.geardroid.design_patterns.pattern.flyweight.FlyweightFactory;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FlyweightTest {

    private static final int FIRST = 1;
    private static final int LAST = 1000;
    private static final int SIZE = LAST;
    private static final List<Arguments> REPORT_TEST_DATA = List.of(
            Arguments.of(FIRST, FIRST, getExpectedReport(FIRST, FIRST)),
            Arguments.of(FIRST, LAST, getExpectedReport(FIRST, LAST)),
            Arguments.of(LAST, FIRST, getExpectedReport(LAST, FIRST)),
            Arguments.of(LAST, LAST, getExpectedReport(LAST, LAST))
    );

    private static String getExpectedReport(int row, int col) {
        return Flyweight.REPORT_TEMPLATE.formatted(row, col);
    }

    private static FlyweightFactory factoryWithSize() {
        return new FlyweightFactory(SIZE);
    }

    @Test
    void whenCreateFactoryWithSize_thenCorrectPoolSize() {
        // when:
        FlyweightFactory factory = factoryWithSize();
        // then:
        assertThat(factory.pool().length)
                .isEqualTo(SIZE);
    }

    @ParameterizedTest
    @FieldSource("REPORT_TEST_DATA")
    void givenFlyweightFactory_whenGetColAndRowReport_thenCorrectReport(int testColumn,
                                                                        int testRow,
                                                                        String expectedReport) {
        // given:
        FlyweightFactory factory = factoryWithSize();
        // when:
        assertThat(factory.getColumn(testColumn).getRowReport(testRow))
                // then:
                .isEqualTo(expectedReport);
    }
}
