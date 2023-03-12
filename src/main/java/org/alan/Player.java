package org.alan;

import org.alan.hands.Hand;

public class Player {

    private final String name;
    private final Hand hand;
    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    public String getName() {
        return name;
    }


    public Hand getHand() {
        return hand;
    }


}
