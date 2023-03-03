package org.alan;

import java.util.List;
import java.util.stream.Collectors;

public class Hand {

    private static final int MAX_HAND = 5;
    private List<Card> currentHand;

    public List<Card> getHand() {
        return currentHand;
    }

    public void setHand(List<Card> currentHand) {
        if (currentHand.size() > MAX_HAND) {
            throw new IllegalArgumentException("A legal hand must be 5 cards");
        }

        this.currentHand = currentHand
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
