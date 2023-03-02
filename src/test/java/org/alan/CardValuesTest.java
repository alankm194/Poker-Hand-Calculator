package org.alan;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardValuesTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/cardValuesTest.csv", numLinesToSkip = 1)
    void testHand(String card, int expectedValue){
        assertEquals(expectedValue, CardValues.valueOf(card).getValue());
    }

}
