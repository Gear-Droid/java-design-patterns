package ru.geardroid.design_patterns.pattern;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;
import ru.geardroid.design_patterns.entity.os.LinuxOS;
import ru.geardroid.design_patterns.entity.os.MacOS;
import ru.geardroid.design_patterns.entity.os.OS;
import ru.geardroid.design_patterns.entity.os.WindowsOS;
import ru.geardroid.design_patterns.pattern.factory.OSFactory;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class FactoryTest {

    private static final Set<Arguments> osStorage = Set.of(
            Arguments.of(WindowsOS.NAME, WindowsOS.class),
            Arguments.of(MacOS.NAME, MacOS.class),
            Arguments.of(LinuxOS.NAME, LinuxOS.class)
    );

    private final OSFactory factory = new OSFactory();

    @ParameterizedTest
    @FieldSource("osStorage")
    void givenOsInput_thenCorrectClass(String osName, Class<?> osClass){
        // when:
        OS os = factory.getCurrentOS(osName);
        // then:
        assertThat(os).isInstanceOf(osClass);
        assertThat(os.getOSName()).isEqualTo(osName);
    }
}
