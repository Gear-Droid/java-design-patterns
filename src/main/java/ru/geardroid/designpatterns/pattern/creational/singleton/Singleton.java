package ru.geardroid.designpatterns.pattern.creational.singleton;

import lombok.Getter;

public class Singleton {

    @Getter
    private static final Singleton instance = new Singleton();

    private Singleton() {}

    public void setUp() {
        System.out.println("setUp");
    }
}
