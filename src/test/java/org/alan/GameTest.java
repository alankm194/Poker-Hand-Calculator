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
}
