package org.alan;

import org.alan.drawnhand.*;

public class Game {



    public Player getWinnerOfGame(Player player1, Player player2) {
        var handRank1 = player1.getHand().getHandRank();
        var handRank2 = player2.getHand().getHandRank();

        if (handRank2.getRank() > handRank1.getRank()) {
            return player2;
        } else if (handRank1.getRank() > handRank2.getRank()) {
            return player1;
        } else {
            return getWinnerOfDrawnHand(player1, player2);
        }
    }

    private Player getWinnerOfDrawnHand(Player player1, Player player2) throws IllegalArgumentException {
        if (player1.getHand().getHandRank() != player2.getHand().getHandRank()) {
            throw new IllegalArgumentException("Hand Must be of same hand rank");
        }
        switch (player1.getHand().getHandRank()) {
            case STRAIGHT_FLUSH -> {
                return StraightFlushDraw.INSTANCE.calculateWinnerFromHandDraw(player1, player2);
            }
            case FOUR_OF_A_KIND -> {
                return FourOfAKindDraw.INSTANCE.calculateWinnerFromHandDraw(player1, player2);
            }
            case FLUSH -> {
                return FlushDraw.INSTANCE.calculateWinnerFromHandDraw(player1, player2);
            }
            case STRAIGHT -> {
                return StraightDraw.INSTANCE.calculateWinnerFromHandDraw(player1, player2);
            }
            case HIGH_CARD -> {
                return HighCardDraw.INSTANCE.calculateWinnerFromHandDraw(player1, player2);
            }
            default -> {
                return null;
            }
        }
    }
}
