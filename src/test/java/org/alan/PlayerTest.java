package org.alan;

import org.alan.card.Card;
import org.alan.card.FaceValues;
import org.alan.card.SuitValues;
import org.alan.hands.RankHand;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {


    @Test
    void testGetHand() {
        var listCards = List.of(
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.DIAMOND)
                );

        Player player1 = new Player("white", new RankHand().rankHand(listCards));
        assertEquals(listCards, player1.hand().getCards());
        assertEquals("white", player1.name());
    }
}
