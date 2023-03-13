package org.alan.hands;

import org.alan.card.Card;
import org.alan.exceptions.InvalidHandException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FullHouseHand extends Hand{

    private static final HandRank FULL_HOUSE_HAND_RANK = HandRank.FULL_HOUSE;

    private static final int TRIPLE = 3;

    private static final int PAIR = 2;


    public FullHouseHand(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return FULL_HOUSE_HAND_RANK;
    }

    @Override
    public int compareHands(Hand opponentsHand) throws InvalidHandException {
        if (FULL_HOUSE_HAND_RANK.getRank() > opponentsHand.getHandRank().getRank()) {
            return 1;
        } else if (FULL_HOUSE_HAND_RANK.getRank() < opponentsHand.getHandRank().getRank()) {
            return -1;
        }

        var myCards = this.getCards().stream().map(Card::getFaceValue).toList();
        var opponentsCards = opponentsHand.getCards().stream().map(Card::getFaceValue).toList();

        var myPairAndTripleMap = myCards
                .stream()
                .collect(Collectors.groupingBy(a -> Collections.frequency(myCards, a)));

        var opponentsPairAndTriple = opponentsCards
                .stream()
                .collect(Collectors.groupingBy(a -> Collections.frequency(opponentsCards, a)));

        var myTripleValue = myPairAndTripleMap
                .get(TRIPLE)
                .stream()
                .distinct()
                .findFirst()
                .orElseThrow(() -> new InvalidHandException(this));

        var opponentTripleValue = opponentsPairAndTriple
                .get(TRIPLE)
                .stream()
                .distinct()
                .findFirst()
                .orElseThrow(() -> new InvalidHandException(opponentsHand));

        if (myTripleValue.compareTo(opponentTripleValue) > 0) {
            return 1;
        } else if(myTripleValue.compareTo(opponentTripleValue) < 0) {
            return -1;
        }

        var myPairValue = myPairAndTripleMap
                .get(PAIR)
                .stream()
                .findFirst()
                .orElseThrow(() -> new InvalidHandException(this));

        var opponentPairValue = opponentsPairAndTriple
                .get(PAIR)
                .stream()
                .findFirst()
                .orElseThrow(() -> new InvalidHandException(opponentsHand));

        if (myPairValue.compareTo(opponentPairValue) > 0) {
            return 1;
        } else if(myPairValue.compareTo(opponentPairValue) < 0) {
            return -1;
        }

        return 0;
    }


}
