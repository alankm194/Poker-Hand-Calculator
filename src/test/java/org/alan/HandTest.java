package org.alan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HandTest {


    @Test
    void testGetCardsFromHand() {
        Hand hand = new Hand();
        var expectedList = Stream.of(
                        new Card(FaceValues.ACE, SuitValues.SPADES),
                        new Card(FaceValues.FOUR, SuitValues.HEARTS),
                        new Card(FaceValues.KING, SuitValues.CLUB),
                        new Card(FaceValues.JACK, SuitValues.CLUB),
                        new Card(FaceValues.THREE, SuitValues.DIAMOND))
                .collect(Collectors.toList());
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

    @Test
    void whenSettingHandTest() {
        var hand = new Hand();
        List<Card> cardList = Stream.of(
                        new Card(FaceValues.ACE, SuitValues.SPADES),
                        new Card(FaceValues.FOUR, SuitValues.HEARTS),
                        new Card(FaceValues.KING, SuitValues.CLUB),
                        new Card(FaceValues.JACK, SuitValues.CLUB),
                        new Card(FaceValues.THREE, SuitValues.DIAMOND))
                .collect(Collectors.toList());
        var expectedList = cardList.stream().sorted().toList();
        hand.setHand(cardList);
        assertEquals(expectedList, hand.getHand());
    }
}
