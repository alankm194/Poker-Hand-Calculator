package org.alan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("Throw illegalArgumentException when trying to set a Hand with more than 5 cards")
    void whenHandIsGivenListOver5Cards_ThrowIllegalArgumentException() {
        var hand = new Hand();
        var cardsList = new ArrayList<Card>();
        for (int i = 0; i < 6; i++) {
            cardsList.add(new Card(FaceValues.ACE, SuitValues.SPADES));
        }

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> hand.setHand(cardsList),
                "Hand cannot set hand of more than 5 cards."
        );
        assertEquals("A legal hand must be 5 cards", thrown.getMessage());
    }
}
