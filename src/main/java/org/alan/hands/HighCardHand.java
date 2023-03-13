package org.alan.hands;

import org.alan.card.Card;
import org.alan.HandRank;

import java.util.List;

public class HighCardHand extends Hand {

    private static final HandRank HIGH_CARD_HIGH_RANK = HandRank.HIGH_CARD;

    public HighCardHand(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return HIGH_CARD_HIGH_RANK;
    }

    @Override
    public int compareHands(Hand opponentHand) {
        if (HIGH_CARD_HIGH_RANK.getRank() > opponentHand.getHandRank().getRank()) {
            return 1;
        } else if (HIGH_CARD_HIGH_RANK.getRank() < opponentHand.getHandRank().getRank()) {
            return -1;
        }
        var myCards = this.getCards();
        var opponentsCards = opponentHand.getCards();

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

