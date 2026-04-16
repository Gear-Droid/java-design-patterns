package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.designpatterns.pattern.proxy.ImageProxy;

import static org.assertj.core.api.Assertions.assertThat;

class ProxyTest {

    private static final String TEST_FILENAME = "test.example";

    @Test
    void givenProxy_thenImageIsNull() {
        // given:
        var proxy = new ImageProxy(TEST_FILENAME);
        // then:
        assertThat(proxy.getImage()).isNull();
    }

    @Test
    void givenProxy_whenDisplayImage_thenNotNull() {
        // given:
        var proxy = new ImageProxy(TEST_FILENAME);
        // when:
        proxy.display();
        // then:
        assertThat(proxy.getImage()).isNotNull();
    }
}
