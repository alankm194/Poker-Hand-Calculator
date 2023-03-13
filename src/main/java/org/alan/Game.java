package org.alan;


import org.alan.exceptions.InvalidHandException;

public class Game {

    public Player getWinnerOfGame(Player player1, Player player2) throws InvalidHandException {
        var player1Hand = player1.getHand();
        var player2Hand = player2.getHand();

        if (player1Hand.compareHands(player2Hand) > 0) {
            return player1;
        } else if(player1Hand.compareHands(player2Hand) < 0) {
            return player2;
        } else {
            return null;
        }
    }

}
