package ru.geardroid.designpatterns.entity.context;

import ru.geardroid.designpatterns.pattern.strategy.DownloadStrategy;

public class DownloadWindowsStrategy implements DownloadStrategy {

    public String download(String file) {
        System.out.println("windows download: " + file);
        return "%s.win".formatted(file);
    }
}
