package org.alan.hands;

import org.alan.card.Card;
import org.alan.HandRank;

import java.util.List;

public abstract class Hand {

    private static final int MAX_HAND = 5;
    private final List<Card> currentHand;

    protected Hand(List<Card> currentHand) {
        if (currentHand.size() > MAX_HAND) {
            throw new IllegalArgumentException("A legal hand must be 5 cards");
        }

        this.currentHand = currentHand;
    }

    public List<Card> getCards() {
        return currentHand;
    }

    public abstract HandRank getHandRank();

}
