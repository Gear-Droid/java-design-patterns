package ru.geardroid.designpatterns.pattern.composite;

import lombok.NoArgsConstructor;
import ru.geardroid.designpatterns.entity.expression.math.ExpressionValue;
import ru.geardroid.designpatterns.entity.expression.math.SubExpression;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ExpressionComposite implements SubExpression {

    private final List<SubExpression> expressions = new ArrayList<>();

    public ExpressionComposite(ExpressionValue firstValue, ExpressionValue secondValue) {
        this.expressions.add(firstValue);
        this.expressions.add(secondValue);
    }

    public ExpressionComposite(SubExpression expressions) {
        this.expressions.addAll(expressions.getExpressionOperations());
    }

    @Override
    public Number value() {
        return expressions.stream()
                .map(SubExpression::value)
                .map(Number::floatValue)
                .reduce(0f, Float::sum);
    }

    @Override
    public SubExpression add(SubExpression expr) {
        expressions.add(expr);
        return this;
    }

    @Override
    public SubExpression sub(SubExpression expr) {
        var negativeValue = new ExpressionValue(-1 * expr.value().floatValue());
        expressions.add(negativeValue);
        return this;
    }

    @Override
    public List<SubExpression> getExpressionOperations() {
        return expressions;
    }
}
