package org.alan.hands;

import org.alan.card.Card;
import org.alan.HandRank;

import java.util.List;

public class TwoPairHand extends Hand {

    private static final HandRank TWO_PAIR_HAND_RANK = HandRank.TWO_PAIR;

    public TwoPairHand(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return TWO_PAIR_HAND_RANK;
    }
}
