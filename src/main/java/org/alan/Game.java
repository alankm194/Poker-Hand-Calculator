package org.alan;

public class Game {

    private final Hand player1;
    private final Hand player2;

    public Game(Hand player1, Hand player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Hand getPlayer1Hand() {
        return player1;
    }

    public Hand getPlayer2Hand() {
        return player2;
    }
}
