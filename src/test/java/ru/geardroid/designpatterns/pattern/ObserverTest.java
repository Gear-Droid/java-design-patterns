package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.geardroid.designpatterns.entity.university.University;
import ru.geardroid.designpatterns.pattern.observer.UniversityObserver;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ObserverTest {

    private static final String TEST_STUDENT = "testStudent";

    private static University createUniversity() {
        return new University();
    }

    private static University createUniversityWithObserver(UniversityObserver observer) {
        var university = createUniversity();
        university.addObserver(observer);
        return university;
    }

    @Test
    void givenUniversityWithObserver_whenAddStudent_then() {
        // given:
        var observer = Mockito.mock(UniversityObserver.class);
        var university = createUniversityWithObserver(observer);
        // when:
        university.addStudent(TEST_STUDENT);
        // then:
        verify(observer, times(1))
                .event(List.of(TEST_STUDENT));
    }

    @Test
    void givenUniversityWithoutObserver_whenAddStudent_then() {
        // given:
        var observer = Mockito.mock(UniversityObserver.class);
        var university = createUniversityWithObserver(observer);
        university.removeObserver(observer);
        // when:
        university.addStudent(TEST_STUDENT);
        // then:
        verify(observer, times(0))
                .event(List.of(TEST_STUDENT));
    }
}
