package org.alan.drawnhand;

import org.alan.HandRank;
import org.alan.Player;

public enum StraightFlushDraw {

    INSTANCE;

    private static final int HAND_SIZE = 5;

    public Player calculateWinnerFromHandDraw(Player player1, Player player2) {
        var player1Hand = player1.getHand();
        var player2Hand = player2.getHand();

        if (player1Hand.getHandRank() != HandRank.STRAIGHT_FLUSH) {
            throw new IllegalArgumentException("player 1 Hand must be Straight flush");
        }
        if (player2Hand.getHandRank() != HandRank.STRAIGHT_FLUSH) {
            throw new IllegalArgumentException("player 1 Hand must be Straight flush");
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
