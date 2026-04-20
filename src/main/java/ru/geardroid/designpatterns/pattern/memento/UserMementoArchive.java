package ru.geardroid.designpatterns.pattern.memento;

import lombok.Getter;
import ru.geardroid.designpatterns.entity.user.User;

import java.util.Stack;

@Getter
public class UserMementoArchive {

    private Stack<UserMemento> history = new Stack<>();
    private User user;

    public UserMementoArchive(User user) {
        this.user = user;
    }

    public void saveState() {
        UserMemento memento = user.save();
        history.push(memento);
    }

    public void undo() {
        if (!history.isEmpty()) {
            UserMemento previousMemento = history.pop();
            user.restore(previousMemento);
        } else {
            System.out.println("Нет сохранённых состояний для восстановления");
        }
    }
}
