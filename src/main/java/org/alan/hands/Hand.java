package org.alan.hands;

import org.alan.card.Card;
import org.alan.exceptions.InvalidHandException;

import java.util.List;

public abstract class Hand  {

    protected static final int MAX_HAND_SIZE = 5;
    private final List<Card> currentHand;

    protected Hand(List<Card> currentHand) {
        if (currentHand.size() > MAX_HAND_SIZE) {
            throw new IllegalArgumentException("A legal hand must be 5 cards");
        }

        this.currentHand = currentHand.stream().sorted().toList();
    }

    public List<Card> getCards() {
        return currentHand;
    }

    public abstract HandRank getHandRank();

    public abstract int compareHands(Hand opponentsHand) throws InvalidHandException;

}
