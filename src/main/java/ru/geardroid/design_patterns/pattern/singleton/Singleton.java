package ru.geardroid.design_patterns.pattern.singleton;

import lombok.Getter;

public class Singleton {

    @Getter
    private static final Singleton instance = new Singleton();

    private Singleton() {}

    public void setUp() {
        System.out.println("setUp");
    }
}
