package org.alan;

import org.alan.exceptions.InvalidUserInputException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputTest {

    @Test
    void testUserInput() throws InvalidUserInputException {
        String testInput = "Player 1: AS 2H KD 4C JA  Player 2: 3C 3H 4D QS 5D";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        UserInput input = new UserInput();
        Map<String, List<String>> playerCardMap = input.getPlayerCards();
        assertEquals(2, playerCardMap.size());
        assertEquals(List.of("AS", "2H", "KD", "4C", "JA"), playerCardMap.get("Player 1"));
        assertEquals(List.of("3C", "3H", "4D", "QS", "5D"), playerCardMap.get("Player 2"));
    }
}
