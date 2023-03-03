package org.alan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testEqualsReflexive() {
        Card a = new Card(FaceValues.KING, SuitValues.SPADES);
        assertTrue(a.equals(a));
    }

    @Test
    void testEqualsSymmetric() {
        Card a = new Card(FaceValues.KING, SuitValues.SPADES);
        Card b = new Card(FaceValues.KING, SuitValues.SPADES);
        assertTrue(a.equals(b));
    }

    @Test
    void testEqualsTransitive() {
        Card a = new Card(FaceValues.KING, SuitValues.SPADES);
        Card b = new Card(FaceValues.KING, SuitValues.SPADES);
        Card c = new Card(FaceValues.KING, SuitValues.SPADES);
        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }

    @Test
    void testHashCodeProduceSameHash() {
        var cardList = List.of(new Card(FaceValues.FOUR, SuitValues.CLUB),
                new Card(FaceValues.TWO, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.SPADES),
                new Card(FaceValues.FOUR, SuitValues.HEARTS));

        var hashCodeList = cardList
                .stream()
                .map(Objects::hashCode)
                .collect(Collectors.toList());

        assertEquals(hashCodeList, cardList.stream().map(Card::hashCode).toList());
    }

    @Test
    void testCompareToGreaterThan() {
        Card greater = new Card(FaceValues.ACE, SuitValues.SPADES);
        Card lesser = new Card(FaceValues.KING, SuitValues.DIAMOND);

        assertEquals(1, greater.compareTo(lesser));
    }


    @Test
    void testCompareToLesserThan() {
        Card greater = new Card(FaceValues.ACE, SuitValues.SPADES);
        Card lesser = new Card(FaceValues.KING, SuitValues.DIAMOND);

        assertEquals(-1, lesser.compareTo(greater));
    }

    @Test
    void testCompareToEquals() {
        Card same = new Card(FaceValues.ACE, SuitValues.SPADES);
        Card same2 = new Card(FaceValues.ACE, SuitValues.SPADES);

        assertEquals(0, same.compareTo(same2));
    }
}
