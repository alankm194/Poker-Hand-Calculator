package org.alan.hands;

import org.alan.card.Card;
import org.alan.HandRank;

import java.util.List;

public class HighCardHand extends Hand{

    private static final HandRank HIGH_CARD_HIGH_RANK = HandRank.HIGH_CARD;

    public HighCardHand(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return HIGH_CARD_HIGH_RANK;
    }
}
