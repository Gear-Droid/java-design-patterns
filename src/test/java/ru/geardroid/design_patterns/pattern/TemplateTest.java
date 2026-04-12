package ru.geardroid.design_patterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.design_patterns.entity.car.serviceable.BrokenCarEngineEngine;
import ru.geardroid.design_patterns.entity.car.serviceable.ServiceableCarEngine;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
