package org.alan;

import org.alan.exceptions.InvalidHandException;
import org.alan.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.InjectMocks;
import java.util.Arrays;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandCalculatorTest {



    @InjectMocks
    private PokerHandCalculator pokerHandCalculator;

    @BeforeEach
    public void init() {
        pokerHandCalculator = new PokerHandCalculator();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/pokerHandCalculatorTest.csv", numLinesToSkip = 1)
    public void testPokerHandCalculateGame(String expectedWinner, String winningHand,  String hand1, String hand2) throws InvalidUserInputException, InvalidHandException {
        pokerHandCalculator = new PokerHandCalculator();

      var userInput = Map.of("Player 1", Arrays.asList(hand1.split(" ")),
                "Player 2", Arrays.asList(hand2.split(" ")));
        var winner = pokerHandCalculator.calculatePokerWinner(userInput);
        assertEquals(String.format("the winner is %s with %s", expectedWinner, winningHand), winner);

    }

}
