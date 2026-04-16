package ru.geardroid.designpatterns.entity.os;

public class LinuxOS implements OS {

    public static final String NAME = "linux";

    @Override
    public String getOSName() {
        return NAME;
    }
}
