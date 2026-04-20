package ru.geardroid.designpatterns.entity.university;

import ru.geardroid.designpatterns.pattern.behavioral.observer.UniversityObserver;

import java.util.ArrayList;
import java.util.List;

public class University {

    private final List<UniversityObserver> observers = new ArrayList<>();
    private final List<String> students = new ArrayList<>();

    public void addStudent(String name) {
        students.add(name);
        notifyObservers();
    }

    public void removeStudent(String name) {
        students.remove(name);
        notifyObservers();
    }

    public void addObserver(UniversityObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(UniversityObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(
                observer -> observer.event(students)
        );
    }
}
