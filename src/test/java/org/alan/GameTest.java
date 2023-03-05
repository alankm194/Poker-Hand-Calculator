package org.alan;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

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
        var straightFlush = List.of(
                new Card(FaceValues.FIVE, SuitValues.SPADES),
                new Card(FaceValues.SIX, SuitValues.SPADES),
                new Card(FaceValues.EIGHT, SuitValues.SPADES),
                new Card(FaceValues.SEVEN, SuitValues.SPADES),
                new Card(FaceValues.FOUR, SuitValues.SPADES)
        );
        Hand player1 = new Hand();
        player1.setHand(straightFlush);
        Hand player2 = new Hand();
        player2.setHand(straightFlush);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.STRAIGHT_FLUSH, player1.getHandRank());
    }

    @Test
    void testPlayersHandHasFourOfAKindFlush() {
        var fourKind = List.of(
                new Card(FaceValues.KING, SuitValues.SPADES),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.CLUB),
                new Card(FaceValues.FIVE, SuitValues.HEARTS)
        );
        Hand player1 = new Hand();
        player1.setHand(fourKind);
        Hand player2 = new Hand();
        player2.setHand(fourKind);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.FOUR_OF_A_KIND, player1.getHandRank());
    }

    @Test
    void testPlayersHandHasFullHouse() {
        var fullhouse = List.of(
                new Card(FaceValues.KING, SuitValues.SPADES),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.FIVE, SuitValues.DIAMOND),
                new Card(FaceValues.FIVE, SuitValues.CLUB),
                new Card(FaceValues.FIVE, SuitValues.HEARTS)
        );
        Hand player1 = new Hand();
        player1.setHand(fullhouse);
        Hand player2 = new Hand();
        player2.setHand(fullhouse);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.FULL_HOUSE, player1.getHandRank());
    }

    @Test
    void testPlayersHandHasFlush() {
        var flush = List.of(
                new Card(FaceValues.KING, SuitValues.SPADES),
                new Card(FaceValues.JACK, SuitValues.SPADES),
                new Card(FaceValues.FIVE, SuitValues.SPADES),
                new Card(FaceValues.FIVE, SuitValues.SPADES),
                new Card(FaceValues.FIVE, SuitValues.SPADES)
        );
        Hand player1 = new Hand();
        player1.setHand(flush);
        Hand player2 = new Hand();
        player2.setHand(flush);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.FLUSH, player1.getHandRank());
    }

    @Test
    void testPlayersHandHasStraight() {
        var flush = List.of(
                new Card(FaceValues.KING, SuitValues.SPADES),
                new Card(FaceValues.JACK, SuitValues.DIAMOND),
                new Card(FaceValues.QUEEN, SuitValues.SPADES),
                new Card(FaceValues.TEN, SuitValues.CLUB),
                new Card(FaceValues.NINE, SuitValues.SPADES)
        );
        Hand player1 = new Hand();
        player1.setHand(flush);
        Hand player2 = new Hand();
        player2.setHand(flush);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.STRAIGHT, player1.getHandRank());
    }

    @Test
    void testPlayerHasThreeOfAKind() {
        var ThreeOfKind = List.of(
                new Card(FaceValues.JACK, SuitValues.SPADES),
                new Card(FaceValues.JACK, SuitValues.DIAMOND),
                new Card(FaceValues.JACK, SuitValues.SPADES),
                new Card(FaceValues.TEN, SuitValues.CLUB),
                new Card(FaceValues.NINE, SuitValues.SPADES)
        );
        Hand player1 = new Hand();
        player1.setHand(ThreeOfKind);
        Hand player2 = new Hand();
        player2.setHand(ThreeOfKind);
        Game game = new Game(player1, player2);
        game.rankHand(player1);
        assertEquals(HandRank.THREE_OF_A_KIND, player1.getHandRank());
    }
}
