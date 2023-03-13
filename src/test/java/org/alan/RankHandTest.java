package org.alan;

import org.alan.card.Card;
import org.alan.card.FaceValues;
import org.alan.card.SuitValues;
import org.alan.hands.Hand;
import org.alan.hands.HandRank;
import org.alan.hands.RankHand;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankHandTest {

    private static List<Card> STRAIGHT_FLUSH;
    private static List<Card> FOUR_OF_A_KIND;
    private static List<Card> FULL_HOUSE;
    private static List<Card> FLUSH;
    private static List<Card> STRAIGHT;
    private static List<Card> THREE_OF_A_KIND;
    private static List<Card> TWO_PAIR;
    private static List<Card> PAIR;
    private static List<Card> HIGH_CARD;

    private RankHand rankHand;
    @BeforeAll
    static void initBeforeAll() {
        STRAIGHT_FLUSH = List.of(
                new Card(FaceValues.FIVE, SuitValues.SPADES),
                new Card(FaceValues.SIX, SuitValues.SPADES),
                new Card(FaceValues.EIGHT, SuitValues.SPADES),
                new Card(FaceValues.SEVEN, SuitValues.SPADES),
                new Card(FaceValues.FOUR, SuitValues.SPADES)
        );

        FOUR_OF_A_KIND = List.of(
                new Card(FaceValues.KING, SuitValues.SPADES),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.CLUB),
                new Card(FaceValues.FIVE, SuitValues.HEARTS)
        );

        FULL_HOUSE = List.of(
                new Card(FaceValues.KING, SuitValues.SPADES),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.FIVE, SuitValues.DIAMOND),
                new Card(FaceValues.FIVE, SuitValues.CLUB),
                new Card(FaceValues.FIVE, SuitValues.HEARTS)
        );

        FLUSH = List.of(
                new Card(FaceValues.KING, SuitValues.SPADES),
                new Card(FaceValues.JACK, SuitValues.SPADES),
                new Card(FaceValues.FIVE, SuitValues.SPADES),
                new Card(FaceValues.FIVE, SuitValues.SPADES),
                new Card(FaceValues.FIVE, SuitValues.SPADES)
        );

        STRAIGHT = List.of(
                new Card(FaceValues.KING, SuitValues.SPADES),
                new Card(FaceValues.JACK, SuitValues.DIAMOND),
                new Card(FaceValues.QUEEN, SuitValues.SPADES),
                new Card(FaceValues.TEN, SuitValues.CLUB),
                new Card(FaceValues.NINE, SuitValues.SPADES)
        );

        THREE_OF_A_KIND = List.of(
                new Card(FaceValues.JACK, SuitValues.SPADES),
                new Card(FaceValues.JACK, SuitValues.DIAMOND),
                new Card(FaceValues.JACK, SuitValues.SPADES),
                new Card(FaceValues.TEN, SuitValues.CLUB),
                new Card(FaceValues.NINE, SuitValues.SPADES)
        );

        TWO_PAIR = List.of(
                new Card(FaceValues.JACK, SuitValues.SPADES),
                new Card(FaceValues.JACK, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.SPADES),
                new Card(FaceValues.ACE, SuitValues.CLUB),
                new Card(FaceValues.NINE, SuitValues.SPADES)
        );
        PAIR = List.of(
                new Card(FaceValues.JACK, SuitValues.SPADES),
                new Card(FaceValues.SEVEN, SuitValues.DIAMOND),
                new Card(FaceValues.EIGHT, SuitValues.SPADES),
                new Card(FaceValues.NINE, SuitValues.CLUB),
                new Card(FaceValues.NINE, SuitValues.SPADES)
        );

        HIGH_CARD = List.of(
                new Card(FaceValues.JACK, SuitValues.SPADES),
                new Card(FaceValues.SEVEN, SuitValues.DIAMOND),
                new Card(FaceValues.EIGHT, SuitValues.SPADES),
                new Card(FaceValues.NINE, SuitValues.CLUB),
                new Card(FaceValues.THREE, SuitValues.SPADES)
        );
    }

    @BeforeEach
    void initBeforeEach(){
        rankHand = new RankHand();
    }

    @Test
    void testPlayersHandHasStraightFlush() {
        Hand straightFlush = rankHand.rankHand(STRAIGHT_FLUSH);
        assertEquals(HandRank.STRAIGHT_FLUSH, straightFlush.getHandRank());
    }

    @Test
    void testPlayersHandHasFourOfAKindFlush() {
        Hand fourOfAKind = rankHand.rankHand(FOUR_OF_A_KIND);
        assertEquals(HandRank.FOUR_OF_A_KIND, fourOfAKind.getHandRank());
    }

    @Test
    void testPlayersHandHasFullHouse() {
        Hand fullHouse = rankHand.rankHand(FULL_HOUSE);
        assertEquals(HandRank.FULL_HOUSE, fullHouse.getHandRank());
    }

    @Test
    void testPlayersHandHasFlush() {
        Hand flush = rankHand.rankHand(FLUSH);
        assertEquals(HandRank.FLUSH, flush.getHandRank());
    }

    @Test
    void testPlayersHandHasStraight() {
        Hand straight = rankHand.rankHand(STRAIGHT);
        assertEquals(HandRank.STRAIGHT, straight.getHandRank());
    }

    @Test
    void testPlayerHasThreeOfAKind() {
        Hand threeOfAKind = rankHand.rankHand(THREE_OF_A_KIND);
        assertEquals(HandRank.THREE_OF_A_KIND, threeOfAKind.getHandRank());
    }

    @Test
    void testPlayerHasTwoPair() {
        Hand twoPair = rankHand.rankHand(TWO_PAIR);
        assertEquals(HandRank.TWO_PAIR, twoPair.getHandRank());
    }
//
    @Test
    void testPlayerHasPair() {
        Hand Pair = rankHand.rankHand(PAIR);
        assertEquals(HandRank.PAIR, Pair.getHandRank());
    }

    @Test
    void testPlayerHasCardHigh() {
        Hand highCard = rankHand.rankHand(HIGH_CARD);
        assertEquals(HandRank.HIGH_CARD, highCard.getHandRank());
    }
}
