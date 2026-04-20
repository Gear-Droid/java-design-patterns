package ru.geardroid.designpatterns.pattern.memento;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserMemento {

    private String name;
    private int age;
}
