package ru.geardroid.designpatterns.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.geardroid.designpatterns.pattern.memento.UserMemento;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private String name;
    private int age;

    public UserMemento save() {
        System.out.printf("save: name = %s, age = %s%n", name, age);
        return new UserMemento(name, age);
    }

    public void restore(UserMemento memento) {
        name = memento.getName();
        age = memento.getAge();
        System.out.printf("restore: name = %s, age = %s%n", name, age);
    }
}
