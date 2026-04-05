package ru.geardroid.design_patterns.pattern.singleton;

public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public void setUp() {
        System.out.println("setUp");
    }
}
