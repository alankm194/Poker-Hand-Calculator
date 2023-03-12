package org.alan.hands;

import org.alan.card.Card;
import org.alan.HandRank;

import java.util.List;

public class StraightHand extends Hand {
    private static final HandRank STRAIGHT_HAND_RANK = HandRank.STRAIGHT;

    public StraightHand(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return STRAIGHT_HAND_RANK;
    }
}
