package ru.geardroid.designpatterns.entity.expression.math;

import java.util.List;

public interface SubExpression {

    Number value();
    SubExpression add(SubExpression expr);
    SubExpression sub(SubExpression expr);
    List<SubExpression> getExpressionOperations();
}
