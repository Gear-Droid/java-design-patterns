package ru.geardroid.designpatterns.entity.expression.text;

import lombok.AllArgsConstructor;
import ru.geardroid.designpatterns.pattern.behavioral.interpreter.ExpressionInterpreter;

@AllArgsConstructor
public class UpperExpression implements ExpressionInterpreter {

    private final String s;

    public String interpret(TextContext context) {
        return context.getUpperCase(s);
    }
}
