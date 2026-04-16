package ru.geardroid.designpatterns.entity.expression;

import java.util.List;

public record ExpressionValue(Number value) implements SubExpression {

    @Override
    public SubExpression add(SubExpression expr) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SubExpression sub(SubExpression expr) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<SubExpression> getExpressionOperations() {
        throw new UnsupportedOperationException();
    }
}
