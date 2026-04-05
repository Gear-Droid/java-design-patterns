package ru.geardroid.design_patterns.entity.os;

public class MacOS implements OS {

    public static final String NAME = "mac";

    @Override
    public String getOSName() {
        return NAME;
    }
}
