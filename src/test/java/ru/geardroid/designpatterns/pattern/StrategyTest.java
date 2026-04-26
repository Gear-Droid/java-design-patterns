package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;
import ru.geardroid.designpatterns.entity.context.DownloadPNGStrategy;
import ru.geardroid.designpatterns.entity.context.DownloadPDFStrategy;
import ru.geardroid.designpatterns.pattern.behavioral.strategy.DownloadContext;
import ru.geardroid.designpatterns.pattern.behavioral.strategy.DownloadStrategy;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StrategyTest {

    public static final String TEST_FILENAME = "testFile";
    public static final String PDF = ".pdf";
    public static final String PNG = ".png";
    public static final List<Arguments> STRATEGY_TEST_DATA = List.of(
            Arguments.of(DownloadPDFStrategy.class, PDF),
            Arguments.of(DownloadPNGStrategy.class, PNG)
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
        var context = new DownloadContext(new DownloadPNGStrategy());
        // when:
        context.setStrategy(new DownloadPDFStrategy());
        String result = context.download(TEST_FILENAME);
        // then:
        assertThat(result).isEqualTo(TEST_FILENAME + PDF);
    }
}
