package org.alan;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuitValuesTest {

    @ParameterizedTest
    @CsvSource({"DIAMOND, 1", "CLUB, 2", "HEARTS, 3", "SPADES, 4"})
    void testGettingSuitValues(String suit, int value) {
        assertEquals(value, SuitValues.valueOf(suit).getValue());
    }

}
