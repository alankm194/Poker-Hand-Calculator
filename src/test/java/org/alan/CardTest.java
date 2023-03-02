package org.alan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {


    @Test
    void testHand(){
        assertEquals(2, Card.TWO.getValue());
    }

}
