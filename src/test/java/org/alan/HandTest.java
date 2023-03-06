package org.alan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
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
        Hand hand = new Hand(expectedList);
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
                () -> new Hand(cardsList),
                "Hand cannot set hand of more than 5 cards."
        );
        assertEquals("A legal hand must be 5 cards", thrown.getMessage());
    }

    @Test
    void whenSettingHandTest_ensureHandIsSorted() {
        List<Card> cardList = Stream.of(
                        new Card(FaceValues.ACE, SuitValues.SPADES),
                        new Card(FaceValues.FOUR, SuitValues.HEARTS),
                        new Card(FaceValues.KING, SuitValues.CLUB),
                        new Card(FaceValues.JACK, SuitValues.CLUB),
                        new Card(FaceValues.THREE, SuitValues.DIAMOND))
                .collect(Collectors.toList());
        var expectedList = cardList.stream().sorted().toList();
        var hand = new Hand(cardList);
        assertEquals(expectedList, hand.getCards());
    }

    @ParameterizedTest
    @CsvSource({"FOUR_OF_A_KIND", "STRAIGHT_FLUSH", "FLUSH", "HIGH_CARD"})
    void testAssignHandRank(String handRank) {
        Hand hand = new Hand(List.of(
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.DIAMOND)
        ));
        hand.setHandRank(HandRank.valueOf(handRank));
        assertEquals(HandRank.valueOf(handRank), hand.getHandRank());
    }
}
