package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;
import ru.geardroid.designpatterns.entity.context.DownloadLinuxStrategy;
import ru.geardroid.designpatterns.entity.context.DownloadWindowsStrategy;
import ru.geardroid.designpatterns.pattern.strategy.DownloadContext;
import ru.geardroid.designpatterns.pattern.strategy.DownloadStrategy;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StrategyTest {

    public static final String TEST_FILENAME = "testFile";
    public static final List<Arguments> STRATEGY_TEST_DATA = List.of(
            Arguments.of(DownloadWindowsStrategy.class, ".win"),
            Arguments.of(DownloadLinuxStrategy.class, ".lin")
    );

    @ParameterizedTest
    @FieldSource("STRATEGY_TEST_DATA")
    void givenContextWithStrategy_thenCorrectFilename(Class<? extends DownloadStrategy> strategyClass, String endFile)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // given:
        var strategy = strategyClass.getDeclaredConstructor()
                .newInstance();
        var context = new DownloadContext(strategy);
        // when:
        String result = context.download(TEST_FILENAME);
        // then:
        assertThat(result).isEqualTo(TEST_FILENAME + endFile);
    }

    @Test
    void givenContextWithStrategy_whenChangeStrategy_thenCorrectFilename() {
        // given:
        var context = new DownloadContext(new DownloadLinuxStrategy());
        // when:
        context.setStrategy(new DownloadWindowsStrategy());
        String result = context.download(TEST_FILENAME);
        // then:
        assertThat(result).isEqualTo(TEST_FILENAME + ".win");
    }
}
