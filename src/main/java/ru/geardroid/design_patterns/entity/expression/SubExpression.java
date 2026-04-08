package ru.geardroid.design_patterns.entity.expression;

import java.util.List;

public interface SubExpression {

    Number value();
    SubExpression add(SubExpression expr);
    SubExpression sub(SubExpression expr);
    List<SubExpression> getExpressionOperations();
}
