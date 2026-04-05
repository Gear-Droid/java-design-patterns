package ru.geardroid.design_patterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.design_patterns.pattern.singleton.LazySingleton;
import ru.geardroid.design_patterns.pattern.singleton.Singleton;

class SingletonTest {

    @Test
    void whenSingletonGetInstance_thenSetUp(){
        // when:
        Singleton singleton = Singleton.getInstance();
        // then:
        singleton.setUp();
    }

    @Test
    void whenLazySingletonGetInstance_thenSetUp(){
        // when:
        LazySingleton singleton = LazySingleton.getInstance();
        // then:
        singleton.setUp();
    }
}
