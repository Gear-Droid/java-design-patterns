package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.designpatterns.entity.car.serviceable.BrokenCarEngineEngine;
import ru.geardroid.designpatterns.entity.car.serviceable.ServiceableCarEngine;

import static org.assertj.core.api.Assertions.assertThat;

public class TemplateTest {

    private static final boolean SUCCESS = true;

    @Test
    void givenServiceableEngine_whenStartEngine_thenSuccess() {
        // given:
        var serviceableEngine = new ServiceableCarEngine();
        // when:
        boolean isGood = serviceableEngine.checkStart();
        // then:
        assertThat(isGood).isEqualTo(SUCCESS);
    }

    @Test
    void givenBrokenEngine_whenStartEngine_thenNotSuccess() {
        // given:
        var brokenEngine = new BrokenCarEngineEngine();
        // when:
        boolean isGood = brokenEngine.checkStart();
        // then:
        assertThat(isGood).isEqualTo(!SUCCESS);
    }
}
