package org.alan.hands;

import org.alan.card.Card;
import org.alan.HandRank;

import java.util.List;

public class FullHouseHand extends Hand{

    private static final HandRank FULL_HOUSE_HAND_RANK = HandRank.FULL_HOUSE;

    public FullHouseHand(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return FULL_HOUSE_HAND_RANK;
    }
}
