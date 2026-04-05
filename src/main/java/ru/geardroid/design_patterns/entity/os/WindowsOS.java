package ru.geardroid.design_patterns.entity.os;

public class WindowsOS implements OS {

    public static final String NAME = "windows";

    @Override
    public String getOSName() {
        return NAME;
    }
}
