package org.alan;

import java.util.List;
import java.util.stream.Collectors;

public class Hand {

    private static final int MAX_HAND = 5;
    private List<Card> currentHand;

    private HandRank handRank;

    public Hand(List<Card> currentHand) {
        if (currentHand.size() > MAX_HAND) {
            throw new IllegalArgumentException("A legal hand must be 5 cards");
        }

        this.currentHand = currentHand
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Card> getHand() {
        return currentHand;
    }

    public HandRank getHandRank() {
        return handRank;
    }

    public void setHandRank(HandRank handRank) {
        this.handRank = handRank;
    }


}
