package ru.geardroid.designpatterns.entity.expression.text;

public class TextContext {

    public String getLowerCase(String s) {
        return s.toLowerCase();
    }

    public String getUpperCase(String s) {
        return s.toUpperCase();
    }
}
