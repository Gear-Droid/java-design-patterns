package ru.geardroid.designpatterns.pattern.structural.flyweight;

public record FlyweightFactory(Flyweight[] pool) {

    public FlyweightFactory(int pool) {
        this(new Flyweight[pool]);
    }

    public Flyweight getColumn(int row) {
        int index = row - 1;
        return pool[index] == null
                ? pool[index] = new Flyweight(row)
                : pool[index];
    }
}
