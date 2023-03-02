package org.alan;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FaceValuesTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/faceValuesTest.csv", numLinesToSkip = 1)
    void testGettingCorrectCardValues(String card, int expectedValue){
        assertEquals(expectedValue, FaceValues.valueOf(card).getValue());
    }

}
