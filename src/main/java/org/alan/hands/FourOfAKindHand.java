package org.alan.hands;

import org.alan.card.Card;
import org.alan.HandRank;

import java.util.List;

public class FourOfAKindHand extends Hand{

    private static final HandRank FOUR_OF_A_KIND_HAND_RANK = HandRank.FOUR_OF_A_KIND;

    public FourOfAKindHand(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return FOUR_OF_A_KIND_HAND_RANK;
    }
}
