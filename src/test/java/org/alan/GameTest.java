package org.alan;

import org.alan.card.Card;
import org.alan.card.FaceValues;
import org.alan.card.SuitValues;
import org.alan.exceptions.InvalidHandException;
import org.alan.hands.RankHand;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {


    private static Map<String, List<Card>> handsMap;

    @BeforeAll
    static void init() {
        List<Card> STRAIGHT_FLUSH = List.of(
                new Card(FaceValues.FIVE, SuitValues.SPADES),
                new Card(FaceValues.SIX, SuitValues.SPADES),
                new Card(FaceValues.EIGHT, SuitValues.SPADES),
                new Card(FaceValues.SEVEN, SuitValues.SPADES),
                new Card(FaceValues.FOUR, SuitValues.SPADES)
        );

        List<Card> FOUR_OF_A_KIND = List.of(
                new Card(FaceValues.KING, SuitValues.SPADES),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.KING, SuitValues.CLUB),
                new Card(FaceValues.FIVE, SuitValues.HEARTS)
        );

        List<Card> FULL_HOUSE = List.of(
                new Card(FaceValues.KING, SuitValues.SPADES),
                new Card(FaceValues.KING, SuitValues.DIAMOND),
                new Card(FaceValues.FIVE, SuitValues.DIAMOND),
                new Card(FaceValues.FIVE, SuitValues.CLUB),
                new Card(FaceValues.FIVE, SuitValues.HEARTS)
        );

        List<Card> FLUSH = List.of(
                new Card(FaceValues.KING, SuitValues.SPADES),
                new Card(FaceValues.JACK, SuitValues.SPADES),
                new Card(FaceValues.FIVE, SuitValues.SPADES),
                new Card(FaceValues.FIVE, SuitValues.SPADES),
                new Card(FaceValues.FIVE, SuitValues.SPADES)
        );

        List<Card> STRAIGHT = List.of(
                new Card(FaceValues.KING, SuitValues.SPADES),
                new Card(FaceValues.JACK, SuitValues.DIAMOND),
                new Card(FaceValues.QUEEN, SuitValues.SPADES),
                new Card(FaceValues.TEN, SuitValues.CLUB),
                new Card(FaceValues.NINE, SuitValues.SPADES)
        );

        List<Card> THREE_OF_A_KIND = List.of(
                new Card(FaceValues.JACK, SuitValues.SPADES),
                new Card(FaceValues.JACK, SuitValues.DIAMOND),
                new Card(FaceValues.JACK, SuitValues.SPADES),
                new Card(FaceValues.TEN, SuitValues.CLUB),
                new Card(FaceValues.NINE, SuitValues.SPADES)
        );

        List<Card> TWO_PAIR = List.of(
                new Card(FaceValues.JACK, SuitValues.SPADES),
                new Card(FaceValues.JACK, SuitValues.DIAMOND),
                new Card(FaceValues.ACE, SuitValues.SPADES),
                new Card(FaceValues.ACE, SuitValues.CLUB),
                new Card(FaceValues.NINE, SuitValues.SPADES)
        );
        List<Card> PAIR = List.of(
                new Card(FaceValues.JACK, SuitValues.SPADES),
                new Card(FaceValues.SEVEN, SuitValues.DIAMOND),
                new Card(FaceValues.EIGHT, SuitValues.SPADES),
                new Card(FaceValues.NINE, SuitValues.CLUB),
                new Card(FaceValues.NINE, SuitValues.SPADES)
        );

        List<Card> HIGH_CARD = List.of(
                new Card(FaceValues.JACK, SuitValues.SPADES),
                new Card(FaceValues.SEVEN, SuitValues.DIAMOND),
                new Card(FaceValues.EIGHT, SuitValues.SPADES),
                new Card(FaceValues.NINE, SuitValues.CLUB),
                new Card(FaceValues.THREE, SuitValues.SPADES)
        );
        handsMap = Map.of(
                "STRAIGHT_FLUSH", STRAIGHT_FLUSH,
                "FOUR_OF_A_KIND", FOUR_OF_A_KIND,
                "FULL_HOUSE", FULL_HOUSE,
                "FLUSH", FLUSH,
                "STRAIGHT", STRAIGHT,
                "THREE_OF_A_KIND", THREE_OF_A_KIND,
                "TWO_PAIR", TWO_PAIR,
                "PAIR", PAIR,
                "HIGH_CARD", HIGH_CARD
        );

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/GameTestWinnersNoDraws.csv", numLinesToSkip = 1)
    void testGettingWinnerWithNoDraws(String winnerHand, String loserHand) throws InvalidHandException {
        Player expectedLoser = new Player("Player 1", new RankHand().rankHand(handsMap.get(loserHand)));
        Player expectedWinner = new Player("Player 2", new RankHand().rankHand(handsMap.get(winnerHand)));
        Game game = new Game();
        Player winner = game.getWinnerOfGame(expectedWinner, expectedLoser);
        assertEquals(expectedWinner, winner);
        assertEquals("Player 2", winner.name());
    }
}
