package org.alan.hands;

import org.alan.card.Card;
import org.alan.HandRank;

import java.util.List;

public class FlushHand extends Hand{
    private static final HandRank FLUSH_HAND_RANK = HandRank.FLUSH;

    public FlushHand(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return FLUSH_HAND_RANK;
    }
}
