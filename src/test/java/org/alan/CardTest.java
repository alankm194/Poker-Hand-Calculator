package org.alan;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {

    @ParameterizedTest
    @CsvSource({"ACE", "KING", "TWO", "THREE", "SEVEN", "NINE", "TEN", "JACK"})
    void testGetFaceValue(String input) {
        Card card = new Card(FaceValues.valueOf(input), SuitValues.SPADES);
        assertEquals(FaceValues.valueOf(input), card.getFaceValue());
    }

    @ParameterizedTest
    @CsvSource({"DIAMOND", "CLUB", "HEARTS", "SPADES",})
    void testGetSuitValue(String input) {
        Card card = new Card(FaceValues.ACE, SuitValues.valueOf(input));
        assertEquals(SuitValues.valueOf(input), card.getSuitValue());
    }
}
