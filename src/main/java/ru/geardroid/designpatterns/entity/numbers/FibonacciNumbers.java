package ru.geardroid.designpatterns.entity.numbers;

import ru.geardroid.designpatterns.pattern.behavioral.iterator.Iterator;

import java.util.Arrays;

public class FibonacciNumbers {

    private static final int[] NUMBERS = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987};

    public static int getMaxValue() {
        return Arrays.stream(NUMBERS)
                .max()
                .orElse(0);
    }

    public Iterator getIterator() {
        return new NumbersIterator();
    }

    private static class NumbersIterator implements Iterator {
        int ind;

        public boolean hasNext() {
            return ind < NUMBERS.length;
        }

        public Object next() {
            if(this.hasNext()) return NUMBERS[ind++];
            return null;
        }
    }
}
