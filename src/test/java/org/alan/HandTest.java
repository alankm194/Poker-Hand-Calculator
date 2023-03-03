package org.alan;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandTest {

    @Test
    void testGetCardsFromHand() {
        Hand hand = new Hand();
        var expectedList = List.of(
                new Card(FaceValues.ACE, SuitValues.SPADES),
                new Card(FaceValues.FOUR, SuitValues.HEARTS),
                new Card(FaceValues.KING, SuitValues.CLUB),
                new Card(FaceValues.JACK, SuitValues.CLUB),
                new Card(FaceValues.THREE, SuitValues.DIAMOND));
        hand.setHand(expectedList);
        assertEquals(expectedList, hand.getHand());
    }
}
