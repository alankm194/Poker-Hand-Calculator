package org.alan;

import java.util.*;

public class UserInput {

    private static final int CARDS_SPLIT_INDEX = 5;
    private static final String PLAYER_1 = "Player 1";
    private static final String PLAYER_2 = "Player 2";

    public Map<String, List<String>> getPlayerCards() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replace(PLAYER_1 + ":", "");
        input = input.replace(PLAYER_2 + ":", "").trim();
        var inputList = Arrays.stream(input.split(" ")).filter(e -> !e.isEmpty()).toList();

        List<String> player1Cards = inputList.subList(0, CARDS_SPLIT_INDEX);
        List<String> player2Cards = inputList.subList(CARDS_SPLIT_INDEX, inputList.size());

        return Map.of(
                PLAYER_1, player1Cards,
                PLAYER_2, player2Cards
        );
    }
}
