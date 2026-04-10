package ru.geardroid.design_patterns.pattern.flyweight;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Flyweight {

    public static final String REPORT_TEMPLATE = "row=%s, col=%s";

    private final int row;

    public String getRowReport(int col) {
        String report = String.format(REPORT_TEMPLATE, row, col);
        System.out.println(report);
        return report;
    }
}
