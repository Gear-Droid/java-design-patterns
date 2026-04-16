package ru.geardroid.designpatterns.entity.context;

import ru.geardroid.designpatterns.pattern.strategy.DownloadStrategy;

public class DownloadLinuxStrategy implements DownloadStrategy {

    public String download(String file) {
        System.out.println("linux download: " + file);
        return "%s.lin".formatted(file);
    }
}
