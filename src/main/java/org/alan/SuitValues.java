package org.alan;

public enum SuitValues {

    DIAMOND(1);

    private final int value;

    SuitValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
