package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.designpatterns.pattern.singleton.LazySingleton;
import ru.geardroid.designpatterns.pattern.singleton.Singleton;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonTest {

    @Test
    void whenSingletonGetInstance_thenSetUp(){
        // when:
        Singleton singleton = Singleton.getInstance();
        singleton.setUp();
        // then:
        assertThat(singleton).isNotNull();
    }

    @Test
    void whenLazySingletonGetInstance_thenSetUp(){
        // when:
        LazySingleton singleton = LazySingleton.getInstance();
        singleton.setUp();
        // then:
        assertThat(singleton).isNotNull();
    }
}
