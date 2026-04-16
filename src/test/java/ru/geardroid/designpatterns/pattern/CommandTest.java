package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.designpatterns.entity.car.command.StartCar;
import ru.geardroid.designpatterns.entity.car.command.StopCar;
import ru.geardroid.designpatterns.pattern.command.CarEngineCommand;
import ru.geardroid.designpatterns.pattern.command.CarInvoker;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {

    @Test
    void givenStartCarCommand_whenExecute_thenStartedFlag() {
        // given:
        CarEngineCommand command = new StartCar();
        var car = new CarInvoker(command);
        // when:
        String flag = car.execute();
        // then:
        assertThat(flag).isEqualTo(StartCar.FLAG);
    }

    @Test
    void givenStopCarCommand_whenExecute_thenStoppedFlag() {
        // given:
        CarEngineCommand command = new StopCar();
        var car = new CarInvoker(command);
        // when:
        String flag = car.execute();
        // then:
        assertThat(flag).isEqualTo(StopCar.FLAG);
    }
}
