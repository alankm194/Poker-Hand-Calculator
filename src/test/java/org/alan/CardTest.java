package org.alan;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/handTest.csv", numLinesToSkip = 1)
    void testHand(String card, int expectedValue){
        assertEquals(expectedValue, Card.valueOf(card).getValue());
    }

}
