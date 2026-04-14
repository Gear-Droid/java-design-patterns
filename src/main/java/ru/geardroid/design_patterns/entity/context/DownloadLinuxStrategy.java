package ru.geardroid.design_patterns.entity.context;

import ru.geardroid.design_patterns.pattern.strategy.DownloadStrategy;

public class DownloadLinuxStrategy implements DownloadStrategy {

    public String download(String file) {
        System.out.println("linux download: " + file);
        return "%s.lin".formatted(file);
    }
}
