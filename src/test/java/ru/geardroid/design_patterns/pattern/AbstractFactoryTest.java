package ru.geardroid.design_patterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.design_patterns.entity.car.saleable.*;
import ru.geardroid.design_patterns.pattern.abstract_factory.DECarFactory;
import ru.geardroid.design_patterns.pattern.abstract_factory.RUCarFactory;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AbstractFactoryTest {

    private static final Map<Class<? extends SaleableCar>, Long> DE_CAR_PRICES = Map.of(
            Lada.class, DELada.PRICE,
            Porsche.class, DEPorsche.PRICE
    );
    private static final Map<Class<? extends SaleableCar>, Long> RU_CAR_PRICES = Map.of(
            Lada.class, RULada.PRICE,
            Porsche.class, RUPorsche.PRICE
    );

    @Test
    void givenDECarFactory_thenCorrectPrices() {
        // given:
        var factory = new DECarFactory();
        var expectedPrices = DE_CAR_PRICES;
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
        var expectedPrices = RU_CAR_PRICES;
        // when:
        var ladaPrice = factory.getLada().getPrice();
        var porschePrice = factory.getPorsche().getPrice();
        // then:
        assertThat(ladaPrice).isEqualTo(expectedPrices.get(Lada.class));
        assertThat(porschePrice).isEqualTo(expectedPrices.get(Porsche.class));
    }
}
