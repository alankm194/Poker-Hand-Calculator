package org.alan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {

    @Test
    void testGetFaceValue() {
        Card ace = new Card(CardValues.ACE);
        assertEquals(CardValues.ACE, ace.getFaceValue());
    }

}
