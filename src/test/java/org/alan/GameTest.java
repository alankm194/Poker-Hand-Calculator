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
        
    }

    @Test
    void testGetPlayerHands() {

        Hand player1 = new Hand();
        player1.setHand(List.of(
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.DIAMOND)
        ));
        Hand player2 = new Hand();
        player2.setHand(List.of(
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

        Hand player1 = new Hand();
        player1.setHand(STRAIGHT_FLUSH);
        Hand player2 = new Hand();
        player2.setHand(STRAIGHT_FLUSH);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.STRAIGHT_FLUSH, player1.getHandRank());
    }

    @Test
    void testPlayersHandHasFourOfAKindFlush() {
        Hand player1 = new Hand();
        player1.setHand(FOUR_OF_A_KIND);
        Hand player2 = new Hand();
        player2.setHand(FOUR_OF_A_KIND);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.FOUR_OF_A_KIND, player1.getHandRank());
    }

    @Test
    void testPlayersHandHasFullHouse() {
        Hand player1 = new Hand();
        player1.setHand(FULL_HOUSE);
        Hand player2 = new Hand();
        player2.setHand(FULL_HOUSE);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.FULL_HOUSE, player1.getHandRank());
    }

    @Test
    void testPlayersHandHasFlush() {

        Hand player1 = new Hand();
        player1.setHand(FLUSH);
        Hand player2 = new Hand();
        player2.setHand(FLUSH);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.FLUSH, player1.getHandRank());
    }

    @Test
    void testPlayersHandHasStraight() {
        Hand player1 = new Hand();
        player1.setHand(STRAIGHT);
        Hand player2 = new Hand();
        player2.setHand(STRAIGHT);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.STRAIGHT, player1.getHandRank());
    }

    @Test
    void testPlayerHasThreeOfAKind() {
        Hand player1 = new Hand();
        player1.setHand(THREE_OF_A_KIND);
        Hand player2 = new Hand();
        player2.setHand(THREE_OF_A_KIND);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.THREE_OF_A_KIND, player1.getHandRank());
    }

    @Test
    void testPlayerHasTwoPair() {
        Hand player1 = new Hand();
        player1.setHand(TWO_PAIR);
        Hand player2 = new Hand();
        player2.setHand(TWO_PAIR);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.TWO_PAIR, player1.getHandRank());
    }

}
