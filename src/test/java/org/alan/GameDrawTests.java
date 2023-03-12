//package org.alan;
//
//import org.alan.Card.Card;
//import org.alan.Card.FaceValues;
//import org.alan.Card.SuitValues;
//import org.alan.hands.Hand;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//public class GameDrawTests {
//    @Test
//    void whenTwoHandsAreStraightFlushAndBothHandsEqual_returnNull() {
//
//        var straightFlushList1 = List.of(
//                new Card(FaceValues.JACK, SuitValues.SPADES),
//                new Card(FaceValues.EIGHT, SuitValues.SPADES),
//                new Card(FaceValues.QUEEN, SuitValues.SPADES),
//                new Card(FaceValues.TEN, SuitValues.SPADES),
//                new Card(FaceValues.NINE, SuitValues.SPADES)
//        );
//        var straightFlushList2 = List.of(
//                new Card(FaceValues.JACK, SuitValues.DIAMOND),
//                new Card(FaceValues.EIGHT, SuitValues.DIAMOND),
//                new Card(FaceValues.QUEEN, SuitValues.DIAMOND),
//                new Card(FaceValues.TEN, SuitValues.DIAMOND),
//                new Card(FaceValues.NINE, SuitValues.DIAMOND)
//        );
//        Player player1 = new Player("player1", new Hand(straightFlushList1));
//        Player player2 = new Player("player2", new Hand(straightFlushList2));
//        Game game = new Game(player1, player2);
//        Player winner = game.getWinnerOfGame();
//
//        assertNull(winner);
//    }
//    @Test
//    void whenTwoHandsAreStraightFlush_findWinnerWithHighCard() {
//
//        var straightListWinner = List.of(
//                new Card(FaceValues.JACK, SuitValues.SPADES),
//                new Card(FaceValues.EIGHT, SuitValues.SPADES),
//                new Card(FaceValues.QUEEN, SuitValues.SPADES),
//                new Card(FaceValues.TEN, SuitValues.SPADES),
//                new Card(FaceValues.NINE, SuitValues.SPADES)
//        );
//        var straightListLoser = List.of(
//                new Card(FaceValues.SEVEN, SuitValues.CLUB),
//                new Card(FaceValues.FIVE, SuitValues.CLUB),
//                new Card(FaceValues.FOUR, SuitValues.CLUB),
//                new Card(FaceValues.SIX, SuitValues.CLUB),
//                new Card(FaceValues.THREE, SuitValues.CLUB)
//        );
//        Player player1 = new Player("player1", new Hand(straightListLoser));
//        Player player2 = new Player("player2", new Hand(straightListWinner));
//        Game game = new Game(player1, player2);
//        Player winner = game.getWinnerOfGame();
//
//        assertEquals(player2, winner);
//    }
//    @Test
//    void whenTwoHandsAreHighCard_findWinnerWithHighCard() {
//
//        var straightListWinner = List.of(
//                new Card(FaceValues.JACK, SuitValues.SPADES),
//                new Card(FaceValues.EIGHT, SuitValues.CLUB),
//                new Card(FaceValues.QUEEN, SuitValues.SPADES),
//                new Card(FaceValues.THREE, SuitValues.DIAMOND),
//                new Card(FaceValues.NINE, SuitValues.SPADES)
//        );
//        var straightListLoser = List.of(
//                new Card(FaceValues.SEVEN, SuitValues.CLUB),
//                new Card(FaceValues.FIVE, SuitValues.DIAMOND),
//                new Card(FaceValues.TEN, SuitValues.SPADES),
//                new Card(FaceValues.SIX, SuitValues.DIAMOND),
//                new Card(FaceValues.TWO, SuitValues.DIAMOND)
//        );
//        Player player1 = new Player("player1", new Hand(straightListLoser));
//        Player player2 = new Player("player2", new Hand(straightListWinner));
//        Game game = new Game(player1, player2);
//        Player winner = game.getWinnerOfGame();
//
//        assertEquals(player2, winner);
//    }
//    @Test
//    void whenTwoHandsAreHighCardAndBothHandsEqual_returnNull() {
//
//        var straightList1= List.of(
//                new Card(FaceValues.JACK, SuitValues.SPADES),
//                new Card(FaceValues.EIGHT, SuitValues.CLUB),
//                new Card(FaceValues.QUEEN, SuitValues.SPADES),
//                new Card(FaceValues.THREE, SuitValues.DIAMOND),
//                new Card(FaceValues.NINE, SuitValues.SPADES)
//        );
//        var straightList2 = List.of(
//                new Card(FaceValues.JACK, SuitValues.CLUB),
//                new Card(FaceValues.EIGHT, SuitValues.DIAMOND),
//                new Card(FaceValues.QUEEN,SuitValues.SPADES),
//                new Card(FaceValues.THREE,SuitValues.DIAMOND),
//                new Card(FaceValues.NINE, SuitValues.DIAMOND)
//        );
//        Player player1 = new Player("player1", new Hand(straightList1));
//        Player player2 = new Player("player2", new Hand(straightList2));
//        Game game = new Game(player1, player2);
//        Player winner = game.getWinnerOfGame();
//
//        assertNull(winner );
//    }
//    @Test
//    void whenTwoHandsAreFlushs_findWinnerWithHighCard() {
//
//        var straightListWinner = List.of(
//                new Card(FaceValues.ACE, SuitValues.SPADES),
//                new Card(FaceValues.EIGHT, SuitValues.SPADES),
//                new Card(FaceValues.QUEEN, SuitValues.SPADES),
//                new Card(FaceValues.JACK, SuitValues.SPADES),
//                new Card(FaceValues.NINE, SuitValues.SPADES)
//        );
//        var straightListLoser = List.of(
//                new Card(FaceValues.ACE, SuitValues.DIAMOND),
//                new Card(FaceValues.FIVE, SuitValues.DIAMOND),
//                new Card(FaceValues.FOUR, SuitValues.DIAMOND),
//                new Card(FaceValues.SIX, SuitValues.DIAMOND),
//                new Card(FaceValues.SEVEN, SuitValues.DIAMOND)
//        );
//        Player player1 = new Player("player1", new Hand(straightListLoser));
//        Player player2 = new Player("player2", new Hand(straightListWinner));
//        Game game = new Game(player1, player2);
//        Player winner = game.getWinnerOfGame();
//
//        assertEquals(player2, winner);
//    }
//
//    @Test
//    void whenTwoHandsAreFlushsAndBothHAndsAreEqual_returnNull() {
//
//        var straightList1 = List.of(
//                new Card(FaceValues.ACE, SuitValues.SPADES),
//                new Card(FaceValues.EIGHT, SuitValues.SPADES),
//                new Card(FaceValues.QUEEN, SuitValues.SPADES),
//                new Card(FaceValues.JACK, SuitValues.SPADES),
//                new Card(FaceValues.NINE, SuitValues.SPADES)
//        );
//        var straightList2 = List.of(
//                new Card(FaceValues.ACE, SuitValues.DIAMOND),
//                new Card(FaceValues.EIGHT, SuitValues.DIAMOND),
//                new Card(FaceValues.QUEEN, SuitValues.DIAMOND),
//                new Card(FaceValues.JACK, SuitValues.DIAMOND),
//                new Card(FaceValues.NINE, SuitValues.DIAMOND)
//        );
//        Player player1 = new Player("player1", new Hand(straightList1));
//        Player player2 = new Player("player2", new Hand(straightList2));
//        Game game = new Game(player1, player2);
//        Player winner = game.getWinnerOfGame();
//
//        assertNull( winner);
//    }
//
//    @Test
//    void whenTwoHandsAreStraights_findWinnerWithHighCard() {
//
//        var straightListWinner = List.of(
//                new Card(FaceValues.KING, SuitValues.SPADES),
//                new Card(FaceValues.JACK, SuitValues.DIAMOND),
//                new Card(FaceValues.QUEEN, SuitValues.SPADES),
//                new Card(FaceValues.TEN, SuitValues.CLUB),
//                new Card(FaceValues.NINE, SuitValues.SPADES)
//        );
//        var straightListLoser = List.of(
//                new Card(FaceValues.THREE, SuitValues.SPADES),
//                new Card(FaceValues.FIVE, SuitValues.DIAMOND),
//                new Card(FaceValues.FOUR, SuitValues.SPADES),
//                new Card(FaceValues.SIX, SuitValues.CLUB),
//                new Card(FaceValues.SEVEN, SuitValues.SPADES)
//        );
//        Player player1 = new Player("player1", new Hand(straightListLoser));
//        Player player2 = new Player("player2", new Hand(straightListWinner));
//        Game game = new Game(player1, player2);
//        Player winner = game.getWinnerOfGame();
//
//        assertEquals(player2, winner);
//    }
//
//    @Test
//    void whenTwoHandsAreStraightsAndBothAreEqual_ReturnNull() {
//
//        var straightListDraw1 = List.of(
//                new Card(FaceValues.KING, SuitValues.SPADES),
//                new Card(FaceValues.JACK, SuitValues.DIAMOND),
//                new Card(FaceValues.QUEEN, SuitValues.SPADES),
//                new Card(FaceValues.TEN, SuitValues.CLUB),
//                new Card(FaceValues.NINE, SuitValues.SPADES)
//        );
//        var straightListDraw2 = List.of(
//                new Card(FaceValues.KING, SuitValues.SPADES),
//                new Card(FaceValues.JACK, SuitValues.HEARTS),
//                new Card(FaceValues.QUEEN, SuitValues.SPADES),
//                new Card(FaceValues.TEN, SuitValues.CLUB),
//                new Card(FaceValues.NINE, SuitValues.SPADES)
//        );
//        Player player1 = new Player("player1", new Hand(straightListDraw1));
//        Player player2 = new Player("player2", new Hand(straightListDraw2));
//        Game game = new Game(player1, player2);
//        Player winner = game.getWinnerOfGame();
//
//        assertNull( winner);
//    }
//
//    @Test
//    void whenTwoHandsAre4OfAKinds_FindWinner() {
//
//        var straightListWinner = List.of(
//                new Card(FaceValues.KING, SuitValues.SPADES),
//                new Card(FaceValues.KING, SuitValues.DIAMOND),
//                new Card(FaceValues.KING, SuitValues.SPADES),
//                new Card(FaceValues.KING, SuitValues.CLUB),
//                new Card(FaceValues.NINE, SuitValues.SPADES)
//        );
//        var straightListLoser= List.of(
//                new Card(FaceValues.TEN, SuitValues.SPADES),
//                new Card(FaceValues.TEN, SuitValues.HEARTS),
//                new Card(FaceValues.TEN, SuitValues.SPADES),
//                new Card(FaceValues.TEN, SuitValues.CLUB),
//                new Card(FaceValues.NINE, SuitValues.SPADES)
//        );
//        Player player1 = new Player("player1", new Hand(straightListLoser));
//        Player player2 = new Player("player2", new Hand(straightListWinner));
//        Game game = new Game(player1, player2);
//        Player winner = game.getWinnerOfGame();
//
//        assertEquals(player2, winner);
//    }
//
//    @Test
//    void whenTwoHandsAre4OfAKindsAndBothHAndsEqual_ReturnNull() {
//
//        var straightListWinner = List.of(
//                new Card(FaceValues.TEN, SuitValues.HEARTS),
//                new Card(FaceValues.TEN, SuitValues.HEARTS),
//                new Card(FaceValues.TEN, SuitValues.HEARTS),
//                new Card(FaceValues.TEN, SuitValues.CLUB),
//                new Card(FaceValues.NINE, SuitValues.SPADES)
//        );
//        var straightListLoser= List.of(
//                new Card(FaceValues.TEN, SuitValues.SPADES),
//                new Card(FaceValues.TEN, SuitValues.HEARTS),
//                new Card(FaceValues.TEN, SuitValues.SPADES),
//                new Card(FaceValues.TEN, SuitValues.CLUB),
//                new Card(FaceValues.NINE, SuitValues.SPADES)
//        );
//        Player player1 = new Player("player1", new Hand(straightListLoser));
//        Player player2 = new Player("player2", new Hand(straightListWinner));
//        Game game = new Game(player1, player2);
//        Player winner = game.getWinnerOfGame();
//
//        assertNull( winner);
//    }
//
//    @Test
//    void whenTwoHandsArePair_thenReturnWinner() {
//
//        var straightListWinner = List.of(
//                new Card(FaceValues.TEN, SuitValues.HEARTS),
//                new Card(FaceValues.TEN, SuitValues.HEARTS),
//                new Card(FaceValues.SEVEN, SuitValues.HEARTS),
//                new Card(FaceValues.SIX, SuitValues.CLUB),
//                new Card(FaceValues.NINE, SuitValues.SPADES)
//        );
//        var straightListLoser= List.of(
//                new Card(FaceValues.TWO, SuitValues.SPADES),
//                new Card(FaceValues.TWO, SuitValues.HEARTS),
//                new Card(FaceValues.EIGHT, SuitValues.SPADES),
//                new Card(FaceValues.TEN, SuitValues.CLUB),
//                new Card(FaceValues.NINE, SuitValues.SPADES)
//        );
//        Player player1 = new Player("player1", new Hand(straightListLoser));
//        Player player2 = new Player("player2", new Hand(straightListWinner));
//        Game game = new Game(player1, player2);
//        Player winner = game.getWinnerOfGame();
//
//        assertEquals(player2, winner);
//    }
//}
