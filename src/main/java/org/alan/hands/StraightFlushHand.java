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

    @Override
    public int compareHands(Hand opponentsHand) {
        if (STRAIGHT_FLUSH_RANK.getRank() > opponentsHand.getHandRank().getRank()) {
            return 1;
        } else if (STRAIGHT_FLUSH_RANK.getRank() < opponentsHand.getHandRank().getRank()) {
            return -1;
        }

        var myCards = this.getCards();
        var opponentsCards = opponentsHand.getCards();
        for (int i = (MAX_HAND_SIZE - 1); i >= 0; i--) {
            if (myCards.get(i).compareFaceValue(opponentsCards.get(i)) > 0) {
                return 1;
            } else if (myCards.get(i).compareFaceValue(opponentsCards.get(i)) < 0) {
                return -1;
            }
        }
        return 0;
    }


}
