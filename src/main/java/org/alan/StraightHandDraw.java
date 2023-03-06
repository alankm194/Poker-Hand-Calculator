package org.alan;

public enum StraightHandDraw {
    INSTANCE;
    private static final int HAND_SIZE = 5;

    public Player calculateWinnerFromHandDraw(Player player1, Player player2) {
        var player1Hand = player1.getHand();
        var player2Hand = player2.getHand();

        if (player1Hand.getHandRank() != HandRank.STRAIGHT) {
            throw new IllegalArgumentException("player 1 Hand must be Straight");
        }
        if (player2Hand.getHandRank() != HandRank.STRAIGHT) {
            throw new IllegalArgumentException("player 1 Hand must be Straight");
        }
        var player1Cards = player1Hand.getCards();
        var player2Cards = player2Hand.getCards();
        for (int i=(HAND_SIZE-1); i >= 0; i--) {
            if (player1Cards.get(i).compareTo(player2Cards.get(i)) > 0) {
                return player1;
            } else if (player1Cards.get(i).compareTo(player2Cards.get(i)) < 0) {
                return player2;
            }
        }
        return null;
    }
}
