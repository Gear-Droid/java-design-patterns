package ru.geardroid.design_patterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.design_patterns.entity.car.servicable.CoolingController;
import ru.geardroid.design_patterns.entity.car.servicable.EngineStarter;
import ru.geardroid.design_patterns.entity.car.servicable.FuelInjector;
import ru.geardroid.design_patterns.pattern.facade.ServiceableCarFacade;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FacadeTest {

    private static final boolean ACTIVE = true;
    private static final long ENGINE_STILL_WORKING_TIME = EngineStarter.WORK_TIME_DURATION.toMillis() / 2;
    private static final long ENGINE_FINISHED_WORKING_TIME = EngineStarter.WORK_TIME_DURATION.toMillis() + 100;

    private ServiceableCarFacade createCarFacade() {
        return new ServiceableCarFacade(
                new EngineStarter(),
                new FuelInjector(),
                new CoolingController()
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
        assertThat(carFacade.getStarter().isActive()).isEqualTo(ACTIVE);
        assertThat(carFacade.getFuelInjector().isActive()).isEqualTo(ACTIVE);
        assertThat(carFacade.getCoolingController().isActive()).isEqualTo(ACTIVE);
    }

    @Test
    void givenCarStartEngine_whenWaitForStarterEnd_thenCorrectDevicesActive() throws InterruptedException {
        // given:
        var carFacade = createCarFacade();
        carFacade.startEngine();
        // when:
        Thread.sleep(ENGINE_FINISHED_WORKING_TIME);
        // then:
        assertThat(carFacade.getStarter().isActive()).isEqualTo(!ACTIVE);
        assertThat(carFacade.getFuelInjector().isActive()).isEqualTo(ACTIVE);
        assertThat(carFacade.getCoolingController().isActive()).isEqualTo(ACTIVE);
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
        assertThat(carFacade.getStarter().isActive()).isEqualTo(!ACTIVE);
        assertThat(carFacade.getFuelInjector().isActive()).isEqualTo(!ACTIVE);
        assertThat(carFacade.getCoolingController().isActive()).isEqualTo(!ACTIVE);
    }

    @Test
    void givenCarStartEngine_whenStopEngineAndWaitForStarterEnd_thenCorrectDevicesActive() throws InterruptedException {
        // given:
        var carFacade = createCarFacade();
        carFacade.startEngine();
        // when:
        carFacade.stopEngine();
        Thread.sleep(ENGINE_FINISHED_WORKING_TIME);
        // then:
        assertThat(carFacade.getStarter().isActive()).isEqualTo(!ACTIVE);
        assertThat(carFacade.getFuelInjector().isActive()).isEqualTo(!ACTIVE);
        assertThat(carFacade.getCoolingController().isActive()).isEqualTo(!ACTIVE);
    }
}
