package org.alan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {

    @Test
    void testGetFaceValue() {
        Card ace = new Card(FaceValues.ACE, SuitValues.SPADES);
        assertEquals(FaceValues.ACE, ace.getFaceValue());
    }

    @ParameterizedTest
    @CsvSource({"DIAMOND", "CLUB", "HEARTS", "SPADES",})
    void testGetSuitValue(String input) {
        Card ace = new Card(FaceValues.ACE, SuitValues.valueOf(input));
        assertEquals(SuitValues.valueOf(input), ace.getSuitValue());
    }
}
