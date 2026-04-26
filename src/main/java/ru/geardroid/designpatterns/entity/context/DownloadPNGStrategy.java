package ru.geardroid.designpatterns.entity.context;

import ru.geardroid.designpatterns.pattern.behavioral.strategy.DownloadStrategy;

public class DownloadPNGStrategy implements DownloadStrategy {

    public String download(String file) {
        System.out.println("PNG file download: " + file);
        return "%s.png".formatted(file);
    }
}
