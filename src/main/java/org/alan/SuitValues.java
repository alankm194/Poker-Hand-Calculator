package org.alan;

public enum SuitValues {

    DIAMOND(1),
    CLUB(2),
    HEARTS(3),
    SPADES(4);

    private final int value;

    SuitValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
