package org.alan.drawnhand;

import org.alan.card.Card;
import org.alan.HandRank;
import org.alan.Player;

import java.util.Collections;
import java.util.stream.Collectors;

public enum FourOfAKindDraw {

    INSTANCE;
    private static final int FOUR_OF_A_KIND = 4;
    private static final int KICKER = 1;

    public Player calculateWinnerFromHandDraw(Player player1, Player player2) {
        var player1Hand = player1.getHand();
        var player2Hand = player2.getHand();

        if (player1Hand.getHandRank() != HandRank.FOUR_OF_A_KIND) {
            throw new IllegalArgumentException("player 1 Hand must be High card");
        }
        if (player2Hand.getHandRank() != HandRank.FOUR_OF_A_KIND) {
            throw new IllegalArgumentException("player 1 Hand must be High card");
        }
        var player1Cards = player1Hand.getCards().stream().map(Card::getFaceValue).toList();
        var player2Cards = player2Hand.getCards().stream().map(Card::getFaceValue).toList();

        var quadAndKickerMapPlayer1 = player1Cards
                .stream()
                .collect(Collectors.groupingBy(a -> Collections.frequency(player1Cards, a)));

        var quadAndKickerMapPlayer2 = player2Cards
                .stream()
                .collect(Collectors.groupingBy(a -> Collections.frequency(player2Cards, a)));

        var fourOfKindCardP1 = quadAndKickerMapPlayer1.get(FOUR_OF_A_KIND).stream()
                .distinct()
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        var fourOfKindCardP2 = quadAndKickerMapPlayer2.get(FOUR_OF_A_KIND).stream()
                .distinct()
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        if (fourOfKindCardP1.compareTo(fourOfKindCardP2) > 0) {
            return player1;
        } else if(fourOfKindCardP1.compareTo(fourOfKindCardP2) < 0) {
            return player2;
        } else {
            var kickerPlayer1 = quadAndKickerMapPlayer1.get(KICKER).get(0);
            var kickerPlayer2 = quadAndKickerMapPlayer2.get(KICKER).get(0);

            if (kickerPlayer1.compareTo(kickerPlayer2) > 0) {
                return player1;
            } else if(kickerPlayer1.compareTo(kickerPlayer2) < 0) {
                return player2;
            } else {
                return null;
            }
        }
    }
}
