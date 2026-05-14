package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;
import ru.geardroid.designpatterns.entity.car.Car;
import ru.geardroid.designpatterns.entity.car.SportCar;
import ru.geardroid.designpatterns.entity.car.UnknownCar;
import ru.geardroid.designpatterns.entity.car.serviceable.SportEngine;
import ru.geardroid.designpatterns.entity.car.serviceable.UnknownEngine;
import ru.geardroid.designpatterns.pattern.structural.bridge.CarEngineBridge;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    static final CarEngineBridge UNKNOWN_ENGINE = new UnknownEngine();
    static final CarEngineBridge SPORT_ENGINE = new SportEngine();

    public static final List<Arguments> BRIDGE_TEST_DATA = List.of(
            Arguments.of(UNKNOWN_ENGINE, (Supplier<Car>) () -> new UnknownCar(UNKNOWN_ENGINE)),
            Arguments.of(SPORT_ENGINE, (Supplier<Car>) () -> new UnknownCar(SPORT_ENGINE)),
            Arguments.of(UNKNOWN_ENGINE, (Supplier<Car>) () -> new SportCar(UNKNOWN_ENGINE)),
            Arguments.of(SPORT_ENGINE, (Supplier<Car>) () -> new SportCar(SPORT_ENGINE))
    );

    @ParameterizedTest
    @FieldSource("BRIDGE_TEST_DATA")
    void givenCarWithEngine_thenCorrectCarAndEngineClass(CarEngineBridge engine,
                                                         Supplier<Car> carGenerator) {
        // given:
        var car = carGenerator.get();
        // when:
        car.setEngine();
        // then:
        assertThat(car.getEngine()).isInstanceOf(engine.getClass());
    }
}
