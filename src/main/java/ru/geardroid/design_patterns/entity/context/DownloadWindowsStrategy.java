package ru.geardroid.design_patterns.entity.context;

import ru.geardroid.design_patterns.pattern.strategy.DownloadStrategy;

public class DownloadWindowsStrategy implements DownloadStrategy {

    public String download(String file) {
        System.out.println("windows download: " + file);
        return "%s.win".formatted(file);
    }
}
