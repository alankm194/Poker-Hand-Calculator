package org.alan;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {


    @Test
    void testGetHand() {
        Hand hand1 = new Hand(List.of(
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.DIAMOND)
                ));
        Player player1 = new Player("white", hand1);
        assertEquals(hand1.getCards(), player1.getHand().getCards());
        assertEquals("white", player1.getName());
    }
}
