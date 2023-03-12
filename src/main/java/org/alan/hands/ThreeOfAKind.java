package org.alan.hands;

import org.alan.card.Card;
import org.alan.HandRank;

import java.util.List;

public class ThreeOfAKind extends Hand{

    private static final HandRank THREE_OF_A_KIND_HAND_RANK = HandRank.THREE_OF_A_KIND;

    public ThreeOfAKind(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return THREE_OF_A_KIND_HAND_RANK;
    }
}
