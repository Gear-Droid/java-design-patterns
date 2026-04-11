package ru.geardroid.design_patterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.design_patterns.entity.car.servicable.engine_device.CoolingController;
import ru.geardroid.design_patterns.entity.car.servicable.engine_device.EngineStarter;
import ru.geardroid.design_patterns.entity.car.servicable.engine_device.FuelInjector;
import ru.geardroid.design_patterns.pattern.facade.ServiceableCarFacade;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FacadeTest {

    private static final boolean ACTIVE = true;
    private static final int TEST_SPEED_LIMIT = 200;
    private static final long ENGINE_STILL_WORKING_TIME = EngineStarter.WORK_TIME_DURATION.toMillis() / 2;
    private static final long ENGINE_FINISHED_WORK_TIME = EngineStarter.WORK_TIME_DURATION.toMillis() + 100;

    private ServiceableCarFacade createCarFacade() {
        return new ServiceableCarFacade(
                new EngineStarter(),
                new FuelInjector(),
                new CoolingController(),
                TEST_SPEED_LIMIT
        );
    }

    @Test
    void whenCarStartEngine_thenCorrectDevicesActive() throws InterruptedException {
        // given:
        var carFacade = createCarFacade();
        // when:
        carFacade.startEngine();
        Thread.sleep(ENGINE_STILL_WORKING_TIME);
        // then:
        assertThat(carFacade.starter().isActive()).isEqualTo(ACTIVE);
        assertThat(carFacade.fuelInjector().isActive()).isEqualTo(ACTIVE);
        assertThat(carFacade.coolingController().isActive()).isEqualTo(ACTIVE);
    }

    @Test
    void givenCarStartEngine_whenWaitForStarterEnd_thenCorrectDevicesActive() throws InterruptedException {
        // given:
        var carFacade = createCarFacade();
        carFacade.startEngine();
        // when:
        Thread.sleep(ENGINE_FINISHED_WORK_TIME);
        // then:
        assertThat(carFacade.starter().isActive()).isEqualTo(!ACTIVE);
        assertThat(carFacade.fuelInjector().isActive()).isEqualTo(ACTIVE);
        assertThat(carFacade.coolingController().isActive()).isEqualTo(ACTIVE);
    }

    @Test
    void givenCarStartEngine_whenCarStopEngine_thenCorrectDevicesActive() throws InterruptedException {
        // given:
        var carFacade = createCarFacade();
        carFacade.startEngine();
        // when:
        Thread.sleep(ENGINE_STILL_WORKING_TIME);
        carFacade.stopEngine();
        // then:
        assertThat(carFacade.starter().isActive()).isEqualTo(!ACTIVE);
        assertThat(carFacade.fuelInjector().isActive()).isEqualTo(!ACTIVE);
        assertThat(carFacade.coolingController().isActive()).isEqualTo(!ACTIVE);
    }

    @Test
    void givenCarStartEngine_whenStopEngineAndWaitForStarterEnd_thenCorrectDevicesActive() throws InterruptedException {
        // given:
        var carFacade = createCarFacade();
        carFacade.startEngine();
        // when:
        carFacade.stopEngine();
        Thread.sleep(ENGINE_FINISHED_WORK_TIME);
        // then:
        assertThat(carFacade.starter().isActive()).isEqualTo(!ACTIVE);
        assertThat(carFacade.fuelInjector().isActive()).isEqualTo(!ACTIVE);
        assertThat(carFacade.coolingController().isActive()).isEqualTo(!ACTIVE);
    }
}
