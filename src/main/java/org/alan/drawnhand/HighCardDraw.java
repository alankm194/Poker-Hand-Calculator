package org.alan.drawnhand;

import org.alan.HandRank;
import org.alan.Player;

public enum HighCardDraw {

    INSTANCE;
    private static final int HAND_SIZE = 5;

    public Player calculateWinnerFromHandDraw(Player player1, Player player2) {
        var player1Hand = player1.getHand();
        var player2Hand = player2.getHand();

        if (player1Hand.getHandRank() != HandRank.HIGH_CARD) {
            throw new IllegalArgumentException("player 1 Hand must be High card");
        }
        if (player2Hand.getHandRank() != HandRank.HIGH_CARD) {
            throw new IllegalArgumentException("player 1 Hand must be High card");
        }
        var player1Cards = player1Hand.getCards();
        var player2Cards = player2Hand.getCards();
        for (int i=(HAND_SIZE-1); i >= 0; i--) {
            if (player1Cards.get(i).compareFaceValue(player2Cards.get(i)) > 0) {
                return player1;
            } else if (player1Cards.get(i).compareFaceValue(player2Cards.get(i)) < 0) {
                return player2;
            }
        }
        return null;
    }
}
