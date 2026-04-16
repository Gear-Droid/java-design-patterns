package ru.geardroid.designpatterns.entity.os;

public class MacOS implements OS {

    public static final String NAME = "mac";

    @Override
    public String getOSName() {
        return NAME;
    }
}
