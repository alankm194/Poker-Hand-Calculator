package org.alan.hands;

import org.alan.card.Card;
import org.alan.HandRank;

import java.util.List;

public class PairHand extends Hand {
    private static final HandRank PAIR_HAND_RANK = HandRank.PAIR;

    public PairHand(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return PAIR_HAND_RANK;
    }
}
