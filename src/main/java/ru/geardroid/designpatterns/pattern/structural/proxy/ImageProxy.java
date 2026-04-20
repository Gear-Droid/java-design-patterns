package ru.geardroid.designpatterns.pattern.structural.proxy;

import lombok.Getter;
import ru.geardroid.designpatterns.entity.image.Image;
import ru.geardroid.designpatterns.entity.image.RealImage;

@Getter
public class ImageProxy implements Image {

    private final String file;
    private RealImage image;

    public ImageProxy(String file){
        this.file = file;
    }

    public void display() {
        if (image == null) {
            image = new RealImage(file);
        }
        image.display();
    }
}
