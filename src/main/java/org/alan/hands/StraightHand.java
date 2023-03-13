package org.alan.hands;

import org.alan.card.Card;

import java.util.List;

public class StraightHand extends Hand {
    private static final HandRank STRAIGHT_HAND_RANK = HandRank.STRAIGHT;

    public StraightHand(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return STRAIGHT_HAND_RANK;
    }

    @Override
    public int compareHands(Hand opponentHand) {
        if (STRAIGHT_HAND_RANK.getRank() > opponentHand.getHandRank().getRank()) {
            return 1;
        } else if(STRAIGHT_HAND_RANK.getRank() < opponentHand.getHandRank().getRank()) {
            return -1;
        }

        var myCards = this.getCards();
        var opponentsCards = opponentHand.getCards();
        for (int i=(MAX_HAND_SIZE-1); i >= 0; i--) {
            if (myCards.get(i).compareFaceValue(opponentsCards.get(i)) > 0) {
                return 1;
            } else if (myCards.get(i).compareFaceValue(opponentsCards.get(i)) < 0) {
                return -1;
            }
        }
        return 0;
    }


}
