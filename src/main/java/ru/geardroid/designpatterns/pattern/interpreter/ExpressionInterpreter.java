package ru.geardroid.designpatterns.pattern.interpreter;

import ru.geardroid.designpatterns.entity.expression.text.TextContext;

public interface ExpressionInterpreter {

    String interpret(TextContext context);
}
