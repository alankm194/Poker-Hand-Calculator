package org.alan.card;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toMap;

public enum SuitValues {

    DIAMOND(1, "D"),
    CLUB(2, "C"),
    HEARTS(3, "H"),
    SPADES(4, "S");

    private final int value;
    private final String abbreviation;

    private static final Map<String, SuitValues> abbreviationToSuitMap;

    static {
        abbreviationToSuitMap = Stream.of(SuitValues.values())
                .collect(toMap(SuitValues::getAbbreviation, identity()));
    }


    SuitValues(int value, String abbreviation) {
        this.value = value;
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
    public int getValue() {
        return value;
    }

    public SuitValues getFaceValueFromAbbreviation(String abbreviation) {
        return abbreviationToSuitMap.get(abbreviation);
    }
}
