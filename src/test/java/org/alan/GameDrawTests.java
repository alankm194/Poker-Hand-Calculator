package org.alan;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameDrawTests {


    @Test
    void testStraightDraws() {

        var straightListWinner = List.of(
                new Card(FaceValues.KING, SuitValues.SPADES),
                new Card(FaceValues.JACK, SuitValues.DIAMOND),
                new Card(FaceValues.QUEEN, SuitValues.SPADES),
                new Card(FaceValues.TEN, SuitValues.CLUB),
                new Card(FaceValues.NINE, SuitValues.SPADES)
        );
        var straightListLoser = List.of(
                new Card(FaceValues.THREE, SuitValues.SPADES),
                new Card(FaceValues.FIVE, SuitValues.DIAMOND),
                new Card(FaceValues.FOUR, SuitValues.SPADES),
                new Card(FaceValues.SIX, SuitValues.CLUB),
                new Card(FaceValues.SEVEN, SuitValues.SPADES)
        );
        Player player1 = new Player("player1", new Hand(straightListLoser));
        Player player2 = new Player("player2", new Hand(straightListWinner));
        Game game = new Game(player1, player2);
        Player winner = game.getWinnerOfGame();

        assertEquals(player2, winner);
    }
}
