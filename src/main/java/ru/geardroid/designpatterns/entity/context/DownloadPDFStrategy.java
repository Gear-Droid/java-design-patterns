package ru.geardroid.designpatterns.entity.context;

import ru.geardroid.designpatterns.pattern.behavioral.strategy.DownloadStrategy;

public class DownloadPDFStrategy implements DownloadStrategy {

    public String download(String file) {
        System.out.println("PDF file download: " + file);
        return "%s.pdf".formatted(file);
    }
}
