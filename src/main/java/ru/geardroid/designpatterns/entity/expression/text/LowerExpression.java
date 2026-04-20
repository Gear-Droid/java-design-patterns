package ru.geardroid.designpatterns.entity.expression.text;

import lombok.AllArgsConstructor;
import ru.geardroid.designpatterns.pattern.interpreter.ExpressionInterpreter;

@AllArgsConstructor
public class LowerExpression implements ExpressionInterpreter {

    private final String s;

    public String interpret(TextContext context) {
        return context.getLowerCase(s);
    }
}
