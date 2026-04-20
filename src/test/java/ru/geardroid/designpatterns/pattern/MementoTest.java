package ru.geardroid.designpatterns.pattern;

import org.junit.jupiter.api.Test;
import ru.geardroid.designpatterns.entity.user.User;
import ru.geardroid.designpatterns.pattern.behavioral.memento.UserMemento;
import ru.geardroid.designpatterns.pattern.behavioral.memento.UserMementoArchive;

import static org.assertj.core.api.Assertions.assertThat;

public class MementoTest {

    private static final String USER_NAME = "Vlad";
    private static final int USER_AGE = 26;

    private User createTestUser() {
        return new User(USER_NAME, USER_AGE);
    }

    private UserMemento createUserSnapshot(User user) {
        return new UserMemento(user.getName(), user.getAge());
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
    void givenSavedUserState_whenChangeUserAndUndoArchive_thenShouldRevertState() {
        // given:
        var user = createTestUser();
        var archive = new UserMementoArchive(user);
        archive.saveState();
        // when:
        user.setName("Bob");
        user.setAge(30);
        archive.undo();
        var current = archive.getUser();
        // then:
        assertThat(current.getName()).isEqualTo(USER_NAME);
        assertThat(current.getAge()).isEqualTo(USER_AGE);
    }
}
