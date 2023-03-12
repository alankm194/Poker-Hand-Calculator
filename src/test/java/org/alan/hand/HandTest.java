package org.alan.hand;

import org.alan.card.Card;
import org.alan.card.FaceValues;
import org.alan.card.SuitValues;
import org.alan.hands.FlushHand;
import org.alan.hands.Hand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {


    @Test
    void testGetCardsFromHand() {
        var expectedList = Stream.of(
                        new Card(FaceValues.ACE, SuitValues.SPADES),
                        new Card(FaceValues.FOUR, SuitValues.HEARTS),
                        new Card(FaceValues.KING, SuitValues.CLUB),
                        new Card(FaceValues.JACK, SuitValues.CLUB),
                        new Card(FaceValues.THREE, SuitValues.DIAMOND))
                .collect(Collectors.toList());
        Hand hand = new FlushHand(expectedList);
        assertTrue(hand.getCards().containsAll(expectedList));
    }

    @Test
    @DisplayName("Throw illegalArgumentException when trying to set a Hand with more than 5 cards")
    void whenHandIsGivenListOver5Cards_ThrowIllegalArgumentException() {
        var cardsList = new ArrayList<Card>();
        for (int i = 0; i < 6; i++) {
            cardsList.add(new Card(FaceValues.ACE, SuitValues.SPADES));
        }

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new FlushHand(cardsList),
                "Hand cannot set hand of more than 5 cards."
        );
        assertEquals("A legal hand must be 5 cards", thrown.getMessage());
    }




}
