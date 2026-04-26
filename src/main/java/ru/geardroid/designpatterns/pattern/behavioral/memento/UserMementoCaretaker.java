package ru.geardroid.designpatterns.pattern.behavioral.memento;

import lombok.Getter;
import ru.geardroid.designpatterns.entity.user.UserOriginator;

import java.util.Stack;

@Getter
public class UserMementoCaretaker {

    private final Stack<UserMemento> history = new Stack<>();
    private final UserOriginator userOriginator;

    public UserMementoCaretaker(UserOriginator userOriginator) {
        this.userOriginator = userOriginator;
    }

    public void saveState() {
        UserMemento memento = userOriginator.save();
        history.push(memento);
    }

    public void undo() {
        if (!history.isEmpty()) {
            UserMemento previousMemento = history.pop();
            userOriginator.restore(previousMemento);
        } else {
            System.out.println("Нет сохранённых состояний для восстановления");
        }
    }
}
