package org.alan;

public enum Card {

    TWO(2);

    private final int value;
    Card (int value) {
        this.value = value;
    }

    public int getValue() { return value; }
}
