package org.alan;

import org.alan.exceptions.InvalidUserInputException;

import java.util.*;

public class UserInput {

    private static final int CARDS_SPLIT_INDEX = 5;
    private static final String PLAYER_1 = "Player 1";
    private static final String PLAYER_2 = "Player 2";

    public Map<String, List<String>> getPlayerCards() throws InvalidUserInputException{
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (!input.contains(PLAYER_1) && !input.contains(PLAYER_2)) {
            throw new InvalidUserInputException("Input must include Player 1 and Player 2");
        }
        input = input.replace(PLAYER_1 + ":", "");
        input = input.replace(PLAYER_2 + ":", "").trim();
        var inputList = Arrays.stream(input.split(" ")).filter(e -> !e.isEmpty()).toList();

        if (inputList.size() != 10) {
            throw new InvalidUserInputException("Card length must be a total of 10. 5 for each player.");
        }

        List<String> player1Cards = inputList.subList(0, CARDS_SPLIT_INDEX);
        List<String> player2Cards = inputList.subList(CARDS_SPLIT_INDEX, inputList.size());

        return Map.of(
                PLAYER_1, player1Cards,
                PLAYER_2, player2Cards
        );
    }
}
