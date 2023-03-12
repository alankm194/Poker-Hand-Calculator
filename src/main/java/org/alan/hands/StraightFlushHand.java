package org.alan.hands;

import org.alan.card.Card;
import org.alan.HandRank;

import java.util.List;

public class StraightFlushHand extends Hand {

    private static final HandRank STRAIGHT_FLUSH_RANK = HandRank.STRAIGHT_FLUSH;
    public StraightFlushHand(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return STRAIGHT_FLUSH_RANK;
    }


}
