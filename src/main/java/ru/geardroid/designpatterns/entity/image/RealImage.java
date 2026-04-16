package ru.geardroid.designpatterns.entity.image;

public class RealImage implements Image {

    private final String file;

    public RealImage(String file) {
        this.file = file;
        load(file);
    }

    private void load(String file) {
        System.out.println("Загрузка " + file);
    }

    public void display() {
        System.out.println("Просмотр " + file);
    }
}
