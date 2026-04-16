package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.designpatterns.pattern.composite.ExpressionComposite;
import ru.geardroid.designpatterns.entity.expression.ExpressionValue;
import ru.geardroid.designpatterns.entity.expression.SubExpression;

import static org.assertj.core.api.Assertions.assertThat;

class CompositeTest {

    public static final ExpressionValue MINUS_TWO = new ExpressionValue(-2);
    public static final ExpressionValue ZERO = new ExpressionValue(0);
    public static final ExpressionValue FIVE = new ExpressionValue(5);
    public static final ExpressionValue SIX = new ExpressionValue(6);
    public static final ExpressionValue ELEVEN = new ExpressionValue(11);
    public static final ExpressionValue TWENTY = new ExpressionValue(20);
    public static final ExpressionValue RESULT = ZERO;

    @Test
    void whenAdapterGetBalance_thenEqualsWithCurrency(){
        // given:
        SubExpression expression = new ExpressionComposite();
        var firstNegativeExpression = new ExpressionComposite(FIVE, MINUS_TWO);
        var secondNegativeExpression = new ExpressionComposite(ELEVEN, SIX);
        var subExpressions = expression.add(TWENTY)
                .sub(firstNegativeExpression)
                .sub(secondNegativeExpression);
        // when:
        var value = new ExpressionComposite(subExpressions)
                .value()
                .floatValue();
        // then:
        assertThat(value)
                .isEqualTo(RESULT.value().floatValue());
    }
}
