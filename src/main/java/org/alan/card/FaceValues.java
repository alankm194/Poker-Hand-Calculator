package org.alan.card;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toMap;

public enum FaceValues {

    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(11, "J"),
    QUEEN(12, "Q"),
    KING(13, "K"),
    ACE(14, "A");

    private final int value;
    private static final Map<String, FaceValues> abbreviationToFaceMap;

    static {
        abbreviationToFaceMap = Stream.of(FaceValues.values())
                .collect(toMap(FaceValues::getAbbreviation, identity()));
    }

    private final String abbreviation;
    FaceValues (int value, String abbreviation) {
        this.value = value;
        this.abbreviation = abbreviation;
    }

    public int getValue() { return value; }

    public String getAbbreviation() {
        return abbreviation;
    }

    public FaceValues getFaceValueFromAbbreviation(String abbreviation) {
        return abbreviationToFaceMap.get(abbreviation);
    }
}
