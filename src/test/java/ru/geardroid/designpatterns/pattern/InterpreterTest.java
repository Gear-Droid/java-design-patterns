package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.designpatterns.entity.expression.text.LowerExpression;
import ru.geardroid.designpatterns.entity.expression.text.TextContext;
import ru.geardroid.designpatterns.entity.expression.text.UpperExpression;
import ru.geardroid.designpatterns.pattern.behavioral.interpreter.ExpressionInterpreter;

import static org.assertj.core.api.Assertions.assertThat;

public class InterpreterTest {

    private static final String SAMPLE_TEXT = "sAmPle TexT";
    private static final TextContext TEXT_CONTEXT = new TextContext();

    @Test
    void givenLowerExpressionInterpreter_whenInterpretContext_thenCorrect() {
        // given:
        ExpressionInterpreter lowerExpression = new LowerExpression(SAMPLE_TEXT);
        // when:
        var interpreted = lowerExpression.interpret(TEXT_CONTEXT);
        // then:
        assertThat(interpreted)
                .isEqualTo(SAMPLE_TEXT.toLowerCase());
    }

    @Test
    void givenUpperExpressionInterpreter_whenInterpretContext_thenCorrect() {
        // given:
        ExpressionInterpreter upperExpression = new UpperExpression(SAMPLE_TEXT);
        // when:
        var interpreted = upperExpression.interpret(TEXT_CONTEXT);
        // then:
        assertThat(interpreted)
                .isEqualTo(SAMPLE_TEXT.toUpperCase());
    }
}
