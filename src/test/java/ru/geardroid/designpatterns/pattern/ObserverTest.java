package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.geardroid.designpatterns.entity.university.University;
import ru.geardroid.designpatterns.pattern.behavioral.observer.UniversityObserver;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ObserverTest {

    private static final String TEST_STUDENT = "testStudent";
    private static final String NEW_TEST_STUDENT = "newTestStudent";

    private static University createUniversity() {
        return new University();
    }

    private static University createUniversityWithObserver(UniversityObserver observer) {
        var university = createUniversity();
        university.addStudent(TEST_STUDENT);
        university.addObserver(observer);
        return university;
    }

    @Test
    void givenUniversityWithObserver_whenAddStudent_thenObserverNotified() {
        // given:
        var observer = Mockito.mock(UniversityObserver.class);
        var university = createUniversityWithObserver(observer);
        // when:
        university.addStudent(NEW_TEST_STUDENT);
        // then:
        verify(observer, times(1))
                .event(List.of(TEST_STUDENT, NEW_TEST_STUDENT));
    }

    @Test
    void givenUniversityWithoutObserver_whenAddStudent_thenObserverNotified() {
        // given:
        var observer = Mockito.mock(UniversityObserver.class);
        var university = createUniversityWithObserver(observer);
        university.removeObserver(observer);
        // when:
        university.addStudent(NEW_TEST_STUDENT);
        // then:
        verify(observer, times(0))
                .event(List.of(TEST_STUDENT, NEW_TEST_STUDENT));
    }

    @Test
    void givenUniversityWithObserver_whenRemoveStudent_thenObserverNotified() {
        // given:
        var observer = Mockito.mock(UniversityObserver.class);
        var university = createUniversityWithObserver(observer);
        // when:
        university.removeStudent(TEST_STUDENT);
        // then:
        verify(observer, times(1))
                .event(List.of());
    }
}
