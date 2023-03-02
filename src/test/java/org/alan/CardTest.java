package org.alan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {

    @Test
    void testGetFaceValue() {
        Card ace = new Card(FaceValues.ACE, SuitValues.SPADES);
        assertEquals(FaceValues.ACE, ace.getFaceValue());
    }

    @Test
    void testGetSuitValue() {
        Card ace = new Card(FaceValues.ACE, SuitValues.SPADES);
        assertEquals(SuitValues.SPADES, ace.getSuitValue());
    }
}
