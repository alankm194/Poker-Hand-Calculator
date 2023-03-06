package org.alan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    private static List<Card> STRAIGHT_FLUSH;
    private static List<Card> FOUR_OF_A_KIND;
    private static List<Card> FULL_HOUSE;
    private static List<Card> FLUSH;
    private static List<Card> STRAIGHT;
    private static List<Card> THREE_OF_A_KIND;
    private static List<Card> TWO_PAIR;
    private static List<Card> PAIR;
    private static List<Card> HIGH_CARD;


    @BeforeAll
    static void init() {
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

    @Test
    void testGetPlayerHands() {

        Hand player1 = new Hand(List.of(
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND)
        ));
        Hand player2 = new Hand(List.of(
                new Card(FaceValues.KING, SuitValues.CLUB),
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND)
        ));
        Game game = new Game(player1, player2);
        assertEquals(player1.getHand(), game.getPlayer1Hand().getHand());
        assertEquals(player2.getHand(), game.getPlayer2Hand().getHand());
    }

    @Test
    void testPlayersHandHasStraightFlush() {
        Hand player1 = new Hand(STRAIGHT_FLUSH);
        Hand player2 = new Hand(STRAIGHT_FLUSH);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.STRAIGHT_FLUSH, player1.getHandRank());
    }

    @Test
    void testPlayersHandHasFourOfAKindFlush() {
        Hand player1 = new Hand(FOUR_OF_A_KIND);
        Hand player2 = new Hand(FOUR_OF_A_KIND);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.FOUR_OF_A_KIND, player1.getHandRank());
    }

    @Test
    void testPlayersHandHasFullHouse() {
        Hand player1 = new Hand(FULL_HOUSE);
        Hand player2 = new Hand(FULL_HOUSE);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.FULL_HOUSE, player1.getHandRank());
    }

    @Test
    void testPlayersHandHasFlush() {
        Hand player1 = new Hand(FLUSH);
        Hand player2 = new Hand(FLUSH);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.FLUSH, player1.getHandRank());
    }

    @Test
    void testPlayersHandHasStraight() {
        Hand player1 = new Hand(STRAIGHT);
        Hand player2 = new Hand(STRAIGHT);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.STRAIGHT, player1.getHandRank());
    }

    @Test
    void testPlayerHasThreeOfAKind() {
        Hand player1 = new Hand(THREE_OF_A_KIND);
        Hand player2 = new Hand(THREE_OF_A_KIND);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.THREE_OF_A_KIND, player1.getHandRank());
    }

    @Test
    void testPlayerHasTwoPair() {
        Hand player1 = new Hand(TWO_PAIR);
        Hand player2 = new Hand(TWO_PAIR);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.TWO_PAIR, player1.getHandRank());
    }

    @Test
    void testPlayerHasPair() {
        Hand player1 = new Hand(PAIR);
        Hand player2 = new Hand(PAIR);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.PAIR, player1.getHandRank());
    }

    @Test
    void testPlayerHasCardHigh() {
        Hand player1 = new Hand(HIGH_CARD);
        Hand player2 = new Hand(HIGH_CARD);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.HIGH_CARD, player1.getHandRank());
    }
}
