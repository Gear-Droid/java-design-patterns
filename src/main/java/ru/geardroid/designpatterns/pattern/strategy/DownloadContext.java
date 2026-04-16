package ru.geardroid.designpatterns.pattern.strategy;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class DownloadContext {

    private DownloadStrategy strategy;

    public String download(String file) {
        return strategy.download(file);
    }
}
