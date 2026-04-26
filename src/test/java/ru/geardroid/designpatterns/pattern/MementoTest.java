package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.designpatterns.entity.user.UserOriginator;
import ru.geardroid.designpatterns.pattern.behavioral.memento.UserMemento;
import ru.geardroid.designpatterns.pattern.behavioral.memento.UserMementoCaretaker;

import static org.assertj.core.api.Assertions.assertThat;

public class MementoTest {

    private static final String USER_NAME = "Vlad";
    private static final int USER_AGE = 26;

    private UserOriginator createTestUser() {
        return new UserOriginator(USER_NAME, USER_AGE);
    }

    private UserMemento createUserSnapshot(UserOriginator userOriginator) {
        return new UserMemento(userOriginator.getName(), userOriginator.getAge());
    }

    @Test
    void givenUser_whenSaveUser_thenCorrect() {
        // given:
        var user = createTestUser();
        UserMemento snapshot = createUserSnapshot(user);
        // when:
        var savedUser = user.save();
        // then:
        assertThat(savedUser.getName()).isEqualTo(snapshot.getName());
        assertThat(savedUser.getAge()).isEqualTo(snapshot.getAge());
    }

    @Test
    void givenUserWithSnapshot_whenChangeUserAndRestore_thenShouldRevertState() {
        // given:
        var user = createTestUser();
        UserMemento snapshot = createUserSnapshot(user);
        // when:
        user.setName("Bob");
        user.setAge(30);
        user.restore(snapshot);
        UserMemento current = user.save();
        // then:
        assertThat(current.getName()).isEqualTo(USER_NAME);
        assertThat(current.getAge()).isEqualTo(USER_AGE);
    }

    @Test
    void givenSavedUserState_whenChangeUserAndUndo_thenShouldRevertState() {
        // given:
        var user = createTestUser();
        var caretaker = new UserMementoCaretaker(user);
        caretaker.saveState();
        // when:
        user.setName("Bob");
        user.setAge(30);
        caretaker.undo();
        var current = caretaker.getUserOriginator();
        // then:
        assertThat(current.getName()).isEqualTo(USER_NAME);
        assertThat(current.getAge()).isEqualTo(USER_AGE);
    }
}
