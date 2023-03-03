package org.alan;

import java.util.List;

public class Hand {

    private List<Card> currentHand;

    public List<Card> getHand() {
        return currentHand;
    }

    public void setHand(List<Card> currentHand) {
        this.currentHand = currentHand;
    }
}
