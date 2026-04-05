package ru.geardroid.design_patterns.entity.os;

public class LinuxOS implements OS {

    public static final String NAME = "linux";

    @Override
    public String getOSName() {
        return NAME;
    }
}
