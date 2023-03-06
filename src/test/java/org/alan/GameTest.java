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

    private static Player PLAYER;

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

        PLAYER = new Player("player1", new Hand(HIGH_CARD));
    }

    @Test
    void testPlayingHandWithNoDraws() {
        Player player1 = new Player("player1", new Hand(HIGH_CARD));
        Player player2 = new Player("player2", new Hand(PAIR));
        Game game = new Game(player1, player2);
        Player winner = game.getWinnerOfGame();
        assertEquals("player2", winner.getName());
        assertEquals(PAIR.stream().sorted().toList(), winner.getHand().getCards());
    }

    @Test
    void testGetPlayerHands() {

        Hand hand1 = new Hand(List.of(
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND)
        ));
        Hand hand2 = new Hand(List.of(
                new Card(FaceValues.KING, SuitValues.CLUB),
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND)
        ));
        Player player1 = new Player("player1", hand1);
        Player player2 = new Player("player2", hand2);
        Game game = new Game(player1, player2);
        assertEquals(hand1.getCards(), game.getPlayer1().getHand().getCards());
        assertEquals(hand2.getCards(), game.getPlayer2().getHand().getCards());
        assertEquals("player1", game.getPlayer1().getName());
        assertEquals("player2", game.getPlayer2().getName());
    }

    @Test
    void testPlayersHandHasStraightFlush() {
        Hand player1 = new Hand(STRAIGHT_FLUSH);
        Game game = new Game(PLAYER, PLAYER);
        game.rankHand(player1);
        assertEquals(HandRank.STRAIGHT_FLUSH, player1.getHandRank());
    }

    @Test
    void testPlayersHandHasFourOfAKindFlush() {
        Hand hand1 = new Hand(FOUR_OF_A_KIND);
        Game game = new Game(PLAYER, PLAYER);
        game.rankHand(hand1);
        assertEquals(HandRank.FOUR_OF_A_KIND, hand1.getHandRank());
    }

    @Test
    void testPlayersHandHasFullHouse() {
        Hand hand1 = new Hand(FULL_HOUSE);
        Game game = new Game(PLAYER, PLAYER);
        game.rankHand(hand1);
        assertEquals(HandRank.FULL_HOUSE, hand1.getHandRank());
    }

    @Test
    void testPlayersHandHasFlush() {
        Hand hand1 = new Hand(FLUSH);
        Game game = new Game(PLAYER, PLAYER);
        game.rankHand(hand1);
        assertEquals(HandRank.FLUSH, hand1.getHandRank());
    }

    @Test
    void testPlayersHandHasStraight() {
        Hand hand1 = new Hand(STRAIGHT);
        Game game = new Game(PLAYER, PLAYER);
        game.rankHand(hand1);
        assertEquals(HandRank.STRAIGHT, hand1.getHandRank());
    }

    @Test
    void testPlayerHasThreeOfAKind() {
        Hand hand1 = new Hand(THREE_OF_A_KIND);
        Game game = new Game(PLAYER, PLAYER);
        game.rankHand(hand1);
        assertEquals(HandRank.THREE_OF_A_KIND, hand1.getHandRank());
    }

    @Test
    void testPlayerHasTwoPair() {
        Hand hand1 = new Hand(TWO_PAIR);
        Game game = new Game(PLAYER, PLAYER);
        game.rankHand(hand1);
        assertEquals(HandRank.TWO_PAIR, hand1.getHandRank());
    }

    @Test
    void testPlayerHasPair() {
        Hand hand1 = new Hand(PAIR);
        Game game = new Game(PLAYER, PLAYER);
        game.rankHand(hand1);
        assertEquals(HandRank.PAIR, hand1.getHandRank());
    }

    @Test
    void testPlayerHasCardHigh() {
        Hand hand1 = new Hand(HIGH_CARD);
        Game game = new Game(PLAYER, PLAYER);
        game.rankHand(hand1);
        assertEquals(HandRank.HIGH_CARD, hand1.getHandRank());
    }
}
