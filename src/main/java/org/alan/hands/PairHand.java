package org.alan.hands;

import org.alan.card.Card;
import org.alan.HandRank;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PairHand extends Hand {
    private static final HandRank PAIR_HAND_RANK = HandRank.PAIR;

    private static final int KICKER = 1;
    private static final int PAIR = 2;


    public PairHand(List<Card> currentHand) {
        super(currentHand);
    }

    @Override
    public HandRank getHandRank() {
        return PAIR_HAND_RANK;
    }

    @Override
    public int compareHands(Hand opponentHand) {
        if (PAIR_HAND_RANK.getRank() > opponentHand.getHandRank().getRank()) {
            return 1;
        } else if (PAIR_HAND_RANK.getRank() < opponentHand.getHandRank().getRank()) {
            return -1;
        }
        var myCards = this.getCards().stream().map(Card::getFaceValue).toList();
        var opponentsCards = opponentHand.getCards().stream().map(Card::getFaceValue).toList();

        var myPairAndKickersMap = myCards
                .stream()
                .collect(Collectors.groupingBy(a -> Collections.frequency(myCards, a)));

        var opponentPairAndKickersMap = opponentsCards
                .stream()
                .collect(Collectors.groupingBy(a -> Collections.frequency(opponentsCards, a)));


        var myPairValue = myPairAndKickersMap.get(PAIR)
                .stream()
                .distinct()
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        var opponentsPairValue = opponentPairAndKickersMap.get(PAIR)
                .stream()
                .distinct()
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);



        if (myPairValue.getValue() > opponentsPairValue.getValue()) {
            return 1;
        } else if (myPairValue.getValue() < opponentsPairValue.getValue()) {
            return -1;
        }

        var myKickersValue = myPairAndKickersMap.get(KICKER).stream().sorted().toList();
        var opponentsKickerValue = opponentPairAndKickersMap.get(KICKER).stream().sorted().toList();
        var myHighestKicker = myKickersValue.get(myKickersValue.size()-1);
        var opponentHighestKicker = opponentsKickerValue.get(opponentsKickerValue.size()-1);

        if (myHighestKicker.getValue() > opponentHighestKicker.getValue()) {
            return 1;
        } else if (myHighestKicker.getValue() < opponentHighestKicker.getValue()) {
            return -1;
        }

        return 0;
    }

}
