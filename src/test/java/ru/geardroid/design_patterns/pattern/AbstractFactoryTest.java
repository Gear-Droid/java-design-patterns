package ru.geardroid.design_patterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.design_patterns.entity.car.*;
import ru.geardroid.design_patterns.pattern.abstract_factory.DECarFactory;
import ru.geardroid.design_patterns.pattern.abstract_factory.RUCarFactory;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AbstractFactoryTest {

    private static final Map<Class<? extends Car>, Long> deCarPrices = Map.of(
            Lada.class, DELada.PRICE,
            Porsche.class, DEPorsche.PRICE
    );
    private static final Map<Class<? extends Car>, Long> ruCarPrices = Map.of(
            Lada.class, RULada.PRICE,
            Porsche.class, RUPorsche.PRICE
    );

    @Test
    void givenDECarFactory_thenCorrectPrices() {
        // given:
        var factory = new DECarFactory();
        var expectedPrices = deCarPrices;
        // when:
        var ladaPrice = factory.getLada().getPrice();
        var porschePrice = factory.getPorsche().getPrice();
        // then:
        assertThat(ladaPrice).isEqualTo(expectedPrices.get(Lada.class));
        assertThat(porschePrice).isEqualTo(expectedPrices.get(Porsche.class));
    }

    @Test
    void givenRUCarFactory_thenCorrectPrices() {
        // given:
        var factory = new RUCarFactory();
        var expectedPrices = ruCarPrices;
        // when:
        var ladaPrice = factory.getLada().getPrice();
        var porschePrice = factory.getPorsche().getPrice();
        // then:
        assertThat(ladaPrice).isEqualTo(expectedPrices.get(Lada.class));
        assertThat(porschePrice).isEqualTo(expectedPrices.get(Porsche.class));
    }
}
