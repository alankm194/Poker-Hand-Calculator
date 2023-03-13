package org.alan.hands;

import org.alan.card.Card;
import org.alan.HandRank;
import org.alan.card.FaceValues;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TwoPairHand extends Hand {

    private static final HandRank TWO_PAIR_HAND_RANK = HandRank.TWO_PAIR;

    private static final int PAIR = 2;

    private static final int KICKER = 1;

    public TwoPairHand(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return TWO_PAIR_HAND_RANK;
    }

    @Override
    public int compareHands(Hand opponentsHand) {
        if (TWO_PAIR_HAND_RANK.getRank() > opponentsHand.getHandRank().getRank()) {
            return 1;
        } else if(TWO_PAIR_HAND_RANK.getRank() < opponentsHand.getHandRank().getRank()) {
            return -1;
        }

        var myCards = this.getCards().stream().map(Card::getFaceValue).toList();
        var opponentsCards = opponentsHand.getCards().stream().map(Card::getFaceValue).toList();

        var myTwoPairAndKickerMap = myCards
                .stream()
                .collect(Collectors.groupingBy(a -> Collections.frequency(myCards, a)));

        var opponentTwoPairAndKickerMap = opponentsCards
                .stream()
                .collect(Collectors.groupingBy(a -> Collections.frequency(opponentsCards, a)));

        var myPairList = myTwoPairAndKickerMap.get(PAIR)
                .stream()
                .distinct()
                .map(FaceValues::getValue)
                .sorted()
                .toList();

        var opponentPairList = opponentTwoPairAndKickerMap.get(PAIR)
                .stream()
                .distinct()
                .map(FaceValues::getValue)
                .sorted()
                .toList();

        for (int i = myPairList.size()-1; i >= 0; i--) {
            if (myPairList.get(i) > opponentPairList.get(i)) {
                return 1;
            } else if(myPairList.get(i) < opponentPairList.get(i)) {
                return -1;
            }
        }

        var myKickerValue =  myTwoPairAndKickerMap.get(KICKER).get(0);
        var opponentKickerValue = opponentTwoPairAndKickerMap.get(KICKER).get(0);

        if (myKickerValue.compareTo(opponentKickerValue) > 0) {
            return 1;
        } else if(myKickerValue.compareTo(opponentKickerValue) < 0) {
            return -1;
        }

        return 0;
    }


}
