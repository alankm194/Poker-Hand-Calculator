package org.alan.hands;

import org.alan.card.Card;

import java.util.List;

public class FlushHand extends Hand {
    private static final HandRank FLUSH_HAND_RANK = HandRank.FLUSH;

    public FlushHand(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return FLUSH_HAND_RANK;
    }

    @Override
    public int compareHands(Hand opponentsHand) {
        if (FLUSH_HAND_RANK.getRank() > opponentsHand.getHandRank().getRank()) {
            return 1;
        } else if (FLUSH_HAND_RANK.getRank() < opponentsHand.getHandRank().getRank()) {
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


