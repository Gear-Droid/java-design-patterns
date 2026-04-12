package ru.geardroid.design_patterns.pattern;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;
import ru.geardroid.design_patterns.entity.car.Car;
import ru.geardroid.design_patterns.entity.car.SportCar;
import ru.geardroid.design_patterns.entity.car.UnknownCar;
import ru.geardroid.design_patterns.entity.car.serviceable.SportEngine;
import ru.geardroid.design_patterns.entity.car.serviceable.UnknownEngine;
import ru.geardroid.design_patterns.pattern.bridge.CarEngineBridge;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeTest {

    public static final List<Arguments> BRIDGE_TEST_DATA = List.of(
            Arguments.of(UnknownCar.class, UnknownEngine.class),
            Arguments.of(UnknownCar.class, SportEngine.class),
            Arguments.of(SportCar.class, UnknownEngine.class),
            Arguments.of(SportCar.class, SportEngine.class)
    );

    @ParameterizedTest
    @FieldSource("BRIDGE_TEST_DATA")
    void givenCarWithEngine_thenCorrectCarAndEngineClass(
            Class<? extends Car> carClass,
            Class<? extends CarEngineBridge> engineClass
    ) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // given:
        var engine = engineClass.getDeclaredConstructor()
                .newInstance();
        var car = carClass.getDeclaredConstructor(CarEngineBridge.class)
                .newInstance(engine);
        // when:
        car.setEngine();
        // then:
        assertThat(car).isInstanceOf(carClass);
        assertThat(car.getEngine()).isInstanceOf(engineClass);
    }
}
