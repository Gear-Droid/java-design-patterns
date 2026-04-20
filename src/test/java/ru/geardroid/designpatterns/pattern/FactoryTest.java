package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;
import ru.geardroid.designpatterns.entity.os.LinuxOS;
import ru.geardroid.designpatterns.entity.os.MacOS;
import ru.geardroid.designpatterns.entity.os.OS;
import ru.geardroid.designpatterns.entity.os.WindowsOS;
import ru.geardroid.designpatterns.pattern.creational.factory.OSFactory;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class FactoryTest {

    private static final OSFactory OS_FACTORY = new OSFactory();
    private static final Set<Arguments> OS_TEST_DATA = Set.of(
            Arguments.of(WindowsOS.NAME, WindowsOS.class),
            Arguments.of(MacOS.NAME, MacOS.class),
            Arguments.of(LinuxOS.NAME, LinuxOS.class)
    );

    @ParameterizedTest
    @FieldSource("OS_TEST_DATA")
    void givenOsInput_thenCorrectClass(String osName, Class<?> osClass){
        // when:
        OS os = OS_FACTORY.getCurrentOS(osName);
        // then:
        assertThat(os).isInstanceOf(osClass);
        assertThat(os.getOSName()).isEqualTo(osName);
    }
}
