package org.alan;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GameDrawTests {


    @Test
    void whenTwoHandsAreStraights_findWinnerWithHighCard() {

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

    @Test
    void whenTwoHandsAreStraightsAndBothAreEqual_ReturnNull() {

        var straightListDraw1 = List.of(
                new Card(FaceValues.KING, SuitValues.SPADES),
                new Card(FaceValues.JACK, SuitValues.DIAMOND),
                new Card(FaceValues.QUEEN, SuitValues.SPADES),
                new Card(FaceValues.TEN, SuitValues.CLUB),
                new Card(FaceValues.NINE, SuitValues.SPADES)
        );
        var straightListDraw2 = List.of(
                new Card(FaceValues.KING, SuitValues.SPADES),
                new Card(FaceValues.JACK, SuitValues.HEARTS),
                new Card(FaceValues.QUEEN, SuitValues.SPADES),
                new Card(FaceValues.TEN, SuitValues.CLUB),
                new Card(FaceValues.NINE, SuitValues.SPADES)
        );
        Player player1 = new Player("player1", new Hand(straightListDraw1));
        Player player2 = new Player("player2", new Hand(straightListDraw2));
        Game game = new Game(player1, player2);
        Player winner = game.getWinnerOfGame();

        assertNull( winner);
    }
}